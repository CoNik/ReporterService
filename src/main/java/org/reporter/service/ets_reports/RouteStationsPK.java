/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author constantinn
 */
@Embeddable
public class RouteStationsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "RouteCode")
    private String routeCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "StationId")
    private long stationId;

    public RouteStationsPK() {
    }

    public RouteStationsPK(String routeCode, long stationId) {
        this.routeCode = routeCode;
        this.stationId = stationId;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeCode != null ? routeCode.hashCode() : 0);
        hash += (int) stationId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RouteStationsPK)) {
            return false;
        }
        RouteStationsPK other = (RouteStationsPK) object;
        if ((this.routeCode == null && other.routeCode != null) || (this.routeCode != null && !this.routeCode.equals(other.routeCode))) {
            return false;
        }
        if (this.stationId != other.stationId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.RouteStationsPK[ routeCode=" + routeCode + ", stationId=" + stationId + " ]";
    }
    
}
