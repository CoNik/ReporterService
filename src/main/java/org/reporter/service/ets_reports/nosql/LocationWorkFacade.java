package org.reporter.service.ets_reports.nosql;
/**
 *  ETS Project
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 *
 * Class used ato persist data in format packaged by LocationWork class
 * The main methods are create, update, remove, find, findAll, count
 *
 * Author: constantinn
 * Date: 2017 12 20
 */
import com.datastax.driver.core.*;
import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class LocationWorkFacade extends CassandraAbstractFacade {
    public LocationWorkFacade(CassandraConnector connector, EtsData etsData) {
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
        LocationWorkData lwd = (LocationWorkData) etsData;
        Session session = connector.getSession();
        Date dn = new Date();
        try {
            PreparedStatement statement = session.prepare(
                    "INSERT INTO  "
                            + etsData.getTableName() + " "
                            + "(id, "

                            + " cardid, "

                            + " createdate, "

                            + " currentbalance, "
                            + " currentpasscount, "

                            + " customerid, "
                            + " loyaltypasscount, " // double,

                            //opt_station_list LIST<bigint>,
                            //opt_station_list_ts LIST<timestamp>,
                            + " stationid_entrance, " // bigint,
                            + " station_id_exit, " // bigint,
                            + " status, " // text,
                            + " travel_time, " // int,
                            + " ts_entrance, " // timestamp,
                            + " ts_exit, " // timestamp,
                            + " validationdate, " // timestamp,

                            + " validator_code_entrance, " // text,
                            + " validator_code_exit " // text,

                            + ") VALUES (now(), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");

// create the bound statement and initialise it with your prepared statement
            BoundStatement boundStatement = new BoundStatement(statement);

            session.execute( // this is where the query is executed
                    boundStatement.bind( // here you are binding the 'boundStatement'

                            lwd.getCardid(), //       + " card_id, "

                            lwd.getCreatedate(), //+ " createdate, "

                            lwd.getCurrentbalance(), //+ " currentbalance, "
                            lwd.getCurrentpasscount(), //+ " currentpasscount, "

                            lwd.getCustomerid(), // + " customerid, "
                            lwd.getLoyaltypasscount(), // + " loyaltypasscount, " // double,
                            //opt_station_list LIST<bigint>,
                            //opt_station_list_ts LIST<timestamp>,

                            lwd.getStationid_entrance(), // + " stationid_entrance, " // bigint,
                            lwd.getStation_id_exit(), // + " station_id_exit, " // bigint,
                            lwd.getStatus(), // " status, " // text,
                            lwd.getTravel_time(), // + " travel_time, " // int,
                            lwd.getTs_entrance(), //+ " ts_entrance, " // timestamp,
                            lwd.getTs_exit(), //+ " ts_exit, " // timestamp,
                            lwd.getValidationdate(), //+ " validationdate, " // timestamp,

                            lwd.getValidator_code_entrance(), // + " validator_code_entrance, " // text,
                            lwd.getValidator_code_exit()  //+ " validator_code_exit " // text,
                    ));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
         String ss = session.execute("select id from " +etsData.getTableName() +" limit 1").one().getUUID(0).toString();
        return ss;
    }

    /**
     * Method used to retrieve all objects from table
     * @return list of objects
     */
    @Override
    public List<LocationWorkData> findAll() {
        //TO DO
        // find all Objects
        List<LocationWorkData> lt = new ArrayList();

        ResultSet rs = connector.getSession().execute("select * from "+etsData.getTableName());
        for (Row r : rs) {
            LocationWorkData lwd = RowTodata(r);
            lt.add(lwd);

        }
        return lt;
    }
    
    /**
     * Method used to count all objects from table
     * @return list of objects
     */
    @Override
    public long countAll() {
        //TO DO
        // find all Objects
        Row rw = connector.getSession().execute("select count(*) from " +etsData.getTableName()).one();
        return rw.getLong(0);
        
    }
    

    /**
     * Method used to retrieve first objects from table
     * @return list of objects
     */
    @Override
    public List<LocationWorkData> findFirst(long limit) {
        //TO DO
        // find all Objects
        List<LocationWorkData> lt = new ArrayList();

        ResultSet rs = connector.getSession().execute("select * from "+etsData.getTableName()+" limit " + limit);
        for (Row r : rs) {
            LocationWorkData ld = RowTodata(r);
            lt.add(ld);

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
    public List<LocationWorkData> findByCardid(BigInteger cardid) {
        //TO DO
        // find all Objects
        List<LocationWorkData> lt = new ArrayList();
        String sc = "select * from "+etsData.getTableName()+" where cardid = "  + cardid.toString() ;
        ResultSet rs = connector.getSession().execute(sc);
        for (Row r : rs) {
            LocationWorkData pd = RowTodata(r);
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
       
        String sc = "select count(*) from " +etsData.getTableName() +" where cardid = "  + cardid ;
        Row  rw= connector.getSession().execute(sc).one();
         return rw.getLong(0);
    }
    
    
    /**
     * Method used to search for an object
     * The search is made on uuid (PK)
     * @param uuid id of object to be searched
     * @return the found object or null
     */

    public List<LocationWorkData> find(String uuid) {
        //TO DO
        // find all Objects
        List<LocationWorkData> lt = new ArrayList();
        String sc = "select * from "+etsData.getTableName()+" where uuid = " + uuid.toString() ;
        ResultSet rs = connector.getSession().execute(sc);
        for (Row r : rs) {
            LocationWorkData lwd = RowTodata(r);
            lt.add(lwd);

        }
        return lt;
    }

    /**
     * Converts a Raw read in a ResultSet after the execution of a CQL statement and compose a LocationWorkData Object
     * @param r a raw from a recordSet obtained after the execution of a CQL statement
     * @return LocationWorkData Object
     */
    private LocationWorkData RowTodata(Row r) {
        LocationWorkData lwd = new LocationWorkData();
        lwd.setId(r.getUUID("id"));
        lwd.setCardid(r.getLong("cardid"));
        lwd.setCreatedate(r.getTimestamp("createdate"));
        lwd.setCurrentbalance(r.getDouble("currentbalance"));
        lwd.setCurrentpasscount(r.getDouble("currentpasscount"));
        lwd.setCustomerid(r.getLong("customerid"));
        lwd.setLoyaltypasscount(r.getDouble("loyaltypasscount"));
        //lwd.setOpt_station_list(r.getList(0, List.class);
        //lwd.setOpt_station_list_ts(r.getList());
        lwd.setStationid_entrance(r.getLong("stationid_entrance"));
        lwd.setStation_id_exit(r.getLong("station_id_exit"));
        lwd.setStatus(r.getString("status"));
        lwd.setTravel_time(r.getInt("travel_time"));
        lwd.setTs_entrance(r.getTimestamp("ts_entrance"));
        lwd.setTs_exit(r.getTimestamp("ts_exit"));
        lwd.setValidationdate(r.getTimestamp("validationdate"));
        lwd.setValidator_code_entrance(r.getString("validator_code_entrance"));
        lwd.setValidator_code_exit(r.getString("validator_code_exit"));
        return lwd;
    }
}
