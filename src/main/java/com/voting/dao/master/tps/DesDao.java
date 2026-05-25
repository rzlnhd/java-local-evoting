/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao.master.tps;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.voting.dao.BaseDao;
import com.voting.model.master.tps.Des;
import com.voting.model.master.tps.Kec;

/**
 *
 * @author Rizal
 */
@Repository
public class DesDao extends BaseDao<Des> {

    @SuppressWarnings("unchecked")
    public List<Des> getFromKec(Kec k) {
        return sessionFactory.getCurrentSession().getNamedQuery("Des.findByKec")
                .setParameter("code", k.getCode()).list();
    }
}
