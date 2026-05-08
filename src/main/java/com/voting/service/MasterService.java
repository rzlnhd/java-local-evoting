/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.service;

import com.voting.model.master.Calon;
import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;
import com.voting.model.master.pemilih.Difabel;
import com.voting.model.master.pemilih.Status;
import com.voting.model.master.tps.Des;
import com.voting.model.master.tps.Kab;
import com.voting.model.master.tps.Kec;
import com.voting.model.master.tps.Prov;
import java.util.List;

/**
 *
 * @author Rizal
 */
public interface MasterService {
    //Master Service Pemilih
    public void savePemilih(Pemilih p);
    public void updatePemilih(Pemilih p);
    public void deletePemilih(Pemilih p);
    public Pemilih getPemilih(String c);
    public List<Pemilih> getAllPemilih();
    public List<Pemilih> getAllPemilih(Tps t);
    public List<Pemilih> searchPemilih(int i, String s);
    public List<Difabel> getAllDifabel();
    public List<Status> getAllStatus();
    public long countT(Tps t);
    public long countP(int ket, String jk);
    
    //Master Servis Calon
    public void saveCalon(Calon c);
    public void updateCalon(Calon c);
    public void deleteCalon(Calon c); 
    public Calon getCalon(String c);
    public Calon getCalonFromId(int i);
    public List<Calon> getAllCalon();
    public List<Calon> searchCalon(int i, String s);
    
    //Master Servis TPS
    public void saveTps(Tps t);
    public void updateTPS(Tps t);
    public void deleteTps(Tps t);
    public List<Tps> getAllTps();
    public List<Tps> searchTps(int i, String s);
    public Tps getTps(String c);
    public Prov getProv(String c);
    public List<Prov> getAllProv();
    public Kab getKab(String c);
    public List<Kab> getFromProv(Prov p);
    public Kec getKec(String c);
    public List<Kec> getFromKab(Kab k);
    public Des getDes(String c);
    public List<Des> getFromKec(Kec k);
}
