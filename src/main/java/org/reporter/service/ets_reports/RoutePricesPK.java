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
import javax.validation.constraints.Size;

/**
 *
 * @author constantinn
 */
@Embeddable
public class RoutePricesPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "RouteCode")
    private String routeCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "CardTypeCode")
    private String cardTypeCode;

    public RoutePricesPK() {
    }

    public RoutePricesPK(String routeCode, String cardTypeCode) {
        this.routeCode = routeCode;
        this.cardTypeCode = cardTypeCode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getCardTypeCode() {
        return cardTypeCode;
    }

    public void setCardTypeCode(String cardTypeCode) {
        this.cardTypeCode = cardTypeCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeCode != null ? routeCode.hashCode() : 0);
        hash += (cardTypeCode != null ? cardTypeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoutePricesPK)) {
            return false;
        }
        RoutePricesPK other = (RoutePricesPK) object;
        if ((this.routeCode == null && other.routeCode != null) || (this.routeCode != null && !this.routeCode.equals(other.routeCode))) {
            return false;
        }
        if ((this.cardTypeCode == null && other.cardTypeCode != null) || (this.cardTypeCode != null && !this.cardTypeCode.equals(other.cardTypeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.RoutePricesPK[ routeCode=" + routeCode + ", cardTypeCode=" + cardTypeCode + " ]";
    }
    
}
