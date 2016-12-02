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
@Table(name = "process")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Process.findAll", query = "SELECT p FROM Process p")
    , @NamedQuery(name = "Process.findById", query = "SELECT p FROM Process p WHERE p.id = :id")
    , @NamedQuery(name = "Process.findByName", query = "SELECT p FROM Process p WHERE p.name = :name")})
public class Process implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processId")
    private Collection<Request> requestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processId")
    private Collection<Activity> activityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processId")
    private Collection<ProcessAdmin> processAdminCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processId")
    private Collection<Transition> transitionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processId")
    private Collection<Action> actionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processId")
    private Collection<State> stateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processId")
    private Collection<Group> group1Collection;

    public Process() {
    }

    public Process(Integer id) {
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

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    @XmlTransient
    public Collection<ProcessAdmin> getProcessAdminCollection() {
        return processAdminCollection;
    }

    public void setProcessAdminCollection(Collection<ProcessAdmin> processAdminCollection) {
        this.processAdminCollection = processAdminCollection;
    }

    @XmlTransient
    public Collection<Transition> getTransitionCollection() {
        return transitionCollection;
    }

    public void setTransitionCollection(Collection<Transition> transitionCollection) {
        this.transitionCollection = transitionCollection;
    }

    @XmlTransient
    public Collection<Action> getActionCollection() {
        return actionCollection;
    }

    public void setActionCollection(Collection<Action> actionCollection) {
        this.actionCollection = actionCollection;
    }

    @XmlTransient
    public Collection<State> getStateCollection() {
        return stateCollection;
    }

    public void setStateCollection(Collection<State> stateCollection) {
        this.stateCollection = stateCollection;
    }

    @XmlTransient
    public Collection<Group> getGroup1Collection() {
        return group1Collection;
    }

    public void setGroup1Collection(Collection<Group> group1Collection) {
        this.group1Collection = group1Collection;
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
        if (!(object instanceof Process)) {
            return false;
        }
        Process other = (Process) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.Process[ id=" + id + " ]";
    }
    
}
