/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.school.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgcastillo
 */
@Entity
@Table(name = "request_action")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestAction.findAll", query = "SELECT r FROM RequestAction r")
    , @NamedQuery(name = "RequestAction.findById", query = "SELECT r FROM RequestAction r WHERE r.id = :id")
    , @NamedQuery(name = "RequestAction.findByIsActive", query = "SELECT r FROM RequestAction r WHERE r.isActive = :isActive")
    , @NamedQuery(name = "RequestAction.findByIsComplete", query = "SELECT r FROM RequestAction r WHERE r.isComplete = :isComplete")})
public class RequestAction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "is_active")
    private Integer isActive;
    @Column(name = "is_complete")
    private Integer isComplete;
    @JoinColumn(name = "action_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Action actionId;
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Request requestId;
    @JoinColumn(name = "transition_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Transition transitionId;

    public RequestAction() {
    }

    public RequestAction(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(Integer isComplete) {
        this.isComplete = isComplete;
    }

    public Action getActionId() {
        return actionId;
    }

    public void setActionId(Action actionId) {
        this.actionId = actionId;
    }

    public Request getRequestId() {
        return requestId;
    }

    public void setRequestId(Request requestId) {
        this.requestId = requestId;
    }

    public Transition getTransitionId() {
        return transitionId;
    }

    public void setTransitionId(Transition transitionId) {
        this.transitionId = transitionId;
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
        if (!(object instanceof RequestAction)) {
            return false;
        }
        RequestAction other = (RequestAction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.RequestAction[ id=" + id + " ]";
    }
    
}
