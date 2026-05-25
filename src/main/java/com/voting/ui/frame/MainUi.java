package com.voting.ui.frame;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;
import com.voting.model.master.Tps;
import com.voting.model.security.Admin;
import com.voting.model.security.admin.Menu;
import com.voting.model.transaksi.Bilik;
import com.voting.service.MasterService;
import com.voting.service.SecurityService;
import com.voting.service.TransactionService;
import com.voting.ui.frame.dialog.CamOptionDialog;
import com.voting.ui.frame.dialog.EditPasswordDialog;
import com.voting.ui.frame.dialog.GetServer;
import com.voting.ui.frame.dialog.InputPass;
import com.voting.ui.frame.dialog.SelectLogin;
import com.voting.ui.security.dialog.InputPetugas;
import com.voting.ui.security.dialog.LoginDialog;
import com.voting.ui.transaksi.BilikPanel;
import com.voting.ui.transaksi.RegistrasiPanel;
import com.voting.util.DataLogger;
import com.voting.util.UrutanComparator;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.openide.util.Exceptions;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rizal
 */
public class MainUi extends javax.swing.JFrame {

    private static boolean bilik = false;
    private static MainUi instance;
    private static MasterService masterService;
    private static SecurityService securityService;
    private static TransactionService transactionService;
    private static String ip;
    private static Admin admin;
    private static Tps tps;
    private static Bilik bil;
    private static Webcam captureCam = Webcam.getDefault();
    private static Webcam QrCam = Webcam.getDefault();
    private static WebcamResolution cSize = WebcamResolution.VGA;
    private static Dimension[] dDefault;
    private static final List<JInternalFrame> frameList = new ArrayList<>();
    private static final Map<String, JInternalFrame> internalFrameMap = new HashMap<>();

    public static MainUi getInstance() {
        return instance;
    }

    public static MasterService getMasterService() {
        return masterService;
    }

    public static SecurityService getSecurityService() {
        return securityService;
    }

    public static TransactionService getTransactionService() {
        return transactionService;
    }

    public static String getAppsIp() {
        return ip;
    }

    public static Admin getAdmin() {
        return admin;
    }

    public static Tps getTps() {
        return tps;
    }

    public static Bilik getBilik() {
        return bil;
    }

    public static Webcam getCaptureCam() {
        return captureCam;
    }

    public static Webcam getQrCam() {
        return QrCam;
    }

    public static Dimension[] getDimensions() {
        return dDefault;
    }

    public static WebcamResolution getCaptureSize() {
        return cSize;
    }

    public static void setIp(String is) {
        ip = is;
    }

    public static void setTps(Tps t) {
        tps = t;
    }

    public static void setBilik(Bilik b) {
        bil = b;
    }

    public static void setCaptureCam(Webcam c) {
        captureCam = c;
    }

    public static void setQrCam(Webcam q) {
        QrCam = q;
    }

    public static void setDefaultDimensions(Dimension[] d) {
        dDefault = d;
    }

    public static void setCaptureSize(WebcamResolution d) {
        cSize = d;
    }

    public static void reload(int c) {
        rld(c);
    }

    /**
     * Creates new form MainUi
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public MainUi() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        initComponents();
        instance = this;// </editor-fold>
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public MainUi(String s) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        initComponents();
        ip = s;
        instance = this;// </editor-fold>}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        iPanel = new javax.swing.JPanel();
        iName = new javax.swing.JLabel();
        iUname = new javax.swing.JLabel();
        iTps = new javax.swing.JLabel();
        panelFoto1 = new com.voting.ui.panel.PanelFoto();
        btnLogin = new javax.swing.JButton();
        mnuFile = new javax.swing.JMenu();
        mnuProfile = new javax.swing.JMenuItem();
        mnuChangePassword = new javax.swing.JMenuItem();
        sepMnu = new javax.swing.JPopupMenu.Separator();
        mnuSettings = new javax.swing.JMenu();
        mnuDbaseOpt = new javax.swing.JMenuItem();
        mnuFtpOpt = new javax.swing.JMenuItem();
        mnuCamOpt = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Local & Secure Electronic Voting System");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                transactionService.makeLog(DataLogger.makeLog(false));
            }
        });

        iPanel.setBackground(new java.awt.Color(77, 77, 77));

        iName.setBackground(new java.awt.Color(77, 77, 77));
        iName.setFont(new java.awt.Font("Futura LtCn BT", 0, 14)); // NOI18N
        iName.setForeground(new java.awt.Color(204, 153, 51));
        iName.setText("-");

        iUname.setBackground(new java.awt.Color(77, 77, 77));
        iUname.setFont(new java.awt.Font("Futura LtCn BT", 2, 11)); // NOI18N
        iUname.setForeground(new java.awt.Color(255, 255, 255));
        iUname.setText("-");

        iTps.setBackground(new java.awt.Color(77, 77, 77));
        iTps.setFont(new java.awt.Font("Futured", 0, 11)); // NOI18N
        iTps.setForeground(new java.awt.Color(204, 153, 51));
        iTps.setText("-");

        javax.swing.GroupLayout panelFoto1Layout = new javax.swing.GroupLayout(panelFoto1);
        panelFoto1.setLayout(panelFoto1Layout);
        panelFoto1Layout.setHorizontalGroup(
                panelFoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 48, Short.MAX_VALUE)
        );
        panelFoto1Layout.setVerticalGroup(
                panelFoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 61, Short.MAX_VALUE)
        );

        btnLogin.setText("Log In");
        btnLogin.addActionListener(e -> eLogOut());

        javax.swing.GroupLayout iPanelLayout = new javax.swing.GroupLayout(iPanel);
        iPanel.setLayout(iPanelLayout);
        iPanelLayout.setHorizontalGroup(
                iPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(iPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panelFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(iPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(iPanelLayout.createSequentialGroup()
                                                .addComponent(iName)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(iPanelLayout.createSequentialGroup()
                                                .addGroup(iPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(iUname)
                                                        .addComponent(iTps))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 658, Short.MAX_VALUE)
                                                .addComponent(btnLogin)))
                                .addContainerGap())
        );
        iPanelLayout.setVerticalGroup(
                iPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(iPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(iPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelFoto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(iPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnLogin)
                                                .addGroup(iPanelLayout.createSequentialGroup()
                                                        .addComponent(iName)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(iUname)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(iTps))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mnuFile.setText("File");

        mnuProfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuProfile.setText("Profile");
        mnuProfile.addActionListener(e -> cEdit());
        mnuFile.add(mnuProfile);

        mnuChangePassword.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuChangePassword.setText("Edit Password");
        mnuChangePassword.addActionListener(e -> cPass());
        mnuFile.add(mnuChangePassword);
        mnuFile.add(sepMnu);

        mnuSettings.setText("Settings");

        mnuDbaseOpt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuDbaseOpt.setText("Database Options");
        mnuSettings.add(mnuDbaseOpt);

        mnuFtpOpt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuFtpOpt.setText("FTP Options");
        mnuSettings.add(mnuFtpOpt);

        mnuCamOpt.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnuCamOpt.setText("Camera Options");
        mnuCamOpt.addActionListener(e -> eCamOpt());
        mnuSettings.add(mnuCamOpt);

        mnuFile.add(mnuSettings);

        mnuBar.add(mnuFile);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(iPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eLogOut() {//GEN-FIRST:event_eLogOut
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        int pilih = 1;
        boolean res = false;
        if (!bilik) {
            pilih = JOptionPane.showConfirmDialog(this, "Anda yakin ingin Log Out?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        } else {
            res = new InputPass().logout();
        }
        if (pilih == JOptionPane.YES_OPTION || res) {
            if (bilik) {
                bOpened(false);
            } else {
                logedIn(false);
            }
            admin = null;
            for (JInternalFrame frame : frameList) {
                frame.dispose();
            }
            frameList.clear();
            internalFrameMap.clear();
            reconsMenu();
            JOptionPane.showMessageDialog(this, "Log Out Berhasil");
            DataLogger.setAdmin(null);
            logIn();
        }// </editor-fold>
    }//GEN-LAST:event_eLogOut

    private void eCamOpt() {//GEN-FIRST:event_eCamOpt
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        CamOptionDialog c = new CamOptionDialog();
        int atur = c.getReturnStatus();
        if (atur == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(MainUi.getInstance(), "Kamera Berhasil Diatur");
        }// </editor-fold>
    }//GEN-LAST:event_eCamOpt

    private void cPass() {//GEN-FIRST:event_cPass
        EditPasswordDialog e = new EditPasswordDialog();
        int atur = e.getReturnStatus(admin);
        if (atur == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(MainUi.getInstance(), "Kata Sandi Berhasil Diubah");
        }
    }//GEN-LAST:event_cPass

    private void cEdit() {//GEN-FIRST:event_cEdit
        InputPetugas ad = new InputPetugas(admin, 1);
        ad.setVisible(true);
    }//GEN-LAST:event_cEdit

    private static void logIn() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        Admin a = new LoginDialog().login();
        if (a != null) {
            admin = a;
            iName.setText(admin.getNama());
            iUname.setText("@" + admin.getUsername());
            tps = admin.getTpsCode();
            if (tps != null) {
                iTps.setText(tps.toString());
            }
            loadImage(admin.getFoto());
            btnLogin.setText("Log Out");
            constructMenu();
            DataLogger.setAdmin(admin);
            if (admin.getAcc().toString().equals("Operator")) {
                bilik = new SelectLogin().getOption();
                openBilik(bilik);
                if (bilik) {
                    bOpened(true);
                } else {
                    logedIn(true);
                }
            } else {
                logedIn(true);
            }
        }// </editor-fold>
    }

    private static void rld(int c) {
        if (c != 0) {
            iName.setText(admin.getNama());
            tps = admin.getTpsCode();
            if (tps != null) {
                iTps.setText(tps.toString());
            }
            loadImage(admin.getFoto());
            JOptionPane.showMessageDialog(MainUi.getInstance(), "Edit Data Berhasil!");
        }
    }

    private static void logedIn(boolean s) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        mnuFile.setEnabled(s);
        transactionService.makeLog(DataLogger.makeLog(s));
        if (s == false) {
            iName.setText("-");
            iUname.setText("-");
            iTps.setText("-");
            panelFoto1.setImage(null);
            btnLogin.setText("Log In");
        } else {
            JOptionPane.showMessageDialog(MainUi.getInstance(), "Log In Berhasil!");
        }// </editor-fold>
    }

    private static void loadImage(String s) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if (s != null) {
            s = s.replace("address", ip);
            try {
                URL url = new URL(s);
                BufferedImage image = ImageIO.read(url);
                panelFoto1.setImage(image);
            } catch (IOException e) {
            }
        } else {
            panelFoto1.setImage(null);
        }//</editor-fold>
    }

    private static void bOpened(boolean b) {
        mnuFile.setEnabled(b);
        transactionService.makeLog(DataLogger.openBilik(b));
        if (!b) {
            iName.setText("-");
            iUname.setText("-");
            iTps.setText("-");
            panelFoto1.setImage(null);
            btnLogin.setText("Log In");
            if (bil.getIdPemilih() == null && bil.getSuara() == 0) {
                transactionService.deleteBilik(bil);
            } else {
                bil.setStatus(0);
                transactionService.updateBilik(bil);
            }
            instance.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        } else {
            instance.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            JOptionPane.showMessageDialog(MainUi.getInstance(), "Buka Bilik Berhasil!");
        }
    }

    private static void openBilik(boolean b) {
        @SuppressWarnings("UnusedAssignment")
        JInternalFrame frame = new RegistrasiPanel();
        if (b) {
            frame = new BilikPanel();
        }
        final JInternalFrame Frame = frame;
        Frame.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                internalFrameMap.remove(Frame.getClass().getName());
                desktopPane.remove(Frame);
            }
        });
        desktopPane.add(Frame);
        internalFrameMap.put(Frame.getClass().getName(), Frame);
        frameList.add(Frame);
        frame.setVisible(true);
        try {
            Frame.setSelected(true);
            Frame.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private static void reconsMenu() {
        for (Component component : mnuBar.getComponents()) {
            if (!component.equals(mnuFile)
                    && !component.equals(mnuChangePassword)
                    && !component.equals(sepMnu)
                    && !component.equals(mnuSettings)
                    && !component.equals(mnuDbaseOpt)
                    && !component.equals(mnuFtpOpt)
                    && !component.equals(mnuCamOpt)) {
                mnuBar.remove(component);
            }
        }
        mnuBar.updateUI();
        mnuFile.setEnabled(false);
    }

    private static void constructMenu() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        Set<Menu> menus = new HashSet<Menu>();
        menus.addAll(admin.getAcc().getMenuList());
        //Map level dan menunya
        Map<Integer, List<Menu>> menuMap = new HashMap<Integer, List<Menu>>();
        menus.stream().forEach((Menu m) -> {
            List<Menu> menuList;
            if (menuMap.get(m.getMnuLevel()) == null) {
                menuList = new ArrayList<Menu>();
                menuMap.put(m.getMnuLevel(), menuList);
            } else {
                menuList = menuMap.get(m.getMnuLevel());
            }
            menuList.add(m);
        });
        //Ambil menu level 0 dan tambahkan dalam menubar
        Set<Menu> menuLevel0 = new TreeSet<Menu>(new UrutanComparator());//mendapatkan menu level 0 yang diurutkan berdasarkan urutan
        if (menuMap.get(0) == null) {
            throw new IllegalStateException("Menu level 0 tidak ada !!!");
        } else {
            menuLevel0.addAll(menuMap.get(0));
        }
        //pasang menu level 0 di dalam menu bar
        Map<Menu, JMenuItem> menuItemMap = new HashMap<Menu, JMenuItem>();
        menuLevel0.stream().forEach((m) -> {
            JMenu jMenu = new JMenu();
            jMenu.setText(m.getId());
            mnuBar.add(jMenu);
            menuItemMap.put(m, jMenu);
        });
        //level berikutnya dipasang
        //construct parent child tree
        List<Menu> parents = menuMap.get(0);
        if (parents == null) {
            throw new IllegalStateException("Menu level 0 tidak ada!");
        }
        Set<Menu> childs;
        Integer maximumLevel = MainUi.getSecurityService().maximumMenuLevel();
        for (int i = 1; i <= maximumLevel; i++) {
            childs = new TreeSet<Menu>(new UrutanComparator());
            childs.addAll(menuMap.get(i));
            if (childs != null) {
                for (Menu m : childs) {
                    if (parents.indexOf(m.getParent()) >= 0) {
                        Menu parent = parents.get(parents.indexOf(m.getParent()));
                        parent.addChild(m);
                    }
                    //bikin menu berdasarkan panelClass, kalau nilainya null dibikin JMenu, kalau ada berarti JMenuItem
                    if (m.getMnuClass() == null) {
                        JMenu jMenu = new JMenu();
                        jMenu.setText(m.getId());
                        menuItemMap.put(m, jMenu);
                        JMenuItem parent = menuItemMap.get(m.getParent());
                        if (parent != null && parent instanceof JMenu) {
                            JMenu parentMenu = (JMenu) parent;
                            parentMenu.add(jMenu);
                        }
                    } else {
                        JMenuItem jMenuItem = new JMenuItem();
                        jMenuItem.setText(m.getId());
                        jMenuItem.addActionListener(createActionListener(m));
                        menuItemMap.put(m, jMenuItem);
                        JMenuItem parent = menuItemMap.get(m.getParent());
                        if (parent != null && parent instanceof JMenu) {
                            JMenu parentMenu = (JMenu) parent;
                            parentMenu.add(jMenuItem);
                        }
                    }
                }
            }
            parents = new ArrayList<Menu>(childs);
        }
        mnuBar.setVisible(true);
        mnuBar.updateUI();//</editor-fold>
    }

    private static ActionListener createActionListener(final Menu menu) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        return (ActionEvent e) -> {
            JInternalFrame Iframe = internalFrameMap.get(menu.getMnuClass());
            try {
                //cek apakah sudah ada
                if (Iframe == null) {
                    final Object o = Class.forName(menu.getMnuClass()).newInstance();
                    if (o instanceof JInternalFrame) {
                        final JInternalFrame frame = (JInternalFrame) o;
                        frame.addInternalFrameListener(new InternalFrameAdapter() {
                            @Override
                            public void internalFrameClosed(InternalFrameEvent e) {
                                internalFrameMap.remove(frame.getClass().getName());
                                desktopPane.remove(frame);
                            }
                        });
                        Iframe = frame;
                        desktopPane.add(Iframe);
                        internalFrameMap.put(Iframe.getClass().getName(), Iframe);
                        frameList.add(frame);
                        Iframe.setVisible(true);
                        Iframe.setSelected(true);
                        Iframe.setMaximum(true);
                    }
                } else {
                    Iframe.toFront();
                }
            } catch (PropertyVetoException ex) {
                Logger.getLogger(MainUi.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Exceptions.printStackTrace(ex);
            }
        };// </editor-fold>
    }

    /**
     * @param args the command line arguments
     */
    private static void ref(String conf) {
        MainUi main = new MainUi();
        MainUi.reconsMenu();
        Properties props = new Properties();
        main.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        try {
            InputStream in = new FileInputStream(conf);
            props.load(in);
            MainUi.setIp(props.getProperty("jdbc.ip"));
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        main.setVisible(true);
        new Thread(() -> {
            try {
                ApplicationContext appContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
                masterService = (MasterService) appContext1.getBean("masterService");
                securityService = (SecurityService) appContext1.getBean("securityService");
                transactionService = (TransactionService) appContext1.getBean("transactionService");
            } catch (RuntimeException t) {
                System.out.println("Error : " + t.getMessage());
                // appropriate error reporting here
            }
            mnuFile.setEnabled(true);
            MainUi.logIn();
        }).start();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }//</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            String path = System.getProperty("user.home") + File.separator + "Documents",
                    name = File.separator + "config.properties";
            path += File.separator + "Local Voting";
            File custDir = new File(path), conf = new File(path + name);
            if ((!custDir.exists() && custDir.mkdirs()) || !conf.exists()) {
                MainUi main = new MainUi();
                main.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
                main.setVisible(true);
                GetServer g = new GetServer(main);
                ip = g.getServer(path + name);
                if (!ip.isEmpty()) {
                    main.dispose();
                    ref(path + name);
                }
            } else if (conf.exists()) {
                ref(path + name);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btnLogin;
    private static javax.swing.JDesktopPane desktopPane;
    private static javax.swing.JLabel iName;
    private javax.swing.JPanel iPanel;
    private static javax.swing.JLabel iTps;
    private static javax.swing.JLabel iUname;
    public static final javax.swing.JMenuBar mnuBar = new javax.swing.JMenuBar();
    private static javax.swing.JMenuItem mnuCamOpt;
    private static javax.swing.JMenuItem mnuChangePassword;
    private static javax.swing.JMenuItem mnuDbaseOpt;
    private static javax.swing.JMenu mnuFile;
    private static javax.swing.JMenuItem mnuFtpOpt;
    private static javax.swing.JMenuItem mnuProfile;
    private static javax.swing.JMenu mnuSettings;
    private static com.voting.ui.panel.PanelFoto panelFoto1;
    private static javax.swing.JPopupMenu.Separator sepMnu;
    // End of variables declaration//GEN-END:variables
}
