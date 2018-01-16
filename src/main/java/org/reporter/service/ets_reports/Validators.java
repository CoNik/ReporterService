/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "Validators_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Validators.findAll", query = "SELECT v FROM Validators v")
    , @NamedQuery(name = "Validators.findByValidatorCode", query = "SELECT v FROM Validators v WHERE v.validatorsPK.validatorCode = :validatorCode")
    , @NamedQuery(name = "Validators.findByIPAdress", query = "SELECT v FROM Validators v WHERE v.validatorsPK.iPAdress = :iPAdress")
    , @NamedQuery(name = "Validators.findBySerialNo", query = "SELECT v FROM Validators v WHERE v.serialNo = :serialNo")
    , @NamedQuery(name = "Validators.findByPassword", query = "SELECT v FROM Validators v WHERE v.password = :password")
    , @NamedQuery(name = "Validators.findByVersionID", query = "SELECT v FROM Validators v WHERE v.versionID = :versionID")
    , @NamedQuery(name = "Validators.findByStationID", query = "SELECT v FROM Validators v WHERE v.stationId.stationId = :stationID")
    , @NamedQuery(name = "Validators.findByValidatorTypeCode", query = "SELECT v FROM Validators v WHERE v.validatorTypeCode = :validatorTypeCode")
    , @NamedQuery(name = "Validators.findByRouteDirection", query = "SELECT v FROM Validators v WHERE v.routeDirection = :routeDirection")
    , @NamedQuery(name = "Validators.findByStatus", query = "SELECT v FROM Validators v WHERE v.status = :status")})
public class Validators implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ValidatorsPK validatorsPK;
    @Size(max = 10)
    @Column(name = "SerialNo")
    private String serialNo;
    @Size(max = 10)
    @Column(name = "Password")
    private String password;
    @Size(max = 15)
    @Column(name = "VersionID")
    private String versionID;
    @Size(max = 3)
    @Column(name = "ValidatorTypeCode")
    private String validatorTypeCode;
    @Size(max = 50)
    @Column(name = "RouteDirection")
    private String routeDirection;
    @Column(name = "Status")
    private Character status;
    @JoinColumn(name = "RouteCode", referencedColumnName = "RouteCode")
    @ManyToOne
    private Routes routeCode;
    @JoinColumn(name = "StationId", referencedColumnName = "StationId")
    @ManyToOne
    private Stations stationId;

    public Validators() {
    }

    public Validators(ValidatorsPK validatorsPK) {
        this.validatorsPK = validatorsPK;
    }

    public Validators(String validatorCode, String iPAdress) {
        this.validatorsPK = new ValidatorsPK(validatorCode, iPAdress);
    }

    public ValidatorsPK getValidatorsPK() {
        return validatorsPK;
    }

    public void setValidatorsPK(ValidatorsPK validatorsPK) {
        this.validatorsPK = validatorsPK;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVersionID() {
        return versionID;
    }

    public void setVersionID(String versionID) {
        this.versionID = versionID;
    }

    public String getValidatorTypeCode() {
        return validatorTypeCode;
    }

    public void setValidatorTypeCode(String validatorTypeCode) {
        this.validatorTypeCode = validatorTypeCode;
    }

    public String getRouteDirection() {
        return routeDirection;
    }

    public void setRouteDirection(String routeDirection) {
        this.routeDirection = routeDirection;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Routes getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(Routes routeCode) {
        this.routeCode = routeCode;
    }

    public Stations getStationId() {
        return stationId;
    }

    public void setStationId(Stations stationId) {
        this.stationId = stationId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (validatorsPK != null ? validatorsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Validators)) {
            return false;
        }
        Validators other = (Validators) object;
        if ((this.validatorsPK == null && other.validatorsPK != null) || (this.validatorsPK != null && !this.validatorsPK.equals(other.validatorsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Validators[ validatorsPK=" + validatorsPK + " ]";
    }
    
}
