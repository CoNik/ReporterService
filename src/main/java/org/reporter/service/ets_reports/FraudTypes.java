/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "FraudTypes_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FraudTypes.findAll", query = "SELECT f FROM FraudTypes f")
    , @NamedQuery(name = "FraudTypes.findByFraudTypeId", query = "SELECT f FROM FraudTypes f WHERE f.fraudTypeId = :fraudTypeId")
    , @NamedQuery(name = "FraudTypes.findByFraudTypeName", query = "SELECT f FROM FraudTypes f WHERE f.fraudTypeName = :fraudTypeName")
    , @NamedQuery(name = "FraudTypes.findByFraudTypeDescription", query = "SELECT f FROM FraudTypes f WHERE f.fraudTypeDescription = :fraudTypeDescription")
    , @NamedQuery(name = "FraudTypes.findByStatus", query = "SELECT f FROM FraudTypes f WHERE f.status = :status")})
public class FraudTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FraudTypeId")
    private Integer fraudTypeId;
    @Size(max = 10)
    @Column(name = "FraudTypeName")
    private String fraudTypeName;
    @Size(max = 50)
    @Column(name = "FraudTypeDescription")
    private String fraudTypeDescription;
    @Column(name = "Status")
    private Character status;

    public FraudTypes() {
    }

    public FraudTypes(Integer fraudTypeId) {
        this.fraudTypeId = fraudTypeId;
    }

    public Integer getFraudTypeId() {
        return fraudTypeId;
    }

    public void setFraudTypeId(Integer fraudTypeId) {
        this.fraudTypeId = fraudTypeId;
    }

    public String getFraudTypeName() {
        return fraudTypeName;
    }

    public void setFraudTypeName(String fraudTypeName) {
        this.fraudTypeName = fraudTypeName;
    }

    public String getFraudTypeDescription() {
        return fraudTypeDescription;
    }

    public void setFraudTypeDescription(String fraudTypeDescription) {
        this.fraudTypeDescription = fraudTypeDescription;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fraudTypeId != null ? fraudTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FraudTypes)) {
            return false;
        }
        FraudTypes other = (FraudTypes) object;
        if ((this.fraudTypeId == null && other.fraudTypeId != null) || (this.fraudTypeId != null && !this.fraudTypeId.equals(other.fraudTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.FraudTypes[ fraudTypeId=" + fraudTypeId + " ]";
    }
    
}
