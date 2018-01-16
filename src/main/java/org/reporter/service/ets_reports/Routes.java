/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "Routes_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Routes.findAll", query = "SELECT r FROM Routes r")
    , @NamedQuery(name = "Routes.findByRouteCode", query = "SELECT r FROM Routes r WHERE r.routeCode = :routeCode")
    , @NamedQuery(name = "Routes.findByRouteDescription", query = "SELECT r FROM Routes r WHERE r.routeDescription = :routeDescription")
    , @NamedQuery(name = "Routes.findByRouteStartDate", query = "SELECT r FROM Routes r WHERE r.routeStartDate = :routeStartDate")
    , @NamedQuery(name = "Routes.findByRouteEndDate", query = "SELECT r FROM Routes r WHERE r.routeEndDate = :routeEndDate")
    , @NamedQuery(name = "Routes.findByStatus", query = "SELECT r FROM Routes r WHERE r.status = :status")
    , @NamedQuery(name = "Routes.findBySpecialRoute", query = "SELECT r FROM Routes r WHERE r.specialRoute = :specialRoute")
    , @NamedQuery(name = "Routes.findByCreateDate", query = "SELECT r FROM Routes r WHERE r.createDate = :createDate")})
public class Routes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "RouteCode")
    private String routeCode;
    @Size(max = 50)
    @Column(name = "RouteDescription")
    private String routeDescription;
    @Column(name = "RouteStartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date routeStartDate;
    @Column(name = "RouteEndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date routeEndDate;
    @Column(name = "Status")
    private Character status;
    @Column(name = "SpecialRoute")
    private Character specialRoute;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routes")
    private Collection<RoutePrices> routePricesCollection;
    @JoinColumn(name = "TransportTypeId", referencedColumnName = "TransportTypeID")
    @ManyToOne
    private TransportTypes transportTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "routes")
    private Collection<RouteStations> routeStationsCollection;
    @OneToMany(mappedBy = "routeCode")
    private Collection<Validators> validatorsCollection;

    public Routes() {
    }

    public Routes(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteDescription() {
        return routeDescription;
    }

    public void setRouteDescription(String routeDescription) {
        this.routeDescription = routeDescription;
    }

    public Date getRouteStartDate() {
        return routeStartDate;
    }

    public void setRouteStartDate(Date routeStartDate) {
        this.routeStartDate = routeStartDate;
    }

    public Date getRouteEndDate() {
        return routeEndDate;
    }

    public void setRouteEndDate(Date routeEndDate) {
        this.routeEndDate = routeEndDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Character getSpecialRoute() {
        return specialRoute;
    }

    public void setSpecialRoute(Character specialRoute) {
        this.specialRoute = specialRoute;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @XmlTransient
    public Collection<RoutePrices> getRoutePricesCollection() {
        return routePricesCollection;
    }

    public void setRoutePricesCollection(Collection<RoutePrices> routePricesCollection) {
        this.routePricesCollection = routePricesCollection;
    }

    public TransportTypes getTransportTypeId() {
        return transportTypeId;
    }

    public void setTransportTypeId(TransportTypes transportTypeId) {
        this.transportTypeId = transportTypeId;
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
        hash += (routeCode != null ? routeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Routes)) {
            return false;
        }
        Routes other = (Routes) object;
        if ((this.routeCode == null && other.routeCode != null) || (this.routeCode != null && !this.routeCode.equals(other.routeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Routes[ routeCode=" + routeCode + " ]";
    }
    
}
