/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao.master;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.voting.dao.BaseDao;
import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;

/**
 *
 * @author Rizal
 */
@Repository
public class PemilihDao extends BaseDao<Pemilih> {

    @SuppressWarnings("unchecked")
    public List<Pemilih> getAll(Tps t) {
        return sessionFactory.getCurrentSession().getNamedQuery("Pemilih.findByTps")
                .setParameter("code", t.toString()).list();
    }

    @SuppressWarnings("unchecked")
    public List<Pemilih> cariBerdasarId(String id) {
        return sessionFactory.getCurrentSession().getNamedQuery("Pemilih.findByInduk")
                .setParameter("induk", "%" + id + "%").list();
    }

    @SuppressWarnings("unchecked")
    public List<Pemilih> cariBerdasarKk(String kk) {
        return sessionFactory.getCurrentSession().getNamedQuery("Pemilih.findByNoKk")
                .setParameter("noKk", "%" + kk + "%").list();
    }

    @SuppressWarnings("unchecked")
    public List<Pemilih> cariBerdasarNama(String nama) {
        return sessionFactory.getCurrentSession().getNamedQuery("Pemilih.findByNama")
                .setParameter("nama", "%" + nama + "%").list();
    }

    @SuppressWarnings("unchecked")
    public List<Pemilih> cariBerdasarAlamat(String alamat) {
        return sessionFactory.getCurrentSession().getNamedQuery("Pemilih.findByAlamat")
                .setParameter("alamat", "%" + alamat + "%").list();
    }

    public Pemilih lookUp(String id) {
        return (Pemilih) sessionFactory.getCurrentSession().getNamedQuery("Pemilih.registUlang")
                .setParameter("induk", id).uniqueResult();
    }

    public Pemilih cariBerdasarTps(String id, Tps t) {
        return (Pemilih) sessionFactory.getCurrentSession().getNamedQuery("Pemilih.cekTps")
                .setParameter("induk", id).setParameter("code", t.toString()).uniqueResult();
    }

    public long countP() {
        return (long) sessionFactory.getCurrentSession().getNamedQuery("Pemilih.countT").uniqueResult();
    }

    public long countP(int ket) {
        return (long) sessionFactory.getCurrentSession().getNamedQuery("Pemilih.countK")
                .setParameter("ket", ket).uniqueResult();
    }

    public long countP(String jk) {
        return (long) sessionFactory.getCurrentSession().getNamedQuery("Pemilih.countJ")
                .setParameter("jenisKelamin", jk).uniqueResult();
    }

    public long countP(int ket, String jk) {
        return (long) sessionFactory.getCurrentSession().getNamedQuery("Pemilih.countJk")
                .setParameter("ket", ket).setParameter("jenisKelamin", jk).uniqueResult();
    }

    public long countT(String code) {
        return (long) sessionFactory.getCurrentSession().getNamedQuery("Pemilih.count")
                .setParameter("code", code).uniqueResult();
    }
}
