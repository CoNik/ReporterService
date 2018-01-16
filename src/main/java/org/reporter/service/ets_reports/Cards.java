/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "Cards_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cards.findAll", query = "SELECT c FROM Cards c")
    , @NamedQuery(name = "Cards.findByCardId", query = "SELECT c FROM Cards c WHERE c.cardId = :cardId")
    , @NamedQuery(name = "Cards.findByCardNumber", query = "SELECT c FROM Cards c WHERE c.cardNumber = :cardNumber")
    , @NamedQuery(name = "Cards.findByCustomerId", query = "SELECT c FROM Cards c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "Cards.findByCurrentBalance", query = "SELECT c FROM Cards c WHERE c.currentBalance = :currentBalance")
    , @NamedQuery(name = "Cards.findByCurrentPassCount", query = "SELECT c FROM Cards c WHERE c.currentPassCount = :currentPassCount")
    , @NamedQuery(name = "Cards.findByCreateDate", query = "SELECT c FROM Cards c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "Cards.findByValidationDate", query = "SELECT c FROM Cards c WHERE c.validationDate = :validationDate")
    , @NamedQuery(name = "Cards.findByStatus", query = "SELECT c FROM Cards c WHERE c.status = :status")
    , @NamedQuery(name = "Cards.findByLoyaltPassCount", query = "SELECT c FROM Cards c WHERE c.loyaltPassCount = :loyaltPassCount")
    , @NamedQuery(name = "Cards.findByCardIdForBle", query = "SELECT c FROM Cards c WHERE c.cardIdForBle = :cardIdForBle")})
public class Cards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CardId")
    private Long cardId;
    @Size(max = 20)
    @Column(name = "CardNumber")
    private String cardNumber;
    @Column(name = "CustomerId")
    private BigInteger customerId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CurrentBalance")
    private BigDecimal currentBalance;
    @Column(name = "CurrentPassCount")
    private Long currentPassCount;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "ValidationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validationDate;
    @Column(name = "Status")
    private Character status;
    @Column(name = "LoyaltPassCount")
    private BigDecimal loyaltPassCount;
    @Size(max = 50)
    @Column(name = "CardIdForBle")
    private String cardIdForBle;
    @JoinColumn(name = "CardTypeCode", referencedColumnName = "CardTypeCode")
    @ManyToOne(optional = false)
    private CardTypes cardTypeCode;

    public Cards() {
    }

    public Cards(Long cardId) {
        this.cardId = cardId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Long getCurrentPassCount() {
        return currentPassCount;
    }

    public void setCurrentPassCount(Long currentPassCount) {
        this.currentPassCount = currentPassCount;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public BigDecimal getLoyaltPassCount() {
        return loyaltPassCount;
    }

    public void setLoyaltPassCount(BigDecimal loyaltPassCount) {
        this.loyaltPassCount = loyaltPassCount;
    }

    public String getCardIdForBle() {
        return cardIdForBle;
    }

    public void setCardIdForBle(String cardIdForBle) {
        this.cardIdForBle = cardIdForBle;
    }

    public CardTypes getCardTypeCode() {
        return cardTypeCode;
    }

    public void setCardTypeCode(CardTypes cardTypeCode) {
        this.cardTypeCode = cardTypeCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardId != null ? cardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cards)) {
            return false;
        }
        Cards other = (Cards) object;
        if ((this.cardId == null && other.cardId != null) || (this.cardId != null && !this.cardId.equals(other.cardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Cards[ cardId=" + cardId + " ]";
    }
    
}
