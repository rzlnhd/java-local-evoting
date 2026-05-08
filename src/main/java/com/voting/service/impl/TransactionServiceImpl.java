/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.service.impl;

import com.voting.dao.master.*;
import com.voting.dao.security.LogDao;
import com.voting.dao.transaksi.*;
import com.voting.model.master.*;
import com.voting.model.security.Log;
import com.voting.model.transaksi.*;
import com.voting.service.TransactionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rizal
 */
@Service("transactionService")
@Transactional(readOnly=true)
public class TransactionServiceImpl implements TransactionService{
    @Autowired private PemilihDao pemilihDao;
    @Autowired private CalonDao calonDao;
    @Autowired private LogDao logDao;
    @Autowired private BilikDao bilikDao;
    @Autowired private CardDao cardDao;
    @Autowired private TungguDao tungguDao;

    @Override
    public Pemilih lookUpPemilih(String id) {
        return pemilihDao.lookUp(id);
    }
    
    @Override
    public boolean cekTps(String id, Tps t){
        if(t!=null){
            return pemilihDao.cariBerdasarTps(id, t)!=null;
        } else{
            return pemilihDao.lookUp(id)!=null;
        }
    }
    
    @Transactional
    @Override
    public void makeLog(Log log){
        logDao.save(log);
    }

    @Transactional
    @Override
    public void pilihCalon(Pemilih p, Calon c, Bilik b) {
        pemilihDao.update(p);
        bilikDao.update(b);
        calonDao.update(c);
        cardDao.save(new Card(p,c,b));
    }

    @Transactional
    @Override
    public void saveBilik(Bilik b) {
        bilikDao.save(b);
    }

    @Transactional
    @Override
    public void updateBilik(Bilik b) {
        bilikDao.update(b);
    }

    @Transactional
    @Override
    public void deleteBilik(Bilik b) {
        bilikDao.delete(b);
    }
    

    @Transactional
    @Override
    public void saveTunggu(Tunggu t) {
        tungguDao.save(t);
    }

    @Transactional
    @Override
    public void updateTunggu(Tunggu t) {
        tungguDao.update(t);
    }

    @Transactional
    @Override
    public void deleteTunggu(Tunggu t) {
        tungguDao.delete(t);
    }
    
    @Override
    public List<Tunggu> getTunggus() {
        return tungguDao.getAll();
    }
    
    @Override
    public Bilik cekBilik(Integer no, Tps t) {
        return bilikDao.cekBilik(no,t);
    }

    @Override
    public List<Bilik> cekAktif(Tps t) {
        return bilikDao.cekAktif(t);
    }

    @Transactional
    @Override
    public void kirimPemilih(Bilik b, Pemilih p) {
        bilikDao.update(b);
        pemilihDao.update(p);
    }

    @Transactional
    @Override
    public void waitingList(Tunggu t, Pemilih p) {
        tungguDao.save(t);
        pemilihDao.update(p);
    }
}
