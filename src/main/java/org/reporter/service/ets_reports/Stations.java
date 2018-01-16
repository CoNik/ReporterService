/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "Stations_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stations.findAll", query = "SELECT s FROM Stations s")
    , @NamedQuery(name = "Stations.findByStationId", query = "SELECT s FROM Stations s WHERE s.stationId = :stationId")
    , @NamedQuery(name = "Stations.findByStationDescription", query = "SELECT s FROM Stations s WHERE s.stationDescription = :stationDescription")
    , @NamedQuery(name = "Stations.findByDisplayName", query = "SELECT s FROM Stations s WHERE s.displayName = :displayName")
    , @NamedQuery(name = "Stations.findByCreateDate", query = "SELECT s FROM Stations s WHERE s.createDate = :createDate")
    , @NamedQuery(name = "Stations.findByStatus", query = "SELECT s FROM Stations s WHERE s.status = :status")})
public class Stations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StationId")
    private Long stationId;
    @Size(max = 50)
    @Column(name = "StationDescription")
    private String stationDescription;
    @Size(max = 50)
    @Column(name = "DisplayName")
    private String displayName;
    @Size(max = 50)
    @Column(name = "CreateDate")
    private String createDate;
    @Column(name = "Status")
    private Short status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stations")
    private Collection<RouteStations> routeStationsCollection;
    @OneToMany(mappedBy = "stationId")
    private Collection<Validators> validatorsCollection;

    public Stations() {
    }

    public Stations(Long stationId) {
        this.stationId = stationId;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getStationDescription() {
        return stationDescription;
    }

    public void setStationDescription(String stationDescription) {
        this.stationDescription = stationDescription;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<RouteStations> getRouteStationsCollection() {
        return routeStationsCollection;
    }

    public void setRouteStationsCollection(Collection<RouteStations> routeStationsCollection) {
        this.routeStationsCollection = routeStationsCollection;
    }

    @XmlTransient
    public Collection<Validators> getValidatorsCollection() {
        return validatorsCollection;
    }

    public void setValidatorsCollection(Collection<Validators> validatorsCollection) {
        this.validatorsCollection = validatorsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stationId != null ? stationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stations)) {
            return false;
        }
        Stations other = (Stations) object;
        if ((this.stationId == null && other.stationId != null) || (this.stationId != null && !this.stationId.equals(other.stationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Stations[ stationId=" + stationId + " ]";
    }
    
}
