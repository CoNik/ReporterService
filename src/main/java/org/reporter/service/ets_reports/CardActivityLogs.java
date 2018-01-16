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
@Table(name = "CardActivityLogs_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardActivityLogs.findAll", query = "SELECT c FROM CardActivityLogs c")
    , @NamedQuery(name = "CardActivityLogs.findById", query = "SELECT c FROM CardActivityLogs c WHERE c.id = :id")
    , @NamedQuery(name = "CardActivityLogs.findByPeriod", query = "SELECT c FROM CardActivityLogs c WHERE c.sentDate between :startDate and :endDate")
    , @NamedQuery(name = "CardActivityLogs.findByPeriodAndStation", query = "SELECT c FROM CardActivityLogs c,  Validators v, Stations s WHERE (c.sentDate between :startDate and :endDate) and c.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.displayName = :stationName")
    , @NamedQuery(name = "CardActivityLogs.findByPeriodAndStationId", query = "SELECT c FROM CardActivityLogs c,  Validators v, Stations s WHERE (c.sentDate between :startDate and :endDate) and c.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.stationId = :stationId")
    , @NamedQuery(name = "CardActivityLogs.findBySessionId", query = "SELECT c FROM CardActivityLogs c WHERE c.sessionId = :sessionId")
    , @NamedQuery(name = "CardActivityLogs.findByCardNumber", query = "SELECT c FROM CardActivityLogs c WHERE c.cardNumber = :cardNumber")
    , @NamedQuery(name = "CardActivityLogs.findByValidatorCode", query = "SELECT c FROM CardActivityLogs c WHERE c.validatorCode = :validatorCode")
    , @NamedQuery(name = "CardActivityLogs.findByCurrentBalance", query = "SELECT c FROM CardActivityLogs c WHERE c.currentBalance = :currentBalance")
    , @NamedQuery(name = "CardActivityLogs.findByAmount", query = "SELECT c FROM CardActivityLogs c WHERE c.amount = :amount")
    , @NamedQuery(name = "CardActivityLogs.findByActivityCode", query = "SELECT c FROM CardActivityLogs c WHERE c.activityCode = :activityCode")
    , @NamedQuery(name = "CardActivityLogs.findByDescription", query = "SELECT c FROM CardActivityLogs c WHERE c.description = :description")
    , @NamedQuery(name = "CardActivityLogs.findByCreatedDate", query = "SELECT c FROM CardActivityLogs c WHERE c.createdDate = :createdDate")
    , @NamedQuery(name = "CardActivityLogs.findByDirectionId", query = "SELECT c FROM CardActivityLogs c WHERE c.directionId = :directionId")
    , @NamedQuery(name = "CardActivityLogs.findBySentDate", query = "SELECT c FROM CardActivityLogs c WHERE c.sentDate = :sentDate")})
public class CardActivityLogs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Long id;
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
    @Size(min = 1, max = 10)
    @Column(name = "ValidatorCode")
    private String validatorCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CurrentBalance")
    private BigDecimal currentBalance;
    @Column(name = "Amount")
    private BigDecimal amount;
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
    @Column(name = "DirectionId")
    private Short directionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    public CardActivityLogs() {
    }

    public CardActivityLogs(Long id) {
        this.id = id;
    }

    public CardActivityLogs(Long id, String sessionId, String cardNumber, String validatorCode, BigDecimal currentBalance, String activityCode, String description, Date createdDate, Date sentDate) {
        this.id = id;
        this.sessionId = sessionId;
        this.cardNumber = cardNumber;
        this.validatorCode = validatorCode;
        this.currentBalance = currentBalance;
        this.activityCode = activityCode;
        this.description = description;
        this.createdDate = createdDate;
        this.sentDate = sentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getValidatorCode() {
        return validatorCode;
    }

    public void setValidatorCode(String validatorCode) {
        this.validatorCode = validatorCode;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public Short getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Short directionId) {
        this.directionId = directionId;
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
        if (!(object instanceof CardActivityLogs)) {
            return false;
        }
        CardActivityLogs other = (CardActivityLogs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.CardActivityLogs[ id=" + id + " ]";
    }
    
}
