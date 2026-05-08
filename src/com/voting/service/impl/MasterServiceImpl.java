/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.service.impl;

import com.voting.dao.master.CalonDao;
import com.voting.dao.master.PemilihDao;
import com.voting.dao.master.TpsDao;
import com.voting.dao.master.pemilih.DifabelDao;
import com.voting.dao.master.pemilih.StatusDao;
import com.voting.dao.master.tps.ProvDao;
import com.voting.dao.master.tps.KabDao;
import com.voting.dao.master.tps.KecDao;
import com.voting.dao.master.tps.DesDao;
import com.voting.model.master.Calon;
import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;
import com.voting.model.master.pemilih.Difabel;
import com.voting.model.master.pemilih.Status;
import com.voting.model.master.tps.Des;
import com.voting.model.master.tps.Kab;
import com.voting.model.master.tps.Kec;
import com.voting.model.master.tps.Prov;
import com.voting.service.MasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rizal
 */
@Service("masterService")
@Transactional(readOnly=true)
public class MasterServiceImpl implements MasterService{
    @Autowired private PemilihDao pemilihDao;
    @Autowired private DifabelDao difabelDao;
    @Autowired private StatusDao statusDao;
    @Autowired private CalonDao calonDao;
    @Autowired private TpsDao tpsDao;
    @Autowired private ProvDao provDao;
    @Autowired private KabDao kabDao;
    @Autowired private KecDao kecDao;    
    @Autowired private DesDao desDao;
    
    
    /* 
     * Master Service Pemilih
     */
    @Transactional
    @Override
    public void savePemilih(Pemilih p) {
        pemilihDao.save(p);
    }
    
    @Transactional
    @Override
    public void updatePemilih(Pemilih p) {
        pemilihDao.update(p);
    }

    @Transactional
    @Override
    public void deletePemilih(Pemilih p) {
        pemilihDao.delete(p);
    }

    @Override
    public Pemilih getPemilih(String c) {
        return pemilihDao.getFromCode(c);
    }
    
    @Override
    public List<Pemilih> getAllPemilih(){
        return pemilihDao.getAll();
    }
    
    @Override
    public List<Pemilih> getAllPemilih(Tps t){
        return pemilihDao.getAll(t);
    }

    @Override
    public List<Pemilih> searchPemilih(int i,String s) {
        switch(i){
            default: return pemilihDao.cariBerdasarKk(s);
            case 1: return pemilihDao.cariBerdasarId(s);
            case 2: return pemilihDao.cariBerdasarNama(s);
            case 3: return pemilihDao.cariBerdasarAlamat(s);
        }
    }
    
    @Override
    public List<Difabel> getAllDifabel(){
        return difabelDao.getAll();
    }
    
    @Override
    public List<Status> getAllStatus(){
        return statusDao.getAll();
    }

    @Override
    public long countT(Tps t) {
        return pemilihDao.countT(t.getCode());
    }
    
    @Override
    public long countP(int ket, String jk) {
        if(jk.equals("0")){
            if(ket!=2){
                return pemilihDao.countP(ket);
            } else {
                return pemilihDao.countP();
            }
        } else if(ket==2){
            return pemilihDao.countP(jk);
        } else{
            return pemilihDao.countP(ket,jk);
        }
    }
    
    /* 
     * Master Service Calon
     */
    @Transactional
    @Override
    public void saveCalon(Calon c) {
        calonDao.save(c);
    }
    
    @Transactional
    @Override
    public void updateCalon(Calon c) {
        calonDao.update(c);
    }
    
    @Transactional
    @Override
    public void deleteCalon(Calon c) {
        calonDao.delete(c);
    }

    @Override
    public Calon getCalon(String c) {
        return calonDao.getFromCode(c);
        
    }
    
    @Override
    public Calon getCalonFromId(int c){
        return calonDao.cariBerdasarUrut(c);
    }

    @Override
    public List<Calon> getAllCalon() {
        return calonDao.getAll();
    }

    @Override
    public List<Calon> searchCalon(int i, String s) {        
        switch(i){
            default: return calonDao.cariBerdasarId(s);
            case 1: return calonDao.cariBerdasarNama(s);
            case 2: return calonDao.cariBerdasarAlamat(s);
        }
    }
    
    /* 
     * Master Service TPS
     */
    @Transactional
    @Override
    public void saveTps(Tps t){
        tpsDao.save(t);
    }

    @Transactional
    @Override
    public void updateTPS(Tps t) {
        tpsDao.update(t);
    }
    
    @Transactional
    @Override
    public void deleteTps(Tps t) {
        tpsDao.delete(t);
    }

    @Override
    public List<Tps> getAllTps() {
        return tpsDao.getAll();
    }

    @Override
    public List<Tps> searchTps(int i, String s) {
        switch(i){
            default: return tpsDao.getTpsFromProv(s);
            case 1: return tpsDao.getTpsFromKab(s);
            case 2: return tpsDao.getTpsFromKec(s);
            case 3: return tpsDao.getTpsFromDes(s);
            case 4: return tpsDao.getTpsFromCode(s);
            case 5: return tpsDao.getTpsFromDesk(s);
        }
    }

    @Override
    public Tps getTps(String c) {
        return tpsDao.getFromCode(c);
    }

    @Override
    public Prov getProv(String c) {
        return provDao.getFromCode(c);
    }

    @Override
    public List<Prov> getAllProv() {
        return provDao.getAll();
    }

    @Override
    public Kab getKab(String c) {
        return kabDao.getFromCode(c);
    }

    @Override
    public List<Kab> getFromProv(Prov p) {
        return kabDao.getFromProv(p);
    }

    @Override
    public Kec getKec(String c) {
        return kecDao.getFromCode(c);
    }

    @Override
    public List<Kec> getFromKab(Kab k) {
        return kecDao.getFromKab(k);
    }

    @Override
    public Des getDes(String c) {
        return desDao.getFromCode(c);
    }

    @Override
    public List<Des> getFromKec(Kec k) {
        return desDao.getFromKec(k);
    }
}
