/*
 * ETS Project
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.pattern;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author constantinn
 * Class used to store the list of pattern definition elements used to define what is hapening in a station
 * in one day
 */
public class StationPattern {
    private Long Id;
    private String stationName;
    private Double posX;
    private Double posY;
    private List<PatternElement> patterns;
    
    public StationPattern(){}
    
    public StationPattern(Long pId, String name, double x, double y){
        Id=pId;
        stationName=name;
        posX=x;
        posY=y;
    }

    public void initialize(int step, PatternMask[] mask){
        patterns = new ArrayList();
        int no = 1440/step;
        LocalTime lt =LocalTime.MIN;
        for(int i =0; i<no; i++){
            PatternElement pe = new PatternElement(lt);
            pe.generateValues(lt.getHour(), step, mask);
            pe.setDefTime(lt);
            patterns.add(pe);
            lt=lt.plusMinutes(step);
        }
        
        
    }
    /**
     * @return the stationName
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * @param stationName the stationName to set
     */
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * @return the posX
     */
    public Double getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(Double posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public Double getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(Double posY) {
        this.posY = posY;
    }

    /**
     * @return the patterns
     */
    public List<PatternElement> getPatterns() {
        return patterns;
    }

    /**
     * @param patterns the patterns to set
     */
    public void setPatterns(List<PatternElement> patterns) {
        this.patterns = patterns;
    }

    /**
     * @return the Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(Long Id) {
        this.Id = Id;
    }
    
}
