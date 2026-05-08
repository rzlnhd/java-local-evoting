/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.service;

import com.voting.model.security.Admin;
import com.voting.model.security.Log;
import com.voting.model.security.admin.Acc;
import java.util.List;

/**
 *
 * @author Rizal
 */
public interface SecurityService {
    //Admin
    public void saveAdmin(Admin a);
    public void updateAdmin(Admin a);
    public void deleteAdmin(Admin a);
    public List<Admin> getAdmins();
    public Admin logIn(String id);

    //Acc
    public Acc getAcc(String id);
    public Integer maximumMenuLevel();
    
    //Log
    public void makeLog(Log l);
    public void updateLog(Log l);
    public void deleteLog(Log l);
    public List<Log> getLogs();    
}
