package org.reporter.service.ets_reports.nosql;
/**
 *  ETS Project
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 *
 * Abstract Class used as parent for data stored in Cassandra
 * Persistence is done using CassandraAbstractFacade
 *
 * Author: constantinn
 * Date: 2017 12 20
 */
import com.datastax.driver.mapping.annotations.Transient;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public abstract class EtsData implements Serializable{
    @Transient
    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        return tableName;
    }

    public String toJSONString(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
