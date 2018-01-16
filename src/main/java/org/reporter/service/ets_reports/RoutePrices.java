/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "RoutePrices_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoutePrices.findAll", query = "SELECT r FROM RoutePrices r")
    , @NamedQuery(name = "RoutePrices.findByRouteCode", query = "SELECT r FROM RoutePrices r WHERE r.routePricesPK.routeCode = :routeCode")
    , @NamedQuery(name = "RoutePrices.findByCardTypeCode", query = "SELECT r FROM RoutePrices r WHERE r.routePricesPK.cardTypeCode = :cardTypeCode")
    , @NamedQuery(name = "RoutePrices.findByUnitPrice", query = "SELECT r FROM RoutePrices r WHERE r.unitPrice = :unitPrice")
    , @NamedQuery(name = "RoutePrices.findByUnitPassCount", query = "SELECT r FROM RoutePrices r WHERE r.unitPassCount = :unitPassCount")
    , @NamedQuery(name = "RoutePrices.findByTransfer1", query = "SELECT r FROM RoutePrices r WHERE r.transfer1 = :transfer1")
    , @NamedQuery(name = "RoutePrices.findByTransfer2", query = "SELECT r FROM RoutePrices r WHERE r.transfer2 = :transfer2")
    , @NamedQuery(name = "RoutePrices.findByTransfer3", query = "SELECT r FROM RoutePrices r WHERE r.transfer3 = :transfer3")
    , @NamedQuery(name = "RoutePrices.findByTransfer4", query = "SELECT r FROM RoutePrices r WHERE r.transfer4 = :transfer4")
    , @NamedQuery(name = "RoutePrices.findByTransfer5", query = "SELECT r FROM RoutePrices r WHERE r.transfer5 = :transfer5")
    , @NamedQuery(name = "RoutePrices.findByUnitTypeUse", query = "SELECT r FROM RoutePrices r WHERE r.unitTypeUse = :unitTypeUse")
    , @NamedQuery(name = "RoutePrices.findByStartDate", query = "SELECT r FROM RoutePrices r WHERE r.startDate = :startDate")
    , @NamedQuery(name = "RoutePrices.findByEndDate", query = "SELECT r FROM RoutePrices r WHERE r.endDate = :endDate")
    , @NamedQuery(name = "RoutePrices.findByCreateDate", query = "SELECT r FROM RoutePrices r WHERE r.createDate = :createDate")
    , @NamedQuery(name = "RoutePrices.findByStatus", query = "SELECT r FROM RoutePrices r WHERE r.status = :status")})
public class RoutePrices implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoutePricesPK routePricesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;
    @Column(name = "UnitPassCount")
    private BigDecimal unitPassCount;
    @Column(name = "Transfer1")
    private BigDecimal transfer1;
    @Column(name = "Transfer2")
    private BigDecimal transfer2;
    @Column(name = "Transfer3")
    private BigDecimal transfer3;
    @Column(name = "Transfer4")
    private BigDecimal transfer4;
    @Column(name = "Transfer5")
    private BigDecimal transfer5;
    @Column(name = "UnitTypeUse")
    private Short unitTypeUse;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "Status")
    private Character status;
    @JoinColumn(name = "CardTypeCode", referencedColumnName = "CardTypeCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CardTypes cardTypes;
    @JoinColumn(name = "RouteCode", referencedColumnName = "RouteCode", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Routes routes;

    public RoutePrices() {
    }

    public RoutePrices(RoutePricesPK routePricesPK) {
        this.routePricesPK = routePricesPK;
    }

    public RoutePrices(String routeCode, String cardTypeCode) {
        this.routePricesPK = new RoutePricesPK(routeCode, cardTypeCode);
    }

    public RoutePricesPK getRoutePricesPK() {
        return routePricesPK;
    }

    public void setRoutePricesPK(RoutePricesPK routePricesPK) {
        this.routePricesPK = routePricesPK;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPassCount() {
        return unitPassCount;
    }

    public void setUnitPassCount(BigDecimal unitPassCount) {
        this.unitPassCount = unitPassCount;
    }

    public BigDecimal getTransfer1() {
        return transfer1;
    }

    public void setTransfer1(BigDecimal transfer1) {
        this.transfer1 = transfer1;
    }

    public BigDecimal getTransfer2() {
        return transfer2;
    }

    public void setTransfer2(BigDecimal transfer2) {
        this.transfer2 = transfer2;
    }

    public BigDecimal getTransfer3() {
        return transfer3;
    }

    public void setTransfer3(BigDecimal transfer3) {
        this.transfer3 = transfer3;
    }

    public BigDecimal getTransfer4() {
        return transfer4;
    }

    public void setTransfer4(BigDecimal transfer4) {
        this.transfer4 = transfer4;
    }

    public BigDecimal getTransfer5() {
        return transfer5;
    }

    public void setTransfer5(BigDecimal transfer5) {
        this.transfer5 = transfer5;
    }

    public Short getUnitTypeUse() {
        return unitTypeUse;
    }

    public void setUnitTypeUse(Short unitTypeUse) {
        this.unitTypeUse = unitTypeUse;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public CardTypes getCardTypes() {
        return cardTypes;
    }

    public void setCardTypes(CardTypes cardTypes) {
        this.cardTypes = cardTypes;
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routePricesPK != null ? routePricesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoutePrices)) {
            return false;
        }
        RoutePrices other = (RoutePrices) object;
        if ((this.routePricesPK == null && other.routePricesPK != null) || (this.routePricesPK != null && !this.routePricesPK.equals(other.routePricesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.RoutePrices[ routePricesPK=" + routePricesPK + " ]";
    }
    
}
