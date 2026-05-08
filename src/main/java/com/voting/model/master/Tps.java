/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.master;

import com.voting.model.security.Admin;
import com.voting.model.transaksi.Bilik;
import com.voting.model.transaksi.Card;
import com.voting.model.transaksi.Tunggu;
import com.voting.model.master.tps.Prov;
import com.voting.model.master.tps.Kab;
import com.voting.model.master.tps.Des;
import com.voting.model.master.tps.Kec;
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
    @NamedQuery(name = "Tps.findAll", query = "SELECT t FROM Tps t"),
    @NamedQuery(name = "Tps.findByNo", query = "SELECT t FROM Tps t WHERE t.no = :no"),
    @NamedQuery(name = "Tps.findByCode", query = "SELECT t FROM Tps t WHERE t.code like :code"),
    @NamedQuery(name = "Tps.findByDesk", query = "SELECT t FROM Tps t WHERE t.desk like :desk"),
    @NamedQuery(name = "Tps.findByProv", query = "SELECT t FROM Tps t inner join t.provCode p WHERE p.nilai like :nilai"),
    @NamedQuery(name = "Tps.findByKab", query = "SELECT t FROM Tps t inner join t.kabCode b WHERE b.nilai like :nilai"),
    @NamedQuery(name = "Tps.findByKec", query = "SELECT t FROM Tps t inner join t.kecCode c WHERE c.nilai like :nilai"),
    @NamedQuery(name = "Tps.findByDes", query = "SELECT t FROM Tps t inner join t.desCode d WHERE d.nilai like :nilai")})
public class Tps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false, length = 2)
    private String no;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 16)
    private String code;
    @Basic(optional = false)
    @Column(nullable = false, length = 500)
    private String desk;
    @OneToMany(mappedBy = "tpsCode")
    private List<Admin> adminList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpsCode")
    private List<Bilik> bilikList;
    @JoinColumn(name = "des_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Des desCode;
    @JoinColumn(name = "kab_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Kab kabCode;
    @JoinColumn(name = "prov_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Prov provCode;
    @JoinColumn(name = "kec_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Kec kecCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpsCode")
    private List<Card> cardList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpsCode")
    private List<Pemilih> pemilihList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tpsCode")
    private List<Tunggu> tungguList;

    public Tps() {
    }

    public Tps(String code) {
        this.code = code;
    }

    public Tps(String code, String no) {
        this.code = code;
        this.no = no;
    }

    public Tps(Prov p, Kab b, Kec c, Des d, String code, String no, String desk) {
        this.provCode = p;
        this.kabCode = b;
        this.kecCode = c;
        this.desCode = d;
        this.code = code;
        this.no = no;
        this.desk = desk;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDesk() {
        return desk;
    }
    
    public void setDesk(String desk) {
        this.desk = desk;
    }
    

    @XmlTransient
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    @XmlTransient
    public List<Bilik> getBilikList() {
        return bilikList;
    }

    public void setBilikList(List<Bilik> bilikList) {
        this.bilikList = bilikList;
    }

    public Des getDesCode() {
        return desCode;
    }

    public void setDesCode(Des desCode) {
        this.desCode = desCode;
    }

    public Kab getKabCode() {
        return kabCode;
    }

    public void setKabCode(Kab kabCode) {
        this.kabCode = kabCode;
    }

    public Prov getProvCode() {
        return provCode;
    }

    public void setProvCode(Prov provCode) {
        this.provCode = provCode;
    }

    public Kec getKecCode() {
        return kecCode;
    }

    public void setKecCode(Kec kecCode) {
        this.kecCode = kecCode;
    }

    @XmlTransient
    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    @XmlTransient
    public List<Pemilih> getPemilihList() {
        return pemilihList;
    }

    public void setPemilihList(List<Pemilih> pemilihList) {
        this.pemilihList = pemilihList;
    }

    @XmlTransient
    public List<Tunggu> getTungguList() {
        return tungguList;
    }

    public void setTungguList(List<Tunggu> tungguList) {
        this.tungguList = tungguList;
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
        if (!(object instanceof Tps)) {
            return false;
        }
        Tps other = (Tps) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return code;
    }
    
}
