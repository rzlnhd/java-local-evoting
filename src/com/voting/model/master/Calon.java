/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.master;

import com.voting.model.transaksi.Card;
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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rizal
 */
@Entity
@Table(catalog = "voting", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"induk"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calon.findAll", query = "SELECT c FROM Calon c"),
    @NamedQuery(name = "Calon.findById", query = "SELECT c FROM Calon c WHERE c.id = :id"),
    @NamedQuery(name = "Calon.findByInduk", query = "SELECT c FROM Calon c WHERE c.induk like :induk"),
    @NamedQuery(name = "Calon.findByNama", query = "SELECT c FROM Calon c WHERE c.nama like :nama"),
    @NamedQuery(name = "Calon.findByAlamat", query = "SELECT c FROM Calon c WHERE c.alamat like :alamat"),
    @NamedQuery(name = "Calon.findByJenisKelamin", query = "SELECT c FROM Calon c WHERE c.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Calon.findByAgama", query = "SELECT c FROM Calon c WHERE c.agama = :agama"),
    @NamedQuery(name = "Calon.findByFoto", query = "SELECT c FROM Calon c WHERE c.foto = :foto"),
    @NamedQuery(name = "Calon.findBySuara", query = "SELECT c FROM Calon c WHERE c.suara = :suara"),
    @NamedQuery(name = "Calon.findByCode", query = "SELECT c FROM Calon c WHERE c.induk = :code")})
public class Calon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 16)
    private String induk;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nama;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String alamat;
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String jenisKelamin;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String agama;
    @Column(length = 500)
    private String foto;
    @Basic(optional = false)
    @Column(nullable = false)
    private int suara;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pil")
    private List<Card> cardList;

    public Calon() {
    }

    public Calon(Integer id) {
        this.id = id;
    }

    public Calon(String induk, String nama, String alamat, String jenisKelamin, String agama, Integer id, String foto) {
        this.id = id;
        this.induk = induk;
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.agama = agama;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInduk() {
        return induk;
    }

    public void setInduk(String induk) {
        this.induk = induk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getSuara() {
        return suara;
    }

    public void setSuara(int suara) {
        this.suara = suara;
    }

    @XmlTransient
    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
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
        if (!(object instanceof Calon)) {
            return false;
        }
        Calon other = (Calon) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return id+"";
    }
    
}
