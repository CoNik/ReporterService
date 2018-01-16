package org.reporter.service.ets_reports.nosql;
/**
 *  ETS Project
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 *
 * Utilities used in othre classes
 *
 * Author: constantinn
 * Date: 2017 12 20
 */

public class EtsUtils {

    /**
     * Random generator
     * @param start start interval
     * @param end end interval
     * @return long returned value
     */
    public static long randL(long start, long end){
        double d = Math.random() * Math.abs(end-start) + start;
        return (long)d;
    }

    /**
     * Random generator
     * @param start start interval
     * @param end end interval
     * @return double returned value
     */
    public static double randD(long start, long end){
        double d = Math.random() * Math.abs(end-start) + start;
        return d;
    }
}
