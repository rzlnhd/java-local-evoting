/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.service;

import com.voting.model.master.Calon;
import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;
import com.voting.model.security.Log;
import com.voting.model.transaksi.Bilik;
import com.voting.model.transaksi.Tunggu;
import java.util.List;

/**
 *
 * @author Rizal
 */
public interface TransactionService {
    //Pemilih Service
    public Pemilih lookUpPemilih(String id);
    public boolean cekTps(String id, Tps t);
    
    public void makeLog(Log log);
    public void pilihCalon(Pemilih p, Calon c, Bilik b);
    
    public void saveBilik(Bilik b);
    public void updateBilik(Bilik b);
    public void deleteBilik(Bilik b);
    
    public void saveTunggu(Tunggu t);
    public void updateTunggu(Tunggu t);
    public void deleteTunggu(Tunggu t);
    public List<Tunggu> getTunggus();    
    
    public Bilik cekBilik(Integer no, Tps t);
    public List<Bilik> cekAktif(Tps t);
    public void kirimPemilih(Bilik b, Pemilih p);
    public void waitingList(Tunggu t, Pemilih p);
}
