/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao.master;

import com.voting.dao.BaseDao;
import com.voting.model.master.Tps;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rizal
 */
@Repository
public class TpsDao extends BaseDao<Tps>{
    public List<Tps> getTpsFromProv(String nilai){
        return sessionFactory.getCurrentSession().getNamedQuery("Tps.findByProv")
                .setParameter("nilai", "%"+nilai+"%").list();        
    }
    public List<Tps> getTpsFromKab(String nilai){
        return sessionFactory.getCurrentSession().getNamedQuery("Tps.findByKab")
                .setParameter("nilai", "%"+nilai+"%").list();        
    }
    public List<Tps> getTpsFromKec(String nilai){
        return sessionFactory.getCurrentSession().getNamedQuery("Tps.findByKec")
                .setParameter("nilai", "%"+nilai+"%").list();        
    }
    public List<Tps> getTpsFromDes(String nilai){
        return sessionFactory.getCurrentSession().getNamedQuery("Tps.findByDes")
                .setParameter("nilai", "%"+nilai+"%").list();        
    }
    public List<Tps> getTpsFromCode(String c){
        return sessionFactory.getCurrentSession().getNamedQuery("Tps.findByCode")
                .setParameter("code", "%"+c+"%").list();        
    }
    public List<Tps> getTpsFromDesk(String desk){
        return sessionFactory.getCurrentSession().getNamedQuery("Tps.findByDesk")
                .setParameter("desk", "%"+desk+"%").list();        
    }
}
