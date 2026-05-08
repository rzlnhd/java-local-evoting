/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.dao.security;

import com.voting.dao.BaseDao;
import com.voting.model.security.admin.Menu;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rizal
 */
@Repository
public class MenuDao extends BaseDao<Menu>{
    public Integer maximumMenuLevel(){
        return (Integer) sessionFactory.getCurrentSession().getNamedQuery("Menu.getMaxLevel").uniqueResult();
    }
    
}
