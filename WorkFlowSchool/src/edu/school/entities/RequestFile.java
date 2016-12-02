/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.school.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jgcastillo
 */
@Entity
@Table(name = "request_file")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestFile.findAll", query = "SELECT r FROM RequestFile r")
    , @NamedQuery(name = "RequestFile.findById", query = "SELECT r FROM RequestFile r WHERE r.id = :id")
    , @NamedQuery(name = "RequestFile.findByDateUploaded", query = "SELECT r FROM RequestFile r WHERE r.dateUploaded = :dateUploaded")
    , @NamedQuery(name = "RequestFile.findByFilename", query = "SELECT r FROM RequestFile r WHERE r.filename = :filename")
    , @NamedQuery(name = "RequestFile.findByMIMEtype", query = "SELECT r FROM RequestFile r WHERE r.mIMEtype = :mIMEtype")})
public class RequestFile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_uploaded")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateUploaded;
    @Column(name = "filename")
    private String filename;
    @Lob
    @Column(name = "file_content")
    private byte[] fileContent;
    @Column(name = "MIME_type")
    private String mIMEtype;
    @JoinColumn(name = "request_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Request requestId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;

    public RequestFile() {
    }

    public RequestFile(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(Date dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public String getMIMEtype() {
        return mIMEtype;
    }

    public void setMIMEtype(String mIMEtype) {
        this.mIMEtype = mIMEtype;
    }

    public Request getRequestId() {
        return requestId;
    }

    public void setRequestId(Request requestId) {
        this.requestId = requestId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof RequestFile)) {
            return false;
        }
        RequestFile other = (RequestFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.school.entities.RequestFile[ id=" + id + " ]";
    }
    
}
