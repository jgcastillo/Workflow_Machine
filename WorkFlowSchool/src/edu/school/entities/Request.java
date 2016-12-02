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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r")
    , @NamedQuery(name = "Request.findById", query = "SELECT r FROM Request r WHERE r.id = :id")
    , @NamedQuery(name = "Request.findByTitle", query = "SELECT r FROM Request r WHERE r.title = :title")
    , @NamedQuery(name = "Request.findByDateRequested", query = "SELECT r FROM Request r WHERE r.dateRequested = :dateRequested")
    , @NamedQuery(name = "Request.findByUserName", query = "SELECT r FROM Request r WHERE r.userName = :userName")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "date_requested")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRequested;
    @Column(name = "user_name")
    private String userName;
    @JoinColumn(name = "process_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Process processId;
    @JoinColumn(name = "current_state_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private State currentStateId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestId")
    private Collection<RequestAction> requestActionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestId")
    private Collection<RequestNote> requestNoteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestId")
    private Collection<RequestStakeholder> requestStakeholderCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestId")
    private Collection<RequestFile> requestFileCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestId")
    private Collection<RequestData> requestDataCollection;

    public Request() {
    }

    public Request(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<RequestAction> getRequestActionCollection() {
        return requestActionCollection;
    }

    public void setRequestActionCollection(Collection<RequestAction> requestActionCollection) {
        this.requestActionCollection = requestActionCollection;
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
    public Collection<RequestFile> getRequestFileCollection() {
        return requestFileCollection;
    }

    public void setRequestFileCollection(Collection<RequestFile> requestFileCollection) {
        this.requestFileCollection = requestFileCollection;
    }

    @XmlTransient
    public Collection<RequestData> getRequestDataCollection() {
        return requestDataCollection;
    }

    public void setRequestDataCollection(Collection<RequestData> requestDataCollection) {
        this.requestDataCollection = requestDataCollection;
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
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.Request[ id=" + id + " ]";
    }
    
}
