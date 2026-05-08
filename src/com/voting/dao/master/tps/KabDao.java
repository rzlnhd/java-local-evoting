/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao.master.tps;

import com.voting.dao.BaseDao;
import com.voting.model.master.tps.Kab;
import com.voting.model.master.tps.Prov;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rizal
 */
@Repository
public class KabDao extends BaseDao<Kab>{
    public List<Kab> getFromProv(Prov p){
        return sessionFactory.getCurrentSession().getNamedQuery("Kab.findByProv")
                .setParameter("code", p.getCode()).list();
    }
}
