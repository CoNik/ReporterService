/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author roxanam
 */
@Entity
@Table(name = "DataAnalyser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataAnalyser.findAll", query = "SELECT d FROM DataAnalyser d")
    , @NamedQuery(name = "DataAnalyser.findById", query = "SELECT d FROM DataAnalyser d WHERE d.id = :id")
    , @NamedQuery(name = "DataAnalyser.findByDayType", query = "SELECT d FROM DataAnalyser d WHERE d.dayType = :dayType")
    , @NamedQuery(name = "DataAnalyser.findByStationId", query = "SELECT d FROM DataAnalyser d WHERE d.stationId = :stationId")
    , @NamedQuery(name = "DataAnalyser.findByStartTime", query = "SELECT d FROM DataAnalyser d WHERE d.startTime = :startTime")
    , @NamedQuery(name = "DataAnalyser.findByEndTime", query = "SELECT d FROM DataAnalyser d WHERE d.endTime = :endTime")
    , @NamedQuery(name = "DataAnalyser.findByV1", query = "SELECT d FROM DataAnalyser d WHERE d.v1 = :v1")
    , @NamedQuery(name = "DataAnalyser.findByV2", query = "SELECT d FROM DataAnalyser d WHERE d.v2 = :v2")
    , @NamedQuery(name = "DataAnalyser.findByV3", query = "SELECT d FROM DataAnalyser d WHERE d.v3 = :v3")
    , @NamedQuery(name = "DataAnalyser.findByV4", query = "SELECT d FROM DataAnalyser d WHERE d.v4 = :v4")
    , @NamedQuery(name = "DataAnalyser.findByV5", query = "SELECT d FROM DataAnalyser d WHERE d.v5 = :v5")
    , @NamedQuery(name = "DataAnalyser.findByV6", query = "SELECT d FROM DataAnalyser d WHERE d.v6 = :v6")
    , @NamedQuery(name = "DataAnalyser.findByV7", query = "SELECT d FROM DataAnalyser d WHERE d.v7 = :v7")
    , @NamedQuery(name = "DataAnalyser.findByV8", query = "SELECT d FROM DataAnalyser d WHERE d.v8 = :v8")
    , @NamedQuery(name = "DataAnalyser.findByV9", query = "SELECT d FROM DataAnalyser d WHERE d.v9 = :v9")
    , @NamedQuery(name = "DataAnalyser.findByV10", query = "SELECT d FROM DataAnalyser d WHERE d.v10 = :v10")
    , @NamedQuery(name = "DataAnalyser.findByV11", query = "SELECT d FROM DataAnalyser d WHERE d.v11 = :v11")
    , @NamedQuery(name = "DataAnalyser.findByV12", query = "SELECT d FROM DataAnalyser d WHERE d.v12 = :v12")
    , @NamedQuery(name = "DataAnalyser.findByV13", query = "SELECT d FROM DataAnalyser d WHERE d.v13 = :v13")
    , @NamedQuery(name = "DataAnalyser.findByV14", query = "SELECT d FROM DataAnalyser d WHERE d.v14 = :v14")
    , @NamedQuery(name = "DataAnalyser.findByV15", query = "SELECT d FROM DataAnalyser d WHERE d.v15 = :v15")
    , @NamedQuery(name = "DataAnalyser.findByV16", query = "SELECT d FROM DataAnalyser d WHERE d.v16 = :v16")
    , @NamedQuery(name = "DataAnalyser.findByV17", query = "SELECT d FROM DataAnalyser d WHERE d.v17 = :v17")
    , @NamedQuery(name = "DataAnalyser.findByV18", query = "SELECT d FROM DataAnalyser d WHERE d.v18 = :v18")
    , @NamedQuery(name = "DataAnalyser.findByV19", query = "SELECT d FROM DataAnalyser d WHERE d.v19 = :v19")
    , @NamedQuery(name = "DataAnalyser.findByV20", query = "SELECT d FROM DataAnalyser d WHERE d.v20 = :v20")
    , @NamedQuery(name = "DataAnalyser.findByV21", query = "SELECT d FROM DataAnalyser d WHERE d.v21 = :v21")
    , @NamedQuery(name = "DataAnalyser.findByV22", query = "SELECT d FROM DataAnalyser d WHERE d.v22 = :v22")
    , @NamedQuery(name = "DataAnalyser.findByV23", query = "SELECT d FROM DataAnalyser d WHERE d.v23 = :v23")
    , @NamedQuery(name = "DataAnalyser.findByV24", query = "SELECT d FROM DataAnalyser d WHERE d.v24 = :v24")
    , @NamedQuery(name = "DataAnalyser.findByV25", query = "SELECT d FROM DataAnalyser d WHERE d.v25 = :v25")
    , @NamedQuery(name = "DataAnalyser.findByV26", query = "SELECT d FROM DataAnalyser d WHERE d.v26 = :v26")
    , @NamedQuery(name = "DataAnalyser.findByV27", query = "SELECT d FROM DataAnalyser d WHERE d.v27 = :v27")
    , @NamedQuery(name = "DataAnalyser.findByV28", query = "SELECT d FROM DataAnalyser d WHERE d.v28 = :v28")
    , @NamedQuery(name = "DataAnalyser.findByV29", query = "SELECT d FROM DataAnalyser d WHERE d.v29 = :v29")
    , @NamedQuery(name = "DataAnalyser.findByV30", query = "SELECT d FROM DataAnalyser d WHERE d.v30 = :v30")
    , @NamedQuery(name = "DataAnalyser.findByTimeInterval", query = "SELECT d FROM DataAnalyser d WHERE d.timeInterval = :timeInterval")})
public class DataAnalyser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Column(name = "DayType")
    private Integer dayType;
    @Column(name = "StationId")
    private Integer stationId;
    @Column(name = "StartTime")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "EndTime")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    @Column(name = "V1")
    private Integer v1;
    @Column(name = "V2")
    private Integer v2;
    @Column(name = "V3")
    private Integer v3;
    @Column(name = "V4")
    private Integer v4;
    @Column(name = "V5")
    private Integer v5;
    @Column(name = "V6")
    private Integer v6;
    @Column(name = "V7")
    private Integer v7;
    @Column(name = "V8")
    private Integer v8;
    @Column(name = "V9")
    private Integer v9;
    @Column(name = "V10")
    private Integer v10;
    @Column(name = "V11")
    private Integer v11;
    @Column(name = "V12")
    private Integer v12;
    @Column(name = "V13")
    private Integer v13;
    @Column(name = "V14")
    private Integer v14;
    @Column(name = "V15")
    private Integer v15;
    @Column(name = "V16")
    private Integer v16;
    @Column(name = "V17")
    private Integer v17;
    @Column(name = "V18")
    private Integer v18;
    @Column(name = "V19")
    private Integer v19;
    @Column(name = "V20")
    private Integer v20;
    @Column(name = "V21")
    private Integer v21;
    @Column(name = "V22")
    private Integer v22;
    @Column(name = "V23")
    private Integer v23;
    @Column(name = "V24")
    private Integer v24;
    @Column(name = "V25")
    private Integer v25;
    @Column(name = "V26")
    private Integer v26;
    @Column(name = "V27")
    private Integer v27;
    @Column(name = "V28")
    private Integer v28;
    @Column(name = "V29")
    private Integer v29;
    @Column(name = "V30")
    private Integer v30;
    @Column(name = "time_interval")
    private Integer timeInterval;

    public DataAnalyser() {
    }

    public DataAnalyser(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDayType() {
        return dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getV1() {
        return v1;
    }

    public void setV1(Integer v1) {
        this.v1 = v1;
    }

    public Integer getV2() {
        return v2;
    }

    public void setV2(Integer v2) {
        this.v2 = v2;
    }

    public Integer getV3() {
        return v3;
    }

    public void setV3(Integer v3) {
        this.v3 = v3;
    }

    public Integer getV4() {
        return v4;
    }

    public void setV4(Integer v4) {
        this.v4 = v4;
    }

    public Integer getV5() {
        return v5;
    }

    public void setV5(Integer v5) {
        this.v5 = v5;
    }

    public Integer getV6() {
        return v6;
    }

    public void setV6(Integer v6) {
        this.v6 = v6;
    }

    public Integer getV7() {
        return v7;
    }

    public void setV7(Integer v7) {
        this.v7 = v7;
    }

    public Integer getV8() {
        return v8;
    }

    public void setV8(Integer v8) {
        this.v8 = v8;
    }

    public Integer getV9() {
        return v9;
    }

    public void setV9(Integer v9) {
        this.v9 = v9;
    }

    public Integer getV10() {
        return v10;
    }

    public void setV10(Integer v10) {
        this.v10 = v10;
    }

    public Integer getV11() {
        return v11;
    }

    public void setV11(Integer v11) {
        this.v11 = v11;
    }

    public Integer getV12() {
        return v12;
    }

    public void setV12(Integer v12) {
        this.v12 = v12;
    }

    public Integer getV13() {
        return v13;
    }

    public void setV13(Integer v13) {
        this.v13 = v13;
    }

    public Integer getV14() {
        return v14;
    }

    public void setV14(Integer v14) {
        this.v14 = v14;
    }

    public Integer getV15() {
        return v15;
    }

    public void setV15(Integer v15) {
        this.v15 = v15;
    }

    public Integer getV16() {
        return v16;
    }

    public void setV16(Integer v16) {
        this.v16 = v16;
    }

    public Integer getV17() {
        return v17;
    }

    public void setV17(Integer v17) {
        this.v17 = v17;
    }

    public Integer getV18() {
        return v18;
    }

    public void setV18(Integer v18) {
        this.v18 = v18;
    }

    public Integer getV19() {
        return v19;
    }

    public void setV19(Integer v19) {
        this.v19 = v19;
    }

    public Integer getV20() {
        return v20;
    }

    public void setV20(Integer v20) {
        this.v20 = v20;
    }

    public Integer getV21() {
        return v21;
    }

    public void setV21(Integer v21) {
        this.v21 = v21;
    }

    public Integer getV22() {
        return v22;
    }

    public void setV22(Integer v22) {
        this.v22 = v22;
    }

    public Integer getV23() {
        return v23;
    }

    public void setV23(Integer v23) {
        this.v23 = v23;
    }

    public Integer getV24() {
        return v24;
    }

    public void setV24(Integer v24) {
        this.v24 = v24;
    }

    public Integer getV25() {
        return v25;
    }

    public void setV25(Integer v25) {
        this.v25 = v25;
    }

    public Integer getV26() {
        return v26;
    }

    public void setV26(Integer v26) {
        this.v26 = v26;
    }

    public Integer getV27() {
        return v27;
    }

    public void setV27(Integer v27) {
        this.v27 = v27;
    }

    public Integer getV28() {
        return v28;
    }

    public void setV28(Integer v28) {
        this.v28 = v28;
    }

    public Integer getV29() {
        return v29;
    }

    public void setV29(Integer v29) {
        this.v29 = v29;
    }

    public Integer getV30() {
        return v30;
    }

    public void setV30(Integer v30) {
        this.v30 = v30;
    }

    public Integer getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
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
        if (!(object instanceof DataAnalyser)) {
            return false;
        }
        DataAnalyser other = (DataAnalyser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.DataAnalyser[ id=" + id + " ]";
    }
    
}
