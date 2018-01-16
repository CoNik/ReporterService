/*
 * ETS Project
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.pattern;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

import org.reporter.service.ets_reports.util.Constants;

/**
 *
 * @author constantinn
 */
@XmlRootElement
public class ValueOnMap implements Serializable{
    private Long stationId;
    private String stationName;
    private int posX;
    private int posY;
    private String color;
    private long value;
    private int normalValue;
    
    public ValueOnMap(){
        
    }
    
    public ValueOnMap(Long pstationId, String pstationName){
        stationName = pstationName;
        stationId = pstationId;
        
    }
    
    public ValueOnMap(Long pstationId, String pstationName, int pposX, int pposY, long pvalue){
        stationName = pstationName;
        stationId = pstationId;
        
        posX=pposX;
        posY=pposY;
        
        value = pvalue;
        
        normalValue = (int)(pvalue / Constants.NORMALIZE_FACTOR);
        
        color = getColor(normalValue);
        
    }
    
    private String getColor(int val){
        String col="";
        int red = val*10 > 255 ? 255 : val*10;
        int green = 255-red;
        int blue =0;
        String sr= Integer.toHexString(red);
        if(sr.length()<2)
            sr ="0"+sr;
        
        String sg= Integer.toHexString(green);
        if(sg.length()<2)
            sg ="0"+sg;
        
        String sb= Integer.toHexString(blue);
        if(sb.length()<2)
            sb ="0"+sb;
        
        col = "#" + sr+sg+sb;
        return col;
    }

    /**
     * @return the stationId
     */
    public Long getStationId() {
        return stationId;
    }

    /**
     * @param stationId the stationId to set
     */
    public void setStationId(Long stationId) {
        this.stationId = stationId;
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
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the value
     */
    public long getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(long value) {
        this.value = value;
    }

    /**
     * @return the normalValue
     */
    public int getNormalValue() {
        return normalValue;
    }

    /**
     * @param normalValue the normalValue to set
     */
    public void setNormalValue(int normalValue) {
        this.normalValue = normalValue;
    }
    
}
