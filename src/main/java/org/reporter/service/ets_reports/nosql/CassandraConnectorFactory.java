/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.nosql;

import com.datastax.driver.core.Session;
import com.datastax.driver.core.Cluster;

/**
 *
 * @author constantinn
 */
public class CassandraConnectorFactory {
    
        final static String ipAddress =  "localhost";
        final static int port =  9042;
        final static String PU =  "url.connector.value";    //TODO: insert connector to cassandra repo
        private final static CassandraConnector CLIENT = new CassandraConnector();
        
    private CassandraConnectorFactory() {
          


//        System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
//        client.connect(ipAddress, port);
    }
    public static Session getSession(){
        if(CLIENT.getSession()==null){
            CLIENT.connect(ipAddress, port);
        }
        return CLIENT.getSession();
    }
    
    public static CassandraConnector getCassandraConnector(){
        if(CLIENT.getSession()==null){
            CLIENT.connect(ipAddress, port);
        }
        return CLIENT;
    }
    public static CassandraConnectorFactory getInstance() {
        return CassandraConnectorFactoryHolder.INSTANCE;
    }
    
    private static class CassandraConnectorFactoryHolder {
        private static final CassandraConnectorFactory INSTANCE = new CassandraConnectorFactory();
        
    }
}
