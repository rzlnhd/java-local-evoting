/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.transaksi;

import com.voting.model.master.Pemilih;
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
    @NamedQuery(name = "Bilik.findAll", query = "SELECT b FROM Bilik b"),
    @NamedQuery(name = "Bilik.findByNo", query = "SELECT b FROM Bilik b inner join b.tpsCode t WHERE b.no = :no AND t.code = :code"),
    @NamedQuery(name = "Bilik.cekActive", query = "SELECT b FROM Bilik b inner join b.tpsCode t WHERE t.code = :code AND b.status = 1 AND b.idPemilih is null"),
    @NamedQuery(name = "Bilik.findBySuara", query = "SELECT b FROM Bilik b WHERE b.suara = :suara")})
public class Bilik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer no;
    @Basic(optional = true)
    @Column(nullable = true)
    private int suara;
    @Basic(optional = true)
    @Column(nullable = true)
    private int status;
    @JoinColumn(name = "id_pemilih", referencedColumnName = "induk")
    @ManyToOne(optional = true)
    private Pemilih idPemilih;
    @JoinColumn(name = "tps_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Tps tpsCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bilikNo")
    private List<Card> cardList;

    public Bilik() {
    }

    public Bilik(Integer no) {
        this.no = no;
    }

    public Bilik(Integer no, Tps tps) {
        this.no = no;
        this.tpsCode = tps;
    }

    public Bilik(Integer no, int suara) {
        this.no = no;
        this.suara = suara;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public int getSuara() {
        return suara;
    }

    public void setSuara(int suara) {
        this.suara = suara;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Pemilih getIdPemilih() {
        return idPemilih;
    }

    public void setIdPemilih(Pemilih idPemilih) {
        this.idPemilih = idPemilih;
    }

    public Tps getTpsCode() {
        return tpsCode;
    }

    public void setTpsCode(Tps tpsCode) {
        this.tpsCode = tpsCode;
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
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bilik)) {
            return false;
        }
        Bilik other = (Bilik) object;
        return !((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no)));
    }

    @Override
    public String toString() {
        return no+"";
    }
    
}
