/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.pattern;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.reporter.service.ets_reports.StationPositions;
import org.reporter.service.ets_reports.StationPositionsFacade;

/**
 *
 * @author constantinn
 * Class used asd map between a station and a stationpattern
 * This is used for one day data
 */
@Stateless
public class PatternMap {

    private LocalDateTime timeStamp;
    private Map<String, StationPattern> stationPatternMap;
    
   // @EJB
   // StationPositionsFacade spf;
    
    /**
     * Initialize the structures with randomly generated values
     * @param step = step in minutes
     */
    public void initialize(int step, PatternMask[] mask, List<StationPositions> lsp){
       stationPatternMap = new HashMap<String, StationPattern>();
       
        for(StationPositions sp : lsp){
            if(sp!=null){
            String stationName = sp.getDisplayName();
            StationPattern spatern= new StationPattern(sp.getStationId(), sp.getDisplayName(), sp.getPosX() == null ? 0. : sp.getPosX(), sp.getPosY() == null ? 0. : sp.getPosY());
            spatern.initialize(step, mask);
            
            stationPatternMap.put(stationName, spatern);
            //System.out.println(stationName);
            }
        }
    }
    /**
     * @return the timeStamp
     */
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the stationPatternMap
     */
    public Map<String, StationPattern> getStationPatternMap() {
        return stationPatternMap;
    }

    /**
     * @param stationPatternMap the stationPatternMap to set
     */
    public void setStationPatternMap(Map<String, StationPattern> stationPatternMap) {
        this.stationPatternMap = stationPatternMap;
    }

    
    
}
