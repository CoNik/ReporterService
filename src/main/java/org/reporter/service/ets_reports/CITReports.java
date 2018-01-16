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
@Table(name = "CITReports_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CITReports.findAll", query = "SELECT c FROM CITReports c")
    , @NamedQuery(name = "CITReports.findById", query = "SELECT c FROM CITReports c WHERE c.id = :id")
    , @NamedQuery(name = "CITReports.findByPeriod", query = "SELECT c FROM CITReports c WHERE c.sentDate between :startDate and :endDate")
    , @NamedQuery(name = "CITReports.findByPeriodAndStation", query = "SELECT c FROM CITReports c, MachinesValidators mv, Validators v, Stations s WHERE (c.sentDate between :startDate and :endDate) and c.machineId=mv.machinesValidatorsPK.machineId and mv.machinesValidatorsPK.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.displayName = :stationName")
    , @NamedQuery(name = "CITReports.findByPeriodAndStationId", query = "SELECT c FROM CITReports c, MachinesValidators mv, Validators v, Stations s WHERE (c.sentDate between :startDate and :endDate) and c.machineId=mv.machinesValidatorsPK.machineId and mv.machinesValidatorsPK.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.stationId = :stationId")
    , @NamedQuery(name = "CITReports.findByMachineId", query = "SELECT c FROM CITReports c WHERE c.machineId = :machineId")
    , @NamedQuery(name = "CITReports.findByCITId", query = "SELECT c FROM CITReports c WHERE c.cITId = :cITId")
    , @NamedQuery(name = "CITReports.findByCITSessionId", query = "SELECT c FROM CITReports c WHERE c.cITSessionId = :cITSessionId")
    , @NamedQuery(name = "CITReports.findByItemId", query = "SELECT c FROM CITReports c WHERE c.itemId = :itemId")
    , @NamedQuery(name = "CITReports.findByCountAtPrimary", query = "SELECT c FROM CITReports c WHERE c.countAtPrimary = :countAtPrimary")
    , @NamedQuery(name = "CITReports.findByCountAtSecondary", query = "SELECT c FROM CITReports c WHERE c.countAtSecondary = :countAtSecondary")
    , @NamedQuery(name = "CITReports.findByDescriptionOnPrimary", query = "SELECT c FROM CITReports c WHERE c.descriptionOnPrimary = :descriptionOnPrimary")
    , @NamedQuery(name = "CITReports.findByDescriptionOnSecondary", query = "SELECT c FROM CITReports c WHERE c.descriptionOnSecondary = :descriptionOnSecondary")
    , @NamedQuery(name = "CITReports.findByOnInfeeder01", query = "SELECT c FROM CITReports c WHERE c.onInfeeder01 = :onInfeeder01")
    , @NamedQuery(name = "CITReports.findByOnInfeeder02", query = "SELECT c FROM CITReports c WHERE c.onInfeeder02 = :onInfeeder02")
    , @NamedQuery(name = "CITReports.findByTypeId", query = "SELECT c FROM CITReports c WHERE c.typeId = :typeId")
    , @NamedQuery(name = "CITReports.findByCreatedDate", query = "SELECT c FROM CITReports c WHERE c.createdDate = :createdDate")
    , @NamedQuery(name = "CITReports.findBySentDate", query = "SELECT c FROM CITReports c WHERE c.sentDate = :sentDate")})
public class CITReports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "MachineId")
    private Integer machineId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CITId")
    private int cITId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CITSessionId")
    private String cITSessionId;
    @Column(name = "ItemId")
    private Integer itemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CountAtPrimary")
    private int countAtPrimary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CountAtSecondary")
    private int countAtSecondary;
    @Size(max = 500)
    @Column(name = "DescriptionOnPrimary")
    private String descriptionOnPrimary;
    @Size(max = 500)
    @Column(name = "DescriptionOnSecondary")
    private String descriptionOnSecondary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OnInfeeder01")
    private boolean onInfeeder01;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OnInfeeder02")
    private boolean onInfeeder02;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TypeId")
    private int typeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "SentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    public CITReports() {
    }

    public CITReports(Integer id) {
        this.id = id;
    }

    public CITReports(Integer id, int cITId, String cITSessionId, int countAtPrimary, int countAtSecondary, boolean onInfeeder01, boolean onInfeeder02, int typeId, Date createdDate) {
        this.id = id;
        this.cITId = cITId;
        this.cITSessionId = cITSessionId;
        this.countAtPrimary = countAtPrimary;
        this.countAtSecondary = countAtSecondary;
        this.onInfeeder01 = onInfeeder01;
        this.onInfeeder02 = onInfeeder02;
        this.typeId = typeId;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    public int getCITId() {
        return cITId;
    }

    public void setCITId(int cITId) {
        this.cITId = cITId;
    }

    public String getCITSessionId() {
        return cITSessionId;
    }

    public void setCITSessionId(String cITSessionId) {
        this.cITSessionId = cITSessionId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public int getCountAtPrimary() {
        return countAtPrimary;
    }

    public void setCountAtPrimary(int countAtPrimary) {
        this.countAtPrimary = countAtPrimary;
    }

    public int getCountAtSecondary() {
        return countAtSecondary;
    }

    public void setCountAtSecondary(int countAtSecondary) {
        this.countAtSecondary = countAtSecondary;
    }

    public String getDescriptionOnPrimary() {
        return descriptionOnPrimary;
    }

    public void setDescriptionOnPrimary(String descriptionOnPrimary) {
        this.descriptionOnPrimary = descriptionOnPrimary;
    }

    public String getDescriptionOnSecondary() {
        return descriptionOnSecondary;
    }

    public void setDescriptionOnSecondary(String descriptionOnSecondary) {
        this.descriptionOnSecondary = descriptionOnSecondary;
    }

    public boolean getOnInfeeder01() {
        return onInfeeder01;
    }

    public void setOnInfeeder01(boolean onInfeeder01) {
        this.onInfeeder01 = onInfeeder01;
    }

    public boolean getOnInfeeder02() {
        return onInfeeder02;
    }

    public void setOnInfeeder02(boolean onInfeeder02) {
        this.onInfeeder02 = onInfeeder02;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
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
        if (!(object instanceof CITReports)) {
            return false;
        }
        CITReports other = (CITReports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.CITReports[ id=" + id + " ]";
    }
    
}
