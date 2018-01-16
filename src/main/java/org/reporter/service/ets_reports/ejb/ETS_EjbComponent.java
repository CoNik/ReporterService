/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reporter.service.ets_reports.ejb;
 
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.reporter.service.ets_reports.CardActivityLogs;
import org.reporter.service.ets_reports.CardActivityLogsFacade;
import org.reporter.service.ets_reports.Cards;
import org.reporter.service.ets_reports.CardsFacade;
import org.reporter.service.ets_reports.Validators;
import org.reporter.service.ets_reports.ValidatorsFacade;
import org.reporter.service.ets_reports.nosql.CassandraConnector;
import org.reporter.service.ets_reports.nosql.CassandraConnectorFactory;
import org.reporter.service.ets_reports.nosql.LocationWorkData;
import org.reporter.service.ets_reports.nosql.LocationWorkFacade;
import org.reporter.service.ets_reports.nosql.PositionData;
import org.reporter.service.ets_reports.nosql.PositionFacade;

/**
 *
 * @author constantinn
 */
@Stateless
public class ETS_EjbComponent {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     
     @EJB
     CardActivityLogsFacade calF;
     
     @EJB
     ValidatorsFacade  validatorsF;
     
     @EJB
     CardsFacade cardsF;
    
     //set persistence=false becauze glassfish 4.1 does not support persistence=true configuration
    @Schedule(second="15", minute="1", hour="*", persistent=false)
    public void execute(Timer timer) {

        System.out.println("Executing ETS-Reports EJB Start migrate data to Cassandra...");
        System.out.println("Execution  ETS-Reports EJB Migrate data: " + new Date());
     
        CassandraConnector client = connectToCassandra();
     
        
        //populate LOCATION_WORK 
         populateLocationWorkTable(client);
          
           //populate POSITIONS
          populatePositionsTable(client);
       
        System.out.println("End Migrate data to Cassandra  ______________________" + new Date()); 
    }
    
    public  CassandraConnector connectToCassandra() {
       
       String result = "OK";
       CassandraConnector client = new CassandraConnector();
        try{
           CassandraConnectorFactory ccf = CassandraConnectorFactory.getInstance();
           client = CassandraConnectorFactory.getCassandraConnector();
           
         }
        catch(Exception ex){
            client.close();
            result = "NOK";
        }
        
      return client;
    }
    
   
  
   
    public  void populateLocationWorkTable( CassandraConnector client){
        
          System.out.println("Migrate data _________ Location_Work"); 
          List<CardActivityLogs> cardActivityLogsList = calF.findAllCardActivityLogs();//calF.findAll();
          
            
             List<LocationWorkData> locationWorkDataList = new ArrayList<LocationWorkData>();
             if(cardActivityLogsList == null )
                 cardActivityLogsList = new ArrayList<CardActivityLogs>();
             
             LocationWorkData lwd1 = null;
             //public LocationWorkData(long pCardId, Date pCreateDate, double pCurrentbalance, double pCurrentpasscount, long pCustomerid,
              //               double pLoyaltypasscount, long pStationIdExit, long pStationIdEntrance, String pStatus , 
             //                List<Long> pOptStationList, List<Date>  pOptStationListTs, int pTravelTime, Date pTsEntrance, Date pTsExit,Date pValidationDate,
             //                String pValidatorCodeEntrance, String pValidatorCodeExit) 
             
             Long stationIdEntrance = 0l;
             Long stationIdExit = 0l;
                 
             Date tsEntrance   = null;
             Date tsExit       = null;
             int tsTravelTime = 0;
             String validatorCodeEntry = null;
             String validatorCodeExit  = null;
                 
            
             for(CardActivityLogs cardActivityLog : cardActivityLogsList){
                
                 if(!"Validation.In".equals(cardActivityLog.getActivityCode()) && !"Validation.OUT".equals(cardActivityLog.getActivityCode())){
                     continue;
                 }  
               
                 String cardInfoByCardNumber = cardsF.getCardIdInfo(cardActivityLog.getCardNumber() );
                 
                 String[] cardInfoArray = cardInfoByCardNumber.split("/");
                 
                         
                 if("Validation.In".equals(cardActivityLog.getActivityCode())){
                     stationIdEntrance = validatorsF.getStationIdbyValidatorCode(cardActivityLog.getValidatorCode() );
                     Long tsEntranceTime = cardActivityLog.getSentDate().getTime();
                     tsEntrance = new Date(tsEntranceTime);
                     validatorCodeEntry = cardActivityLog.getValidatorCode();
                     continue;
                 }
                 
                 if("Validation.OUT".equals(cardActivityLog.getActivityCode())){
                     stationIdExit = validatorsF.getStationIdbyValidatorCode(cardActivityLog.getValidatorCode() );
                     Long tsExitTime = cardActivityLog.getSentDate().getTime();
                     tsExit = new Date(tsExitTime);
                     validatorCodeExit = cardActivityLog.getValidatorCode();
                 }
               
                 if(tsEntrance != null && tsExit != null){
                    tsTravelTime = (int)(tsExit.getTime() - tsEntrance.getTime());
                     
                 }
                 try{
                 lwd1 = new LocationWorkData(new Long(cardInfoArray[0]),  //pCardId
                                             cardActivityLog.getCreatedDate(), //pCreateDate
                                             cardActivityLog.getCurrentBalance() != null ? (cardActivityLog.getCurrentBalance()).doubleValue(): 0d, //pCurrentbalance
                                             0d, //pCurrentpasscount - check what value should be inserted
                                             (cardInfoArray[1] != null && !"null".equals(cardInfoArray[1]) ) ? new Long(cardInfoArray[1]) : 0l, //pCustomerid       - check what value should be inserted
                                             0d, //pLoyaltypasscount - check what value should be inserted
                                             stationIdExit,//cardActivityLog.getValidatorCode() , //pStationIdExit
                                             stationIdEntrance,  //pStationIdEntrance 
                                             null, //status
                                             null, //pOptStationList
                                             null, //pOptStationListTs
                                             tsTravelTime, //pTravelTime
                                             tsEntrance, //pTsEntrance
                                             tsExit, //pTsExit
                                             tsEntrance, //pValidationDate
                                             validatorCodeEntry, //pValidatorCodeEntrance null OR value of code validator for Validation In
                                             validatorCodeExit //pValidatorCodeExit ull OR value of code validator for Validation OUT
                 
                 );
                 }
                 catch(Exception ex){
                  System.out.println(ex.getMessage());
                 }
                 
               //  locationWorkDataList.add(lwd1);
                LocationWorkFacade lwf1 = new LocationWorkFacade(client, lwd1);
                lwf1.create(lwd1);
                 
                 stationIdEntrance = 0l;
                 stationIdExit = 0l;
                 
                 tsEntrance = null;
                 tsExit     = null;
                 tsTravelTime = 0; 
                 validatorCodeEntry = null;
                 validatorCodeExit = null;
                 
             }  
         cardActivityLogsList.clear();
         System.out.println("Successfully inserted data for Location Work");
         System.out.println("END Migrate data _________ Location_Work "+ new Date()); 
    }
    
    public  void populatePositionsTable(CassandraConnector client){
       
       System.out.println("Migrate data _________ Positions"); 
       List<CardActivityLogs> cardActivityLogsList = calF.findAllCardActivityLogs();
       if(cardActivityLogsList == null )
                 cardActivityLogsList = new ArrayList<CardActivityLogs>();
             
             PositionData pd = null;
//            public PositionData(long pcardid, long pcustomerid, List<Double> plocation_latitude, List<Double> plocation_longitude,
//                        List<Date> plocation_ts, Date ptravel_init_ts, Date ptravel_end_ts ){
             
               
             Date tsEntrance   = null;
             Date tsExit       = null;
             int tsTravelTime = 0;
             String validatorCodeEntry = null;
             String validatorCodeExit  = null;
                    
             
             for(CardActivityLogs cardActivityLog : cardActivityLogsList){
                  
                 if(!"Validation.In".equals(cardActivityLog.getActivityCode()) && !"Validation.OUT".equals(cardActivityLog.getActivityCode())){
                     continue;
                 }  
                 
                 String cardInfoByCardNumber = cardsF.getCardIdInfo(cardActivityLog.getCardNumber() );
                 
                 String[] cardInfoArray = cardInfoByCardNumber.split("/");
                 
                         
                 if("Validation.In".equals(cardActivityLog.getActivityCode())){
                   
                     Long tsEntranceTime = cardActivityLog.getSentDate().getTime();
                     tsEntrance = new Date(tsEntranceTime);
                     validatorCodeEntry = cardActivityLog.getValidatorCode();
                     continue;
                 }
                 
                 if("Validation.OUT".equals(cardActivityLog.getActivityCode())){
                   
                     Long tsExitTime = cardActivityLog.getSentDate().getTime();
                     tsExit = new Date(tsExitTime);
                     validatorCodeExit = cardActivityLog.getValidatorCode();
                 }
               
                 if(tsEntrance != null && tsExit != null){
                    tsTravelTime = (int)(tsExit.getTime() - tsEntrance.getTime());
                     
                 }
                 try{
                 pd = new PositionData(new Long(cardInfoArray[0]),  //pCardId
                                       (cardInfoArray[1] != null && !"null".equals(cardInfoArray[1]) ) ? new Long(cardInfoArray[1]) : 0l, //pCustomerid       - check what value should be inserted
                                         null, //plocation_latitude
                                         null, //plocation_longitude
                                         null, //plocation_ts
                                         tsEntrance, //ptravel_init_ts
                                         tsExit //ptravel_end_ts
                                            
                 
                 );
                 }
                 catch(Exception ex){
                  System.out.println(ex.getMessage());
                 }
                 
               //  locationWorkDataList.add(lwd1);
               PositionFacade pf = new PositionFacade(client, pd);
               pf.create(pd);
              // System.out.println("Row cardid position data"+ pd.getCardid());
                 
               tsEntrance = null;
               tsExit     = null;
               tsTravelTime = 0; 
               validatorCodeEntry = null;
               validatorCodeExit = null;
             }
              
         cardActivityLogsList.clear();
         System.out.println("Successfully inserted data for Positions");
         System.out.println("END Migrate data _________ Positions "+ new Date()); 
    }
    
   
    
}
