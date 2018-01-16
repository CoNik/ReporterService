/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reporter.service.ets_reports.service;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.reporter.service.ets_reports.ValidatorsActivity;

/**
 *
 * @author roxanam
 */
@Stateless
@Path("org.reporter.service.ets_reports.validatorsactivity")
public class ValidatorsActivityFacadeREST extends AbstractFacade<ValidatorsActivity> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public ValidatorsActivityFacadeREST() {
        super(ValidatorsActivity.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(ValidatorsActivity entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, ValidatorsActivity entity) {
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
    public ValidatorsActivity find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ValidatorsActivity> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<ValidatorsActivity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
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
    
    
    public long calcul(long time_interval, Date dateStart, Date dateEnd){
        long rez=0;
        java.sql.Date sqlDateStart = new java.sql.Date(dateStart.getTime());
        java.sql.Date sqlDateEnd = new java.sql.Date(dateEnd.getTime());
        
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("upsGetTripStatistics").
                registerStoredProcedureParameter("time_interval", Long.class, ParameterMode.IN).
                setParameter("time_interval", time_interval).
                registerStoredProcedureParameter("start_time", Date.class, ParameterMode.IN).
                setParameter("start_time", sqlDateStart).
                registerStoredProcedureParameter("end_time", Date.class, ParameterMode.IN).
                setParameter("end_time", sqlDateEnd).
                registerStoredProcedureParameter("insertCount", Long.class, ParameterMode.OUT);
        
        query.execute();
        rez = (Long)query.getOutputParameterValue("insertCount");
        return rez;
        
    }
    
}
