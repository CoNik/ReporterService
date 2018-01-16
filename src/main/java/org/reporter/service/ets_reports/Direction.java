/*
 *  
 * ETS Custom Reporting Tool, using Structured and Big Data data stores..
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
@Table(name = "Direction_V")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direction.findAll", query = "SELECT d FROM Direction d")
    , @NamedQuery(name = "Direction.findByDirectionId", query = "SELECT d FROM Direction d WHERE d.directionId = :directionId")
    , @NamedQuery(name = "Direction.findByDescription", query = "SELECT d FROM Direction d WHERE d.description = :description")})
public class Direction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DirectionId")
    private Short directionId;
    @Size(max = 50)
    @Column(name = "Description")
    private String description;

    public Direction() {
    }

    public Direction(Short directionId) {
        this.directionId = directionId;
    }

    public Short getDirectionId() {
        return directionId;
    }

    public void setDirectionId(Short directionId) {
        this.directionId = directionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (directionId != null ? directionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direction)) {
            return false;
        }
        Direction other = (Direction) object;
        if ((this.directionId == null && other.directionId != null) || (this.directionId != null && !this.directionId.equals(other.directionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.reporter.service.ets_reports.Direction[ directionId=" + directionId + " ]";
    }
    
}
