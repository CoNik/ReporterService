/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "positions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Positions.findAll", query = "SELECT p FROM Positions p")
    , @NamedQuery(name = "Positions.findByCardid", query = "SELECT p FROM Positions p WHERE p.cardid = :cardid")
    , @NamedQuery(name = "Positions.findByCustomerid", query = "SELECT p FROM Positions p WHERE p.customerid = :customerid")
    , @NamedQuery(name = "Positions.findById", query = "SELECT p FROM Positions p WHERE p.id = :id")
    , @NamedQuery(name = "Positions.findByLocationLatitude", query = "SELECT p FROM Positions p WHERE p.locationLatitude = :locationLatitude")
    , @NamedQuery(name = "Positions.findByLocationLongitude", query = "SELECT p FROM Positions p WHERE p.locationLongitude = :locationLongitude")
    , @NamedQuery(name = "Positions.findByLocationTs", query = "SELECT p FROM Positions p WHERE p.locationTs = :locationTs")
    , @NamedQuery(name = "Positions.findByTravelEndTs", query = "SELECT p FROM Positions p WHERE p.travelEndTs = :travelEndTs")
    , @NamedQuery(name = "Positions.findByTravelInitTs", query = "SELECT p FROM Positions p WHERE p.travelInitTs = :travelInitTs")})
public class Positions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "cardid")
    private BigInteger cardid;
    @Column(name = "customerid")
    private BigInteger customerid;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "id")
    private String id;
    @Size(max = 2000)
    @Column(name = "location_latitude")
    private String locationLatitude;
    @Size(max = 2000)
    @Column(name = "location_longitude")
    private String locationLongitude;
    @Size(max = 2000)
    @Column(name = "location_ts")
    private String locationTs;
    @Column(name = "travel_end_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date travelEndTs;
    @Column(name = "travel_init_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date travelInitTs;

    public Positions() {
    }

    public Positions(String id) {
        this.id = id;
    }

    public BigInteger getCardid() {
        return cardid;
    }

    public void setCardid(BigInteger cardid) {
        this.cardid = cardid;
    }

    public BigInteger getCustomerid() {
        return customerid;
    }

    public void setCustomerid(BigInteger customerid) {
        this.customerid = customerid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public String getLocationTs() {
        return locationTs;
    }

    public void setLocationTs(String locationTs) {
        this.locationTs = locationTs;
    }

    public Date getTravelEndTs() {
        return travelEndTs;
    }

    public void setTravelEndTs(Date travelEndTs) {
        this.travelEndTs = travelEndTs;
    }

    public Date getTravelInitTs() {
        return travelInitTs;
    }

    public void setTravelInitTs(Date travelInitTs) {
        this.travelInitTs = travelInitTs;
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
        if (!(object instanceof Positions)) {
            return false;
        }
        Positions other = (Positions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Positions[ id=" + id + " ]";
    }
    
}
