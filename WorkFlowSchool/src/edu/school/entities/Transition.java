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
@Table(name = "transition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transition.findAll", query = "SELECT t FROM Transition t")
    , @NamedQuery(name = "Transition.findById", query = "SELECT t FROM Transition t WHERE t.id = :id")})
public class Transition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transitionId")
    private Collection<RequestAction> requestActionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transitionId")
    private Collection<TransitionAction> transitionActionCollection;
    @JoinColumn(name = "process_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Process processId;
    @JoinColumn(name = "current_state_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private State currentStateId;
    @JoinColumn(name = "next_state_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private State nextStateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transitionId")
    private Collection<TransitionActivity> transitionActivityCollection;

    public Transition() {
    }

    public Transition(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<RequestAction> getRequestActionCollection() {
        return requestActionCollection;
    }

    public void setRequestActionCollection(Collection<RequestAction> requestActionCollection) {
        this.requestActionCollection = requestActionCollection;
    }

    @XmlTransient
    public Collection<TransitionAction> getTransitionActionCollection() {
        return transitionActionCollection;
    }

    public void setTransitionActionCollection(Collection<TransitionAction> transitionActionCollection) {
        this.transitionActionCollection = transitionActionCollection;
    }

    public Process getProcessId() {
        return processId;
    }

    public void setProcessId(Process processId) {
        this.processId = processId;
    }

    public State getCurrentStateId() {
        return currentStateId;
    }

    public void setCurrentStateId(State currentStateId) {
        this.currentStateId = currentStateId;
    }

    public State getNextStateId() {
        return nextStateId;
    }

    public void setNextStateId(State nextStateId) {
        this.nextStateId = nextStateId;
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
        if (!(object instanceof Transition)) {
            return false;
        }
        Transition other = (Transition) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.Transition[ id=" + id + " ]";
    }
    
}
