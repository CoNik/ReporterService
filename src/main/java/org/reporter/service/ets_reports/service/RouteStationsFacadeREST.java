/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.service;

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
import javax.ws.rs.core.PathSegment;

import org.reporter.service.ets_reports.RouteStations;
import org.reporter.service.ets_reports.RouteStationsPK;

/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.routestations")
public class RouteStationsFacadeREST extends AbstractFacade<RouteStations> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    private RouteStationsPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;routeCode=routeCodeValue;stationId=stationIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        org.reporter.service.ets_reports.RouteStationsPK key = new org.reporter.service.ets_reports.RouteStationsPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> routeCode = map.get("routeCode");
        if (routeCode != null && !routeCode.isEmpty()) {
            key.setRouteCode(routeCode.get(0));
        }
        java.util.List<String> stationId = map.get("stationId");
        if (stationId != null && !stationId.isEmpty()) {
            key.setStationId(new java.lang.Long(stationId.get(0)));
        }
        return key;
    }

    public RouteStationsFacadeREST() {
        super(RouteStations.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(RouteStations entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, RouteStations entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        org.reporter.service.ets_reports.RouteStationsPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public RouteStations find(@PathParam("id") PathSegment id) {
        org.reporter.service.ets_reports.RouteStationsPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RouteStations> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<RouteStations> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    
}
