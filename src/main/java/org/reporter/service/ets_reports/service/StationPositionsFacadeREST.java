/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.reporter.service.ets_reports.StationPositions;
import org.reporter.service.ets_reports.pattern.PatternFactory;
import org.reporter.service.ets_reports.pattern.PatternMain;
import org.reporter.service.ets_reports.pattern.ValueOnChart;
import org.reporter.service.ets_reports.pattern.ValueOnMap;

/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.stationpositions")
public class StationPositionsFacadeREST extends AbstractFacade<StationPositions> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public StationPositionsFacadeREST() {
        super(StationPositions.class);
        
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StationPositions entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, StationPositions entity) {
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
    public StationPositions find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StationPositions> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StationPositions> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("testGeneratePattern")
    @Produces(MediaType.TEXT_PLAIN)
    public String initialGeneratePattern() {
        Date d1 = new Date();
        
        List<StationPositions> lsp = findAll();
        PatternMain  pm = PatternFactory.getNewPattern(lsp);
        
        Date d2 = new Date();
        
        long dif = d2.getTime()-d1.getTime();
        
        String sret = "Values generated in " + dif + " miliseconds";
        System.out.println(sret);
        return sret;
    } 
    
    @GET
    @Path("getPositionsOnMap/{day}/{minuteNo}/{nominal}/{card}/{in}/{type}")
    @Produces({MediaType.TEXT_PLAIN + ";charset=utf-8", MediaType.APPLICATION_JSON + ";charset=utf-8", 
        MediaType.APPLICATION_XML + ";charset=utf-8"})
    public List<ValueOnMap> getPositionsOnMap(
            @PathParam("day") Integer day,
            @PathParam("minuteNo") Integer minuteNo,
            @PathParam("nominal") Integer nominal,
            @PathParam("card") Integer card,
            @PathParam("in") Integer in,
            @PathParam("type") Integer type) {
         List<ValueOnMap> lvom= null;
         
         int h = minuteNo/60;
         int m= minuteNo%60;
         
         String timeH = String.format("%02d:%02d",h,m);
         return getPositionsOnMapWithTime(day, timeH, nominal, card, in, type);
         
    }
    
     @GET
    @Path("getPositionsOnMapWithTime/{day}/{localTime}/{nominal}/{card}/{in}/{type}")
    @Produces({MediaType.TEXT_PLAIN + ";charset=utf-8", MediaType.APPLICATION_JSON + ";charset=utf-8", 
        MediaType.APPLICATION_XML + ";charset=utf-8"})
    public List<ValueOnMap> getPositionsOnMapWithTime(
            @PathParam("day") Integer day,
            @PathParam("localTime") String localTime,
            @PathParam("nominal") Integer nominal,
            @PathParam("card") Integer card,
            @PathParam("in") Integer in,
            @PathParam("type") Integer type) {
         List<ValueOnMap> lvom= new ArrayList();
         
        Date d1 = new Date();
        LocalTime lt = LocalTime.parse(localTime+":00", DateTimeFormatter.ISO_LOCAL_TIME);
        
        PatternMain pm = PatternFactory.getPattern();
        
        if(pm.noInit==0)
           initialGeneratePattern();
        
        lvom=pm.getPositionsOnMap(day, lt, nominal, card, in, type);
        
        Date d2 = new Date();
        
        long dif = d2.getTime()-d1.getTime();
        
        //System.out.println("Values generated in " + dif + " miliseconds");
        return lvom;
        
    } 
    
    @GET
    @Path("getPositionsOnChartByName/{day}/{station}/{nominal}/{card}/{in}/{type}")
    @Produces({MediaType.TEXT_PLAIN + ";charset=utf-8", MediaType.APPLICATION_JSON + ";charset=utf-8", 
        MediaType.APPLICATION_XML + ";charset=utf-8"})
    public List<ValueOnChart> getPositionsOnChartByName(
            @PathParam("day") Integer day,
            @PathParam("station") String station,
            @PathParam("nominal") Integer nominal,
            @PathParam("card") Integer card,
            @PathParam("in") Integer in,
            @PathParam("type") Integer type) {
         List<ValueOnChart> lvoc= new ArrayList();
         
        Date d1 = new Date();
        
        PatternMain pm = PatternFactory.getPattern();
        
        if(pm.noInit==0)
           initialGeneratePattern();
        
        lvoc=pm.getPositionsOnChart(day, station, nominal, card, in, type);
        
        Date d2 = new Date();
        
        long dif = d2.getTime()-d1.getTime();
        
        //System.out.println("Values generated in " + dif + " miliseconds");
        return lvoc;
        
    } 
    
    @GET
    @Path("getPositionsOnChart/{day}/{stationId}/{nominal}/{card}/{in}/{type}")
    @Produces({MediaType.TEXT_PLAIN + ";charset=utf-8", MediaType.APPLICATION_JSON + ";charset=utf-8", 
        MediaType.APPLICATION_XML + ";charset=utf-8"})
    public List<ValueOnChart> getPositionsOnChart(
            @PathParam("day") Integer day,
            @PathParam("stationId") Long stationId,
            @PathParam("nominal") Integer nominal,
            @PathParam("card") Integer card,
            @PathParam("in") Integer in,
            @PathParam("type") Integer type) {
         List<ValueOnChart> lvoc= new ArrayList();
         
        Date d1 = new Date();
        
        PatternMain pm = PatternFactory.getPattern();
        
        if(pm.noInit==0)
           initialGeneratePattern();
        
        String stationNanme="";
        StationPositions sp = this.find(stationId);
        stationNanme=sp.getDisplayName();
         
        lvoc=pm.getPositionsOnChart(day, stationNanme, nominal, card, in, type);
        
        Date d2 = new Date();
        
        long dif = d2.getTime()-d1.getTime();
        
        //System.out.println("Values generated in " + dif + " miliseconds");
        return lvoc;
        
    } 
    
    

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
