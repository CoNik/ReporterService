package org.reporter.service.ets_reports.nosql;
/**
 *  ETS Project
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 *
 * Abstract Class used as parent for data persistence
 * The main methods are create, update, remove, find, findAll, count
 *
 * Author: constantinn
 * Date: 2017 12 20
 */
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public abstract class CassandraAbstractFacade<T> {

    CassandraConnector connector;   // conncetor retreived from jdbc driver (should be initialized before with  new CassandraConnector().connect(ipAddress, port);
    EtsData etsData;    // data to be persisted (this is abstract, but polymorphism is used for instance class)

    /**
     * Main constructor
     * @param connector Cassandra connector (previoulsy created and initialized)
     * @param ed Data to be persisted
     */
    public CassandraAbstractFacade(CassandraConnector connector, EtsData ed) {
        this.connector = connector;
        this.etsData = ed;

    }

    /**
     * This method inserts a record in database (creates a raw)
     * @param ed Data to be persisted
     */
    public String create(EtsData ed) {
        //TO DO
        // create entry in Cassandra
        this.etsData = ed;
        return "";
    }

    /**
     * This method updates  a record
     * The record is updated based on id (from the input object)
     *
     * @param ed  Object to be edited
     */
    public void update(EtsData ed) {
        //TO DO
        // update entry in Cassandra
        this.etsData = ed;
    }

    /**
     * This methods removes a record from database
     * The recored removed is given by the id member of ed
     *
     * @param ed - Object to be removed
     */
    public void remove(EtsData ed) {
        //TO DO
        // delete entry in Cassandra
        this.etsData = ed;
    }

    /**
     * Method used to search for an object
     * The search is made on id (PK)
     * @param id id of object to be searched
     * @return the found object or null
     */
    public T find(Object id) {
        //TO DO
        // find an object
        T t = null;
        return t;
    }

    /**
     * Method used to search for an object
     * The search is made on uuid (PK)
     * @param uuid id of object to be searched
     * @return the found object or null
     */
    public T find(String uuid) {
        //TO DO
        // find an object
        T t = null;
        return t;
    }

    /**
     * Method used to search for an object
     * The search is made on cardid (Index)
     * @param uuid id of object to be searched
     * @return the found object or null
     */
    public T findByCardid(BigInteger cardid) {
        //TO DO
        // find an object
        T t = null;
        return t;
    }

    
    /**
     * Method used to retrieve all objects from table
     * @return list of objects
     */
    public List<T> findAll() {
        //TO DO
        // find all Objects
        List<T> lt = new ArrayList();
        return lt;
    }

    /**
     * Method used to retrieve all objects from table
     * @param no The maximum number of objects returned
     * @return list of objects
     */
    public List<T> findFirst(long no) {
        //TO DO
        // find all Objects
        List<T> lt = new ArrayList();
        return lt;
    }

    /**
     * Method used to retrieve a list of objects registered in a given period of time
     * @param from Period start date and time
     * @param to Period end date and time
     * @return List of objects
     */
    public List<T> findInPeriod(Date from, Date to) {
        //TO DO
        // find all Objects registered in a period of time
        List<T> lt = new ArrayList();
        return lt;
    }

    /**
     * Method used to retrieve a list of objects registered in a given period of time
     * @param from Period start date and time
     * @param to Period end date and time
     * @param  no Maximum number of records returned
     * @return List of objects
     */
    public List<T> findFirstInPeriod(Date from, Date to, long no) {
        //TO DO
        // find all Objects registered in a period of time
        List<T> lt = new ArrayList();
        return lt;
    }

    /**
     * Counts how many records are in table
     * @return Number of records
     */
    public long countAll() {
        //TO DO
        // count all objects
        long l = 0l;
        return l;
    }
    
      /**
     * Counts how many records are in table
     * @return Number of records
     */
    public long countByCardId(long cardid) {
        //TO DO
        // count all objects
        long l = 0l;
        return l;
    }

    /**
     * Counts the number of records registered in a period
     * @param from Period start date and time
     * @param to Period end date and time
     * @return Number of records
     */
    public long countInPeriod(Date from, Date to) {
        //TO DO
        // count objects registered in a period
        long l = 0l;
        return l;
    }

}
