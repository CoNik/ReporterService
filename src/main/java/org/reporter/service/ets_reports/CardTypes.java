/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "CardTypes_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardTypes.findAll", query = "SELECT c FROM CardTypes c")
    , @NamedQuery(name = "CardTypes.findByCardTypeCode", query = "SELECT c FROM CardTypes c WHERE c.cardTypeCode = :cardTypeCode")
    , @NamedQuery(name = "CardTypes.findByCardTypeDescription", query = "SELECT c FROM CardTypes c WHERE c.cardTypeDescription = :cardTypeDescription")
    , @NamedQuery(name = "CardTypes.findByStartDate", query = "SELECT c FROM CardTypes c WHERE c.startDate = :startDate")
    , @NamedQuery(name = "CardTypes.findByEndDate", query = "SELECT c FROM CardTypes c WHERE c.endDate = :endDate")
    , @NamedQuery(name = "CardTypes.findByStatus", query = "SELECT c FROM CardTypes c WHERE c.status = :status")})
public class CardTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CardTypeCode")
    private String cardTypeCode;
    @Size(max = 50)
    @Column(name = "CardTypeDescription")
    private String cardTypeDescription;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "Status")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardTypeCode")
    private Collection<Cards> cardsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cardTypes")
    private Collection<RoutePrices> routePricesCollection;

    public CardTypes() {
    }

    public CardTypes(String cardTypeCode) {
        this.cardTypeCode = cardTypeCode;
    }

    public String getCardTypeCode() {
        return cardTypeCode;
    }

    public void setCardTypeCode(String cardTypeCode) {
        this.cardTypeCode = cardTypeCode;
    }

    public String getCardTypeDescription() {
        return cardTypeDescription;
    }

    public void setCardTypeDescription(String cardTypeDescription) {
        this.cardTypeDescription = cardTypeDescription;
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Cards> getCardsCollection() {
        return cardsCollection;
    }

    public void setCardsCollection(Collection<Cards> cardsCollection) {
        this.cardsCollection = cardsCollection;
    }

    @XmlTransient
    public Collection<RoutePrices> getRoutePricesCollection() {
        return routePricesCollection;
    }

    public void setRoutePricesCollection(Collection<RoutePrices> routePricesCollection) {
        this.routePricesCollection = routePricesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardTypeCode != null ? cardTypeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardTypes)) {
            return false;
        }
        CardTypes other = (CardTypes) object;
        if ((this.cardTypeCode == null && other.cardTypeCode != null) || (this.cardTypeCode != null && !this.cardTypeCode.equals(other.cardTypeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.CardTypes[ cardTypeCode=" + cardTypeCode + " ]";
    }
    
}
