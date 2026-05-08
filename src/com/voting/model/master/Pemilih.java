/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.master;

import com.voting.model.transaksi.Bilik;
import com.voting.model.transaksi.Card;
import com.voting.model.master.pemilih.Difabel;
import com.voting.model.master.pemilih.Status;
import com.voting.model.transaksi.Tunggu;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Rizal
 */
@Entity
@Table(catalog = "voting", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"induk", "id_lkl"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pemilih.findAll", query = "SELECT p FROM Pemilih p"),
    @NamedQuery(name = "Pemilih.findByNoKk", query = "SELECT p FROM Pemilih p WHERE p.noKk like :noKk"),
    @NamedQuery(name = "Pemilih.findByInduk", query = "SELECT p FROM Pemilih p WHERE p.induk like :induk"),
    @NamedQuery(name = "Pemilih.findByNama", query = "SELECT p FROM Pemilih p WHERE p.nama like :nama"),
    @NamedQuery(name = "Pemilih.findByTLahir", query = "SELECT p FROM Pemilih p WHERE p.tLahir = :tLahir"),
    @NamedQuery(name = "Pemilih.findByTglLahir", query = "SELECT p FROM Pemilih p WHERE p.tglLahir = :tglLahir"),
    @NamedQuery(name = "Pemilih.findByUmur", query = "SELECT p FROM Pemilih p WHERE p.umur = :umur"),
    @NamedQuery(name = "Pemilih.findByJenisKelamin", query = "SELECT p FROM Pemilih p WHERE p.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Pemilih.findByAlamat", query = "SELECT p FROM Pemilih p WHERE p.alamat like :alamat"),
    @NamedQuery(name = "Pemilih.findByRt", query = "SELECT p FROM Pemilih p WHERE p.rt = :rt"),
    @NamedQuery(name = "Pemilih.findByRw", query = "SELECT p FROM Pemilih p WHERE p.rw = :rw"),
    @NamedQuery(name = "Pemilih.findByIdLkl", query = "SELECT p FROM Pemilih p WHERE p.idLkl = :idLkl"),
    @NamedQuery(name = "Pemilih.findByFoto", query = "SELECT p FROM Pemilih p WHERE p.foto = :foto"),
    @NamedQuery(name = "Pemilih.findByKet", query = "SELECT p FROM Pemilih p WHERE p.ket = :ket"),
    @NamedQuery(name = "Pemilih.findByTps", query = "SELECT p FROM Pemilih p inner join p.tpsCode t WHERE t.code = :code"),
    @NamedQuery(name = "Pemilih.registUlang", query = "SELECT p FROM Pemilih p WHERE p.induk = :induk AND p.ket = 0"),
    @NamedQuery(name = "Pemilih.cekTps", query = "SELECT p FROM Pemilih p inner join p.tpsCode t WHERE p.induk = :induk AND t.code = :code AND p.ket = 0"),
    @NamedQuery(name = "Pemilih.findByCode", query = "SELECT p FROM Pemilih p WHERE p.induk = :code"),
    @NamedQuery(name = "Pemilih.count", query = "SELECT COUNT(p) FROM Pemilih p inner join p.tpsCode t WHERE t.code = :code"),
    @NamedQuery(name = "Pemilih.countT", query = "SELECT COUNT(p) FROM Pemilih p"),
    @NamedQuery(name = "Pemilih.countK", query = "SELECT COUNT(p) FROM Pemilih p WHERE p.ket = :ket"),
    @NamedQuery(name = "Pemilih.countJ", query = "SELECT COUNT(p) FROM Pemilih p WHERE p.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Pemilih.countJk", query = "SELECT COUNT(p) FROM Pemilih p WHERE p.ket = :ket AND p.jenisKelamin = :jenisKelamin")})
public class Pemilih implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "no_kk", nullable = false, length = 16)
    private String noKk;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 16)
    private String induk;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String nama;
    @Basic(optional = false)
    @Column(name = "t_lahir", nullable = false, length = 30)
    private String tLahir;
    @Basic(optional = false)
    @Column(name = "tgl_lahir", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tglLahir;
    @Basic(optional = false)
    @Column(nullable = false)
    private int umur;
    @Basic(optional = false)
    @Column(nullable = false, length = 1)
    private String jenisKelamin;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String alamat;
    @Basic(optional = false)
    @Column(nullable = false, length = 4)
    private String rt;
    @Basic(optional = false)
    @Column(nullable = false, length = 4)
    private String rw;
    @Basic(optional = false)
    @Column(name = "id_lkl", nullable = false, length = 5)
    private String idLkl;
    @Column(length = 500)
    private String foto;
    @Basic(optional = false)
    @Column(nullable = false)
    private int ket;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPemilih")
    private List<Bilik> bilikList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pemilih")
    private Card card;
    @JoinColumn(name = "tps_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Tps tpsCode;
    @JoinColumn(name = "difable_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Difabel difableCode;
    @JoinColumn(name = "status_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Status statusCode;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pemilihId")
    private Tunggu tunggu;

    public Pemilih() {
    }

    public Pemilih(String induk) {
        this.induk = induk;
    }

    public Pemilih(String induk, String noKk, String nama, String tLahir, Date tglLahir, int umur,
            String jenisKelamin, String alamat, String rt, String rw, String idLkl, int ket,
            Status statusCode, Difabel difableCode, Tps tpsCode, String foto) {
        this.induk = induk;
        this.noKk = noKk;
        this.nama = nama;
        this.tLahir = tLahir;
        this.tglLahir = tglLahir;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.rt = rt;
        this.rw = rw;
        this.idLkl = idLkl;
        this.ket = ket;
        this.statusCode = statusCode;
        this.difableCode = difableCode;
        this.tpsCode = tpsCode;
        this.foto = foto;
    }

    public String getNoKk() {
        return noKk;
    }

    public void setNoKk(String noKk) {
        this.noKk = noKk;
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

    public String getTLahir() {
        return tLahir;
    }

    public void setTLahir(String tLahir) {
        this.tLahir = tLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getIdLkl() {
        return idLkl;
    }

    public void setIdLkl(String idLkl) {
        this.idLkl = idLkl;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getKet() {
        return ket;
    }

    public void setKet(int ket) {
        this.ket = ket;
    }

    @XmlTransient
    public List<Bilik> getBilikList() {
        return bilikList;
    }

    public void setBilikList(List<Bilik> bilikList) {
        this.bilikList = bilikList;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Tps getTpsCode() {
        return tpsCode;
    }

    public void setTpsCode(Tps tpsCode) {
        this.tpsCode = tpsCode;
    }

    public Difabel getDifableCode() {
        return difableCode;
    }

    public void setDifableCode(Difabel difableCode) {
        this.difableCode = difableCode;
    }

    public Status getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Status statusCode) {
        this.statusCode = statusCode;
    }

    public Tunggu getTunggu() {
        return tunggu;
    }

    public void setTunggu(Tunggu tunggu) {
        this.tunggu = tunggu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (induk != null ? induk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pemilih)) {
            return false;
        }
        Pemilih other = (Pemilih) object;
        return !((this.induk == null && other.induk != null) || (this.induk != null && !this.induk.equals(other.induk)));
    }

    @Override
    public String toString() {
        return induk;
    }
    
}
