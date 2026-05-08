/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.master.tps;

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
    @NamedQuery(name = "Kab.findAll", query = "SELECT k FROM Kab k"),
    @NamedQuery(name = "Kab.findByCode", query = "SELECT k FROM Kab k WHERE k.code = :code"),
    @NamedQuery(name = "Kab.findByNilai", query = "SELECT k FROM Kab k WHERE k.nilai = :nilai"),
    @NamedQuery(name = "Kab.findByProv", query = "SELECT k FROM Kab k inner join k.provCode p WHERE p.code = :code")})
public class Kab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 5)
    private String code;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nilai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kabCode")
    private List<Kec> kecList;
    @JoinColumn(name = "prov_code", referencedColumnName = "code")
    @ManyToOne
    private Prov provCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kabCode")
    private List<Tps> tpsList;

    public Kab() {
    }

    public Kab(String code) {
        this.code = code;
    }

    public Kab(String code, String nilai) {
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
    public List<Kec> getKecList() {
        return kecList;
    }

    public void setKecList(List<Kec> kecList) {
        this.kecList = kecList;
    }

    public Prov getProvCode() {
        return provCode;
    }

    public void setProvCode(Prov provCode) {
        this.provCode = provCode;
    }

    @XmlTransient
    public List<Tps> getTpsList() {
        return tpsList;
    }

    public void setTpsList(List<Tps> tpsList) {
        this.tpsList = tpsList;
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
        if (!(object instanceof Kab)) {
            return false;
        }
        Kab other = (Kab) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return nilai;
    }
    
}
