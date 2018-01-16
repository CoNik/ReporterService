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
@Table(name = "CitKioskCaseReceiptDetail_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CitKioskCaseReceiptDetailV.findAll", query = "SELECT c FROM CitKioskCaseReceiptDetail c")
    , @NamedQuery(name = "CitKioskCaseReceiptDetailV.findByHeaderid", query = "SELECT c FROM CitKioskCaseReceiptDetail c WHERE c.headerid = :headerid")
    , @NamedQuery(name = "CitKioskCaseReceiptDetailV.findByReceipttype", query = "SELECT c FROM CitKioskCaseReceiptDetail c WHERE c.receipttype = :receipttype")
    , @NamedQuery(name = "CitKioskCaseReceiptDetailV.findByItemId", query = "SELECT c FROM CitKioskCaseReceiptDetail c WHERE c.itemId = :itemId")
    , @NamedQuery(name = "CitKioskCaseReceiptDetailV.findByData1", query = "SELECT c FROM CitKioskCaseReceiptDetail c WHERE c.data1 = :data1")
    , @NamedQuery(name = "CitKioskCaseReceiptDetailV.findByData2", query = "SELECT c FROM CitKioskCaseReceiptDetail c WHERE c.data2 = :data2")})
public class CitKioskCaseReceiptDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "HEADERID")
    private int headerid;
    @Size(max = 50)
    @Column(name = "RECEIPTTYPE")
    private String receipttype;
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Column(name = "DATA1")
    private Integer data1;
    @Column(name = "DATA2")
    private Integer data2;

    public CitKioskCaseReceiptDetail() {
    }

    public int getHeaderid() {
        return headerid;
    }

    public void setHeaderid(int headerid) {
        this.headerid = headerid;
    }

    public String getReceipttype() {
        return receipttype;
    }

    public void setReceipttype(String receipttype) {
        this.receipttype = receipttype;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getData1() {
        return data1;
    }

    public void setData1(Integer data1) {
        this.data1 = data1;
    }

    public Integer getData2() {
        return data2;
    }

    public void setData2(Integer data2) {
        this.data2 = data2;
    }
    
}
