/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports.util;

/**
 *
 * @author constantinn
 */
public class ValidatorPosition {

    private Long stationId;
    private String stationName;
    private String code;
    private String IPAddress;
    private Integer PosX;
    private Integer PosY;
    
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the IPAddress
     */
    public String getIPAddress() {
        return IPAddress;
    }

    /**
     * @param IPAddress the IPAddress to set
     */
    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    /**
     * @return the PosX
     */
    public Integer getPosX() {
        return PosX;
    }

    /**
     * @param PosX the PosX to set
     */
    public void setPosX(Integer PosX) {
        this.PosX = PosX;
    }

    /**
     * @return the PosY
     */
    public Integer getPosY() {
        return PosY;
    }

    /**
     * @param PosY the PosY to set
     */
    public void setPosY(Integer PosY) {
        this.PosY = PosY;
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
    
    
    
}
