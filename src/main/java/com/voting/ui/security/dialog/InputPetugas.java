/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.ui.security.dialog;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.twmacinta.util.MD5;
import com.voting.model.master.Tps;
import com.voting.model.security.Admin;
import com.voting.model.security.admin.Acc;
import com.voting.service.SecurityService;
import com.voting.ui.frame.MainUi;
import com.voting.ui.frame.dialog.CaptureDialog;
import com.voting.ui.frame.dialog.GetTPS;
import com.voting.ui.master.dialog.InputPemilih;
import com.voting.ui.security.PetugasPanel;
import com.voting.util.DataLogger;
import com.voting.util.UploadImg;

public class InputPetugas extends javax.swing.JFrame {

    private final ResourceBundle bundle = ResourceBundle.getBundle("com.voting.ui.security.dialog.Bundle");
    private BufferedImage image;
    String foto;
    int s = 0, c = 0;
    Admin admin;
    SecurityService ss = MainUi.getSecurityService();
    Acc acc;
    Tps tps;

    public InputPetugas() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        initComponents();// </editor-fold>
    }

    public InputPetugas(Admin a, int i) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        initComponents();
        s = i;
        admin = a;
        initData(admin);// </editor-fold>        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aType = new javax.swing.ButtonGroup();
        lTitle = new javax.swing.JLabel();
        pData = new javax.swing.JPanel();
        lNama = new javax.swing.JLabel();
        lUname = new javax.swing.JLabel();
        lTPS = new javax.swing.JLabel();
        lType = new javax.swing.JLabel();
        fNama = new javax.swing.JTextField();
        fUname = new javax.swing.JTextField();
        fTps = new javax.swing.JTextField();
        rSU = new javax.swing.JRadioButton();
        rReg = new javax.swing.JRadioButton();
        rOp = new javax.swing.JRadioButton();
        rAu = new javax.swing.JRadioButton();
        sTps = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        pFoto = new javax.swing.JPanel();
        panelFoto1 = new com.voting.ui.panel.PanelFoto();
        bSearch = new javax.swing.JButton();
        fFoto = new javax.swing.JTextField();
        bCapture = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        aType.clearSelection();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(bundle.getString("InputPetugas.title")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent evt) {
                if (s == 0) {
                    PetugasPanel.refresh();
                } else {
                    MainUi.reload(c);
                }
            }
        });

        lTitle.setFont(new java.awt.Font("Futured", 1, 24)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText(bundle.getString("InputPetugas.lTitle.text")); // NOI18N

        pData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("InputPetugas.pData.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futured", 1, 12))); // NOI18N

        lNama.setText(bundle.getString("InputPetugas.lNama.text")); // NOI18N

        lUname.setText(bundle.getString("InputPetugas.lUname.text")); // NOI18N

        lTPS.setText(bundle.getString("InputPetugas.lTPS.text")); // NOI18N

        lType.setText(bundle.getString("InputPetugas.lType.text")); // NOI18N

        fTps.setEditable(false);

        aType.add(rSU);
        rSU.setText(bundle.getString("InputPetugas.rSU.text")); // NOI18N
        rSU.addActionListener(e -> setAcc());

        aType.add(rReg);
        rReg.setText(bundle.getString("InputPetugas.rReg.text")); // NOI18N
        rReg.addActionListener(e -> setAcc());

        aType.add(rOp);
        rOp.setText(bundle.getString("InputPetugas.rOp.text")); // NOI18N
        rOp.addActionListener(e -> setAcc());

        aType.add(rAu);
        rAu.setText(bundle.getString("InputPetugas.rAu.text")); // NOI18N
        rAu.addActionListener(e -> setAcc());

        sTps.setText("Pilih");
        sTps.addActionListener(e -> ePilih());

        javax.swing.GroupLayout pDataLayout = new javax.swing.GroupLayout(pData);
        pData.setLayout(pDataLayout);
        pDataLayout.setHorizontalGroup(
                pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pDataLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pDataLayout.createSequentialGroup()
                                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lNama, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lUname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(rAu)
                                                        .addComponent(rOp)
                                                        .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(fUname, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                                                .addComponent(fNama))
                                                        .addComponent(rSU)
                                                        .addComponent(rReg))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataLayout.createSequentialGroup()
                                                .addComponent(lTPS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(fTps)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sTps)))
                                .addContainerGap())
        );
        pDataLayout.setVerticalGroup(
                pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pDataLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lNama)
                                        .addComponent(fNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lUname))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lType)
                                        .addComponent(rSU))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rReg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rOp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rAu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lTPS)
                                        .addComponent(fTps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sTps))
                                .addContainerGap(51, Short.MAX_VALUE))
        );

        bSave.setText(bundle.getString("InputPetugas.bSave.text")); // NOI18N
        bSave.addActionListener(e -> eSave());

        bCancel.setText(bundle.getString("InputPetugas.bCancel.text")); // NOI18N
        bCancel.addActionListener(e -> dispose());

        pFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, bundle.getString("InputPetugas.pFoto.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futured", 1, 12))); // NOI18N

        javax.swing.GroupLayout panelFoto1Layout = new javax.swing.GroupLayout(panelFoto1);
        panelFoto1.setLayout(panelFoto1Layout);
        panelFoto1Layout.setHorizontalGroup(
                panelFoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        panelFoto1Layout.setVerticalGroup(
                panelFoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        bSearch.setText(bundle.getString("InputPetugas.bSearch.text")); // NOI18N
        bSearch.setToolTipText("Type jpg|png|bmp");
        bSearch.addActionListener(e -> cCari());

        bCapture.setText(bundle.getString("InputPetugas.bCapture.text")); // NOI18N
        bCapture.addActionListener(e -> eCapture());

        javax.swing.GroupLayout pFotoLayout = new javax.swing.GroupLayout(pFoto);
        pFoto.setLayout(pFotoLayout);
        pFotoLayout.setHorizontalGroup(
                pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pFotoLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                        .addComponent(bCapture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pFotoLayout.createSequentialGroup()
                                                .addComponent(fFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bSearch)))
                                .addContainerGap())
        );
        pFotoLayout.setVerticalGroup(
                pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pFotoLayout.createSequentialGroup()
                                .addComponent(panelFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bSearch)
                                        .addComponent(fFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bCapture)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(pData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bSave)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bCancel)))
                                .addContainerGap())
                        .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bSave)
                                        .addComponent(bCancel))
                                .addContainerGap())
        );

        setSize(new java.awt.Dimension(576, 389));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void eSave() {//GEN-FIRST:event_eSave
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if (isValidated()) {
            if (image != null) {
                foto = UploadImg.uploadImage(image, "admin", fUname.getText());
            }
            if (admin == null) {
                if (ss.logIn(fUname.getText()) != null) {
                    JOptionPane.showMessageDialog(this,
                            "Nama Pengguna Sudah Terdaftar", "Data Sudah Ada", JOptionPane.ERROR_MESSAGE);
                } else {
                    ss.saveAdmin(setPetugas());
                    ss.makeLog(DataLogger.makeLog(setPetugas(), DataLogger.ADD));
                    dispose();
                }
            } else {
                ss.updateAdmin(setPetugas());
                c = 1;
                ss.makeLog(DataLogger.makeLog(setPetugas(), DataLogger.EDIT));
                dispose();
            }
        }// </editor-fold>
    }//GEN-LAST:event_eSave

    private void cCari() {//GEN-FIRST:event_cCari
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileNameExtensionFilter("jpg", "jpg"));
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                image = ImageIO.read(file);
                panelFoto1.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(InputPemilih.class.getName()).log(Level.SEVERE, null, ex);
            }
            fFoto.setText(file.getAbsolutePath());
        }//</editor-fold>
    }//GEN-LAST:event_cCari

    private void eCapture() {//GEN-FIRST:event_eCapture
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        CaptureDialog ca = new CaptureDialog(this);
        bCapture.setEnabled(false);
        if (ca.getImage() != null) {
            image = ca.getImage();
        }
        bCapture.setEnabled(true);
        panelFoto1.setImage(image);//</editor-fold>
    }//GEN-LAST:event_eCapture

    private void ePilih() {//GEN-FIRST:event_ePilih
        GetTPS g = new GetTPS(this);
        tps = g.getTps();
        String text = "";
        if (tps != null) {
            text = tps.getCode();
        }
        fTps.setText(text);
    }//GEN-LAST:event_ePilih

    private void initData(Admin a) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        setTitle(s);
        fUname.setEditable(false);
        fUname.setText(a.getUsername());
        fNama.setText(a.getNama());
        if (a.getTpsCode() != null) {
            fTps.setText(a.getTpsCode().toString());
        }
        loadImage(a.getFoto());
        selectAcc(a.getAcc());
        editAcc(isEdited(s));
        //</editor-fold>
    }

    private void loadImage(String s) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if (s != null) {
            s = s.replace("address", MainUi.getAppsIp());
            try {
                URL url = new URL(s);
                image = ImageIO.read(url);
                panelFoto1.setImage(image);
            } catch (IOException e) {
            }
        } else {
            panelFoto1.setImage(null);
        }//</editor-fold>
    }

    private Admin setPetugas() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if (admin == null) {
            String password = new MD5(fUname.getText()).asHex();
            admin = new Admin(fUname.getText(), fNama.getText(), password, acc, foto);
        } else {
            admin.setFoto(foto);
            admin.setNama(fNama.getText());
            if (s == 0) {
                admin.setAcc(acc);
            }
        }
        if (tps != null) {
            admin.setTpsCode(tps);
        }
        return admin;//</editor-fold>
    }

    private void setTitle(int i) {
        switch (i) {
            case 0:
                lTitle.setText("Edit Petugas");
            default:
                lTitle.setText("Edit Profile");
        }
    }

    private void selectAcc(Acc ac) {
        switch (ac.getId()) {
            case "Auditor" ->
                rAu.setSelected(true);
            case "Operator" ->
                rOp.setSelected(true);
            case "Registrator" ->
                rReg.setSelected(true);
            default ->
                rSU.setSelected(true);
        }
    }

    private void setAcc() {
        Object[] o = {rAu, rOp, rReg, rSU};
        javax.swing.JRadioButton b;
        for (Object r : o) {
            b = (javax.swing.JRadioButton) r;
            if (b.isSelected()) {
                acc = ss.getAcc(b.getText());
                break;
            }
        }
    }

    private void editAcc(boolean edited) {
        Object[] o = {rAu, rOp, rReg, rSU};
        for (Object ac : o) {
            ((javax.swing.JRadioButton) ac).setEnabled(edited);
        }
    }

    private boolean isEdited(int i) {
        return i == 0;
    }

    private boolean isValidated() {
        Object[] fields = {fNama, fUname};
        String[] labels = {"Nama Lengkap", "Nama Pengguna"};
        boolean b = true;
        int i = 0;
        for (Object f : fields) {
            javax.swing.JTextField tf = (javax.swing.JTextField) f;
            if (tf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        labels[i] + " Harus Diisi", "Field Harus Diisi", JOptionPane.ERROR_MESSAGE);
                tf.requestFocus();
                b = false;
                break;
            }
            i++;
        }
        if (aType.getSelection() == null && b == true) {
            JOptionPane.showMessageDialog(this,
                    "Type Petugas Harus Dipilih", "Field Harus Diisi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return b;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup aType;
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bCapture;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bSearch;
    private javax.swing.JTextField fFoto;
    public static javax.swing.JTextField fNama;
    public static javax.swing.JTextField fTps;
    public static javax.swing.JTextField fUname;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lNama;
    private javax.swing.JLabel lTPS;
    public static javax.swing.JLabel lTitle;
    private javax.swing.JLabel lType;
    private javax.swing.JLabel lUname;
    public static javax.swing.JPanel pData;
    private javax.swing.JPanel pFoto;
    private com.voting.ui.panel.PanelFoto panelFoto1;
    private javax.swing.JRadioButton rAu;
    private javax.swing.JRadioButton rOp;
    private javax.swing.JRadioButton rReg;
    private javax.swing.JRadioButton rSU;
    private javax.swing.JButton sTps;
    // End of variables declaration//GEN-END:variables
}
