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
@Table(name = "MachinesValidators_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MachinesValidators.findAll", query = "SELECT m FROM MachinesValidators m")
    , @NamedQuery(name = "MachinesValidators.findByMachineId", query = "SELECT m FROM MachinesValidators m WHERE m.machinesValidatorsPK.machineId = :machineId")
    , @NamedQuery(name = "MachinesValidators.findByValidatorCode", query = "SELECT m FROM MachinesValidators m WHERE m.machinesValidatorsPK.validatorCode = :validatorCode")})
public class MachinesValidators implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MachinesValidatorsPK machinesValidatorsPK;

    public MachinesValidators() {
    }

    public MachinesValidators(MachinesValidatorsPK machinesValidatorsPK) {
        this.machinesValidatorsPK = machinesValidatorsPK;
    }

    public MachinesValidators(int machineId, String validatorCode) {
        this.machinesValidatorsPK = new MachinesValidatorsPK(machineId, validatorCode);
    }

    public MachinesValidatorsPK getMachinesValidatorsPK() {
        return machinesValidatorsPK;
    }

    public void setMachinesValidatorsPK(MachinesValidatorsPK machinesValidatorsPK) {
        this.machinesValidatorsPK = machinesValidatorsPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (machinesValidatorsPK != null ? machinesValidatorsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MachinesValidators)) {
            return false;
        }
        MachinesValidators other = (MachinesValidators) object;
        if ((this.machinesValidatorsPK == null && other.machinesValidatorsPK != null) || (this.machinesValidatorsPK != null && !this.machinesValidatorsPK.equals(other.machinesValidatorsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.MachinesValidators[ machinesValidatorsPK=" + machinesValidatorsPK + " ]";
    }
    
}
