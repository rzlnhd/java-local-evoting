/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.ui.master.dialog;

import com.voting.ui.frame.dialog.CaptureDialog;
import com.voting.model.master.Calon;
import com.voting.service.MasterService;
import com.voting.service.SecurityService;
import com.voting.ui.frame.MainUi;
import com.voting.ui.master.CalonPanel;
import com.voting.util.DataLogger;
import com.voting.util.UploadImg;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InputCalon extends javax.swing.JFrame {
    private BufferedImage image;
    String foto;
    Calon calon;
    MasterService ms = MainUi.getMasterService();
    SecurityService ss = MainUi.getSecurityService();
    
    public InputCalon() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        initComponents();// </editor-fold>
    }
    public InputCalon(Calon c){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        initComponents();
        calon=c;initData(calon);// </editor-fold>        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lTitle = new javax.swing.JLabel();
        pData = new javax.swing.JPanel();
        lInduk = new javax.swing.JLabel();
        lNama = new javax.swing.JLabel();
        lJenisK = new javax.swing.JLabel();
        lAlamat = new javax.swing.JLabel();
        lAgama = new javax.swing.JLabel();
        fInduk = new javax.swing.JTextField();
        fNama = new javax.swing.JTextField();
        rL = new javax.swing.JRadioButton();
        rP = new javax.swing.JRadioButton();
        cAgama = new javax.swing.JComboBox<>();
        lUrut = new javax.swing.JLabel();
        fUrut = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        fAlamat = new javax.swing.JTextArea();
        bSave = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        pFoto = new javax.swing.JPanel();
        panelFoto1 = new com.voting.ui.panel.PanelFoto();
        bSearch = new javax.swing.JButton();
        fFoto = new javax.swing.JTextField();
        bCapture = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.title")); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                wExit(evt);
            }
        });

        lTitle.setFont(new java.awt.Font("Futured", 1, 24)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.lTitle.text")); // NOI18N

        pData.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.pData.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futured", 1, 12))); // NOI18N

        lInduk.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.lInduk.text")); // NOI18N

        lNama.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.lNama.text")); // NOI18N

        lJenisK.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.lJenisK.text")); // NOI18N

        lAlamat.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.lAlamat.text")); // NOI18N

        lAgama.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.lAgama.text")); // NOI18N

        buttonGroup1.add(rL);
        rL.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.rL.text")); // NOI18N

        buttonGroup1.add(rP);
        rP.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.rP.text")); // NOI18N

        cAgama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Islam", "Kristen Katolik", "Kristen Protestan", "Hindu", "Budha", "Konghuchu" }));

        lUrut.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.lUrut.text")); // NOI18N

        fUrut.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        fAlamat.setColumns(20);
        fAlamat.setRows(5);
        jScrollPane1.setViewportView(fAlamat);

        javax.swing.GroupLayout pDataLayout = new javax.swing.GroupLayout(pData);
        pData.setLayout(pDataLayout);
        pDataLayout.setHorizontalGroup(
            pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lInduk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNama, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lJenisK, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pDataLayout.createSequentialGroup()
                        .addComponent(rL)
                        .addGap(18, 18, 18)
                        .addComponent(rP))
                    .addComponent(fNama, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pDataLayout.createSequentialGroup()
                        .addComponent(cAgama, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lUrut)
                        .addGap(18, 18, 18)
                        .addComponent(fUrut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fInduk, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDataLayout.setVerticalGroup(
            pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lInduk)
                    .addComponent(fInduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lAlamat)
                    .addGroup(pDataLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rL)
                            .addComponent(rP)
                            .addComponent(lJenisK))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lAgama)
                    .addComponent(cAgama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lUrut)
                    .addComponent(fUrut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        bSave.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.bSave.text")); // NOI18N
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eSave(evt);
            }
        });

        bCancel.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.bCancel.text")); // NOI18N
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eExit(evt);
            }
        });

        pFoto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.pFoto.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Futured", 1, 12))); // NOI18N

        javax.swing.GroupLayout panelFoto1Layout = new javax.swing.GroupLayout(panelFoto1);
        panelFoto1.setLayout(panelFoto1Layout);
        panelFoto1Layout.setHorizontalGroup(
            panelFoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelFoto1Layout.setVerticalGroup(
            panelFoto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        bSearch.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.bSearch.text")); // NOI18N
        bSearch.setToolTipText("Type jpg|png|bmp");
        bSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCari(evt);
            }
        });

        bCapture.setText(org.openide.util.NbBundle.getMessage(InputCalon.class, "InputCalon.bCapture.text")); // NOI18N
        bCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCapture(evt);
            }
        });

        javax.swing.GroupLayout pFotoLayout = new javax.swing.GroupLayout(pFoto);
        pFoto.setLayout(pFotoLayout);
        pFotoLayout.setHorizontalGroup(
            pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFotoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(bCapture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pFotoLayout.createSequentialGroup()
                        .addComponent(fFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSearch)))
                .addContainerGap())
        );
        pFotoLayout.setVerticalGroup(
            pFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFotoLayout.createSequentialGroup()
                .addComponent(panelFoto1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
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
                    .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
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

        setSize(new java.awt.Dimension(619, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void eExit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eExit
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        dispose();// </editor-fold>
    }//GEN-LAST:event_eExit
    private void wExit(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_wExit
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        CalonPanel.refresh();// </editor-fold>
    }//GEN-LAST:event_wExit
    private void eSave(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eSave
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(isValidated()){
            if(image!=null){
                foto = UploadImg.uploadImage(image,"calon",fInduk.getText());
            }
            if(calon==null){
                if(ms.getCalon(fInduk.getText())!=null){
                    JOptionPane.showMessageDialog(this,
                            "Nomor Induk Sudah Terdaftar", "Data Sudah Ada", JOptionPane.ERROR_MESSAGE);
                } else if(ms.getCalonFromId(Integer.parseInt(fUrut.getText()))!=null){
                    JOptionPane.showMessageDialog(this,
                            "Nomor Urut Sudah Terdaftar", "Data Sudah Ada", JOptionPane.ERROR_MESSAGE);
                } else {                        
                    ms.saveCalon(setCalon());
                    ss.makeLog(DataLogger.makeLog(setCalon(), DataLogger.ADD));
                    dispose();
                }
            } else{
                ms.updateCalon(setCalon());
                ss.makeLog(DataLogger.makeLog(setCalon(), DataLogger.EDIT));
                dispose();
            }
        }// </editor-fold>
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
    private void initData(Calon c){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        fInduk.setText(c.getInduk());fUrut.setText(""+c.getId());
        fInduk.setEditable(false);fUrut.setEditable(false);
        fNama.setText(c.getNama());fAlamat.setText(c.getAlamat());        
        if(c.getJenisKelamin().equalsIgnoreCase("L")){rL.setSelected(true);}else{rP.setSelected(true);}
        cAgama.setSelectedItem(c.getAgama());loadImage(c.getFoto());
        lTitle.setText("Edit Data Calon");//</editor-fold>
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
    private Calon setCalon(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        String jk="L";if(rP.isSelected()){jk="P";}
        if(calon==null){
            return new Calon(fInduk.getText(), fNama.getText(), fAlamat.getText(), jk,
                    (String)cAgama.getSelectedItem(), Integer.parseInt(fUrut.getText()), foto);
        } else{
            calon.setNama(fNama.getText());calon.setJenisKelamin(jk);
            calon.setAlamat(fAlamat.getText());calon.setFoto(foto);
            calon.setAgama((String)cAgama.getSelectedItem());
            return calon;
        }
        //</editor-fold>
    }
    private boolean isValidated(){
        Object[] fields={fInduk,fNama,fUrut};
        String[] labels={"NIK","Nama Lengkap","No. Urut"};
        boolean b=true;int i=0;
        for(Object f:fields){
            javax.swing.JTextField tf = (javax.swing.JTextField) f;
            if(tf.getText().isEmpty()){
                JOptionPane.showMessageDialog(this,
                    labels[i]+" Harus Diisi", "Field Harus Diisi", JOptionPane.ERROR_MESSAGE);
                tf.requestFocus();
                b=false;break;
            }i++;
        }
        if(fAlamat.getText().isEmpty() && b==true){
            JOptionPane.showMessageDialog(this,
                "Alamat Harus Diisi", "Field Harus Diisi", JOptionPane.ERROR_MESSAGE);
            fAlamat.requestFocus();
            return false;                
        }
        if(buttonGroup1.getSelection()==null && b==true){
            JOptionPane.showMessageDialog(this,
                "Jenis Kelamin Harus Dipilih", "Field Harus Diisi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return b;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bCapture;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bSearch;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JComboBox<String> cAgama;
    private javax.swing.JTextArea fAlamat;
    private javax.swing.JTextField fFoto;
    public static javax.swing.JTextField fInduk;
    public static javax.swing.JTextField fNama;
    public static javax.swing.JTextField fUrut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lAgama;
    private javax.swing.JLabel lAlamat;
    private javax.swing.JLabel lInduk;
    private javax.swing.JLabel lJenisK;
    private javax.swing.JLabel lNama;
    public static javax.swing.JLabel lTitle;
    public static javax.swing.JLabel lUrut;
    public static javax.swing.JPanel pData;
    private javax.swing.JPanel pFoto;
    private com.voting.ui.panel.PanelFoto panelFoto1;
    public static javax.swing.JRadioButton rL;
    public static javax.swing.JRadioButton rP;
    // End of variables declaration//GEN-END:variables
}