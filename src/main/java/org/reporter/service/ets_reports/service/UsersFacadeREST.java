/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.service;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
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

import org.reporter.service.ets_reports.Users;
import org.reporter.service.ets_reports.nosql.CassandraConnector;

/**
 *
 * @author constantinn
 */
@Stateless
@Path("org.reporter.service.ets_reports.users")
public class UsersFacadeREST extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "org.reporting.service.nomicro.ets_ETS_Reports_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Users entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Users entity) {
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
    public Users find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

     @GET
     @Path("testCassandra")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String testCassandra() {
         final CassandraConnector client = new CassandraConnector();
        final String ipAddress =  "localhost";
        final int port =  9042;
        final String PU =  "cassandra.url.string"; //TODO: insert local cassandra string

        String ss="";
        System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
        client.connect(ipAddress, port);

        ResultSet rs = client.getSession().execute("select * from ets.positions");

        for (Row r : rs) {
            System.out.println("Row: " + r.toString());
          ss=ss+r.toString();
        }

  
        client.close();
        return ss;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
