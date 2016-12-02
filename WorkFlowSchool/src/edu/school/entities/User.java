/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.school.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jgcastillo
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName")
    , @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName")
    , @NamedQuery(name = "User.findByDateOfBirthday", query = "SELECT u FROM User u WHERE u.dateOfBirthday = :dateOfBirthday")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birthday")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirthday;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Request> requestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<RequestNote> requestNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<RequestStakeholder> requestStakeholderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<ProcessAdmin> processAdminCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<RequestFile> requestFileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<GroupMember> groupMemberCollection;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(Date dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @XmlTransient
    public Collection<RequestNote> getRequestNoteCollection() {
        return requestNoteCollection;
    }

    public void setRequestNoteCollection(Collection<RequestNote> requestNoteCollection) {
        this.requestNoteCollection = requestNoteCollection;
    }

    @XmlTransient
    public Collection<RequestStakeholder> getRequestStakeholderCollection() {
        return requestStakeholderCollection;
    }

    public void setRequestStakeholderCollection(Collection<RequestStakeholder> requestStakeholderCollection) {
        this.requestStakeholderCollection = requestStakeholderCollection;
    }

    @XmlTransient
    public Collection<ProcessAdmin> getProcessAdminCollection() {
        return processAdminCollection;
    }

    public void setProcessAdminCollection(Collection<ProcessAdmin> processAdminCollection) {
        this.processAdminCollection = processAdminCollection;
    }

    @XmlTransient
    public Collection<RequestFile> getRequestFileCollection() {
        return requestFileCollection;
    }

    public void setRequestFileCollection(Collection<RequestFile> requestFileCollection) {
        this.requestFileCollection = requestFileCollection;
    }

    @XmlTransient
    public Collection<GroupMember> getGroupMemberCollection() {
        return groupMemberCollection;
    }

    public void setGroupMemberCollection(Collection<GroupMember> groupMemberCollection) {
        this.groupMemberCollection = groupMemberCollection;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.User[ id=" + id + " ]";
    }
    
}
