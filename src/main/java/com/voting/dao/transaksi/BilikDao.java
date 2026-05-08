/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao.transaksi;

import com.voting.dao.BaseDao;
import com.voting.model.master.Tps;
import com.voting.model.transaksi.Bilik;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rizal
 */
@Repository
public class BilikDao extends BaseDao<Bilik>{
    public Bilik cekBilik(Integer id, Tps t){
        return (Bilik) sessionFactory.getCurrentSession().getNamedQuery("Bilik.findByNo")
                .setParameter("no", id).setParameter("code", t.toString()).uniqueResult();
    }
    public List<Bilik> cekAktif(Tps t){
        return sessionFactory.getCurrentSession().getNamedQuery("Bilik.cekActive")
                .setParameter("code", t.toString()).list();
    }
}
