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
@Table(name = "RulesRoute_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RulesRoute.findAll", query = "SELECT r FROM RulesRoute r")
    , @NamedQuery(name = "RulesRoute.findByRuleId", query = "SELECT r FROM RulesRoute r WHERE r.ruleId = :ruleId")
    , @NamedQuery(name = "RulesRoute.findByRouteCode", query = "SELECT r FROM RulesRoute r WHERE r.routeCode = :routeCode")
    , @NamedQuery(name = "RulesRoute.findByCardTypeCode", query = "SELECT r FROM RulesRoute r WHERE r.cardTypeCode = :cardTypeCode")
    , @NamedQuery(name = "RulesRoute.findByFormula", query = "SELECT r FROM RulesRoute r WHERE r.formula = :formula")
    , @NamedQuery(name = "RulesRoute.findByStartDate", query = "SELECT r FROM RulesRoute r WHERE r.startDate = :startDate")
    , @NamedQuery(name = "RulesRoute.findByEndDate", query = "SELECT r FROM RulesRoute r WHERE r.endDate = :endDate")
    , @NamedQuery(name = "RulesRoute.findByMultiplier", query = "SELECT r FROM RulesRoute r WHERE r.multiplier = :multiplier")
    , @NamedQuery(name = "RulesRoute.findByCreateDate", query = "SELECT r FROM RulesRoute r WHERE r.createDate = :createDate")})
public class RulesRoute implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RuleId")
    private Long ruleId;
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
    @Size(max = 250)
    @Column(name = "Formula")
    private String formula;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Multiplier")
    private BigDecimal multiplier;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public RulesRoute() {
    }

    public RulesRoute(Long ruleId) {
        this.ruleId = ruleId;
    }

    public RulesRoute(Long ruleId, String routeCode, String cardTypeCode) {
        this.ruleId = ruleId;
        this.routeCode = routeCode;
        this.cardTypeCode = cardTypeCode;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
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

    public BigDecimal getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(BigDecimal multiplier) {
        this.multiplier = multiplier;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruleId != null ? ruleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RulesRoute)) {
            return false;
        }
        RulesRoute other = (RulesRoute) object;
        if ((this.ruleId == null && other.ruleId != null) || (this.ruleId != null && !this.ruleId.equals(other.ruleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.RulesRoute[ ruleId=" + ruleId + " ]";
    }
    
}
