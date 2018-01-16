/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
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
 * @author constantinn
 */
@Entity
@Table(name = "AlertLogs_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlertLogs.findAll", query = "SELECT a FROM AlertLogs a")
    , @NamedQuery(name = "AlertLogs.findById", query = "SELECT a FROM AlertLogs a WHERE a.id = :id")
    , @NamedQuery(name = "AlertLogs.findByPeriod", query = "SELECT a FROM AlertLogs a WHERE a.sentDate between :startDate and :endDate")
    , @NamedQuery(name = "AlertLogs.findByPeriodAndStation", query = "SELECT a FROM AlertLogs a, MachinesValidators mv, Validators v, Stations s WHERE (a.sentDate between :startDate and :endDate) and a.machineId=mv.machinesValidatorsPK.machineId and mv.machinesValidatorsPK.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.displayName = :stationName")
//    , @NamedQuery(name = "AlertLogs.findByPeriodAndStationId", query = "SELECT a FROM AlertLogs a, MachinesValidators mv, Validators v, Stations s WHERE (a.sentDate between :startDate and :endDate) and a.machineId=mv.machinesValidatorsPK.machineId and mv.machinesValidatorsPK.validatorCode = v.validatorsPK.validatorCode and v.stationId = s and s.stationId = :stationId")
    , @NamedQuery(name = "AlertLogs.findByPeriodAndStationId", query = "SELECT alertLog FROM AlertLogs alertLog, Alerts alert, Stations station WHERE alertLog.alertId = alert.id AND alert.stationId = station.stationId AND (alertLog.sentDate BETWEEN :startDate AND :endDate) AND station.stationId = :stationId")
    , @NamedQuery(name = "AlertLogs.findByMachineId", query = "SELECT a FROM AlertLogs a WHERE a.machineId = :machineId")
    , @NamedQuery(name = "AlertLogs.findBySessionId", query = "SELECT a FROM AlertLogs a WHERE a.sessionId = :sessionId")
    , @NamedQuery(name = "AlertLogs.findByCardId", query = "SELECT a FROM AlertLogs a WHERE a.cardId = :cardId")
    , @NamedQuery(name = "AlertLogs.findByAlertId", query = "SELECT a FROM AlertLogs a WHERE a.alertId = :alertId")
    , @NamedQuery(name = "AlertLogs.findByItemId", query = "SELECT a FROM AlertLogs a WHERE a.itemId = :itemId")
    , @NamedQuery(name = "AlertLogs.findByDeviceId", query = "SELECT a FROM AlertLogs a WHERE a.deviceId = :deviceId")
    , @NamedQuery(name = "AlertLogs.findByDescription", query = "SELECT a FROM AlertLogs a WHERE a.description = :description")
    , @NamedQuery(name = "AlertLogs.findByAlertCode", query = "SELECT a FROM AlertLogs a WHERE a.alertCode = :alertCode")
    , @NamedQuery(name = "AlertLogs.findByCreatedDate", query = "SELECT a FROM AlertLogs a WHERE a.createdDate = :createdDate")
    , @NamedQuery(name = "AlertLogs.findBySentDate", query = "SELECT a FROM AlertLogs a WHERE a.sentDate = :sentDate")})
public class AlertLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "MachineId")
    private Integer machineId;
    @Size(max = 36)
    @Column(name = "SessionId")
    private String sessionId;
    @Size(max = 50)
    @Column(name = "CardId")
    private String cardId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "AlertId")
    private String alertId;
    @Column(name = "ItemId")
    private Integer itemId;
    @Column(name = "DeviceId")
    private Integer deviceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AlertCode")
    private String alertCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "SentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    public AlertLogs() {
    }

    public AlertLogs(Integer id) {
        this.id = id;
    }

    public AlertLogs(Integer id, String alertId, String description, String alertCode, Date createdDate) {
        this.id = id;
        this.alertId = alertId;
        this.description = description;
        this.alertCode = alertCode;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAlertId() {
        return alertId;
    }

    public void setAlertId(String alertId) {
        this.alertId = alertId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlertCode() {
        return alertCode;
    }

    public void setAlertCode(String alertCode) {
        this.alertCode = alertCode;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
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
        if (!(object instanceof AlertLogs)) {
            return false;
        }
        AlertLogs other = (AlertLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.AlertLogs[ id=" + id + " ]";
    }
    
}
