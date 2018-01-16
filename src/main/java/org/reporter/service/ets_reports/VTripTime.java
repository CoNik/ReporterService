/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roxanam
 */
@Entity
@Table(name = "V_TripTime")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VTripTime.findAll", query = "SELECT v FROM VTripTime v")
    , @NamedQuery(name = "VTripTime.findBySessionId", query = "SELECT v FROM VTripTime v WHERE v.sessionId = :sessionId")
    , @NamedQuery(name = "VTripTime.findByCardNumber", query = "SELECT v FROM VTripTime v WHERE v.cardNumber = :cardNumber")
    , @NamedQuery(name = "VTripTime.findByStartDate", query = "SELECT v FROM VTripTime v WHERE v.startDate = :startDate")
    , @NamedQuery(name = "VTripTime.findByEndDate", query = "SELECT v FROM VTripTime v WHERE v.endDate = :endDate")
    , @NamedQuery(name = "VTripTime.findByDifftime", query = "SELECT v FROM VTripTime v WHERE v.difftime = :difftime")
    , @NamedQuery(name = "VTripTime.findByStationIn", query = "SELECT v FROM VTripTime v WHERE v.stationIn = :stationIn")
    , @NamedQuery(name = "VTripTime.findByStationOut", query = "SELECT v FROM VTripTime v WHERE v.stationOut = :stationOut")})
public class VTripTime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SessionId")
    private String sessionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CardNumber")
    private String cardNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "difftime")
    private Integer difftime;
    @Size(max = 50)
    @Column(name = "stationIn")
    private String stationIn;
    @Size(max = 50)
    @Column(name = "stationOut")
    private String stationOut;

    public VTripTime() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getDifftime() {
        return difftime;
    }

    public void setDifftime(Integer difftime) {
        this.difftime = difftime;
    }

    public String getStationIn() {
        return stationIn;
    }

    public void setStationIn(String stationIn) {
        this.stationIn = stationIn;
    }

    public String getStationOut() {
        return stationOut;
    }

    public void setStationOut(String stationOut) {
        this.stationOut = stationOut;
    }
    
}
