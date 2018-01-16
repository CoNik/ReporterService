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
@Table(name = "StationPositions_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StationPositions.findAll", query = "SELECT s FROM StationPositions s")
    , @NamedQuery(name = "StationPositions.findByStationId", query = "SELECT s FROM StationPositions s WHERE s.stationId = :stationId")
    , @NamedQuery(name = "StationPositions.findByStationDescription", query = "SELECT s FROM StationPositions s WHERE s.stationDescription = :stationDescription")
    , @NamedQuery(name = "StationPositions.findByDisplayName", query = "SELECT s FROM StationPositions s WHERE s.displayName = :displayName")
    , @NamedQuery(name = "StationPositions.findByCreateDate", query = "SELECT s FROM StationPositions s WHERE s.createDate = :createDate")
    , @NamedQuery(name = "StationPositions.findByStatus", query = "SELECT s FROM StationPositions s WHERE s.status = :status")
    , @NamedQuery(name = "StationPositions.findByPosX", query = "SELECT s FROM StationPositions s WHERE s.posX = :posX")
    , @NamedQuery(name = "StationPositions.findByPosY", query = "SELECT s FROM StationPositions s WHERE s.posY = :posY")})
public class StationPositions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "StationId")
    private Long stationId;
    @Size(max = 50)
    @Column(name = "StationDescription")
    private String stationDescription;
    @Size(max = 50)
    @Column(name = "DisplayName")
    private String displayName;
    @Size(max = 50)
    @Column(name = "CreateDate")
    private String createDate;
    @Column(name = "Status")
    private Short status;
    @Column(name = "PosX")
    private Integer posX;
    @Column(name = "PosY")
    private Integer posY;

    public StationPositions() {
    }

    public StationPositions(Long stationId) {
        this.stationId = stationId;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getStationDescription() {
        return stationDescription;
    }

    public void setStationDescription(String stationDescription) {
        this.stationDescription = stationDescription;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stationId != null ? stationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StationPositions)) {
            return false;
        }
        StationPositions other = (StationPositions) object;
        if ((this.stationId == null && other.stationId != null) || (this.stationId != null && !this.stationId.equals(other.stationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.StationPositions[ stationId=" + stationId + " ]";
    }
    
}
