/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.service.impl;

import com.voting.dao.security.AccDao;
import com.voting.dao.security.AdminDao;
import com.voting.dao.security.LogDao;
import com.voting.dao.security.MenuDao;
import com.voting.model.security.Admin;
import com.voting.model.security.Log;
import com.voting.model.security.admin.Acc;
import com.voting.service.SecurityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Rizal
 */
@Service("securityService")
@Transactional(readOnly=true)
public class SecurityServiceImpl implements SecurityService{
    @Autowired private AdminDao adminDao;
    @Autowired private AccDao accDao;
    @Autowired private MenuDao menuDao;
    @Autowired private LogDao logDao;

    @Transactional
    @Override
    public void saveAdmin(Admin a) {
        adminDao.save(a);
    }
    
    @Transactional
    @Override
    public void updateAdmin(Admin a){
        adminDao.update(a);
    }

    @Transactional
    @Override
    public void deleteAdmin(Admin a) {
        adminDao.delete(a);
    }

    @Override
    public List<Admin> getAdmins() {
        return adminDao.getAll();
    }

    @Override
    public Admin logIn(String id) {
        return adminDao.cariBerdasarId(id);
    }

    @Override
    public Acc getAcc(String id) {
        return accDao.cariBerdasarId(id);
    }

    @Override
    public Integer maximumMenuLevel() {
        return menuDao.maximumMenuLevel();
    }    

    @Transactional
    @Override
    public void makeLog(Log l) {
        logDao.save(l);
    }

    @Transactional
    @Override
    public void updateLog(Log l) {
        logDao.update(l);
    }

    @Transactional
    @Override
    public void deleteLog(Log l) {
        logDao.delete(l);
    }

    @Override
    public List<Log> getLogs() {
        return logDao.getAll();
    }
}
