/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@XmlRootElement
public class DashboardInfo implements Serializable{

 
    private Long passengersIn;
    private Long passengersOut;
    private Long noTransactions;
    private Long smartCardTikets;
    private Long passengersInStation;
    private Long noFraudulents;
    private List<NoActivitiesInPeriod> activitiesList;

    public DashboardInfo(){
        // to do ic 2017 11 16
        // replace this with real date from DB
        passengersIn=Math.round(Math.random()*1000l);
        passengersOut=Math.round(Math.random()*1000l);
        noTransactions=Math.round(Math.random()*1000l);
        smartCardTikets=Math.round(Math.random()*1000l);
        passengersInStation=Math.round(Math.random()*1000l);
        noFraudulents=Math.round(Math.random()*1000l);
        activitiesList= new ArrayList<>();
        Date d = new Date();
        long ld = d.getTime();
        for(int i=0; i<50; i++){
            NoActivitiesInPeriod nap = new NoActivitiesInPeriod();
            Date sd = new Date();
            Date ed = new Date();
            sd.setTime(ld-(50-i)*10000l);
            ed.setTime(ld-(49-i)*10000l);
            nap.setStartDate(sd);
            nap.setEndDate(ed);
            nap.setNoActivities(Math.round(Math.random()*10000l));
        }
        
        
    }
    
    public DashboardInfo(Long pi, Long po, Long nt,Long sct, Long pis, Long nf ){
        passengersIn=pi;
        passengersOut=po;
        noTransactions=nt;
        smartCardTikets=sct;
        passengersInStation=pis;
        noFraudulents=nf;
        activitiesList= new ArrayList<>();
    }
    
    /**
     * @return the activitiesList
     */
    public List<NoActivitiesInPeriod> getActivitiesList() {
        return activitiesList;
    }

    /**
     * @param activitiesList the activitiesList to set
     */
    public void setActivitiesList(List<NoActivitiesInPeriod> activitiesList) {
        this.activitiesList = activitiesList;
    }
    
      /**
     * @return the passengersIn
     */
    public Long getPassengersIn() {
        return passengersIn;
    }

    /**
     * @param passengersIn the passengersIn to set
     */
    public void setPassengersIn(Long passengersIn) {
        this.passengersIn = passengersIn;
    }

    /**
     * @return the passengersOut
     */
    public Long getPassengersOut() {
        return passengersOut;
    }

    /**
     * @param passengersOut the passengersOut to set
     */
    public void setPassengersOut(Long passengersOut) {
        this.passengersOut = passengersOut;
    }

    /**
     * @return the noTransactions
     */
    public Long getNoTransactions() {
        return noTransactions;
    }

    /**
     * @param noTransactions the noTransactions to set
     */
    public void setNoTransactions(Long noTransactions) {
        this.noTransactions = noTransactions;
    }

    /**
     * @return the smartCardTikets
     */
    public Long getSmartCardTikets() {
        return smartCardTikets;
    }

    /**
     * @param smartCardTikets the smartCardTikets to set
     */
    public void setSmartCardTikets(Long smartCardTikets) {
        this.smartCardTikets = smartCardTikets;
    }

    /**
     * @return the passengersInStation
     */
    public Long getPassengersInStation() {
        return passengersInStation;
    }

    /**
     * @param passengersInStation the passengersInStation to set
     */
    public void setPassengersInStation(Long passengersInStation) {
        this.passengersInStation = passengersInStation;
    }

    /**
     * @return the noFraudulents
     */
    public Long getNoFraudulents() {
        return noFraudulents;
    }

    /**
     * @param noFraudulents the noFraudulents to set
     */
    public void setNoFraudulents(Long noFraudulents) {
        this.noFraudulents = noFraudulents;
    } 
}
