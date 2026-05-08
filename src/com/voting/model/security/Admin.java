/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.security;

import com.voting.model.security.admin.Acc;
import com.voting.model.master.Tps;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Rizal
 */
@Entity
@Table(catalog = "voting", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByNama", query = "SELECT a FROM Admin a WHERE a.nama = :nama"),
    @NamedQuery(name = "Admin.findByUsername", query = "SELECT a FROM Admin a WHERE a.username = :username"),
    @NamedQuery(name = "Admin.findByPassword", query = "SELECT a FROM Admin a WHERE a.password = :password"),
    @NamedQuery(name = "Admin.findByFoto", query = "SELECT a FROM Admin a WHERE a.foto = :foto")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nama;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String username;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String password;
    @Column(length = 500)
    private String foto;
    @JoinColumn(name = "acc_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    private Acc accList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminId")
    private List<Log> logList;
    @JoinColumn(name = "tps_code", referencedColumnName = "code")
    @ManyToOne
    private Tps tpsCode;

    public Admin() {
    }

    public Admin(String username) {
        this.username = username;
    }

    public Admin(String username, String nama, String password, Acc accList, String foto) {
        this.username = username;
        this.nama = nama;
        this.password = password;
        this.accList = accList;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @XmlTransient
    public Acc getAcc() {
        return accList;
    }

    public void setAcc(Acc accList) {
        this.accList = accList;
    }

    @XmlTransient
    public List<Log> getLogList() {
        return logList;
    }

    public void setLogList(List<Log> logList) {
        this.logList = logList;
    }

    public Tps getTpsCode() {
        return tpsCode;
    }

    public void setTpsCode(Tps tpsCode) {
        this.tpsCode = tpsCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        return !((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username)));
    }

    @Override
    public String toString() {
        return username;
    }
    
}
