/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.reporter.service.ets_reports.ActivityLogs;
import org.reporter.service.ets_reports.NoActivitiesInPeriod;

/**
 *
 * @author constantinn
 */
public class TimeSeries {
    
    public static  List<NoActivitiesInPeriod> getInitialTimeSeries(Long noItems, Date dfrom, Date dto){
    List<NoActivitiesInPeriod> lnoap=null;
        if(noItems<1) return null;
        lnoap=new ArrayList<>();
         long l1=dfrom.getTime();
         long l2=dto.getTime();
         long step=(l2-l1)/noItems;
         // first build the time values
         for(int i=0; i<noItems; i++){
            
             NoActivitiesInPeriod nap = new NoActivitiesInPeriod();
             Date lds=new Date();
             Date lde=new Date();
             lds.setTime(l1+i*step);
             nap.setStartDate(lds);
             lde.setTime(l1+(i+1)*step);
             nap.setEndDate(lde);
             nap.setNoActivities(0l);
             lnoap.add(nap);
         }
         return lnoap;
    }
}
