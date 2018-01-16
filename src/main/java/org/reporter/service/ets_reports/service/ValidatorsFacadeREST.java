/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.ws.rs.core.PathSegment;

import org.reporter.service.ets_reports.StationPositions;
import org.reporter.service.ets_reports.Validators;
import org.reporter.service.ets_reports.ValidatorsPK;
import org.reporter.service.ets_reports.util.ValidatorPosition;

/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.validators")
public class ValidatorsFacadeREST extends AbstractFacade<Validators> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private ValidatorsPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;validatorCode=validatorCodeValue;iPAdress=iPAdressValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        org.reporter.service.ets_reports.ValidatorsPK key = new org.reporter.service.ets_reports.ValidatorsPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> validatorCode = map.get("validatorCode");
        if (validatorCode != null && !validatorCode.isEmpty()) {
            key.setValidatorCode(validatorCode.get(0));
        }
        java.util.List<String> iPAdress = map.get("iPAdress");
        if (iPAdress != null && !iPAdress.isEmpty()) {
            key.setIPAdress(iPAdress.get(0));
        }
        return key;
    }

    public ValidatorsFacadeREST() {
        super(Validators.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Validators entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Validators entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        org.reporter.service.ets_reports.ValidatorsPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Validators find(@PathParam("id") PathSegment id) {
        org.reporter.service.ets_reports.ValidatorsPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Validators> findAll() {
        return super.findAll();
    }
    
     @GET
    @Path("positions")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ValidatorPosition> findAllPositions() {
        return this.getAllValidatorPositions();
    }
    

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Validators> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("inStation/{station}")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ValidatorPosition> findInStation(@PathParam("station") Long stationId) {
        
        List<ValidatorPosition> lret = getValidatorPositions(stationId);
       
        return lret;

    }

    @GET
    @Path("inStationString/{station}")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String findInStationString(@PathParam("station") Long stationId) {
        String ret = "";
        List<Validators> lv = getItems(stationId);
        if (lv == null) {
            ret = "No validators in station " + stationId;
        } else {
            for (Validators v : lv) {
                ret = ret + "{"+ v.getValidatorsPK().getValidatorCode() +"-" +v.getValidatorsPK().getIPAdress() +"}" + ";";
            }
        }
        return ret;

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

    public List<Validators> getItems(Long stationId) {
        List<Validators> items = null;
        if (items == null) {
            EntityManager em = getEntityManager();
            Query q = em.createNamedQuery("Validators.findByStationID", Validators.class);
            try {
                items = (List<Validators>) q.setParameter("stationID", stationId).
                        getResultList();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        
        return items;
    }
    
    public List<ValidatorPosition> getValidatorPositions(Long stationId) {
        List<Validators> items = null;
        List<ValidatorPosition> lret = new ArrayList<ValidatorPosition>();
        if (items == null) {
            EntityManager em = getEntityManager();
            Query q = em.createNamedQuery("Validators.findByStationID", Validators.class);
            try {
                items = (List<Validators>) q.setParameter("stationID", stationId).
                        getResultList();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        
        Query q1 = em.createNamedQuery("StationPositions.findByStationId", Validators.class);
        
         for (Validators v : items) {
             StationPositions sp =(StationPositions) q1.setParameter("stationId", stationId).getSingleResult();
                     
                ValidatorPosition vp = new ValidatorPosition();
                vp.setCode(v.getValidatorsPK().getValidatorCode());
                vp.setIPAddress(v.getValidatorsPK().getIPAdress());
                vp.setPosX(sp.getPosX());
                vp.setPosY(sp.getPosY());
                lret.add(vp);
                
                
            }
         
        return lret;
    }
    
    public List<ValidatorPosition> getAllValidatorPositions() {
        List<Validators> items = findAll();
        List<ValidatorPosition> lret = new ArrayList<ValidatorPosition>();
        
        Query q1 = em.createNamedQuery("StationPositions.findByStationId", Validators.class);
        for(Validators v : items) {
             StationPositions sp =(StationPositions) q1.setParameter("stationId", v.getStationId().getStationId()).getSingleResult();
                ValidatorPosition vp = new ValidatorPosition();
                vp.setStationId(v.getStationId().getStationId());
                vp.setStationName(v.getStationId().getDisplayName());
                vp.setCode(v.getValidatorsPK().getValidatorCode());
                vp.setIPAddress(v.getValidatorsPK().getIPAdress());
                vp.setPosX(sp.getPosX());
                vp.setPosY(sp.getPosY());
                lret.add(vp);
        }
         
        return lret;
    }
    
}
