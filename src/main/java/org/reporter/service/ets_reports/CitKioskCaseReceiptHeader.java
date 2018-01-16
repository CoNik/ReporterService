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
@Table(name = "CitKioskCaseReceiptHeader_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitKioskCaseReceiptHeaderV.findAll", query = "SELECT c FROM CitKioskCaseReceiptHeader c")
    , @NamedQuery(name = "CitKioskCaseReceiptHeaderV.findById", query = "SELECT c FROM CitKioskCaseReceiptHeader c WHERE c.id = :id")
    , @NamedQuery(name = "CitKioskCaseReceiptHeaderV.findByCitDate", query = "SELECT c FROM CitKioskCaseReceiptHeader c WHERE c.citDate = :citDate")
    , @NamedQuery(name = "CitKioskCaseReceiptHeaderV.findByMachineid", query = "SELECT c FROM CitKioskCaseReceiptHeader c WHERE c.machineid = :machineid")
    , @NamedQuery(name = "CitKioskCaseReceiptHeaderV.findByCitfullname", query = "SELECT c FROM CitKioskCaseReceiptHeader c WHERE c.citfullname = :citfullname")
    , @NamedQuery(name = "CitKioskCaseReceiptHeaderV.findByCardid", query = "SELECT c FROM CitKioskCaseReceiptHeader c WHERE c.cardid = :cardid")
    , @NamedQuery(name = "CitKioskCaseReceiptHeaderV.findByCitsessionid", query = "SELECT c FROM CitKioskCaseReceiptHeader c WHERE c.citsessionid = :citsessionid")
    , @NamedQuery(name = "CitKioskCaseReceiptHeaderV.findByOldcitcasereceiptDate", query = "SELECT c FROM CitKioskCaseReceiptHeader c WHERE c.oldcitcasereceiptDate = :oldcitcasereceiptDate")
    , @NamedQuery(name = "CitKioskCaseReceiptHeaderV.findByOldcitcasereceiptSessionid", query = "SELECT c FROM CitKioskCaseReceiptHeader c WHERE c.oldcitcasereceiptSessionid = :oldcitcasereceiptSessionid")})
public class CitKioskCaseReceiptHeader implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Column(name = "CIT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date citDate;
    @Column(name = "MACHINEID")
    private Integer machineid;
    @Size(max = 255)
    @Column(name = "CITFULLNAME")
    private String citfullname;
    @Size(max = 50)
    @Column(name = "CARDID")
    private String cardid;
    @Size(max = 100)
    @Column(name = "CITSESSIONID")
    private String citsessionid;
    @Size(max = 50)
    @Column(name = "OLDCITCASERECEIPT_DATE")
    private String oldcitcasereceiptDate;
    @Size(max = 100)
    @Column(name = "OLDCITCASERECEIPT_SESSIONID")
    private String oldcitcasereceiptSessionid;

    public CitKioskCaseReceiptHeader() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCitDate() {
        return citDate;
    }

    public void setCitDate(Date citDate) {
        this.citDate = citDate;
    }

    public Integer getMachineid() {
        return machineid;
    }

    public void setMachineid(Integer machineid) {
        this.machineid = machineid;
    }

    public String getCitfullname() {
        return citfullname;
    }

    public void setCitfullname(String citfullname) {
        this.citfullname = citfullname;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getCitsessionid() {
        return citsessionid;
    }

    public void setCitsessionid(String citsessionid) {
        this.citsessionid = citsessionid;
    }

    public String getOldcitcasereceiptDate() {
        return oldcitcasereceiptDate;
    }

    public void setOldcitcasereceiptDate(String oldcitcasereceiptDate) {
        this.oldcitcasereceiptDate = oldcitcasereceiptDate;
    }

    public String getOldcitcasereceiptSessionid() {
        return oldcitcasereceiptSessionid;
    }

    public void setOldcitcasereceiptSessionid(String oldcitcasereceiptSessionid) {
        this.oldcitcasereceiptSessionid = oldcitcasereceiptSessionid;
    }
    
}
