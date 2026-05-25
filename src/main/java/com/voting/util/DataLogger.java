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

    static Object object;
    static String desk;
    static boolean logged;
    static Admin admin;

    public static final int ADD = 0;
    public static final int EDIT = 1;
    public static final int DEL = 2;
    public static final int PRINT = 3;
    public static final int PAS = 4;
    public static final int RST = 5;
    public static final int LOG = 6;

    public static Log makeLog(Object o, int s) {
        object = o;
        return setLog(s);
    }

    public static Log makeLog(boolean b) {
        logged = b;
        return setLog(6);
    }

    public static Log openBilik(boolean b) {
        logged = b;
        return setLog(7);
    }

    public static void setAdmin(Admin a) {
        admin = a;
    }

    private static Log setLog(int s) {
        desk = makeDesk(s);
        return new Log(admin, desk);
    }

    private static String makeDesk(int s) {
        // String d;
        return switch (s) {
            case 0 ->
                add();
            case 5 ->
                rst();
            case 6 ->
                loged(logged);
            case 7 ->
                bilik(logged);
            default ->
                edit_del_print(s);
        };
        // return d;
    }

    private static String add() {
        String obj = "";
        if (object instanceof Admin admin1) {
            obj = admin1.getUsername() + " Sebagai " + admin1.getAcc().getId();
        } else if (object instanceof Pemilih pemilih) {
            obj = pemilih.getNama() + "(" + pemilih.getInduk() + ")" + "Sebagai Pemilih di TPS " + pemilih.getTpsCode().getCode();
        } else if (object instanceof Calon calon) {
            obj = calon.getNama() + "(" + calon.getInduk() + ") sebagai Calon dengan Nomor Urut " + calon.getId();
        } else if (object instanceof Tps tps) {
            obj = "TPS dengan kode " + tps.getCode();
        }
        return "Menambah " + obj;
    }

    private static String edit_del_print(int s) {
        String obj = "", pre = "";
        switch (s) {
            case 1 ->
                pre = "Mengubah data";
            case 2 ->
                pre = "Menghapus data";
            case 3 ->
                pre = "Pencetak data";
            case 4 ->
                pre = "Mengubah Password";
        }
        if (object instanceof Admin admin1) {
            if (admin == admin1) {
                obj = "nya sendiri";
            } else {
                obj = " Petugas dengan username " + admin1.getUsername();
            }
        } else if (object instanceof Pemilih pemilih) {
            obj = " Pemilih dengan ID " + pemilih.getInduk();
        } else if (object instanceof Calon calon) {
            obj = " Calon dengan ID " + calon.getInduk();
        } else if (object instanceof Tps tps) {
            obj = " TPS dengan kode" + tps.getCode();
        }
        return pre + obj;
    }

    private static String rst() {
        return "Mereset password untuk username " + ((Admin) object).getUsername();
    }

    private static String loged(boolean b) {
        String obj = "Keluar";
        if (b) {
            obj = "Masuk sebagai " + admin.getAcc().getId();
        }
        return obj;
    }

    private static String bilik(boolean b) {
        String obj = "Menutup Bilik";
        if (b) {
            obj = "Membuka Bilik";
        }
        return obj;
    }
}
