/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@XmlRootElement
public class NoActivitiesInPeriod implements Serializable{

    /**
     * @return the noActivities
     */
    public Long getNoActivities() {
        return noActivities;
    }

    /**
     * @param noActivities the noActivities to set
     */
    public void setNoActivities(Long noActivities) {
        this.noActivities = noActivities;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    private Long noActivities;
    private Date startDate;
    private Date endDate;
    
}
