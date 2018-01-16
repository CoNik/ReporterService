/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import org.reporter.service.ets_reports.CITReports;
import org.reporter.service.ets_reports.util.Constants;

/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.citreports")
public class CITReportsFacadeREST extends AbstractFacade<CITReports> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;
      private final static String dformat=Constants.dformat;

    public CITReportsFacadeREST() {
        super(CITReports.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(CITReports entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, CITReports entity) {
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
    public CITReports find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CITReports> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CITReports> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("byPeriod/{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CITReports> findByPeriod(@PathParam("from") String sfrom, @PathParam("to") String sto) {
        DateFormat format = new SimpleDateFormat(dformat);
         Date from = new Date();
         from.setTime(from.getTime()-3600000);
         Date to = new Date();
         
        try {
            from = format.parse(sfrom);
            to = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(CITReportsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getItems(from, to);
    }
    
    @GET
    @Path("byPeriodAndStation/{from}/{to}/{station}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CITReports> findByPeriodAndStation(@PathParam("from") String sfrom, @PathParam("to") String sto, @PathParam("station") String station) {
        DateFormat format = new SimpleDateFormat(dformat);
         Date from = new Date();
         from.setTime(from.getTime()-3600000);
         Date to = new Date();
         
        try {
            from = format.parse(sfrom);
            to = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(CITReportsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getItems(station,from, to);
    }
    
     @GET
    @Path("byPeriodAndStationId/{from}/{to}/{stationId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CITReports> findByPeriodAndStation(@PathParam("from") String sfrom, @PathParam("to") String sto, @PathParam("stationId") Long stationId) {
        DateFormat format = new SimpleDateFormat(dformat);
         Date from = new Date();
         from.setTime(from.getTime()-3600000);
         Date to = new Date();
         
        try {
            from = format.parse(sfrom);
            to = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(CITReportsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getItems(stationId,from, to);
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
    
    public List<CITReports> getItems(Date startDate, Date endDate) {
        List<CITReports> items=null;
        if (items == null) {
            EntityManager em=getEntityManager();
            Query q= em.createNamedQuery("CITReports.findByPeriod", CITReports.class);
            try{
                items=(List<CITReports>) q.setParameter("startDate", startDate).
                        setParameter("endDate", endDate).
                        getResultList();
        }
        catch(Exception ex){     
            System.out.println(ex.getMessage());
        }
        
        
    }
     return items;
     }
   
     public List<CITReports> getItems(String stationName, Date startDate, Date endDate) {
          List<CITReports> items=null;
        if (items == null) {
            EntityManager em=getEntityManager();
            Query q= em.createNamedQuery("CITReports.findByPeriodAndStation", CITReports.class);
            try{
                items=(List<CITReports>) q.setParameter("startDate", startDate).
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
     
     public List<CITReports> getItems(Long stationId, Date startDate, Date endDate) {
          List<CITReports> items=null;
        if (items == null) {
            EntityManager em=getEntityManager();
            Query q= em.createNamedQuery("CITReports.findByPeriodAndStationId", CITReports.class);
            try{
                items=(List<CITReports>) q.setParameter("startDate", startDate).
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
     
}
