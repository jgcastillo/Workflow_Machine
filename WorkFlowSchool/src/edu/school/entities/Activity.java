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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
    , @NamedQuery(name = "Activity.findById", query = "SELECT a FROM Activity a WHERE a.id = :id")
    , @NamedQuery(name = "Activity.findByName", query = "SELECT a FROM Activity a WHERE a.name = :name")})
public class Activity implements Serializable {

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
    @JoinColumn(name = "activity_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ActivityType activityTypeId;
    @JoinColumn(name = "process_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Process processId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityId")
    private Collection<StateActivity> stateActivityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityId")
    private Collection<ActivityTarget> activityTargetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityId")
    private Collection<TransitionActivity> transitionActivityCollection;

    public Activity() {
    }

    public Activity(Integer id) {
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

    public ActivityType getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(ActivityType activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Process getProcessId() {
        return processId;
    }

    public void setProcessId(Process processId) {
        this.processId = processId;
    }

    @XmlTransient
    public Collection<StateActivity> getStateActivityCollection() {
        return stateActivityCollection;
    }

    public void setStateActivityCollection(Collection<StateActivity> stateActivityCollection) {
        this.stateActivityCollection = stateActivityCollection;
    }

    @XmlTransient
    public Collection<ActivityTarget> getActivityTargetCollection() {
        return activityTargetCollection;
    }

    public void setActivityTargetCollection(Collection<ActivityTarget> activityTargetCollection) {
        this.activityTargetCollection = activityTargetCollection;
    }

    @XmlTransient
    public Collection<TransitionActivity> getTransitionActivityCollection() {
        return transitionActivityCollection;
    }

    public void setTransitionActivityCollection(Collection<TransitionActivity> transitionActivityCollection) {
        this.transitionActivityCollection = transitionActivityCollection;
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
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.Activity[ id=" + id + " ]";
    }
    
}
