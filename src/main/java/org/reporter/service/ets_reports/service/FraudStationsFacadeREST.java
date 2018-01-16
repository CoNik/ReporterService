/*
 *  
 * Reporter Service 2018 Updates
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

import org.reporter.service.ets_reports.FraudStations;
import org.reporter.service.ets_reports.StationPositions;
import org.reporter.service.ets_reports.maps.data.StationFraudulents;
import org.reporter.service.ets_reports.util.Constants;

/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.fraudstations")
public class FraudStationsFacadeREST extends AbstractFacade<FraudStations> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
     private final static String dformat=Constants.dformat;

    public FraudStationsFacadeREST() {
        super(FraudStations.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(FraudStations entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, FraudStations entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public FraudStations find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FraudStations> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FraudStations> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("byPeriodAndStationId/{from}/{to}/{stationId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<FraudStations> findByPeriodAndStationId(@PathParam("from") String sfrom, @PathParam("to") String sto, @PathParam("stationId") Long stationId) {
        DateFormat format = new SimpleDateFormat(dformat);
         Date from = new Date();
         from.setTime(from.getTime()-3600000);
         Date to = new Date();
         
        try {
            from = format.parse(sfrom);
            to = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(KioskItemsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getItems(stationId,from, to);
    }
    
    @GET
    @Path("countByPeriodAndStationId/{from}/{to}/{stationId}")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Long countByPeriodAndStationId(@PathParam("from") String sfrom, @PathParam("to") String sto, @PathParam("stationId") Long stationId) {
        DateFormat format = new SimpleDateFormat(dformat);
        Date from = new Date();
        from.setTime(from.getTime()-3600000);
        Date to = new Date();
         
        try {
            from = format.parse(sfrom);
            to = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(KioskItemsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countItems(stationId,from, to);
    }
    
    @GET
    @Path("stationsFraudulents/{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StationFraudulents> findStationFraudulents(@PathParam("from") String sfrom, @PathParam("to") String sto){
        DateFormat format = new SimpleDateFormat(dformat);
        Date from = new Date();
        from.setTime(from.getTime()-3600000);
        Date to = new Date();
        try {
            from = format.parse(sfrom);
            to = format.parse(sto);
        } catch (ParseException ex) {
            Logger.getLogger(KioskItemsFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getStationFraudulents(from, to);
    }
    
    public List<FraudStations> getItems(Long stationId, Date startDate, Date endDate) {
          List<FraudStations> items=null;
        if (items == null) {
            EntityManager em=getEntityManager();
            Query q= em.createNamedQuery("FraudStations.findByPeriodAndStationId", FraudStations.class);
            try{
                items=(List<FraudStations>) q.setParameter("startDate", startDate).
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
     
     
    public Long countItems(Long stationId, Date startDate, Date endDate) {
        List<FraudStations> items=null;
        Long lret=0l;
        if (items == null) {
          EntityManager em=getEntityManager();
          Query q= em.createNamedQuery("FraudStations.countByPeriodAndStationId", FraudStations.class);
          try{
              lret=(Long) q.setParameter("startDate", startDate).
                      setParameter("endDate", endDate).
                      setParameter("stationId", stationId).getSingleResult();

            }
          catch(Exception ex){     
              System.out.println(ex.getMessage());
          }
        }
        
        return lret;
    }
    
    /**
     * Get a list with stations and nb of fraudulents for each station.
     * Uses countItems method to get fraudulents number for a station within a period of time
     * @param startDate
     * @param endDate
     * @return 
     */
    public List<StationFraudulents> getStationFraudulents(Date startDate, Date endDate){
        List<StationFraudulents> stationFraudulents = new ArrayList<>();
        EntityManager em = getEntityManager();
        Query getStationsPositionQuery = em.createNamedQuery("StationPositions.findAll", StationPositions.class);
        List<StationPositions> stations = getStationsPositionQuery.getResultList();
        
        for(StationPositions station:stations){
            StationFraudulents sf = new StationFraudulents(station.getStationId());
            if(station.getPosX()!=null && station.getPosY()!=null){
                sf.setPosX(station.getPosX());
                sf.setPosY(station.getPosY());
            }
            sf.setStationName(station.getDisplayName());
            
            //get nb of fraudulents for this station
            sf.setFraudulents(countItems(sf.getStationId(), startDate, endDate));
            
            stationFraudulents.add(sf);
        }
        
        return stationFraudulents;
    }
    
     
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
