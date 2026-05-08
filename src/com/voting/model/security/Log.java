/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.security;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rizal
 */
@Entity
@Table(catalog = "voting", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByTime", query = "SELECT l FROM Log l WHERE l.time = :time"),
    @NamedQuery(name = "Log.findByDescription", query = "SELECT l FROM Log l WHERE l.description = :description")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String description;
    @JoinColumn(name = "admin_id", referencedColumnName = "username", nullable = false)
    @ManyToOne(optional = false)
    private Admin adminId;

    public Log() {
    }

    public Log(Date time) {
        this.time = time;
    }

    public Log(Admin adminId, String description) {
        this.time = new Timestamp(System.currentTimeMillis());
        this.adminId = adminId;
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (time != null ? time.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        return !((this.time == null && other.time != null) || (this.time != null && !this.time.equals(other.time)));
    }

    @Override
    public String toString() {
        return time+"";
    }
    
}
