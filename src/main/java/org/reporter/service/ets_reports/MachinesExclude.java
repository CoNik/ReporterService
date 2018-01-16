/*
 *  
 * Reporter Service 2018 Updates
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "MachinesExclude_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MachinesExcludeV.findAll", query = "SELECT m FROM MachinesExclude m")
    , @NamedQuery(name = "MachinesExcludeV.findByKioskid", query = "SELECT m FROM MachinesExclude m WHERE m.kioskid = :kioskid")})
public class MachinesExclude implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "KIOSKID")
    private int kioskid;

    public MachinesExclude() {
    }

    public int getKioskid() {
        return kioskid;
    }

    public void setKioskid(int kioskid) {
        this.kioskid = kioskid;
    }
    
}
