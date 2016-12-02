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
@Table(name = "group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Group1.findAll", query = "SELECT g FROM Group1 g")
    , @NamedQuery(name = "Group1.findById", query = "SELECT g FROM Group1 g WHERE g.id = :id")
    , @NamedQuery(name = "Group1.findByName", query = "SELECT g FROM Group1 g WHERE g.name = :name")})
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<ActivityTarget> activityTargetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<ActionTarget> actionTargetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId")
    private Collection<GroupMember> groupMemberCollection;
    @JoinColumn(name = "process_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Process processId;

    public Group() {
    }

    public Group(Integer id) {
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

    @XmlTransient
    public Collection<GroupMember> getGroupMemberCollection() {
        return groupMemberCollection;
    }

    public void setGroupMemberCollection(Collection<GroupMember> groupMemberCollection) {
        this.groupMemberCollection = groupMemberCollection;
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
        if (!(object instanceof Group)) {
            return false;
        }
        Group other = (Group) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.Group1[ id=" + id + " ]";
    }
    
}
