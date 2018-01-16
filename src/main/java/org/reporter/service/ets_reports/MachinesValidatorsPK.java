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
public class MachinesValidatorsPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MachineId")
    private int machineId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ValidatorCode")
    private String validatorCode;

    public MachinesValidatorsPK() {
    }

    public MachinesValidatorsPK(int machineId, String validatorCode) {
        this.machineId = machineId;
        this.validatorCode = validatorCode;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    public String getValidatorCode() {
        return validatorCode;
    }

    public void setValidatorCode(String validatorCode) {
        this.validatorCode = validatorCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) machineId;
        hash += (validatorCode != null ? validatorCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MachinesValidatorsPK)) {
            return false;
        }
        MachinesValidatorsPK other = (MachinesValidatorsPK) object;
        if (this.machineId != other.machineId) {
            return false;
        }
        if ((this.validatorCode == null && other.validatorCode != null) || (this.validatorCode != null && !this.validatorCode.equals(other.validatorCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.MachinesValidatorsPK[ machineId=" + machineId + ", validatorCode=" + validatorCode + " ]";
    }
    
}
