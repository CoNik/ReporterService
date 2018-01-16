package org.reporter.service.ets_reports.charts;

import java.io.Serializable;

/**
 *
 * @author constantinn
 */
public class EtsChart implements Serializable{
    
    private String srcBase64;
    private String chartDescription;
    private String startDate;
    private String endDate;
    
    public EtsChart(){}

    public EtsChart(String srcBase64, String chartDescription, String startDate, String endDate) {
        this.srcBase64 = srcBase64;
        this.chartDescription = chartDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getSrcBase64() {
        return srcBase64;
    }
    public void setSrcBase64(String srcBase64) {
        this.srcBase64 = srcBase64;
    }
    public String getChartDescription() {
        return chartDescription;
    }
    public void setChartDescription(String chartDescription) {
        this.chartDescription = chartDescription;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
}
