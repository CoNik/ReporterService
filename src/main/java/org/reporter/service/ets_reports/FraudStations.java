/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "FraudStations_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FraudStations.findAll", query = "SELECT f FROM FraudStations f")
    , @NamedQuery(name = "FraudStations.findByFraudId", query = "SELECT f FROM FraudStations f WHERE f.fraudId = :fraudId")
    , @NamedQuery(name = "FraudStations.findByFraudStations", query = "SELECT f FROM FraudStations f WHERE f.fraudStations = :fraudStations")
    , @NamedQuery(name = "FraudStations.findByFraudCardId", query = "SELECT f FROM FraudStations f WHERE f.fraudCardId = :fraudCardId")
    , @NamedQuery(name = "FraudStations.findByFraudType", query = "SELECT f FROM FraudStations f WHERE f.fraudType = :fraudType")
    , @NamedQuery(name = "FraudStations.findByCreateDate", query = "SELECT f FROM FraudStations f WHERE f.createDate = :createDate")
    , @NamedQuery(name = "FraudStations.findByPeriodAndStationId", query = "SELECT f FROM FraudStations f where (f.createDate between :startDate and :endDate) and f.fraudStations = :stationId")
    , @NamedQuery(name = "FraudStations.countByPeriodAndStationId", query = "SELECT count(f) FROM FraudStations f where (f.createDate between :startDate and :endDate) and f.fraudStations = :stationId")
    , @NamedQuery(name = "FraudStations.findByFraudPicture", query = "SELECT f FROM FraudStations f WHERE f.fraudPicture = :fraudPicture")})
public class FraudStations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FraudId")
    private Long fraudId;
    @Column(name = "FraudStations")
    private BigInteger fraudStations;
    @Column(name = "FraudCardId")
    private BigInteger fraudCardId;
    @Column(name = "FraudType")
    private Integer fraudType;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Size(max = 50)
    @Column(name = "FraudPicture")
    private String fraudPicture;

    public FraudStations() {
    }

    public FraudStations(Long fraudId) {
        this.fraudId = fraudId;
    }

    public Long getFraudId() {
        return fraudId;
    }

    public void setFraudId(Long fraudId) {
        this.fraudId = fraudId;
    }

    public BigInteger getFraudStations() {
        return fraudStations;
    }

    public void setFraudStations(BigInteger fraudStations) {
        this.fraudStations = fraudStations;
    }

    public BigInteger getFraudCardId() {
        return fraudCardId;
    }

    public void setFraudCardId(BigInteger fraudCardId) {
        this.fraudCardId = fraudCardId;
    }

    public Integer getFraudType() {
        return fraudType;
    }

    public void setFraudType(Integer fraudType) {
        this.fraudType = fraudType;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFraudPicture() {
        return fraudPicture;
    }

    public void setFraudPicture(String fraudPicture) {
        this.fraudPicture = fraudPicture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fraudId != null ? fraudId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FraudStations)) {
            return false;
        }
        FraudStations other = (FraudStations) object;
        if ((this.fraudId == null && other.fraudId != null) || (this.fraudId != null && !this.fraudId.equals(other.fraudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.FraudStations[ fraudId=" + fraudId + " ]";
    }
    
}
