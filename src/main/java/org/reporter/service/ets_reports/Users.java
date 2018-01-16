/*
 * ETS Project
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Users_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")
//    , @NamedQuery(name = "Users.findByUserId", query = "SELECT u FROM Users u WHERE u.userId = :userId")
    , @NamedQuery(name = "Users.findByUserName", query = "SELECT u FROM Users u WHERE u.userName = :userName")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByCardId", query = "SELECT u FROM Users u WHERE u.cardId = :cardId")
    , @NamedQuery(name = "Users.findByValidationDate", query = "SELECT u FROM Users u WHERE u.validationDate = :validationDate")
    , @NamedQuery(name = "Users.findByLastLoginDate", query = "SELECT u FROM Users u WHERE u.lastLoginDate = :lastLoginDate")
    , @NamedQuery(name = "Users.findByLast3TimesPasswordErrorOccuredTime", query = "SELECT u FROM Users u WHERE u.last3TimesPasswordErrorOccuredTime = :last3TimesPasswordErrorOccuredTime")
    , @NamedQuery(name = "Users.findByPreventLoggingUntilTheTime", query = "SELECT u FROM Users u WHERE u.preventLoggingUntilTheTime = :preventLoggingUntilTheTime")
    , @NamedQuery(name = "Users.findBySentDate", query = "SELECT u FROM Users u WHERE u.sentDate = :sentDate")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
//    @Basic(optional = false)
//    @NotNull
//    @Column(name = "UserId")
//    private int userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "UserName")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 400)
    @Column(name = "CardId")
    private String cardId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValidationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validationDate;
    @Column(name = "LastLoginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginDate;
    @Column(name = "Last3TimesPasswordErrorOccuredTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date last3TimesPasswordErrorOccuredTime;
    @Column(name = "PreventLoggingUntilTheTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preventLoggingUntilTheTime;
    @Column(name = "SentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, int userId, String userName, String password, String cardId, Date validationDate) {
        this.id = id;
//        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.cardId = cardId;
        this.validationDate = validationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Date getValidationDate() {
        return validationDate;
    }

    public void setValidationDate(Date validationDate) {
        this.validationDate = validationDate;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLast3TimesPasswordErrorOccuredTime() {
        return last3TimesPasswordErrorOccuredTime;
    }

    public void setLast3TimesPasswordErrorOccuredTime(Date last3TimesPasswordErrorOccuredTime) {
        this.last3TimesPasswordErrorOccuredTime = last3TimesPasswordErrorOccuredTime;
    }

    public Date getPreventLoggingUntilTheTime() {
        return preventLoggingUntilTheTime;
    }

    public void setPreventLoggingUntilTheTime(Date preventLoggingUntilTheTime) {
        this.preventLoggingUntilTheTime = preventLoggingUntilTheTime;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Users[ id=" + id + " ]";
    }
    
}
