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
@Table(name = "Groups_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupsV.findAll", query = "SELECT g FROM Groups g")
    , @NamedQuery(name = "GroupsV.findById", query = "SELECT g FROM Groups g WHERE g.id = :id")
    , @NamedQuery(name = "GroupsV.findByName", query = "SELECT g FROM Groups g WHERE g.name = :name")
    , @NamedQuery(name = "GroupsV.findByStatus", query = "SELECT g FROM Groups g WHERE g.status = :status")
    , @NamedQuery(name = "GroupsV.findByLocationid", query = "SELECT g FROM Groups g WHERE g.locationid = :locationid")})
public class Groups implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "LOCATIONID")
    private int locationid;

    public Groups() {
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

    public int getLocationid() {
        return locationid;
    }

    public void setLocationid(int locationid) {
        this.locationid = locationid;
    }
    
}
