/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao.security;

import com.voting.dao.BaseDao;
import com.voting.model.security.Admin;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rizal
 */
@Repository
public class AdminDao extends BaseDao<Admin>{
    public Admin cariBerdasarId(String id){
        return (Admin) sessionFactory.getCurrentSession().getNamedQuery("Admin.findByUsername")
                .setParameter("username", id).uniqueResult();
    }
}
