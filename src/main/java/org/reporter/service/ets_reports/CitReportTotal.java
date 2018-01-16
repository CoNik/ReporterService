/*
 *  
 * Reporter Service 2018 Updates
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
@Table(name = "CitReportTotal_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitReportTotalV.findAll", query = "SELECT c FROM CitReportTotal c")
    , @NamedQuery(name = "CitReportTotalV.findById", query = "SELECT c FROM CitReportTotal c WHERE c.id = :id")
    , @NamedQuery(name = "CitReportTotalV.findByMachineid", query = "SELECT c FROM CitReportTotal c WHERE c.machineid = :machineid")
    , @NamedQuery(name = "CitReportTotalV.findByCitid", query = "SELECT c FROM CitReportTotal c WHERE c.citid = :citid")
    , @NamedQuery(name = "CitReportTotalV.findByCitsessionid", query = "SELECT c FROM CitReportTotal c WHERE c.citsessionid = :citsessionid")
    , @NamedQuery(name = "CitReportTotalV.findByRemovedmoney", query = "SELECT c FROM CitReportTotal c WHERE c.removedmoney = :removedmoney")
    , @NamedQuery(name = "CitReportTotalV.findByAddedmoney", query = "SELECT c FROM CitReportTotal c WHERE c.addedmoney = :addedmoney")
    , @NamedQuery(name = "CitReportTotalV.findByLoadedticket", query = "SELECT c FROM CitReportTotal c WHERE c.loadedticket = :loadedticket")
    , @NamedQuery(name = "CitReportTotalV.findByLoadedcard", query = "SELECT c FROM CitReportTotal c WHERE c.loadedcard = :loadedcard")
    , @NamedQuery(name = "CitReportTotalV.findByCreateddate", query = "SELECT c FROM CitReportTotal c WHERE c.createddate = :createddate")})
public class CitReportTotal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MACHINEID")
    private int machineid;
    @Column(name = "CITID")
    private Integer citid;
    @Size(max = 50)
    @Column(name = "CITSESSIONID")
    private String citsessionid;
    @Column(name = "REMOVEDMONEY")
    private Integer removedmoney;
    @Column(name = "ADDEDMONEY")
    private Integer addedmoney;
    @Column(name = "LOADEDTICKET")
    private Integer loadedticket;
    @Column(name = "LOADEDCARD")
    private Integer loadedcard;
    @Column(name = "CREATEDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;

    public CitReportTotal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMachineid() {
        return machineid;
    }

    public void setMachineid(int machineid) {
        this.machineid = machineid;
    }

    public Integer getCitid() {
        return citid;
    }

    public void setCitid(Integer citid) {
        this.citid = citid;
    }

    public String getCitsessionid() {
        return citsessionid;
    }

    public void setCitsessionid(String citsessionid) {
        this.citsessionid = citsessionid;
    }

    public Integer getRemovedmoney() {
        return removedmoney;
    }

    public void setRemovedmoney(Integer removedmoney) {
        this.removedmoney = removedmoney;
    }

    public Integer getAddedmoney() {
        return addedmoney;
    }

    public void setAddedmoney(Integer addedmoney) {
        this.addedmoney = addedmoney;
    }

    public Integer getLoadedticket() {
        return loadedticket;
    }

    public void setLoadedticket(Integer loadedticket) {
        this.loadedticket = loadedticket;
    }

    public Integer getLoadedcard() {
        return loadedcard;
    }

    public void setLoadedcard(Integer loadedcard) {
        this.loadedcard = loadedcard;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }
    
}
