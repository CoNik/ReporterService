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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "MachineTypes_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MachineTypesV.findAll", query = "SELECT m FROM MachineTypes m")
    , @NamedQuery(name = "MachineTypesV.findById", query = "SELECT m FROM MachineTypes m WHERE m.id = :id")
    , @NamedQuery(name = "MachineTypesV.findByName", query = "SELECT m FROM MachineTypes m WHERE m.name = :name")
    , @NamedQuery(name = "MachineTypesV.findByStatus", query = "SELECT m FROM MachineTypes m WHERE m.status = :status")})
public class MachineTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Size(max = 200)
    @Column(name = "NAME")
    private String name;
    @Column(name = "STATUS")
    private Integer status;

    public MachineTypes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
}
