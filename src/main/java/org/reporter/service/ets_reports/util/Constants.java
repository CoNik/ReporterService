/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.util;

import java.util.Date;

/**
 *
 * @author constantinn
 */
public class Constants {
    public final static String dformat="yyyy-MM-dd HH:mm:ss";
    public final static Long noTimeSeries=25l;
    
    public final static Date defaultStartDate = new Date(2017, 10, 19);
    public final static Date defaultEndDate = new Date(2017, 10, 20);
    public final static Long defaultStationId=-1l;
    
    public static final String START_DATE = "START_DATE";
    public static final String END_DATE = "END_DATE";
    public static final String STATION_ID = "STATION_ID";
    
    /** GMap config **/
    public static final String API_KEY = "AIzaSyAkQBIx6iLXrnXocOcUcP98sTqPs-l4v1g";
    
    
    
    /** Chart config **/
    public static final String CHART_DATE_FOMART = "yyyy-MM-dd HH:mm:ss";
    public static final String CHART_TICK_FORMAT ="%#d,%H:%#M:%S";
    
    public static boolean ANIMATE_CHART = true;
    public static final String CHART_POS_COLOR = "97ce21";//"60B53F";
    public static final String CHART_NEG_COLOR =  "EE2F41";//"D32527";
    public static final String CHART_SERIES_COLORS = CHART_POS_COLOR + ", " + CHART_NEG_COLOR;
    
    public static final int NORMALIZE_FACTOR =2;
    
}
