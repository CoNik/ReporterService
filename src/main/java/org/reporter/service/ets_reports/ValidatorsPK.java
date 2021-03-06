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
public class ValidatorsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ValidatorCode")
    private String validatorCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IPAdress")
    private String iPAdress;

    public ValidatorsPK() {
    }

    public ValidatorsPK(String validatorCode, String iPAdress) {
        this.validatorCode = validatorCode;
        this.iPAdress = iPAdress;
    }

    public String getValidatorCode() {
        return validatorCode;
    }

    public void setValidatorCode(String validatorCode) {
        this.validatorCode = validatorCode;
    }

    public String getIPAdress() {
        return iPAdress;
    }

    public void setIPAdress(String iPAdress) {
        this.iPAdress = iPAdress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (validatorCode != null ? validatorCode.hashCode() : 0);
        hash += (iPAdress != null ? iPAdress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValidatorsPK)) {
            return false;
        }
        ValidatorsPK other = (ValidatorsPK) object;
        if ((this.validatorCode == null && other.validatorCode != null) || (this.validatorCode != null && !this.validatorCode.equals(other.validatorCode))) {
            return false;
        }
        if ((this.iPAdress == null && other.iPAdress != null) || (this.iPAdress != null && !this.iPAdress.equals(other.iPAdress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.ValidatorsPK[ validatorCode=" + validatorCode + ", iPAdress=" + iPAdress + " ]";
    }
    
}
