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
@Table(name = "location_work")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocationWork.findAll", query = "SELECT l FROM LocationWork l")
    , @NamedQuery(name = "LocationWork.findByCardid", query = "SELECT l FROM LocationWork l WHERE l.cardid = :cardid")
    , @NamedQuery(name = "LocationWork.findByCreatedate", query = "SELECT l FROM LocationWork l WHERE l.createdate = :createdate")
    , @NamedQuery(name = "LocationWork.findByCurrentbalance", query = "SELECT l FROM LocationWork l WHERE l.currentbalance = :currentbalance")
    , @NamedQuery(name = "LocationWork.findByCurrentpasscount", query = "SELECT l FROM LocationWork l WHERE l.currentpasscount = :currentpasscount")
    , @NamedQuery(name = "LocationWork.findByCustomerid", query = "SELECT l FROM LocationWork l WHERE l.customerid = :customerid")
    , @NamedQuery(name = "LocationWork.findById", query = "SELECT l FROM LocationWork l WHERE l.id = :id")
    , @NamedQuery(name = "LocationWork.findByLoyaltypasscount", query = "SELECT l FROM LocationWork l WHERE l.loyaltypasscount = :loyaltypasscount")
    , @NamedQuery(name = "LocationWork.findByOptStationList", query = "SELECT l FROM LocationWork l WHERE l.optStationList = :optStationList")
    , @NamedQuery(name = "LocationWork.findByOptStationListTs", query = "SELECT l FROM LocationWork l WHERE l.optStationListTs = :optStationListTs")
    , @NamedQuery(name = "LocationWork.findByStationIdExit", query = "SELECT l FROM LocationWork l WHERE l.stationIdExit = :stationIdExit")
    , @NamedQuery(name = "LocationWork.findByStationidEntrance", query = "SELECT l FROM LocationWork l WHERE l.stationidEntrance = :stationidEntrance")
    , @NamedQuery(name = "LocationWork.findByStatus", query = "SELECT l FROM LocationWork l WHERE l.status = :status")
    , @NamedQuery(name = "LocationWork.findByTravelTime", query = "SELECT l FROM LocationWork l WHERE l.travelTime = :travelTime")
    , @NamedQuery(name = "LocationWork.findByTsEntrance", query = "SELECT l FROM LocationWork l WHERE l.tsEntrance = :tsEntrance")
    , @NamedQuery(name = "LocationWork.findByTsExit", query = "SELECT l FROM LocationWork l WHERE l.tsExit = :tsExit")
    , @NamedQuery(name = "LocationWork.findByValidationdate", query = "SELECT l FROM LocationWork l WHERE l.validationdate = :validationdate")
    , @NamedQuery(name = "LocationWork.findByValidatorCodeEntrance", query = "SELECT l FROM LocationWork l WHERE l.validatorCodeEntrance = :validatorCodeEntrance")
    , @NamedQuery(name = "LocationWork.findByValidatorCodeExit", query = "SELECT l FROM LocationWork l WHERE l.validatorCodeExit = :validatorCodeExit")})
public class LocationWork implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "cardid")
    private BigInteger cardid;
    @Column(name = "createdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "currentbalance")
    private Double currentbalance;
    @Column(name = "currentpasscount")
    private Double currentpasscount;
    @Column(name = "customerid")
    private BigInteger customerid;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "id")
    private String id;
    @Column(name = "loyaltypasscount")
    private Double loyaltypasscount;
    @Size(max = 2000)
    @Column(name = "opt_station_list")
    private String optStationList;
    @Size(max = 2000)
    @Column(name = "opt_station_list_ts")
    private String optStationListTs;
    @Column(name = "station_id_exit")
    private BigInteger stationIdExit;
    @Column(name = "stationid_entrance")
    private BigInteger stationidEntrance;
    @Size(max = 2000)
    @Column(name = "status")
    private String status;
    @Column(name = "travel_time")
    private Integer travelTime;
    @Column(name = "ts_entrance")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsEntrance;
    @Column(name = "ts_exit")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tsExit;
    @Column(name = "validationdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validationdate;
    @Size(max = 2000)
    @Column(name = "validator_code_entrance")
    private String validatorCodeEntrance;
    @Size(max = 2000)
    @Column(name = "validator_code_exit")
    private String validatorCodeExit;

    public LocationWork() {
    }

    public LocationWork(String id) {
        this.id = id;
    }

    public BigInteger getCardid() {
        return cardid;
    }

    public void setCardid(BigInteger cardid) {
        this.cardid = cardid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Double getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(Double currentbalance) {
        this.currentbalance = currentbalance;
    }

    public Double getCurrentpasscount() {
        return currentpasscount;
    }

    public void setCurrentpasscount(Double currentpasscount) {
        this.currentpasscount = currentpasscount;
    }

    public BigInteger getCustomerid() {
        return customerid;
    }

    public void setCustomerid(BigInteger customerid) {
        this.customerid = customerid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getLoyaltypasscount() {
        return loyaltypasscount;
    }

    public void setLoyaltypasscount(Double loyaltypasscount) {
        this.loyaltypasscount = loyaltypasscount;
    }

    public String getOptStationList() {
        return optStationList;
    }

    public void setOptStationList(String optStationList) {
        this.optStationList = optStationList;
    }

    public String getOptStationListTs() {
        return optStationListTs;
    }

    public void setOptStationListTs(String optStationListTs) {
        this.optStationListTs = optStationListTs;
    }

    public BigInteger getStationIdExit() {
        return stationIdExit;
    }

    public void setStationIdExit(BigInteger stationIdExit) {
        this.stationIdExit = stationIdExit;
    }

    public BigInteger getStationidEntrance() {
        return stationidEntrance;
    }

    public void setStationidEntrance(BigInteger stationidEntrance) {
        this.stationidEntrance = stationidEntrance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(Integer travelTime) {
        this.travelTime = travelTime;
    }

    public Date getTsEntrance() {
        return tsEntrance;
    }

    public void setTsEntrance(Date tsEntrance) {
        this.tsEntrance = tsEntrance;
    }

    public Date getTsExit() {
        return tsExit;
    }

    public void setTsExit(Date tsExit) {
        this.tsExit = tsExit;
    }

    public Date getValidationdate() {
        return validationdate;
    }

    public void setValidationdate(Date validationdate) {
        this.validationdate = validationdate;
    }

    public String getValidatorCodeEntrance() {
        return validatorCodeEntrance;
    }

    public void setValidatorCodeEntrance(String validatorCodeEntrance) {
        this.validatorCodeEntrance = validatorCodeEntrance;
    }

    public String getValidatorCodeExit() {
        return validatorCodeExit;
    }

    public void setValidatorCodeExit(String validatorCodeExit) {
        this.validatorCodeExit = validatorCodeExit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocationWork)) {
            return false;
        }
        LocationWork other = (LocationWork) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.LocationWork[ id=" + id + " ]";
    }
    
}
