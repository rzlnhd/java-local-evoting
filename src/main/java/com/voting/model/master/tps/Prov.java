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
    @NamedQuery(name = "Prov.findAll", query = "SELECT p FROM Prov p"),
    @NamedQuery(name = "Prov.findByCode", query = "SELECT p FROM Prov p WHERE p.code = :code"),
    @NamedQuery(name = "Prov.findByNilai", query = "SELECT p FROM Prov p WHERE p.nilai = :nilai")})
public class Prov implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 2)
    private String code;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nilai;
    @OneToMany(mappedBy = "provCode")
    private List<Kab> kabList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provCode")
    private List<Tps> tpsList;

    public Prov() {
    }

    public Prov(String code) {
        this.code = code;
    }

    public Prov(String code, String nilai) {
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
    public List<Kab> getKabList() {
        return kabList;
    }

    public void setKabList(List<Kab> kabList) {
        this.kabList = kabList;
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
        if (!(object instanceof Prov)) {
            return false;
        }
        Prov other = (Prov) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return nilai;
    }
    
}
