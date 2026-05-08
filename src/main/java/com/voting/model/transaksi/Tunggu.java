/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.model.transaksi;

import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;
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
    @NamedQuery(name = "Tunggu.findAll", query = "SELECT t FROM Tunggu t"),
    @NamedQuery(name = "Tunggu.findByPemilihId", query = "SELECT t FROM Tunggu t inner join t.pemilihId p WHERE p.induk = :induk"),
    @NamedQuery(name = "Tunggu.findByTime", query = "SELECT t FROM Tunggu t WHERE t.time = :time")})
public class Tunggu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "pemilih_id", referencedColumnName = "induk", nullable = false)
    @OneToOne(optional = false)
    private Pemilih pemilihId;
    @JoinColumn(name = "tps_code", referencedColumnName = "code", nullable = false)
    @ManyToOne(optional = false)
    private Tps tpsCode;

    public Tunggu() {
    }

    public Tunggu(Pemilih pemilihId) {
        this.pemilihId = pemilihId;
    }

    public Tunggu(Pemilih pemilihId, Tps t) {
        this.time = new Timestamp(System.currentTimeMillis());
        this.pemilihId = pemilihId;
        this.tpsCode = t;
    }

    public Pemilih getPemilih() {
        return pemilihId;
    }

    public void setPemilih(Pemilih pemilihId) {
        this.pemilihId = pemilihId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Tps getTpsCode() {
        return tpsCode;
    }

    public void setTpsCode(Tps tpsCode) {
        this.tpsCode = tpsCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pemilihId != null ? pemilihId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tunggu)) {
            return false;
        }
        Tunggu other = (Tunggu) object;
        return !((this.pemilihId == null && other.pemilihId != null) || (this.pemilihId != null && !this.pemilihId.equals(other.pemilihId)));
    }

    @Override
    public String toString() {
        return pemilihId.getInduk();
    }
    
}
