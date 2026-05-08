/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.ui.master.dialog;
import com.voting.ui.frame.dialog.CaptureDialog;
import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;
import com.voting.model.master.pemilih.Difabel;
import com.voting.model.master.pemilih.Status;
import com.voting.service.MasterService;
import com.voting.service.SecurityService;
import com.voting.ui.frame.MainUi;
import com.voting.ui.frame.dialog.GetTPS;
import com.voting.ui.master.PemilihPanel;
import com.voting.util.DataLogger;
import com.voting.util.UploadImg;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static java.time.LocalDate.now;

public class InputPemilih extends javax.swing.JFrame {
    private BufferedImage image;
    Pemilih pemilih;
    String foto;
    Tps tps;
    MasterService ms = MainUi.getMasterService();
    SecurityService ss = MainUi.getSecurityService();
    
    //TpsList tList;
    public InputPemilih(Tps t){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        initComponents();
        if(t!=null){tps=t;loadTps(t);tpsIsSet();}// </editor-fold>
    }
    public InputPemilih(Pemilih p){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        initComponents();pemilih=p;
        initData(pemilih);tpsIsSet();// </editor-fold>
    }
    private void age_calc(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">    
        if(fTglLahir.getDate()!=null){
            Date birth = fTglLahir.getDate();
            LocalDate brth = birth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int age = Period.between(brth, now()).getYears();
            fUmur.setText(""+age);
        }else{
            fUmur.setText("");
        }// </editor-fold>
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lTitle = new javax.swing.JLabel();
        pData = new javax.swing.JPanel();
        lInduk = new javax.swing.JLabel();
        fInduk = new javax.swing.JTextField();
        lNama = new javax.swing.JLabel();
        fNama = new javax.swing.JTextField();
        lAlamat = new javax.swing.JLabel();
        rL = new javax.swing.JRadioButton();
        rP = new javax.swing.JRadioButton();
        lJenisK = new javax.swing.JLabel();
        cDifabel = new javax.swing.JComboBox<>();
        lDisabilitas = new javax.swing.JLabel();
        lKk = new javax.swing.JLabel();
        fKk = new javax.swing.JTextField();
        lTlahir = new javax.swing.JLabel();
        fTlahir = new javax.swing.JTextField();
        lUmur = new javax.swing.JLabel();
        fUmur = new javax.swing.JTextField();
        lDukuh = new javax.swing.JLabel();
        fAlamat = new javax.swing.JTextField();
        lRt = new javax.swing.JLabel();
        fRt = new javax.swing.JTextField();
        lRw = new javax.swing.JLabel();
        fRw = new javax.swing.JTextField();
        lStat = new javax.swing.JLabel();
        cStatus = new javax.swing.JComboBox<>();
        lLkl = new javax.swing.JLabel();
        fLkl = new javax.swing.JTextField();
        fTglLahir = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        fTps = new javax.swing.JTextField();
        btnPilih = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        pFoto = new javax.swing.JPanel();
        fFoto = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        bCapture = new javax.swing.JButton();
        panelFoto1 = new com.voting.ui.panel.PanelFoto();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.title")); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 367));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                wExit(evt);
            }
        });

        lTitle.setFont(new java.awt.Font("Futured", 1, 24)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lTitle.txt")); // NOI18N

        pData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.pData.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futured", 1, 12))); // NOI18N

        lInduk.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lInduk.text")); // NOI18N

        lNama.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lNama.text")); // NOI18N

        lAlamat.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lAlamat.text")); // NOI18N

        buttonGroup1.add(rL);
        rL.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.rL.text")); // NOI18N

        buttonGroup1.add(rP);
        rP.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.rP.text")); // NOI18N

        lJenisK.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lJenisK.text")); // NOI18N

        List<Difabel> dif= MainUi.getMasterService().getAllDifabel();
        cDifabel.setModel(new DefaultComboBoxModel<Difabel>(dif.toArray(new Difabel[0])));

        lDisabilitas.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lDisabilitas.text")); // NOI18N

        lKk.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lKk.text")); // NOI18N

        lTlahir.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lTlahir.text")); // NOI18N

        lUmur.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lUmur.text")); // NOI18N

        fUmur.setEditable(false);
        fUmur.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        lDukuh.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lDukuh.text")); // NOI18N

        lRt.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lRt.text")); // NOI18N

        lRw.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lRw.text")); // NOI18N

        lStat.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.lStat.text")); // NOI18N

        List<Status> stat= MainUi.getMasterService().getAllStatus();
        cStatus.setModel(new DefaultComboBoxModel<Status>(stat.toArray(new Status[0])));

        lLkl.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.Lkll.text")); // NOI18N

        fTglLahir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fTglLahirPropertyChange(evt);
            }
        });

        jLabel1.setText("Kode TPS");

        fTps.setEditable(false);

        btnPilih.setText("Pilih");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ePilih(evt);
            }
        });

        javax.swing.GroupLayout pDataLayout = new javax.swing.GroupLayout(pData);
        pData.setLayout(pDataLayout);
        pDataLayout.setHorizontalGroup(
            pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataLayout.createSequentialGroup()
                        .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNama)
                            .addComponent(lInduk)
                            .addComponent(lAlamat)
                            .addComponent(lTlahir)
                            .addComponent(lStat)
                            .addComponent(lJenisK)
                            .addComponent(lKk))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDataLayout.createSequentialGroup()
                                .addComponent(rL)
                                .addGap(28, 28, 28)
                                .addComponent(rP))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataLayout.createSequentialGroup()
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fTlahir, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pDataLayout.createSequentialGroup()
                                        .addComponent(lUmur)
                                        .addGap(18, 18, 18)
                                        .addComponent(fUmur))))
                            .addComponent(fInduk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fKk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataLayout.createSequentialGroup()
                        .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDataLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lDukuh)
                                    .addComponent(lRt)))
                            .addComponent(lDisabilitas)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataLayout.createSequentialGroup()
                                .addComponent(fTps)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPilih))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataLayout.createSequentialGroup()
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cDifabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fRt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lRw)
                                    .addComponent(lLkl))
                                .addGap(18, 18, 18)
                                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fLkl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fRw, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fAlamat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pDataLayout.setVerticalGroup(
            pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataLayout.createSequentialGroup()
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lKk)
                    .addComponent(fKk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInduk)
                    .addComponent(fInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNama)
                    .addComponent(fNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lTlahir)
                        .addComponent(fTlahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fTglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lStat)
                    .addComponent(cStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lUmur)
                    .addComponent(fUmur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lJenisK, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(lAlamat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDukuh)
                    .addComponent(fAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lRt)
                    .addComponent(fRw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fRt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lRw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDisabilitas)
                    .addComponent(cDifabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lLkl)
                    .addComponent(fLkl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fTps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPilih))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bSave.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.bSave.text")); // NOI18N
        bSave.setToolTipText("Simpan");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eSave(evt);
            }
        });

        bCancel.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.bCancel.text")); // NOI18N
        bCancel.setToolTipText("Batal");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eExit(evt);
            }
        });

        pFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.pFoto.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futured", 1, 12))); // NOI18N

        fFoto.setEditable(false);

        bCari.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.bCari.text")); // NOI18N
        bCari.setToolTipText("Cari Foto");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCari(evt);
            }
        });

        bCapture.setText(org.openide.util.NbBundle.getMessage(InputPemilih.class, "InputPemilih.bCapture.text")); // NOI18N
        bCapture.setToolTipText("Ambil Foto");
        bCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCapture(evt);
            }
        });

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

        javax.swing.GroupLayout pFotoLayout = new javax.swing.GroupLayout(pFoto);
        pFoto.setLayout(pFotoLayout);
        pFotoLayout.setHorizontalGroup(
            pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(bCapture, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addGroup(pFotoLayout.createSequentialGroup()
                        .addComponent(fFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bCari)))
                .addContainerGap())
        );
        pFotoLayout.setVerticalGroup(
            pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCapture))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSave)
                    .addComponent(bCancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void eExit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eExit
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        dispose();
        // </editor-fold>
    }//GEN-LAST:event_eExit
    private void eSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eSave
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(isValidated()){
            String tpsCode = fTps.getText();
            if(image!=null){
                foto = UploadImg.uploadImage(image,"pemilih",fInduk.getText());
            }
            if(ms.getTps(tpsCode)==null){ms.saveTps(tps);}
            if(pemilih==null){
                if(ms.getPemilih(fInduk.getText())!=null){
                    JOptionPane.showMessageDialog(this,
                            "Nomor Induk Sudah Terdaftar", "Data Sudah Ada ✔", JOptionPane.ERROR_MESSAGE);
                } else{
                    ms.savePemilih(setPemilih());
                    ss.makeLog(DataLogger.makeLog(setPemilih(), DataLogger.ADD));
                    dispose();
                }
            }else{
                ms.updatePemilih(setPemilih());
                ss.makeLog(DataLogger.makeLog(setPemilih(), DataLogger.EDIT));
                dispose();
            }
        }//</editor-fold>
    }//GEN-LAST:event_eSave
    private void cCari(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCari
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home"));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileNameExtensionFilter("jpg", "jpg"));
        if(chooser.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            File file=chooser.getSelectedFile();
            try {
                image = ImageIO.read(file);
                panelFoto1.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(InputPemilih.class.getName()).log(Level.SEVERE, null, ex);
            }
            fFoto.setText(file.getAbsolutePath());
        }//</editor-fold>
    }//GEN-LAST:event_cCari
    private void eCapture(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eCapture
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        CaptureDialog c = new CaptureDialog(this);
        bCapture.setEnabled(false);
        if(c.getImage()!=null){image = c.getImage();}
        bCapture.setEnabled(true);
        panelFoto1.setImage(image);//</editor-fold>
    }//GEN-LAST:event_eCapture
    private void fTglLahirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fTglLahirPropertyChange
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        age_calc();//</editor-fold>
    }//GEN-LAST:event_fTglLahirPropertyChange
    private void wExit(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_wExit
        PemilihPanel.refresh();
    }//GEN-LAST:event_wExit

    private void ePilih(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ePilih
        GetTPS g = new GetTPS(this);
        tps = g.getTps();String text="";
        if(tps!=null){text=tps.getCode();}
        fTps.setText(text);
    }//GEN-LAST:event_ePilih
    
    private void initData(Pemilih p){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        fKk.setText(p.getNoKk());fInduk.setText(p.getInduk());
        fKk.setEditable(false);fInduk.setEditable(false);
        cDifabel.setSelectedItem(p.getDifableCode());
        if(p.getJenisKelamin().equalsIgnoreCase("L")){rL.setSelected(true);}else{rP.setSelected(true);}
        cStatus.setSelectedItem(p.getStatusCode());
        fNama.setText(p.getNama());fTlahir.setText(p.getTLahir());
        fTglLahir.setDate(p.getTglLahir());fUmur.setText(""+p.getUmur()+"");
        fAlamat.setText(p.getAlamat());fRt.setText(p.getRt());
        fRw.setText(p.getRw());fLkl.setText(p.getIdLkl());
        loadTps(p.getTpsCode());loadImage(p.getFoto());
        lTitle.setText("Edit Data Pemilih");//</editor-fold>
    }    
    private void loadTps(Tps t){
        tps=t;fTps.setText(t.getCode());
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">//</editor-fold>
    }
    private void tpsIsSet(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        btnPilih.setEnabled(false);// </editor-fold>
    }
    private void loadImage(String s){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(s!=null){
            s=s.replace("address", MainUi.getAppsIp());
            try{
                URL url = new URL(s);
                image = ImageIO.read(url);
                panelFoto1.setImage(image);
            } catch (IOException e) {
            }
        } else{
            panelFoto1.setImage(null);
        }//</editor-fold>
    }
    private Pemilih setPemilih(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        String jk="L";if(rP.isSelected()){jk="P";}
        return new Pemilih(fInduk.getText(), fKk.getText(), fNama.getText(), fTlahir.getText(), fTglLahir.getDate(), Integer.parseInt(fUmur.getText()),
            jk, fAlamat.getText(), fRt.getText(), fRw.getText(), fLkl.getText(), 0,
            (Status)cStatus.getSelectedItem(), (Difabel)cDifabel.getSelectedItem(), tps, foto);//</editor-fold>
    }    
    private boolean isValidated(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        Object[] fields = {fKk,fInduk,fNama,fTlahir,fAlamat,fRt,fRw};
        String[] labels = {"No. KK","NIK","Nama Lengkap","Tempat Lahir","Dukuh/Jalan","RT","RW"};
        boolean b=true;int i=0;
        for(Object f : fields){
            javax.swing.JTextField tf = (javax.swing.JTextField) f;
            if(tf.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,
                    labels[i]+" Harus Diisi", "Field Harus Diisi", JOptionPane.ERROR_MESSAGE);
                tf.requestFocus();
                b=false;break;
            }i++;
        }
        if(buttonGroup1.getSelection()==null && b==true){
            JOptionPane.showMessageDialog(this,
                "Jenis Kelamin Harus Dipilih", "Field Harus Diisi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(fTglLahir.getDate() == null && b==true){
            JOptionPane.showMessageDialog(this,
                "Tanggal Lahir Harus Diisi","Field Harus Diisi", JOptionPane.ERROR_MESSAGE);
            fTglLahir.requestFocus();
            return false;
        }
        if(Integer.valueOf(fUmur.getText()) <= 16 && b==true){
            JOptionPane.showMessageDialog(this,
                "Umur Kurang dari 17 Tahun","Umur Tidak Memenuhi", JOptionPane.ERROR_MESSAGE);
            fUmur.requestFocus();
            return false;
        }
        if(tps == null){
            JOptionPane.showMessageDialog(this,
                "TPS Belum Dipilih","Field Harus Diisi", JOptionPane.ERROR_MESSAGE);
            fTps.requestFocus();
            return false;
        }
        return b;//</editor-fold>
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    public javax.swing.JButton bCapture;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bSave;
    private javax.swing.JButton btnPilih;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Difabel> cDifabel;
    private javax.swing.JComboBox<Status> cStatus;
    private javax.swing.JTextField fAlamat;
    private javax.swing.JTextField fFoto;
    private javax.swing.JTextField fInduk;
    private javax.swing.JTextField fKk;
    private javax.swing.JTextField fLkl;
    private javax.swing.JTextField fNama;
    private javax.swing.JTextField fRt;
    private javax.swing.JTextField fRw;
    private com.toedter.calendar.JDateChooser fTglLahir;
    private javax.swing.JTextField fTlahir;
    private javax.swing.JTextField fTps;
    private javax.swing.JTextField fUmur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lAlamat;
    private javax.swing.JLabel lDisabilitas;
    private javax.swing.JLabel lDukuh;
    private javax.swing.JLabel lInduk;
    private javax.swing.JLabel lJenisK;
    private javax.swing.JLabel lKk;
    private javax.swing.JLabel lLkl;
    private javax.swing.JLabel lNama;
    private javax.swing.JLabel lRt;
    private javax.swing.JLabel lRw;
    private javax.swing.JLabel lStat;
    private javax.swing.JLabel lTitle;
    private javax.swing.JLabel lTlahir;
    private javax.swing.JLabel lUmur;
    private javax.swing.JPanel pData;
    private javax.swing.JPanel pFoto;
    private com.voting.ui.panel.PanelFoto panelFoto1;
    private javax.swing.JRadioButton rL;
    private javax.swing.JRadioButton rP;
    // End of variables declaration//GEN-END:variables
}
