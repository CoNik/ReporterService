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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "UserGroups_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserGroupsV.findAll", query = "SELECT u FROM UserGroups u")
    , @NamedQuery(name = "UserGroupsV.findById", query = "SELECT u FROM UserGroups u WHERE u.id = :id")
    , @NamedQuery(name = "UserGroupsV.findByUserid", query = "SELECT u FROM UserGroups u WHERE u.userid = :userid")
    , @NamedQuery(name = "UserGroupsV.findByGroupid", query = "SELECT u FROM UserGroups u WHERE u.groupid = :groupid")})
public class UserGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private int userid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GROUPID")
    private int groupid;

    public UserGroups() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }
    
}
