/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao.master;

import com.voting.dao.BaseDao;
import com.voting.model.master.Calon;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rizal
 */
@Repository
public class CalonDao extends BaseDao<Calon>{
    public List<Calon> cariBerdasarId(String id){
        return sessionFactory.getCurrentSession().getNamedQuery("Calon.findByInduk")
                .setParameter("induk", "%"+id+"%").list();
    }
    
    public List<Calon> cariBerdasarNama(String nama){
        return sessionFactory.getCurrentSession().getNamedQuery("Calon.findByNama")
                .setParameter("nama", "%"+nama+"%").list();
    }    
    
    public List<Calon> cariBerdasarAlamat(String alamat){
        return sessionFactory.getCurrentSession().getNamedQuery("Calon.findByAlamat")
                .setParameter("alamat", "%"+alamat+"%").list();
    }
    
    public Calon cariBerdasarUrut(Integer id){
        return (Calon) sessionFactory.getCurrentSession().getNamedQuery("Calon.findById")
                .setParameter("id", id).uniqueResult();
    }
}
