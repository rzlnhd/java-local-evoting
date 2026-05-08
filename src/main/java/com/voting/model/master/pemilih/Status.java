/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.master.pemilih;

import com.voting.model.master.Pemilih;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByCode", query = "SELECT s FROM Status s WHERE s.code = :code"),
    @NamedQuery(name = "Status.findByNilai", query = "SELECT s FROM Status s WHERE s.nilai = :nilai")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String code;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nilai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusCode")
    private List<Pemilih> pemilihList;

    public Status() {
    }

    public Status(String code) {
        this.code = code;
    }

    public Status(String code, String nilai) {
        this.code = code;
        this.nilai = nilai;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    @XmlTransient
    public List<Pemilih> getPemilihList() {
        return pemilihList;
    }

    public void setPemilihList(List<Pemilih> pemilihList) {
        this.pemilihList = pemilihList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return nilai;
    }
    
}
