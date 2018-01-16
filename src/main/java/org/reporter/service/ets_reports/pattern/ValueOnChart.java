/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.pattern;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@XmlRootElement
public class ValueOnChart implements Serializable{
    private String timeStamp;
    private Long value;
    
    public ValueOnChart(){}
    
    public ValueOnChart(String st, Long lv){
        timeStamp=st;
        value = lv;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the value
     */
    public Long getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Long value) {
        this.value = value;
    }
    
}
