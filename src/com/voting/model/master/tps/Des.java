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
    @NamedQuery(name = "Des.findAll", query = "SELECT d FROM Des d"),
    @NamedQuery(name = "Des.findByCode", query = "SELECT d FROM Des d WHERE d.code = :code"),
    @NamedQuery(name = "Des.findByNilai", query = "SELECT d FROM Des d WHERE d.nilai = :nilai"),
    @NamedQuery(name = "Des.findByKec", query = "SELECT d FROM Des d inner join d.kecCode p WHERE p.code = :code")})
public class Des implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 13)
    private String code;
    @Basic(optional = false)
    @Column(nullable = false, length = 150)
    private String nilai;
    @JoinColumn(name = "kec_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Kec kecCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "desCode")
    private List<Tps> tpsList;

    public Des() {
    }

    public Des(String code) {
        this.code = code;
    }

    public Des(String code, String nilai) {
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

    public Kec getKecCode() {
        return kecCode;
    }

    public void setKecCode(Kec kecCode) {
        this.kecCode = kecCode;
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
        if (!(object instanceof Des)) {
            return false;
        }
        Des other = (Des) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return nilai;
    }
    
}
