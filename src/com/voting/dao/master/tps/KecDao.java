/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao.master.tps;

import com.voting.dao.BaseDao;
import com.voting.model.master.tps.Kab;
import com.voting.model.master.tps.Kec;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rizal
 */
@Repository
public class KecDao extends BaseDao<Kec>{
    public List<Kec> getFromKab(Kab k){
        return sessionFactory.getCurrentSession().getNamedQuery("Kec.findByKab")
                .setParameter("code", k.getCode()).list();
    }
}
