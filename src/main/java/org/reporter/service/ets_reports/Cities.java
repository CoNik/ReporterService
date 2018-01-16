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
@Table(name = "Cities_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitiesV.findAll", query = "SELECT c FROM Cities c")
    , @NamedQuery(name = "CitiesV.findById", query = "SELECT c FROM Cities c WHERE c.id = :id")
    , @NamedQuery(name = "CitiesV.findByName", query = "SELECT c FROM Cities c WHERE c.name = :name")
    , @NamedQuery(name = "CitiesV.findByStatus", query = "SELECT c FROM Cities c WHERE c.status = :status")})
public class Cities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;

    public Cities() {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
