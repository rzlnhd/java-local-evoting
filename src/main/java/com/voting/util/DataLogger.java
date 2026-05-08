package com.voting.util;

import com.voting.model.master.*;
import com.voting.model.security.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rizal
 */
public class DataLogger {
    static Log log;static Object object;static String desk;
    static boolean logged;
    static Admin admin;
    
    public static final int ADD=0;
    public static final int EDIT=1;
    public static final int DEL=2;
    public static final int PRINT=3;
    public static final int PAS=4;
    public static final int RST=5;
    public static final int LOG=6;
    
    public static Log makeLog(Object o, int s){
        object=o;
        return setLog(s);
    }
    
    public static Log makeLog(boolean b){
        logged=b;
        return setLog(6);
    }
    
    public static Log openBilik(boolean b){
        logged=b;
        return setLog(7);
    }
    
    public static void setAdmin(Admin a){
        admin=a;
    }
    
    private static Log setLog(int s){
        desk=makeDesk(s);
        return new Log(admin,desk);
    }
    
    private static String makeDesk(int s){
        String d;
        switch(s){
            case 0:d=add();break;
            case 5:d=rst();break;
            case 6:d=loged(logged);break;
            case 7:d=bilik(logged);break;
            default:d=edit_del_print(s);break;
        }
        return d;
    }
    
    private static String add(){
        String obj="";
        if(object instanceof Admin){
            obj=((Admin) object).getUsername()+" Sebagai "+((Admin) object).getAcc().getId();
        } else if(object instanceof Pemilih){
            obj=((Pemilih) object).getNama()+"("+((Pemilih) object).getInduk()+")"+"Sebagai Pemilih di TPS "+((Pemilih) object).getTpsCode().getCode();
        } else if(object instanceof Calon){
            obj=((Calon) object).getNama()+"("+((Calon) object).getInduk()+") sebagai Calon dengan Nomor Urut "+((Calon) object).getId();
        } else if(object instanceof Tps){
            obj="TPS dengan kode "+((Tps) object).getCode();
        }
        return "Menambah "+obj;
    }
    
    private static String edit_del_print(int s){
        String obj="",pre="";        
        switch(s){
            case 1:pre="Mengubah data";break;
            case 2:pre="Menghapus data";break;
            case 3:pre="Pencetak data";break;
            case 4:pre="Mengubah Password";break;
        }
        if(object instanceof Admin){
            if(admin == (Admin) object){
                obj="nya sendiri";
            } else {
                obj=" Petugas dengan username "+((Admin) object).getUsername();
            }
        } else if(object instanceof Pemilih){
            obj=" Pemilih dengan ID "+((Pemilih) object).getInduk();
        } else if(object instanceof Calon){
            obj=" Calon dengan ID "+((Calon) object).getInduk();
        } else if(object instanceof Tps){
            obj=" TPS dengan kode"+((Tps) object).getCode();
        }
        return pre+obj;
    }
    
    private static String rst(){
        return "Mereset password untuk username "+((Admin) object).getUsername();
    }
    
    private static String loged(boolean b){
        String obj="Keluar";
        if(b){
            obj="Masuk sebagai "+admin.getAcc().getId();
        }
        return obj;
    }
    
    private static String bilik(boolean b){
        String obj="Menutup Bilik";
        if(b){
            obj="Membuka Bilik";
        }
        return obj;
    }
}

