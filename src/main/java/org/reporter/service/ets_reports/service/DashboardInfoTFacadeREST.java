/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
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
import javax.ws.rs.core.Response;

import org.reporter.service.ets_reports.DashboardInfo;
import org.reporter.service.ets_reports.DashboardInfoT;
import org.reporter.service.ets_reports.Stations;

/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.dashboardinfot")
public class DashboardInfoTFacadeREST extends AbstractFacade<DashboardInfoT> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public DashboardInfoTFacadeREST() {
        super(DashboardInfoT.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(DashboardInfoT entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, DashboardInfoT entity) {
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
    public DashboardInfoT find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DashboardInfoT> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DashboardInfoT> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @GET
    @Path("byStationId/{stationid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public DashboardInfoT getByStationId(@PathParam("stationid") Integer stationid) {
       return  findByStationId(stationid);
    }
    
    @GET
    @Path("byStationName/{stationName}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response getByStationName(@PathParam("stationName") String stationName){
        if(stationName==null || stationName.trim().isEmpty()){
            return Response.serverError().entity("Station name cannot be empty!").build();
        }
        DashboardInfoT di = findByStationName(stationName);
        if(di==null){
            return Response.status(Response.Status.NOT_FOUND).entity("Station not found").build();
        }else{
            return Response.ok().entity(di).build();
        }
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    private DashboardInfoT findByStationId (Integer stationid){
        DashboardInfoT di = null;
        Query q= em.createNamedQuery("DashboardInfoT.findByStationId", DashboardInfoT.class);
            try{
                di=(DashboardInfoT) q.setParameter("stationId", stationid).
                        setFirstResult(0).
                        setMaxResults(1).
                        getSingleResult();                
        }
        catch(Exception ex){     
            System.out.println(ex.getMessage());
        }
            // todo ic 2018 01 11
            // remove this in real situations
            DashboardInfo dirandom=new DashboardInfo();
            di = new DashboardInfoT(dirandom);
            di.setStationId(stationid);
            
        return di;
    }
    
    /**
     * Get station info by stationName. This uses findByStationId.
     * @param stationName
     * @return 
     */
    private DashboardInfoT findByStationName(String stationName){
        DashboardInfoT dashInfo= null;
        //Get stationId
        Stations station = null;
        Query query = em.createNamedQuery("Stations.findByDisplayName", Stations.class);
        try{
            station = (Stations)query.setParameter("displayName", stationName). setFirstResult(0).
                        setMaxResults(1).
                    getSingleResult();
            if(station!=null){
                return findByStationId(station.getStationId().intValue());
            }
        }catch(NonUniqueResultException nure){
            System.out.println("More stations than one found with the same name: " + stationName);
            nure.printStackTrace();
        }catch(NoResultException nre){
            System.out.println("No station named: " + stationName + " found");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return dashInfo;
    }
}
