/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "TransportTypes_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransportTypes.findAll", query = "SELECT t FROM TransportTypes t")
    , @NamedQuery(name = "TransportTypes.findByTransportTypeID", query = "SELECT t FROM TransportTypes t WHERE t.transportTypeID = :transportTypeID")
    , @NamedQuery(name = "TransportTypes.findByTransportTypeDescription", query = "SELECT t FROM TransportTypes t WHERE t.transportTypeDescription = :transportTypeDescription")
    , @NamedQuery(name = "TransportTypes.findByStatus", query = "SELECT t FROM TransportTypes t WHERE t.status = :status")})
public class TransportTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TransportTypeID")
    private Short transportTypeID;
    @Size(max = 50)
    @Column(name = "TransportTypeDescription")
    private String transportTypeDescription;
    @Size(max = 10)
    @Column(name = "Status")
    private String status;
    @OneToMany(mappedBy = "transportTypeId")
    private Collection<Routes> routesCollection;

    public TransportTypes() {
    }

    public TransportTypes(Short transportTypeID) {
        this.transportTypeID = transportTypeID;
    }

    public Short getTransportTypeID() {
        return transportTypeID;
    }

    public void setTransportTypeID(Short transportTypeID) {
        this.transportTypeID = transportTypeID;
    }

    public String getTransportTypeDescription() {
        return transportTypeDescription;
    }

    public void setTransportTypeDescription(String transportTypeDescription) {
        this.transportTypeDescription = transportTypeDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Routes> getRoutesCollection() {
        return routesCollection;
    }

    public void setRoutesCollection(Collection<Routes> routesCollection) {
        this.routesCollection = routesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transportTypeID != null ? transportTypeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransportTypes)) {
            return false;
        }
        TransportTypes other = (TransportTypes) object;
        if ((this.transportTypeID == null && other.transportTypeID != null) || (this.transportTypeID != null && !this.transportTypeID.equals(other.transportTypeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.TransportTypes[ transportTypeID=" + transportTypeID + " ]";
    }
    
}
