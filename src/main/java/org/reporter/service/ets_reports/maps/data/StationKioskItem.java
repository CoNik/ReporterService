package org.reporter.service.ets_reports.maps.data;

/**
 *
 * @author constantinn
 */
public class StationKioskItem {
    
    private Long stationId;
    private String stationName;
    private double posX;
    private double posY;
    private String tooltipText;
    
    public StationKioskItem(){
    
    }

    public StationKioskItem(Long stationId, double posX, double posY) {
        this.stationId = stationId;
        this.posX = posX;
        this.posY = posY;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
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

    public String getTooltipText() {
        return tooltipText;
    }

    public void setTooltipText(String tooltipText) {
        this.tooltipText = tooltipText;
    }
    
    
    
}
