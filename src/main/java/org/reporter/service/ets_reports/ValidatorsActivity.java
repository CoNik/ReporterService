/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author roxanam
 */
@Entity
@Table(name = "ValidatorsActivity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValidatorsActivity.findAll", query = "SELECT v FROM ValidatorsActivity v")
    , @NamedQuery(name = "ValidatorsActivity.findById", query = "SELECT v FROM ValidatorsActivity v WHERE v.id = :id")
    , @NamedQuery(name = "ValidatorsActivity.findByValidatorCode", query = "SELECT v FROM ValidatorsActivity v WHERE v.validatorCode = :validatorCode")
    , @NamedQuery(name = "ValidatorsActivity.findByStartDate", query = "SELECT v FROM ValidatorsActivity v WHERE v.startDate = :startDate")
    , @NamedQuery(name = "ValidatorsActivity.findByEndDate", query = "SELECT v FROM ValidatorsActivity v WHERE v.endDate = :endDate")
    , @NamedQuery(name = "ValidatorsActivity.findByNoIn", query = "SELECT v FROM ValidatorsActivity v WHERE v.noIn = :noIn")
    , @NamedQuery(name = "ValidatorsActivity.findByNoOut", query = "SELECT v FROM ValidatorsActivity v WHERE v.noOut = :noOut")})
public class ValidatorsActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "ValidatorCode")
    private Integer validatorCode;
    @Column(name = "StartDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "EndDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "NoIn")
    private Integer noIn;
    @Column(name = "NoOut")
    private Integer noOut;

    public ValidatorsActivity() {
    }

    public ValidatorsActivity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValidatorCode() {
        return validatorCode;
    }

    public void setValidatorCode(Integer validatorCode) {
        this.validatorCode = validatorCode;
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

    public Integer getNoIn() {
        return noIn;
    }

    public void setNoIn(Integer noIn) {
        this.noIn = noIn;
    }

    public Integer getNoOut() {
        return noOut;
    }

    public void setNoOut(Integer noOut) {
        this.noOut = noOut;
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
        if (!(object instanceof ValidatorsActivity)) {
            return false;
        }
        ValidatorsActivity other = (ValidatorsActivity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.ValidatorsActivity[ id=" + id + " ]";
    }
    
}
