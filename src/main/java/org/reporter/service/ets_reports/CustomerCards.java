/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "CustomerCards_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerCards.findAll", query = "SELECT c FROM CustomerCards c")
    , @NamedQuery(name = "CustomerCards.findByCustomerId", query = "SELECT c FROM CustomerCards c WHERE c.customerCardsPK.customerId = :customerId")
    , @NamedQuery(name = "CustomerCards.findByCardId", query = "SELECT c FROM CustomerCards c WHERE c.customerCardsPK.cardId = :cardId")})
public class CustomerCards implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CustomerCardsPK customerCardsPK;

    public CustomerCards() {
    }

    public CustomerCards(CustomerCardsPK customerCardsPK) {
        this.customerCardsPK = customerCardsPK;
    }

    public CustomerCards(long customerId, long cardId) {
        this.customerCardsPK = new CustomerCardsPK(customerId, cardId);
    }

    public CustomerCardsPK getCustomerCardsPK() {
        return customerCardsPK;
    }

    public void setCustomerCardsPK(CustomerCardsPK customerCardsPK) {
        this.customerCardsPK = customerCardsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerCardsPK != null ? customerCardsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerCards)) {
            return false;
        }
        CustomerCards other = (CustomerCards) object;
        if ((this.customerCardsPK == null && other.customerCardsPK != null) || (this.customerCardsPK != null && !this.customerCardsPK.equals(other.customerCardsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.CustomerCards[ customerCardsPK=" + customerCardsPK + " ]";
    }
    
}
