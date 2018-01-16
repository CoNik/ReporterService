package org.reporter.service.ets_reports.nosql;

import com.datastax.driver.core.*;
import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.reporter.service.ets_reports.nosql.CassandraConnector;

public class PositionFacade extends CassandraAbstractFacade {
    public PositionFacade(CassandraConnector connector, EtsData etsData) {
        super(connector, etsData);
    }
    /**
     * This method inserts a record in database (creates a raw)
     * @param ed Data to be persisted
     */
    @Override
    public String create(EtsData ed) {
        //TO DO
        // create entry in Cassandra
        this.etsData = ed;
        PositionData pd = (PositionData) etsData;
        Session session = connector.getSession();
        Date dn = new Date();
        try {
            PreparedStatement statement = session.prepare(
                    "INSERT INTO  "
                            + etsData.getTableName() + " "
                            + "(id, "
                            + " cardid, "
                            + " customerid, "
                            //location_latitude LIST<float>,
                            //location_longitude LIST<float>,
                            //location_ts LIST<timestamp>,
                            + " travel_init_ts, " // timestamp,
                            + " travel_end_ts " // timestamp,
                            + ") VALUES (now(), ?, ?, ?, ?);");

// create the bound statement and initialise it with your prepared statement
            BoundStatement boundStatement = new BoundStatement(statement);

            session.execute( // this is where the query is executed
                    boundStatement.bind( // here you are binding the 'boundStatement'

                            pd.getCardid(), //       + " card_id, "
                            pd.getCustomerid(), // + " customerid, "
                            pd.getTravel_init_ts(),
                            pd.getTravel_end_ts()
                    ));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        String ss = session.execute("select id from " + etsData.getTableName() + "  limit 1").one().getUUID(0).toString();
        return ss;
    }

    /**
     * Method used to retrieve all objects from table
     * @return list of objects
     */
    @Override
    public List<PositionData> findAll() {
        //TO DO
        // find all Objects
        List<PositionData> lt = new ArrayList();

        ResultSet rs = connector.getSession().execute("select * from " + etsData.getTableName());
        for (Row r : rs) {
            PositionData pd = RowTodata(r);
            lt.add(pd);

        }
        return lt;
    }

    /**
     * Method used to retrieve first objects from table
     * @return list of objects
     */
    @Override
    public List<PositionData> findFirst(long limit) {
        //TO DO
        // find all Objects
        List<PositionData> lt = new ArrayList();

        ResultSet rs = connector.getSession().execute("select * from " +  etsData.getTableName() +" limit " + limit);
        for (Row r : rs) {
            PositionData pd = RowTodata(r);
            lt.add(pd);

        }
        return lt;
    }
    
    /**
     * Method used to search for an object
     * The search is made on uuid (PK)
     * @param uuid id of object to be searched
     * @return the found object or null
     */
    @Override
    public List<PositionData> find(String uuid) {
        //TO DO
        // find all Objects
        List<PositionData> lt = new ArrayList();
        String sc = "select * from ets.positions where id = " +  uuid ;
        ResultSet rs = connector.getSession().execute(sc);
        for (Row r : rs) {
            PositionData pd = RowTodata(r);
            lt.add(pd);

        }
        return lt;
    }

    /**
     * Method used to search for an object
     * The search is made on uuid (PK)
     * @param uuid id of object to be searched
     * @return the found object or null
     */
    @Override
    public List<PositionData> findByCardid(BigInteger cardid) {
        //TO DO
        // find all Objects
        List<PositionData> lt = new ArrayList();
        String sc = "select * from " +  etsData.getTableName() +" where cardid = "  + cardid.toString() ;
        ResultSet rs = connector.getSession().execute(sc);
        for (Row r : rs) {
            PositionData pd = RowTodata(r);
            lt.add(pd);

        }
        return lt;
    }
    
      /**
     * Method used to count for an object
     * The search is made on cardId (PK)
     * @param uuid id of object to be searched
     * @return the found object or null
     */
    @Override
    public long countByCardId(long cardid) {
        //TO DO
        // find all Objects
       
        String sc = "select count(*) from "+ etsData.getTableName()+" where cardid = "  + cardid ;
        Row  rw= connector.getSession().execute(sc).one();
         return rw.getLong(0);
    }
    
    
    /**
     * Method used to count all objects from table
     * @return list of objects
     */
    @Override
    public long countAll() {
        //TO DO
        // find all Objects
        Row rw = connector.getSession().execute("select count(*) from " +  etsData.getTableName()).one();
        return rw.getLong(0);
        
    }
    
    /**
     * Converts a Raw read in a ResultSet after the execution of a CQL statement and compose a PositionData Object
     * @param r a raw from a recordSet obtained after the execution of a CQL statement
     * @return PositionData Object
     */
    private PositionData RowTodata(Row r) {
        PositionData pd = new PositionData();
        pd.setId(r.getUUID("id"));
        pd.setCardid(r.getLong("cardid"));
        pd.setCustomerid(r.getLong("customerid"));
        
        
       try{ 
       pd.setTravel_init_ts(r.getTimestamp("travel_init_ts"));
       pd.setTravel_end_ts(r.getTimestamp("travel_end_ts"));
       }
       catch(Exception ex){
           System.out.println(ex.getMessage());
       }

        return pd;
    }
}