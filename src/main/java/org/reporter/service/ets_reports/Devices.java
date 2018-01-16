/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "Devices_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devices.findAll", query = "SELECT d FROM Devices d")
    , @NamedQuery(name = "Devices.findById", query = "SELECT d FROM Devices d WHERE d.id = :id")
    , @NamedQuery(name = "Devices.findByCode", query = "SELECT d FROM Devices d WHERE d.code = :code")
    , @NamedQuery(name = "Devices.findByDescription", query = "SELECT d FROM Devices d WHERE d.description = :description")
    , @NamedQuery(name = "Devices.findByLastActivityDate", query = "SELECT d FROM Devices d WHERE d.lastActivityDate = :lastActivityDate")
    , @NamedQuery(name = "Devices.findByLastErrorDate", query = "SELECT d FROM Devices d WHERE d.lastErrorDate = :lastErrorDate")
    , @NamedQuery(name = "Devices.findByLastErrorDescription", query = "SELECT d FROM Devices d WHERE d.lastErrorDescription = :lastErrorDescription")
    , @NamedQuery(name = "Devices.findByCreatedDate", query = "SELECT d FROM Devices d WHERE d.createdDate = :createdDate")
    , @NamedQuery(name = "Devices.findByStatus", query = "SELECT d FROM Devices d WHERE d.status = :status")})
public class Devices implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Description")
    private String description;
    @Column(name = "LastActivityDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastActivityDate;
    @Column(name = "LastErrorDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastErrorDate;
    @Size(max = 1000)
    @Column(name = "LastErrorDescription")
    private String lastErrorDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;

    public Devices() {
    }

    public Devices(Integer id) {
        this.id = id;
    }

    public Devices(Integer id, String code, String description, Date createdDate, int status) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.createdDate = createdDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Date getLastErrorDate() {
        return lastErrorDate;
    }

    public void setLastErrorDate(Date lastErrorDate) {
        this.lastErrorDate = lastErrorDate;
    }

    public String getLastErrorDescription() {
        return lastErrorDescription;
    }

    public void setLastErrorDescription(String lastErrorDescription) {
        this.lastErrorDescription = lastErrorDescription;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        if (!(object instanceof Devices)) {
            return false;
        }
        Devices other = (Devices) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Devices[ id=" + id + " ]";
    }
    
}
