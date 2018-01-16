/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "KioskItems_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KioskItems.findAll", query = "SELECT k FROM KioskItems k")
    , @NamedQuery(name = "KioskItems.findById", query = "SELECT k FROM KioskItems k WHERE k.id = :id")
    , @NamedQuery(name = "KioskItems.findByPeriod", query = "SELECT k FROM KioskItems k WHERE k.sentDate between :startDate and :endDate")
    , @NamedQuery(name = "KioskItems.findByPeriodAndStation", query = "SELECT k FROM KioskItems k,  Validators v, Stations s WHERE (k.sentDate between :startDate and :endDate) and k.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.displayName = :stationName")
    , @NamedQuery(name = "KioskItems.findByStationId", query = "SELECT k FROM KioskItems k,  Validators v WHERE  k.validatorCode = v.validatorsPK.validatorCode and v.stationId.stationId = :stationID")
    , @NamedQuery(name = "KioskItems.findByPeriodAndStationId", query = "SELECT k FROM KioskItems k,  Validators v, Stations s WHERE (k.sentDate between :startDate and :endDate) and k.validatorCode = v.validatorsPK.validatorCode and v.stationId = s.stationId and s.stationId = :stationId")
    , @NamedQuery(name = "KioskItems.findByCode", query = "SELECT k FROM KioskItems k WHERE k.code = :code")
    , @NamedQuery(name = "KioskItems.findByValidatorCode", query = "SELECT k FROM KioskItems k WHERE k.validatorCode = :validatorCode")
    , @NamedQuery(name = "KioskItems.findByItemType", query = "SELECT k FROM KioskItems k WHERE k.itemType = :itemType")
    , @NamedQuery(name = "KioskItems.findByValidatorPath", query = "SELECT k FROM KioskItems k WHERE k.validatorPath = :validatorPath")
    , @NamedQuery(name = "KioskItems.findByHopperDeviceId", query = "SELECT k FROM KioskItems k WHERE k.hopperDeviceId = :hopperDeviceId")
    , @NamedQuery(name = "KioskItems.findByHopperVaultIndex", query = "SELECT k FROM KioskItems k WHERE k.hopperVaultIndex = :hopperVaultIndex")
    , @NamedQuery(name = "KioskItems.findByIproRCDeviceId", query = "SELECT k FROM KioskItems k WHERE k.iproRCDeviceId = :iproRCDeviceId")
    , @NamedQuery(name = "KioskItems.findByIproRCStackIndex", query = "SELECT k FROM KioskItems k WHERE k.iproRCStackIndex = :iproRCStackIndex")
    , @NamedQuery(name = "KioskItems.findByOnInfeeder01", query = "SELECT k FROM KioskItems k WHERE k.onInfeeder01 = :onInfeeder01")
    , @NamedQuery(name = "KioskItems.findByOnInfeeder02", query = "SELECT k FROM KioskItems k WHERE k.onInfeeder02 = :onInfeeder02")
    , @NamedQuery(name = "KioskItems.findByDescription", query = "SELECT k FROM KioskItems k WHERE k.description = :description")
    , @NamedQuery(name = "KioskItems.findByValue", query = "SELECT k FROM KioskItems k WHERE k.value = :value")
    , @NamedQuery(name = "KioskItems.findByCurrentCount", query = "SELECT k FROM KioskItems k WHERE k.currentCount = :currentCount")
    , @NamedQuery(name = "KioskItems.findByCountAtPrimary", query = "SELECT k FROM KioskItems k WHERE k.countAtPrimary = :countAtPrimary")
    , @NamedQuery(name = "KioskItems.findByCountAtSecondary", query = "SELECT k FROM KioskItems k WHERE k.countAtSecondary = :countAtSecondary")
    , @NamedQuery(name = "KioskItems.findByLastUpdateTime", query = "SELECT k FROM KioskItems k WHERE k.lastUpdateTime = :lastUpdateTime")
    , @NamedQuery(name = "KioskItems.findByMinimumCount", query = "SELECT k FROM KioskItems k WHERE k.minimumCount = :minimumCount")
    , @NamedQuery(name = "KioskItems.findByMaximumCount", query = "SELECT k FROM KioskItems k WHERE k.maximumCount = :maximumCount")
    , @NamedQuery(name = "KioskItems.findByLowerTrashHoldCount", query = "SELECT k FROM KioskItems k WHERE k.lowerTrashHoldCount = :lowerTrashHoldCount")
    , @NamedQuery(name = "KioskItems.findByUpperTrashHoldCount", query = "SELECT k FROM KioskItems k WHERE k.upperTrashHoldCount = :upperTrashHoldCount")
    , @NamedQuery(name = "KioskItems.findByCreatedDate", query = "SELECT k FROM KioskItems k WHERE k.createdDate = :createdDate")
    , @NamedQuery(name = "KioskItems.findByStatus", query = "SELECT k FROM KioskItems k WHERE k.status = :status")
    , @NamedQuery(name = "KioskItems.findBySentDate", query = "SELECT k FROM KioskItems k WHERE k.sentDate = :sentDate")})
public class KioskItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ValidatorCode")
    private String validatorCode;
    @Column(name = "ItemType")
    private Integer itemType;
    @Size(max = 100)
    @Column(name = "ValidatorPath")
    private String validatorPath;
    @Column(name = "HopperDeviceId")
    private Integer hopperDeviceId;
    @Column(name = "HopperVaultIndex")
    private Integer hopperVaultIndex;
    @Column(name = "IproRCDeviceId")
    private Integer iproRCDeviceId;
    @Column(name = "IproRCStackIndex")
    private Integer iproRCStackIndex;
    @Column(name = "OnInfeeder01")
    private Boolean onInfeeder01;
    @Column(name = "OnInfeeder02")
    private Boolean onInfeeder02;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Value")
    private BigDecimal value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CurrentCount")
    private int currentCount;
    @Column(name = "CountAtPrimary")
    private Integer countAtPrimary;
    @Column(name = "CountAtSecondary")
    private Integer countAtSecondary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastUpdateTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MinimumCount")
    private int minimumCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaximumCount")
    private int maximumCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LowerTrashHoldCount")
    private int lowerTrashHoldCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UpperTrashHoldCount")
    private int upperTrashHoldCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status")
    private int status;
    @Column(name = "SentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    public KioskItems() {
    }

    public KioskItems(Integer id) {
        this.id = id;
    }

    public KioskItems(Integer id, String code, String validatorCode, String description, BigDecimal value, int currentCount, Date lastUpdateTime, int minimumCount, int maximumCount, int lowerTrashHoldCount, int upperTrashHoldCount, Date createdDate, int status) {
        this.id = id;
        this.code = code;
        this.validatorCode = validatorCode;
        this.description = description;
        this.value = value;
        this.currentCount = currentCount;
        this.lastUpdateTime = lastUpdateTime;
        this.minimumCount = minimumCount;
        this.maximumCount = maximumCount;
        this.lowerTrashHoldCount = lowerTrashHoldCount;
        this.upperTrashHoldCount = upperTrashHoldCount;
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

    public String getValidatorCode() {
        return validatorCode;
    }

    public void setValidatorCode(String validatorCode) {
        this.validatorCode = validatorCode;
    }

    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    public String getValidatorPath() {
        return validatorPath;
    }

    public void setValidatorPath(String validatorPath) {
        this.validatorPath = validatorPath;
    }

    public Integer getHopperDeviceId() {
        return hopperDeviceId;
    }

    public void setHopperDeviceId(Integer hopperDeviceId) {
        this.hopperDeviceId = hopperDeviceId;
    }

    public Integer getHopperVaultIndex() {
        return hopperVaultIndex;
    }

    public void setHopperVaultIndex(Integer hopperVaultIndex) {
        this.hopperVaultIndex = hopperVaultIndex;
    }

    public Integer getIproRCDeviceId() {
        return iproRCDeviceId;
    }

    public void setIproRCDeviceId(Integer iproRCDeviceId) {
        this.iproRCDeviceId = iproRCDeviceId;
    }

    public Integer getIproRCStackIndex() {
        return iproRCStackIndex;
    }

    public void setIproRCStackIndex(Integer iproRCStackIndex) {
        this.iproRCStackIndex = iproRCStackIndex;
    }

    public Boolean getOnInfeeder01() {
        return onInfeeder01;
    }

    public void setOnInfeeder01(Boolean onInfeeder01) {
        this.onInfeeder01 = onInfeeder01;
    }

    public Boolean getOnInfeeder02() {
        return onInfeeder02;
    }

    public void setOnInfeeder02(Boolean onInfeeder02) {
        this.onInfeeder02 = onInfeeder02;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public Integer getCountAtPrimary() {
        return countAtPrimary;
    }

    public void setCountAtPrimary(Integer countAtPrimary) {
        this.countAtPrimary = countAtPrimary;
    }

    public Integer getCountAtSecondary() {
        return countAtSecondary;
    }

    public void setCountAtSecondary(Integer countAtSecondary) {
        this.countAtSecondary = countAtSecondary;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getMinimumCount() {
        return minimumCount;
    }

    public void setMinimumCount(int minimumCount) {
        this.minimumCount = minimumCount;
    }

    public int getMaximumCount() {
        return maximumCount;
    }

    public void setMaximumCount(int maximumCount) {
        this.maximumCount = maximumCount;
    }

    public int getLowerTrashHoldCount() {
        return lowerTrashHoldCount;
    }

    public void setLowerTrashHoldCount(int lowerTrashHoldCount) {
        this.lowerTrashHoldCount = lowerTrashHoldCount;
    }

    public int getUpperTrashHoldCount() {
        return upperTrashHoldCount;
    }

    public void setUpperTrashHoldCount(int upperTrashHoldCount) {
        this.upperTrashHoldCount = upperTrashHoldCount;
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
        if (!(object instanceof KioskItems)) {
            return false;
        }
        KioskItems other = (KioskItems) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.KioskItems[ id=" + id + " ]";
    }
    
}
