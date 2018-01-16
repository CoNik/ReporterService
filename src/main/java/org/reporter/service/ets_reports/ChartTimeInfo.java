/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author constantinn
 */
public class ChartTimeInfo {

    public ChartTimeInfo(){
        seriesDate = new Date();
        series1Value = (long) Math.round(Math.random()*1000l);
        series2Value = (long) Math.round(Math.random()*100l);;
    }
    
    public ChartTimeInfo(Date d, Long l1, Long l2){
        seriesDate = new Date();
        series1Value = l1;
        series2Value = l2;
    }
   
    private Date    seriesDate;
    private Long    series1Value;
    private Long    series2Value;
    private Long    series3Value;
    private Long    series4Value;
    private Long    series5Value;


    
     /**
     * @return the seriesDate
     */
    public Date getSeriesDate() {
        return seriesDate;
    }

    /**
     * @param seriesDate the seriesDate to set
     */
    public void setSeriesDate(Date seriesDate) {
        this.seriesDate = seriesDate;
    }

    /**
     * @return the series1Value
     */
    public Long getSeries1Value() {
        return series1Value;
    }

    /**
     * @param series1Value the series1Value to set
     */
    public void setSeries1Value(Long series1Value) {
        this.series1Value = series1Value;
    }

    /**
     * @return the series2Value
     */
    public Long getSeries2Value() {
        return series2Value;
    }

    /**
     * @param series2Value the series2Value to set
     */
    public void setSeries2Value(Long series2Value) {
        this.series2Value = series2Value;
    }

    /**
     * @return the series3Value
     */
    public Long getSeries3Value() {
        return series3Value;
    }

    /**
     * @param series3Value the series3Value to set
     */
    public void setSeries3Value(Long series3Value) {
        this.series3Value = series3Value;
    }

    /**
     * @return the series4Value
     */
    public Long getSeries4Value() {
        return series4Value;
    }

    /**
     * @param series4Value the series4Value to set
     */
    public void setSeries4Value(Long series4Value) {
        this.series4Value = series4Value;
    }

    /**
     * @return the series5Value
     */
    public Long getSeries5Value() {
        return series5Value;
    }

    /**
     * @param series5Value the series5Value to set
     */
    public void setSeries5Value(Long series5Value) {
        this.series5Value = series5Value;
    }
}
