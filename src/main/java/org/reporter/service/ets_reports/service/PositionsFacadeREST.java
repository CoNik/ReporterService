/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.service;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.reporter.service.ets_reports.nosql.CassandraConnectorFactory;
import org.reporter.service.ets_reports.nosql.PositionData;
import org.reporter.service.ets_reports.nosql.PositionFacade;

/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.positions")
public class PositionsFacadeREST  {

    //@PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    //private EntityManager em;
        
    public PositionsFacadeREST() {
        //super(Positions.class);
        
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON})
    public String create(PositionData entity) {
         PositionFacade pf = new PositionFacade(CassandraConnectorFactory.getCassandraConnector(), entity);
        return pf.create(entity);
    }
    
    
     @GET
     @Path("testCassandra")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String testCassandra() {
        Session cs =  CassandraConnectorFactory.getSession();
        String ss="";
        ResultSet rs = cs.execute("select release_version from system.local");

        for (Row r : rs) {
            System.out.println("Row: " + r.toString());
            ss=ss+r.toString();
        }

  
        //client.close();
        return ss;
    }
    
    @GET
    @Path("first/{limit}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PositionData> findLimit(@PathParam("limit") long limit) {
        
        List<PositionData> lpd=null;
        
        PositionData pd = new PositionData(3);
        PositionFacade pf = new PositionFacade(CassandraConnectorFactory.getCassandraConnector(), pd);

        lpd= pf.findFirst(limit);

        return lpd;
    }
    
    @GET
    @Path("byCardId/{cardid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PositionData> findByCardId(@PathParam("cardid") long cardid) {
        
        List<PositionData> lpd=null;
        
        PositionData pd = new PositionData(3);
        PositionFacade pf = new PositionFacade(CassandraConnectorFactory.getCassandraConnector(), pd);

        lpd= pf.findByCardid(BigInteger.valueOf(cardid));

        return lpd;
    }
    
    @GET
    @Path("byUUID/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PositionData> findById(@PathParam("id") String uuid) {
        
        List<PositionData> lpd=null;
        
        PositionData pd = new PositionData(3);
        PositionFacade pf = new PositionFacade(CassandraConnectorFactory.getCassandraConnector(), pd);

        lpd= pf.find(uuid);

        return lpd;
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<PositionData> findAll() {
        
        List<PositionData> lpd = null;
        

        PositionData pd = new PositionData(3);
        PositionFacade pf = new PositionFacade(CassandraConnectorFactory.getCassandraConnector(), pd);

        lpd= pf.findAll();

        return lpd;
    }
    
    @GET
    @Path("countByCardId/{cardid}")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Long countByCardId(@PathParam("cardid") long cardid) {
        
        long lc=0l;
        
        PositionData pd = new PositionData(3);
        PositionFacade lf = new PositionFacade(CassandraConnectorFactory.getCassandraConnector(), pd);

        lc= lf.countByCardId(cardid);

        return lc;
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Long countAll() {
        
        long lc=0l;
        
        PositionData pd = new PositionData(3);
        PositionFacade lf = new PositionFacade(CassandraConnectorFactory.getCassandraConnector(), pd);

        lc= lf.countAll();

        return lc;
    }
    
}
