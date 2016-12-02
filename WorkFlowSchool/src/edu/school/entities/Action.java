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
@Table(name = "action")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Action.findAll", query = "SELECT a FROM Action a")
    , @NamedQuery(name = "Action.findById", query = "SELECT a FROM Action a WHERE a.id = :id")
    , @NamedQuery(name = "Action.findByName", query = "SELECT a FROM Action a WHERE a.name = :name")})
public class Action implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "action_type")
    private String actionType;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actionId")
    private Collection<RequestAction> requestActionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actionId")
    private Collection<TransitionAction> transitionActionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actionId")
    private Collection<ActionTarget> actionTargetCollection;
    @JoinColumn(name = "process_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Process processId;

    public Action() {
    }

    public Action(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
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

    @XmlTransient
    public Collection<ActionTarget> getActionTargetCollection() {
        return actionTargetCollection;
    }

    public void setActionTargetCollection(Collection<ActionTarget> actionTargetCollection) {
        this.actionTargetCollection = actionTargetCollection;
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
        if (!(object instanceof Action)) {
            return false;
        }
        Action other = (Action) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.Action[ id=" + id + " ]";
    }
    
}
