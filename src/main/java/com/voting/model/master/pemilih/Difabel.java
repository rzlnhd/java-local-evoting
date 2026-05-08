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
    @NamedQuery(name = "Difabel.findAll", query = "SELECT d FROM Difabel d"),
    @NamedQuery(name = "Difabel.findByCode", query = "SELECT d FROM Difabel d WHERE d.code = :code"),
    @NamedQuery(name = "Difabel.findByNilai", query = "SELECT d FROM Difabel d WHERE d.nilai = :nilai")})
public class Difabel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer code;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nilai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "difableCode")
    private List<Pemilih> pemilihList;

    public Difabel() {
    }

    public Difabel(Integer code) {
        this.code = code;
    }

    public Difabel(Integer code, String nilai) {
        this.code = code;
        this.nilai = nilai;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
        if (!(object instanceof Difabel)) {
            return false;
        }
        Difabel other = (Difabel) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return nilai;
    }
    
}
