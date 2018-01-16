/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.reporter.service.ets_reports.ActivityLogs;
import org.reporter.service.ets_reports.NoActivitiesInPeriod;
import org.reporter.service.ets_reports.util.Constants;
import org.reporter.service.ets_reports.util.TimeSeries;

/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.activitylogs")
public class ActivityLogsFacadeREST extends AbstractFacade<ActivityLogs> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    private final static String dformat=Constants.dformat;

    public ActivityLogsFacadeREST() {
        super(ActivityLogs.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ActivityLogs entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, ActivityLogs entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ActivityLogs find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActivityLogs> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActivityLogs> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("byPeriod/{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActivityLogs> findByPeriod(@PathParam("from") String sfrom, @PathParam("to") String sto) {
        DateFormat format = new SimpleDateFormat(dformat);
         Date dfrom = new Date();
         dfrom.setTime(dfrom.getTime()-3600000);
         Date dto = new Date();
         
        try {
            dfrom = format.parse(sfrom);
            dto = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(ActivityLogsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getItems(dfrom, dto);
    }
    
    @GET
    @Path("byPeriodAndStation/{from}/{to}/{station}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActivityLogs> findByPeriodAndStation(@PathParam("from") String sfrom, @PathParam("to") String sto, @PathParam("station") String station) {
        DateFormat format = new SimpleDateFormat(dformat);
         Date dfrom = new Date();
         dfrom.setTime(dfrom.getTime()-3600000);
         Date dto = new Date();
         
        try {
            dfrom = format.parse(sfrom);
            dto = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(ActivityLogsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getItems(station,dfrom, dto);
    }
    
    @GET
    @Path("byPeriodAndStationId/{from}/{to}/{stationId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ActivityLogs> findByPeriodAndStationId(@PathParam("from") String sfrom, @PathParam("to") String sto, @PathParam("stationId") Long stationId) {
        DateFormat format = new SimpleDateFormat(dformat);
         Date dfrom = new Date();
         dfrom.setTime(dfrom.getTime()-3600000);
         Date dto = new Date();
         
        try {
            dfrom = format.parse(sfrom);
            dto = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(ActivityLogsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getItems(stationId,dfrom, dto);
    }
    
    
    //noTimeSeries
    @GET
    @Path("timeSeries/{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<NoActivitiesInPeriod> findTimeSeries(@PathParam("from") String sfrom, @PathParam("to") String sto) {
        DateFormat format = new SimpleDateFormat(dformat);
         Date dfrom = new Date();
         dfrom.setTime(dfrom.getTime()-3600000);
         Date dto = new Date();
         
        try {
            dfrom = format.parse(sfrom);
            dto = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(ActivityLogsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getTimeSeries(Constants.noTimeSeries, dfrom, dto);
    }
    
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<ActivityLogs> getItems(Date startDate, Date endDate) {
        List<ActivityLogs> items=null;
        if (items == null) {
            EntityManager em=getEntityManager();
            Query q= em.createNamedQuery("ActivityLogs.findByPeriod", ActivityLogs.class);
            try{
                items=(List<ActivityLogs>) q.setParameter("startDate", startDate).
                        setParameter("endDate", endDate).
                        getResultList();
        }
        catch(Exception ex){     
            System.out.println(ex.getMessage());
        }
        
        
    }
     return items;
     }
   
     public List<ActivityLogs> getItems(String stationName, Date startDate, Date endDate) {
          List<ActivityLogs> items=null;
        if (items == null) {
            EntityManager em=getEntityManager();
            Query q= em.createNamedQuery("ActivityLogs.findByPeriodAndStation", ActivityLogs.class);
            try{
                items=(List<ActivityLogs>) q.setParameter("startDate", startDate).
                        setParameter("endDate", endDate).
                        setParameter("stationName", stationName).
                        getResultList();
        }
        catch(Exception ex){     
            System.out.println(ex.getMessage());
        }
        
        
    }
     return items;
     }
     
      public List<ActivityLogs> getItems(Long stationId, Date startDate, Date endDate) {
          List<ActivityLogs> items=null;
        if (items == null) {
            EntityManager em=getEntityManager();
            Query q= em.createNamedQuery("ActivityLogs.findByPeriodAndStationId", ActivityLogs.class);
            try{
                items=(List<ActivityLogs>) q.setParameter("startDate", startDate).
                        setParameter("endDate", endDate).
                        setParameter("stationId", stationId).
                        getResultList();
        }
        catch(Exception ex){     
            System.out.println(ex.getMessage());
        }
        
        
    }
     return items;
     }
      
     
     private List<NoActivitiesInPeriod> getTimeSeries(Long noElements, Date dfrom, Date dto){
         long noItems;
         
         List<NoActivitiesInPeriod> lnoap=null;
        // first build the time values
         List<ActivityLogs> lag = getItems(dfrom, dto);
         noItems = lag.size() > noElements ? noElements : lag.size();
         lnoap=TimeSeries.getInitialTimeSeries(noItems, dfrom, dto);
         // now for each entry count values with sendDate in the given interval
         for(ActivityLogs al : lag){
             for(NoActivitiesInPeriod ap: lnoap){
                 if((al.getSentDate().after(ap.getStartDate())) && (al.getSentDate().before(ap.getEndDate()))){
                     ap.setNoActivities(ap.getNoActivities()+1l);
                     break;
                 }
             }
         }
         return lnoap;
     }
}
