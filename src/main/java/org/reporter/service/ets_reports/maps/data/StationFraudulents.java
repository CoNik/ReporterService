
package org.reporter.service.ets_reports.maps.data;

/**
 *
 * @author constantinn
 */
public class StationFraudulents {
    
    private Long stationId;
    private String stationName;
    private double posX;
    private double posY;
    private Long fraudulents;

    public StationFraudulents(){}
    
    public StationFraudulents(Long stationId){
        this.stationId = stationId;
    }
    
    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public Long getFraudulents() {
        return fraudulents;
    }

    public void setFraudulents(Long fraudulents) {
        this.fraudulents = fraudulents;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    
    
    
    
    
}
