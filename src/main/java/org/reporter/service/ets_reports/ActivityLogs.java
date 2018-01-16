/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ActivityLogs_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivityLogs.findAll", query = "SELECT a FROM ActivityLogs a")
    , @NamedQuery(name = "ActivityLogs.findById", query = "SELECT a FROM ActivityLogs a WHERE a.id = :id")
    , @NamedQuery(name = "ActivityLogs.findByPeriod", query = "SELECT a FROM ActivityLogs a WHERE a.sentDate between :startDate and :endDate")
    , @NamedQuery(name = "ActivityLogs.findByPeriodAndStation", query = "SELECT a FROM ActivityLogs a, MachinesValidators mv, Validators v, Stations s WHERE (a.sentDate between :startDate and :endDate) and a.machineId=mv.machinesValidatorsPK.machineId and mv.machinesValidatorsPK.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.displayName = :stationName")
    , @NamedQuery(name = "ActivityLogs.findByPeriodAndStationId", query = "SELECT a FROM ActivityLogs a, MachinesValidators mv, Validators v, Stations s WHERE (a.sentDate between :startDate and :endDate) and a.machineId=mv.machinesValidatorsPK.machineId and mv.machinesValidatorsPK.validatorCode = v.validatorsPK.validatorCode and v.stationId = s and s.stationId = :stationId")
    , @NamedQuery(name = "ActivityLogs.findByMachineId", query = "SELECT a FROM ActivityLogs a WHERE a.machineId = :machineId")
    , @NamedQuery(name = "ActivityLogs.findBySessionId", query = "SELECT a FROM ActivityLogs a WHERE a.sessionId = :sessionId")
    , @NamedQuery(name = "ActivityLogs.findByCardId", query = "SELECT a FROM ActivityLogs a WHERE a.cardId = :cardId")
    , @NamedQuery(name = "ActivityLogs.findByActivityId", query = "SELECT a FROM ActivityLogs a WHERE a.activityId = :activityId")
    , @NamedQuery(name = "ActivityLogs.findByItemId", query = "SELECT a FROM ActivityLogs a WHERE a.itemId = :itemId")
    , @NamedQuery(name = "ActivityLogs.findByQuantity", query = "SELECT a FROM ActivityLogs a WHERE a.quantity = :quantity")
    , @NamedQuery(name = "ActivityLogs.findByValue", query = "SELECT a FROM ActivityLogs a WHERE a.value = :value")
    , @NamedQuery(name = "ActivityLogs.findByActivityCode", query = "SELECT a FROM ActivityLogs a WHERE a.activityCode = :activityCode")
    , @NamedQuery(name = "ActivityLogs.findByDescription", query = "SELECT a FROM ActivityLogs a WHERE a.description = :description")
    , @NamedQuery(name = "ActivityLogs.findByCreatedDate", query = "SELECT a FROM ActivityLogs a WHERE a.createdDate = :createdDate")
    , @NamedQuery(name = "ActivityLogs.findBySentDate", query = "SELECT a FROM ActivityLogs a WHERE a.sentDate = :sentDate")})
public class ActivityLogs implements Serializable {

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
    @Column(name = "ActivityId")
    private int activityId;
    @Column(name = "ItemId")
    private Integer itemId;
    @Column(name = "Quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Value")
    private BigDecimal value;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ActivityCode")
    private String activityCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "SentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    public ActivityLogs() {
    }

    public ActivityLogs(Integer id) {
        this.id = id;
    }

    public ActivityLogs(Integer id, int activityId, String activityCode, String description, Date createdDate) {
        this.id = id;
        this.activityId = activityId;
        this.activityCode = activityCode;
        this.description = description;
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

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof ActivityLogs)) {
            return false;
        }
        ActivityLogs other = (ActivityLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.ActivityLogs[ id=" + id + " ]";
    }
    
}
