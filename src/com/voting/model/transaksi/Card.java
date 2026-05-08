/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.transaksi;

import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;
import com.voting.model.master.Calon;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rizal
 */
@Entity
@Table(catalog = "voting", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findByPemilihId", query = "SELECT c FROM Card c inner join c.pemilih p WHERE p.induk = :induk"),
    @NamedQuery(name = "Card.findByTime", query = "SELECT c FROM Card c WHERE c.time = :time")})
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time = new Timestamp(System.currentTimeMillis());
    @JoinColumn(name = "pemilih_id", referencedColumnName = "induk", nullable = false)
    @OneToOne(optional = false)
    private Pemilih pemilih;
    @JoinColumn(name = "bilik_no", referencedColumnName = "no", nullable = false)
    @ManyToOne(optional = false)
    private Bilik bilikNo;
    @JoinColumn(name = "tps_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Tps tpsCode;
    @JoinColumn(name = "pil", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Calon pil;

    public Card() {
    }

    public Card(Pemilih p, Calon c, Bilik b) {
        this.tpsCode = b.getTpsCode();
        this.pemilih = p;
        this.pil = c;
        this.bilikNo = b;
    }
    
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Pemilih getPemilih() {
        return pemilih;
    }

    public void setPemilih(Pemilih pemilih) {
        this.pemilih = pemilih;
    }

    public Bilik getBilikNo() {
        return bilikNo;
    }

    public void setBilikNo(Bilik bilikNo) {
        this.bilikNo = bilikNo;
    }

    public Tps getTpsCode() {
        return tpsCode;
    }

    public void setTpsCode(Tps tpsCode) {
        this.tpsCode = tpsCode;
    }

    public Calon getPil() {
        return pil;
    }

    public void setPil(Calon pil) {
        this.pil = pil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (time != null ? time.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        return !((this.time == null && other.time != null) || (this.time != null && !this.time.equals(other.time)));
    }

    @Override
    public String toString() {
        return pemilih.getInduk();
    }
    
}
