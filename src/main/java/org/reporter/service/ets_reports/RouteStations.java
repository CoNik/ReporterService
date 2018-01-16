/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "RouteStations_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteStations.findAll", query = "SELECT r FROM RouteStations r")
    , @NamedQuery(name = "RouteStations.findByRouteCode", query = "SELECT r FROM RouteStations r WHERE r.routeStationsPK.routeCode = :routeCode")
    , @NamedQuery(name = "RouteStations.findByStationId", query = "SELECT r FROM RouteStations r WHERE r.routeStationsPK.stationId = :stationId")
    , @NamedQuery(name = "RouteStations.findByLineNo", query = "SELECT r FROM RouteStations r WHERE r.lineNo = :lineNo")
    , @NamedQuery(name = "RouteStations.findByStatus", query = "SELECT r FROM RouteStations r WHERE r.status = :status")})
public class RouteStations implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RouteStationsPK routeStationsPK;
    @Column(name = "LineNo")
    private Integer lineNo;
    @Column(name = "Status")
    private Character status;
    @JoinColumn(name = "RouteCode", referencedColumnName = "RouteCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Routes routes;
    @JoinColumn(name = "StationId", referencedColumnName = "StationId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Stations stations;

    public RouteStations() {
    }

    public RouteStations(RouteStationsPK routeStationsPK) {
        this.routeStationsPK = routeStationsPK;
    }

    public RouteStations(String routeCode, long stationId) {
        this.routeStationsPK = new RouteStationsPK(routeCode, stationId);
    }

    public RouteStationsPK getRouteStationsPK() {
        return routeStationsPK;
    }

    public void setRouteStationsPK(RouteStationsPK routeStationsPK) {
        this.routeStationsPK = routeStationsPK;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    public Stations getStations() {
        return stations;
    }

    public void setStations(Stations stations) {
        this.stations = stations;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeStationsPK != null ? routeStationsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RouteStations)) {
            return false;
        }
        RouteStations other = (RouteStations) object;
        if ((this.routeStationsPK == null && other.routeStationsPK != null) || (this.routeStationsPK != null && !this.routeStationsPK.equals(other.routeStationsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.RouteStations[ routeStationsPK=" + routeStationsPK + " ]";
    }
    
}
