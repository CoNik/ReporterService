/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.service;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.reporter.service.ets_reports.nosql.CassandraConnectorFactory;
import org.reporter.service.ets_reports.nosql.LocationWorkData;
import org.reporter.service.ets_reports.nosql.LocationWorkFacade;


/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.locationwork")
public class LocationWorkFacadeREST  {


    public LocationWorkFacadeREST() {
        //super(LocationWork.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public String create(LocationWorkData entity) {
         LocationWorkFacade lf = new LocationWorkFacade(CassandraConnectorFactory.getCassandraConnector(), entity);
         return lf.create(entity);
    }
    
    @GET
    @Path("first/{limit}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<LocationWorkData> findLimit(@PathParam("limit") long limit) {
        
        List<LocationWorkData> lpd=null;
        
        LocationWorkData ld = new LocationWorkData(3);
        LocationWorkFacade lf = new LocationWorkFacade(CassandraConnectorFactory.getCassandraConnector(), ld);

        lpd= lf.findFirst(limit);

        return lpd;
    }
    
    @GET
    @Path("byCardId/{cardid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<LocationWorkData> findByCardId(@PathParam("cardid") long cardid) {
        
        List<LocationWorkData> lld=null;
        
        LocationWorkData ld = new LocationWorkData(3);
        LocationWorkFacade lf = new LocationWorkFacade(CassandraConnectorFactory.getCassandraConnector(), ld);

        lld= lf.findByCardid(BigInteger.valueOf(cardid));

        return lld;
    }
    
    @GET
    @Path("byUUID/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<LocationWorkData> findById(@PathParam("id") String uuid) {
        
        List<LocationWorkData> lld=null;
        
        LocationWorkData ld = new LocationWorkData(3);
        LocationWorkFacade lf = new LocationWorkFacade(CassandraConnectorFactory.getCassandraConnector(), ld);

        lld= lf.find(uuid);

        return lld;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<LocationWorkData> findAll() {
        
        List<LocationWorkData> lld = null;
        

        LocationWorkData ld = new LocationWorkData(3);
        LocationWorkFacade lf = new LocationWorkFacade(CassandraConnectorFactory.getCassandraConnector(), ld);

        lld= lf.findAll();

        return lld;
    }
    
    @GET
    @Path("countByCardId/{cardid}")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Long countByCardId(@PathParam("cardid") long cardid) {
        
        long lc=0l;
        
        LocationWorkData ld = new LocationWorkData(3);
        LocationWorkFacade lf = new LocationWorkFacade(CassandraConnectorFactory.getCassandraConnector(), ld);

        lc= lf.countByCardId(cardid);

        return lc;
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Long countAll() {
        
        long lc=0l;
        
        LocationWorkData ld = new LocationWorkData(3);
        LocationWorkFacade lf = new LocationWorkFacade(CassandraConnectorFactory.getCassandraConnector(), ld);

        lc= lf.countAll();

        return lc;
    }
    
    
}
