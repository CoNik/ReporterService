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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "ActivityLogHourly_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivityLogHourlyV.findAll", query = "SELECT a FROM ActivityLogHourly a")
    , @NamedQuery(name = "ActivityLogHourlyV.findById", query = "SELECT a FROM ActivityLogHourly a WHERE a.id = :id")
    , @NamedQuery(name = "ActivityLogHourlyV.findByKioskid", query = "SELECT a FROM ActivityLogHourly a WHERE a.kioskid = :kioskid")
    , @NamedQuery(name = "ActivityLogHourlyV.findByActivitytypeid", query = "SELECT a FROM ActivityLogHourly a WHERE a.activitytypeid = :activitytypeid")
    , @NamedQuery(name = "ActivityLogHourlyV.findByActivitytimeperiod", query = "SELECT a FROM ActivityLogHourly a WHERE a.activitytimeperiod = :activitytimeperiod")
    , @NamedQuery(name = "ActivityLogHourlyV.findByQuantity", query = "SELECT a FROM ActivityLogHourly a WHERE a.quantity = :quantity")
    , @NamedQuery(name = "ActivityLogHourlyV.findByValue", query = "SELECT a FROM ActivityLogHourly a WHERE a.value = :value")
    , @NamedQuery(name = "ActivityLogHourlyV.findByItemid", query = "SELECT a FROM ActivityLogHourly a WHERE a.itemid = :itemid")})
public class ActivityLogHourly implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KIOSKID")
    private int kioskid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVITYTYPEID")
    private int activitytypeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVITYTIMEPERIOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activitytimeperiod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALUE")
    private int value;
    @Column(name = "ITEMID")
    private Integer itemid;

    public ActivityLogHourly() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKioskid() {
        return kioskid;
    }

    public void setKioskid(int kioskid) {
        this.kioskid = kioskid;
    }

    public int getActivitytypeid() {
        return activitytypeid;
    }

    public void setActivitytypeid(int activitytypeid) {
        this.activitytypeid = activitytypeid;
    }

    public Date getActivitytimeperiod() {
        return activitytimeperiod;
    }

    public void setActivitytimeperiod(Date activitytimeperiod) {
        this.activitytimeperiod = activitytimeperiod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }
    
}
