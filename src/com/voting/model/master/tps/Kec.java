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
    @NamedQuery(name = "Kec.findAll", query = "SELECT k FROM Kec k"),
    @NamedQuery(name = "Kec.findByCode", query = "SELECT k FROM Kec k WHERE k.code = :code"),
    @NamedQuery(name = "Kec.findByNilai", query = "SELECT k FROM Kec k WHERE k.nilai = :nilai"),
    @NamedQuery(name = "Kec.findByKab", query = "SELECT k FROM Kec k inner join k.kabCode p WHERE p.code = :code")})
public class Kec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 8)
    private String code;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nilai;
    @JoinColumn(name = "kab_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Kab kabCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kecCode")
    private List<Des> desList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kecCode")
    private List<Tps> tpsList;

    public Kec() {
    }

    public Kec(String code) {
        this.code = code;
    }

    public Kec(String code, String nilai) {
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

    public Kab getKabCode() {
        return kabCode;
    }

    public void setKabCode(Kab kabCode) {
        this.kabCode = kabCode;
    }

    @XmlTransient
    public List<Des> getDesList() {
        return desList;
    }

    public void setDesList(List<Des> desList) {
        this.desList = desList;
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
        if (!(object instanceof Kec)) {
            return false;
        }
        Kec other = (Kec) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return nilai;
    }
    
}
