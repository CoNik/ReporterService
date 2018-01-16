/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author constantinn
 */
@Embeddable
public class CustomerCardsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerId")
    private long customerId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CardId")
    private long cardId;

    public CustomerCardsPK() {
    }

    public CustomerCardsPK(long customerId, long cardId) {
        this.customerId = customerId;
        this.cardId = cardId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) customerId;
        hash += (int) cardId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerCardsPK)) {
            return false;
        }
        CustomerCardsPK other = (CustomerCardsPK) object;
        if (this.customerId != other.customerId) {
            return false;
        }
        if (this.cardId != other.cardId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.CustomerCardsPK[ customerId=" + customerId + ", cardId=" + cardId + " ]";
    }
    
}
