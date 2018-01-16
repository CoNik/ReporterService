/*
 *  
 * Reporter Service 2018 Updates
 */
package org.reporter.service.ets_reports;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author constantinn
 */
@Entity
@Table(name = "UserReportParemeter_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserReportParemeterV.findAll", query = "SELECT u FROM UserReportParemeter u")
    , @NamedQuery(name = "UserReportParemeterV.findByUserid", query = "SELECT u FROM UserReportParemeter u WHERE u.userid = :userid")
    , @NamedQuery(name = "UserReportParemeterV.findByKey", query = "SELECT u FROM UserReportParemeter u WHERE u.key = :key")
    , @NamedQuery(name = "UserReportParemeterV.findByValue", query = "SELECT u FROM UserReportParemeter u WHERE u.value = :value")})
public class UserReportParemeter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "USERID")
    private Integer userid;
    @Size(max = 100)
    @Column(name = "KEY")
    private String key;
    @Size(max = 100)
    @Column(name = "VALUE")
    private String value;

    public UserReportParemeter() {
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}
