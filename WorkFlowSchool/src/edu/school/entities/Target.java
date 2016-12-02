/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.school.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jgcastillo
 */
@Entity
@Table(name = "target")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Target.findAll", query = "SELECT t FROM Target t")
    , @NamedQuery(name = "Target.findById", query = "SELECT t FROM Target t WHERE t.id = :id")
    , @NamedQuery(name = "Target.findByName", query = "SELECT t FROM Target t WHERE t.name = :name")})
public class Target implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetId")
    private Collection<ActivityTarget> activityTargetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "targetId")
    private Collection<ActionTarget> actionTargetCollection;

    public Target() {
    }

    public Target(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<ActivityTarget> getActivityTargetCollection() {
        return activityTargetCollection;
    }

    public void setActivityTargetCollection(Collection<ActivityTarget> activityTargetCollection) {
        this.activityTargetCollection = activityTargetCollection;
    }

    @XmlTransient
    public Collection<ActionTarget> getActionTargetCollection() {
        return actionTargetCollection;
    }

    public void setActionTargetCollection(Collection<ActionTarget> actionTargetCollection) {
        this.actionTargetCollection = actionTargetCollection;
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
        if (!(object instanceof Target)) {
            return false;
        }
        Target other = (Target) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.Target[ id=" + id + " ]";
    }
    
}
