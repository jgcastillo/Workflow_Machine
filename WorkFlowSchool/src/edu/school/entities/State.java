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
@Table(name = "state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s")
    , @NamedQuery(name = "State.findById", query = "SELECT s FROM State s WHERE s.id = :id")
    , @NamedQuery(name = "State.findByName", query = "SELECT s FROM State s WHERE s.name = :name")
    , @NamedQuery(name = "State.findByStateType", query = "SELECT s FROM State s WHERE s.stateType = :stateType")})
public class State implements Serializable {

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
    @Column(name = "state_type")
    private String stateType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currentStateId")
    private Collection<Request> requestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<StateActivity> stateActivityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currentStateId")
    private Collection<Transition> transitionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nextStateId")
    private Collection<Transition> transitionCollection1;
    @JoinColumn(name = "process_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Process processId;

    public State() {
    }

    public State(Integer id) {
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

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @XmlTransient
    public Collection<StateActivity> getStateActivityCollection() {
        return stateActivityCollection;
    }

    public void setStateActivityCollection(Collection<StateActivity> stateActivityCollection) {
        this.stateActivityCollection = stateActivityCollection;
    }

    @XmlTransient
    public Collection<Transition> getTransitionCollection() {
        return transitionCollection;
    }

    public void setTransitionCollection(Collection<Transition> transitionCollection) {
        this.transitionCollection = transitionCollection;
    }

    @XmlTransient
    public Collection<Transition> getTransitionCollection1() {
        return transitionCollection1;
    }

    public void setTransitionCollection1(Collection<Transition> transitionCollection1) {
        this.transitionCollection1 = transitionCollection1;
    }

    public Process getProcessId() {
        return processId;
    }

    public void setProcessId(Process processId) {
        this.processId = processId;
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
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.State[ id=" + id + " ]";
    }
    
}
