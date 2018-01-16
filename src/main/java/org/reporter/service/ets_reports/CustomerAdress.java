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
@Table(name = "CustomerAdress_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerAdress.findAll", query = "SELECT c FROM CustomerAdress c")
    , @NamedQuery(name = "CustomerAdress.findByCustomerId", query = "SELECT c FROM CustomerAdress c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "CustomerAdress.findByCustomerAdressId", query = "SELECT c FROM CustomerAdress c WHERE c.customerAdressId = :customerAdressId")
    , @NamedQuery(name = "CustomerAdress.findByAdress1", query = "SELECT c FROM CustomerAdress c WHERE c.adress1 = :adress1")
    , @NamedQuery(name = "CustomerAdress.findByCities", query = "SELECT c FROM CustomerAdress c WHERE c.cities = :cities")
    , @NamedQuery(name = "CustomerAdress.findByCity", query = "SELECT c FROM CustomerAdress c WHERE c.city = :city")
    , @NamedQuery(name = "CustomerAdress.findByCountry", query = "SELECT c FROM CustomerAdress c WHERE c.country = :country")
    , @NamedQuery(name = "CustomerAdress.findByValid", query = "SELECT c FROM CustomerAdress c WHERE c.valid = :valid")
    , @NamedQuery(name = "CustomerAdress.findByStatus", query = "SELECT c FROM CustomerAdress c WHERE c.status = :status")
    , @NamedQuery(name = "CustomerAdress.findByCreateDate", query = "SELECT c FROM CustomerAdress c WHERE c.createDate = :createDate")})
public class CustomerAdress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerId")
    private long customerId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerAdressId")
    private Long customerAdressId;
    @Size(max = 250)
    @Column(name = "Adress1")
    private String adress1;
    @Column(name = "Cities")
    private BigInteger cities;
    @Column(name = "City")
    private BigInteger city;
    @Column(name = "Country")
    private Integer country;
    @Column(name = "Valid")
    private Character valid;
    @Column(name = "Status")
    private Character status;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    public CustomerAdress() {
    }

    public CustomerAdress(Long customerAdressId) {
        this.customerAdressId = customerAdressId;
    }

    public CustomerAdress(Long customerAdressId, long customerId) {
        this.customerAdressId = customerAdressId;
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerAdressId() {
        return customerAdressId;
    }

    public void setCustomerAdressId(Long customerAdressId) {
        this.customerAdressId = customerAdressId;
    }

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
    }

    public BigInteger getCities() {
        return cities;
    }

    public void setCities(BigInteger cities) {
        this.cities = cities;
    }

    public BigInteger getCity() {
        return city;
    }

    public void setCity(BigInteger city) {
        this.city = city;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Character getValid() {
        return valid;
    }

    public void setValid(Character valid) {
        this.valid = valid;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerAdressId != null ? customerAdressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerAdress)) {
            return false;
        }
        CustomerAdress other = (CustomerAdress) object;
        if ((this.customerAdressId == null && other.customerAdressId != null) || (this.customerAdressId != null && !this.customerAdressId.equals(other.customerAdressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.CustomerAdress[ customerAdressId=" + customerAdressId + " ]";
    }
    
}
