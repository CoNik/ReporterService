/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "DashboardInfo_T")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DashboardInfoT.findAll", query = "SELECT d FROM DashboardInfoT d")
    , @NamedQuery(name = "DashboardInfoT.findById", query = "SELECT d FROM DashboardInfoT d WHERE d.id = :id")
    , @NamedQuery(name = "DashboardInfoT.findByRegisteredAt", query = "SELECT d FROM DashboardInfoT d WHERE d.registeredAt = :registeredAt")
    , @NamedQuery(name = "DashboardInfoT.findByPassengersIn", query = "SELECT d FROM DashboardInfoT d WHERE d.passengersIn = :passengersIn")
    , @NamedQuery(name = "DashboardInfoT.findByPassengersOut", query = "SELECT d FROM DashboardInfoT d WHERE d.passengersOut = :passengersOut")
    , @NamedQuery(name = "DashboardInfoT.findByNoTransactions", query = "SELECT d FROM DashboardInfoT d WHERE d.noTransactions = :noTransactions")
    , @NamedQuery(name = "DashboardInfoT.findBySmartCardTikets", query = "SELECT d FROM DashboardInfoT d WHERE d.smartCardTikets = :smartCardTikets")
    , @NamedQuery(name = "DashboardInfoT.findByPassengersInStation", query = "SELECT d FROM DashboardInfoT d WHERE d.passengersInStation = :passengersInStation")
    , @NamedQuery(name = "DashboardInfoT.findByStationId", query = "SELECT d FROM DashboardInfoT d WHERE d.stationId = :stationId")
    , @NamedQuery(name = "DashboardInfoT.findByNoFraudulents", query = "SELECT d FROM DashboardInfoT d WHERE d.noFraudulents = :noFraudulents")})
public class DashboardInfoT implements Serializable {

    /**
     * @return the difPassengersIn
     */
    public Integer getDifPassengersIn() {
        return difPassengersIn;
    }

    /**
     * @param difPassengersIn the difPassengersIn to set
     */
    public void setDifPassengersIn(Integer difPassengersIn) {
        this.difPassengersIn = difPassengersIn;
    }

    /**
     * @return the difPassengersOut
     */
    public Integer getDifPassengersOut() {
        return difPassengersOut;
    }

    /**
     * @param difPassengersOut the difPassengersOut to set
     */
    public void setDifPassengersOut(Integer difPassengersOut) {
        this.difPassengersOut = difPassengersOut;
    }

    /**
     * @return the difNoTransactions
     */
    public Integer getDifNoTransactions() {
        return difNoTransactions;
    }

    /**
     * @param difNoTransactions the difNoTransactions to set
     */
    public void setDifNoTransactions(Integer difNoTransactions) {
        this.difNoTransactions = difNoTransactions;
    }

    /**
     * @return the difSmartCardTikets
     */
    public Integer getDifSmartCardTikets() {
        return difSmartCardTikets;
    }

    /**
     * @param difSmartCardTikets the difSmartCardTikets to set
     */
    public void setDifSmartCardTikets(Integer difSmartCardTikets) {
        this.difSmartCardTikets = difSmartCardTikets;
    }

    /**
     * @return the difPassengersInStation
     */
    public Integer getDifPassengersInStation() {
        return difPassengersInStation;
    }

    /**
     * @param difPassengersInStation the difPassengersInStation to set
     */
    public void setDifPassengersInStation(Integer difPassengersInStation) {
        this.difPassengersInStation = difPassengersInStation;
    }

    /**
     * @return the difNoFraudulents
     */
    public Integer getDifNoFraudulents() {
        return difNoFraudulents;
    }

    /**
     * @param difNoFraudulents the difNoFraudulents to set
     */
    public void setDifNoFraudulents(Integer difNoFraudulents) {
        this.difNoFraudulents = difNoFraudulents;
    }

    @Column(name = "StationId")
    private Integer stationId;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "RegisteredAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;
    @Column(name = "PassengersIn")
    private Integer passengersIn;
    @Column(name = "PassengersOut")
    private Integer passengersOut;
    @Column(name = "NoTransactions")
    private Integer noTransactions;
    @Column(name = "SmartCardTikets")
    private Integer smartCardTikets;
    @Column(name = "PassengersInStation")
    private Integer passengersInStation;
    @Column(name = "NoFraudulents")
    private Integer noFraudulents;
 
    //@Column(name = "PrevPassengersIn")
    private Integer difPassengersIn;
  //@Column(name = "PrevPassengersOut")
    private Integer difPassengersOut;
    //@Column(name = "NoTransactions")
    private Integer difNoTransactions;
    //@Column(name = "SmartCardTikets")
    private Integer difSmartCardTikets;
    //@Column(name = "PassengersInStation")
    private Integer difPassengersInStation;
    //@Column(name = "NoFraudulents")
    private Integer difNoFraudulents;
 
    
     
    public DashboardInfoT() {
    }

    public DashboardInfoT(Integer id) {
        this.id = id;
    }

    public DashboardInfoT(DashboardInfo di){
        this.id =(Integer.valueOf((int)new Date().getTime()));
        this.noFraudulents = di.getNoFraudulents().intValue();
        this.noTransactions = di.getNoTransactions().intValue();
        this.passengersIn = di.getPassengersIn().intValue();
        this.passengersOut = di.getPassengersOut().intValue();
        this.passengersInStation = di.getPassengersInStation().intValue();
        this.registeredAt = new Date();
        this.smartCardTikets = di.getSmartCardTikets().intValue();
        
        this.difNoFraudulents = 2-(int)(Math.random()*5);
        this.difNoTransactions = 50 -(int)(Math.random()*100);
        this.difPassengersIn = 25 -(int)(Math.random()*50);
        this.difPassengersOut = 25 -(int)(Math.random()*50);
        this.difSmartCardTikets = 25 -(int)(Math.random()*50);
        this.difPassengersInStation = 15 -(int)(Math.random()*30);
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(Date registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Integer getPassengersIn() {
        return passengersIn;
    }

    public void setPassengersIn(Integer passengersIn) {
        this.passengersIn = passengersIn;
    }

    public Integer getPassengersOut() {
        return passengersOut;
    }

    public void setPassengersOut(Integer passengersOut) {
        this.passengersOut = passengersOut;
    }

    public Integer getNoTransactions() {
        return noTransactions;
    }

    public void setNoTransactions(Integer noTransactions) {
        this.noTransactions = noTransactions;
    }

    public Integer getSmartCardTikets() {
        return smartCardTikets;
    }

    public void setSmartCardTikets(Integer smartCardTikets) {
        this.smartCardTikets = smartCardTikets;
    }

    public Integer getPassengersInStation() {
        return passengersInStation;
    }

    public void setPassengersInStation(Integer passengersInStation) {
        this.passengersInStation = passengersInStation;
    }

    public Integer getNoFraudulents() {
        return noFraudulents;
    }

    public void setNoFraudulents(Integer noFraudulents) {
        this.noFraudulents = noFraudulents;
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
        if (!(object instanceof DashboardInfoT)) {
            return false;
        }
        DashboardInfoT other = (DashboardInfoT) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.DashboardInfoT[ id=" + id + " ]";
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }
    
}
