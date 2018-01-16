/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
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
@Table(name = "Customers_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c")
    , @NamedQuery(name = "Customers.findByCustomerId", query = "SELECT c FROM Customers c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "Customers.findByCustomerName", query = "SELECT c FROM Customers c WHERE c.customerName = :customerName")
    , @NamedQuery(name = "Customers.findByCustomerSurname", query = "SELECT c FROM Customers c WHERE c.customerSurname = :customerSurname")
    , @NamedQuery(name = "Customers.findByGender", query = "SELECT c FROM Customers c WHERE c.gender = :gender")
    , @NamedQuery(name = "Customers.findByBirthDate", query = "SELECT c FROM Customers c WHERE c.birthDate = :birthDate")
    , @NamedQuery(name = "Customers.findByCustomerPicturePath", query = "SELECT c FROM Customers c WHERE c.customerPicturePath = :customerPicturePath")
    , @NamedQuery(name = "Customers.findByCreateDate", query = "SELECT c FROM Customers c WHERE c.createDate = :createDate")
    , @NamedQuery(name = "Customers.findByStatus", query = "SELECT c FROM Customers c WHERE c.status = :status")
    , @NamedQuery(name = "Customers.findByNationalId", query = "SELECT c FROM Customers c WHERE c.nationalId = :nationalId")
    , @NamedQuery(name = "Customers.findByEmail", query = "SELECT c FROM Customers c WHERE c.email = :email")
    , @NamedQuery(name = "Customers.findByMsisdn", query = "SELECT c FROM Customers c WHERE c.msisdn = :msisdn")
    , @NamedQuery(name = "Customers.findByNotification", query = "SELECT c FROM Customers c WHERE c.notification = :notification")
    , @NamedQuery(name = "Customers.findByPassword", query = "SELECT c FROM Customers c WHERE c.password = :password")
    , @NamedQuery(name = "Customers.findByPasscode", query = "SELECT c FROM Customers c WHERE c.passcode = :passcode")
    , @NamedQuery(name = "Customers.findByGuid", query = "SELECT c FROM Customers c WHERE c.guid = :guid")
    , @NamedQuery(name = "Customers.findByToken", query = "SELECT c FROM Customers c WHERE c.token = :token")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CustomerId")
    private Long customerId;
    @Size(max = 20)
    @Column(name = "CustomerName")
    private String customerName;
    @Size(max = 50)
    @Column(name = "CustomerSurname")
    private String customerSurname;
    @Size(max = 11)
    @Column(name = "Gender")
    private String gender;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;
    @Size(max = 500)
    @Column(name = "CustomerPicturePath")
    private String customerPicturePath;
    @Column(name = "CreateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "Status")
    private Character status;
    @Size(max = 11)
    @Column(name = "NationalId")
    private String nationalId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email")
    private String email;
    @Size(max = 11)
    @Column(name = "Msisdn")
    private String msisdn;
    @Column(name = "Notification")
    private Boolean notification;
    @Size(max = 50)
    @Column(name = "Password")
    private String password;
    @Size(max = 50)
    @Column(name = "Passcode")
    private String passcode;
    @Size(max = 100)
    @Column(name = "Guid")
    private String guid;
    @Size(max = 100)
    @Column(name = "Token")
    private String token;

    public Customers() {
    }

    public Customers(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCustomerPicturePath() {
        return customerPicturePath;
    }

    public void setCustomerPicturePath(String customerPicturePath) {
        this.customerPicturePath = customerPicturePath;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Boolean getNotification() {
        return notification;
    }

    public void setNotification(Boolean notification) {
        this.notification = notification;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Customers[ customerId=" + customerId + " ]";
    }
    
}
