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
@Table(name = "Locations_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LocationsV.findAll", query = "SELECT l FROM Locations l")
    , @NamedQuery(name = "LocationsV.findById", query = "SELECT l FROM Locations l WHERE l.id = :id")
    , @NamedQuery(name = "LocationsV.findByCityid", query = "SELECT l FROM Locations l WHERE l.cityid = :cityid")
    , @NamedQuery(name = "LocationsV.findByName", query = "SELECT l FROM Locations l WHERE l.name = :name")
    , @NamedQuery(name = "LocationsV.findByStatus", query = "SELECT l FROM Locations l WHERE l.status = :status")})
public class Locations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CITYID")
    private int cityid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    private int status;

    public Locations() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
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
