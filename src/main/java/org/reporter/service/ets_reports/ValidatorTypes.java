/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "ValidatorTypes_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValidatorTypes.findAll", query = "SELECT v FROM ValidatorTypes v")
    , @NamedQuery(name = "ValidatorTypes.findByValidatorTypeCode", query = "SELECT v FROM ValidatorTypes v WHERE v.validatorTypeCode = :validatorTypeCode")
    , @NamedQuery(name = "ValidatorTypes.findByDescription", query = "SELECT v FROM ValidatorTypes v WHERE v.description = :description")})
public class ValidatorTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ValidatorTypeCode")
    private String validatorTypeCode;
    @Size(max = 50)
    @Column(name = "Description")
    private String description;

    public ValidatorTypes() {
    }

    public ValidatorTypes(String validatorTypeCode) {
        this.validatorTypeCode = validatorTypeCode;
    }

    public String getValidatorTypeCode() {
        return validatorTypeCode;
    }

    public void setValidatorTypeCode(String validatorTypeCode) {
        this.validatorTypeCode = validatorTypeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (validatorTypeCode != null ? validatorTypeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidatorTypes)) {
            return false;
        }
        ValidatorTypes other = (ValidatorTypes) object;
        if ((this.validatorTypeCode == null && other.validatorTypeCode != null) || (this.validatorTypeCode != null && !this.validatorTypeCode.equals(other.validatorTypeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.ValidatorTypes[ validatorTypeCode=" + validatorTypeCode + " ]";
    }
    
}
