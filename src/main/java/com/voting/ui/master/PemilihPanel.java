/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.ui.master;

import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;
import com.voting.service.MasterService;
import com.voting.service.SecurityService;
import com.voting.ui.frame.MainUi;
import com.voting.ui.master.dialog.InputPemilih;
import com.voting.ui.master.dialog.ViewPemilih;
import com.voting.util.DataLogger;
import com.voting.util.UploadImg;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rizal
 */
public class PemilihPanel extends javax.swing.JInternalFrame {
    
    private static List<Pemilih> pemilihs;
    private Pemilih pemilih;
    private static Tps tps;
    int urut;
    MasterService ms = MainUi.getMasterService();
    SecurityService ss = MainUi.getSecurityService();

    /**
     * Creates new form PemilihPanel
     */
    public PemilihPanel() {
        initComponents();initListener();loadData();
    }
        
    private void initListener() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        tData.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(tData.getSelectedRow()>=0){
                int indexModel = tData.convertRowIndexToModel(tData.getSelectedRow());
                urut = (int) tData.getValueAt(tData.getSelectedRow(),0);
                pemilih = pemilihs.get(indexModel);
                panelTombol1.Terpilih(true);
            }
        });
        panelTombol1.getBtnExit().addActionListener((ActionEvent e) -> {
            dispose();
        });
        panelTombol1.getBtnNew().addActionListener((ActionEvent e) -> {
            InputPemilih pem = new InputPemilih(tps);
            pem.setVisible(true);
            panelTombol1.Disable();
        });
        panelTombol1.getBtnView().addActionListener((ActionEvent e) ->{
            ViewPemilih view = new ViewPemilih();
            panelTombol1.Disable();
            int data = view.setData(pemilih,urut);
            if(data == 0){
                panelTombol1.Terpilih(true);
            }
        });
        panelTombol1.getBtnEdit().addActionListener((ActionEvent e) -> {
            InputPemilih pem = new InputPemilih(pemilih);
            pem.setVisible(true);
            panelTombol1.Disable();
        });
        panelTombol1.getBtnDelete().addActionListener((ActionEvent e) ->{
            panelTombol1.Disable();
            int Pilih = JOptionPane.showConfirmDialog(this,"Apakah anda yakin akan menghapus data ini?","Konfirmasi",JOptionPane.YES_NO_OPTION);
            if(Pilih == JOptionPane.YES_OPTION){
                ms.deletePemilih(pemilih);UploadImg.deletePhoto(pemilih.getFoto());refresh();
                ss.makeLog(DataLogger.makeLog(pemilih, DataLogger.DEL));
                JOptionPane.showMessageDialog(this,"PENGHAPUSAN BERHASIL");
            } else{
                panelTombol1.Terpilih(true);
            }
        });
        panelTombol1.getBtnCancel().addActionListener((ActionEvent e) ->{
            tData.clearSelection();pemilih = null;panelTombol1.Terpilih(false);
        });// </editor-fold>
    }
    
    private static void loadData(){
        if(tps==null){
            pemilihs = MainUi.getMasterService().getAllPemilih();
        } else{
            pemilihs = MainUi.getMasterService().getAllPemilih(tps);            
        }
        tData.setModel(new PemilihModel(pemilihs));
    }

    private static class PemilihModel extends AbstractTableModel{
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        private List<Pemilih> pemilihModel = new ArrayList();

        public PemilihModel(List<Pemilih> pemilihModel) {
            this.pemilihModel = pemilihModel;
            fireTableDataChanged();
        }
        @Override
        public int getRowCount() {
            return pemilihModel.size();
        }
        @Override
        public int getColumnCount() {
            return 13;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Pemilih p = pemilihModel.get(rowIndex);
            switch(columnIndex){
                case 0 : return rowIndex+1;
                case 1 : return p.getNoKk();
                case 2 : return p.getInduk();
                case 3 : return p.getNama();
                case 4 : return p.getTLahir();
                case 5 : return p.getTglLahir();
                case 6 : return p.getUmur();
                case 7 : return p.getStatusCode();
                case 8 : return p.getJenisKelamin();
                case 9 : return p.getAlamat();
                case 10 : return p.getRt();
                case 11 : return p.getRw();
                case 12 : return p.getDifableCode();
                case 13 : return p.getIdLkl();
                default : return "";
            }
        }// </editor-fold>
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tps = MainUi.getTps();
        pPemilih = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tData = new javax.swing.JTable();
        sType = new javax.swing.JComboBox<>();
        iForm = new javax.swing.JTextField();
        bRefresh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        panelTombol1 = new com.voting.ui.panel.PanelTombol();

        setTitle(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.title")); // NOI18N

        lTitle.setFont(new java.awt.Font("Futured", 1, 24)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.lTitle.text")); // NOI18N

        tData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "No. KK", "NIK", "Nama Lengkap", "Tempat Lahir", "Tanggal Lahir", "Umur", "Status Perkawinan", "Jenis Kelamin", "Alamat", "RT", "RW", "Difabilitas", "ID_LKL"
            }
        ));
        jScrollPane1.setViewportView(tData);
        if (tData.getColumnModel().getColumnCount() > 0) {
            tData.getColumnModel().getColumn(0).setMinWidth(30);
            tData.getColumnModel().getColumn(0).setMaxWidth(30);
            tData.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title13")); // NOI18N
            tData.getColumnModel().getColumn(1).setMinWidth(150);
            tData.getColumnModel().getColumn(1).setMaxWidth(150);
            tData.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title0")); // NOI18N
            tData.getColumnModel().getColumn(2).setMinWidth(150);
            tData.getColumnModel().getColumn(2).setMaxWidth(150);
            tData.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title1")); // NOI18N
            tData.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title2")); // NOI18N
            tData.getColumnModel().getColumn(4).setMinWidth(100);
            tData.getColumnModel().getColumn(4).setMaxWidth(250);
            tData.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title3")); // NOI18N
            tData.getColumnModel().getColumn(5).setMinWidth(100);
            tData.getColumnModel().getColumn(5).setMaxWidth(250);
            tData.getColumnModel().getColumn(5).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title4")); // NOI18N
            tData.getColumnModel().getColumn(6).setMaxWidth(45);
            tData.getColumnModel().getColumn(6).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title10")); // NOI18N
            tData.getColumnModel().getColumn(7).setMinWidth(120);
            tData.getColumnModel().getColumn(7).setMaxWidth(120);
            tData.getColumnModel().getColumn(7).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title5")); // NOI18N
            tData.getColumnModel().getColumn(8).setMaxWidth(70);
            tData.getColumnModel().getColumn(8).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title6")); // NOI18N
            tData.getColumnModel().getColumn(9).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title7")); // NOI18N
            tData.getColumnModel().getColumn(10).setMaxWidth(35);
            tData.getColumnModel().getColumn(10).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title8")); // NOI18N
            tData.getColumnModel().getColumn(11).setMaxWidth(35);
            tData.getColumnModel().getColumn(11).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title9")); // NOI18N
            tData.getColumnModel().getColumn(12).setMinWidth(100);
            tData.getColumnModel().getColumn(12).setMaxWidth(100);
            tData.getColumnModel().getColumn(12).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title11")); // NOI18N
            tData.getColumnModel().getColumn(13).setMaxWidth(60);
            tData.getColumnModel().getColumn(13).setHeaderValue(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.tData.columnModel.title12")); // NOI18N
        }
        tData.setAutoCreateColumnsFromModel(false);

        sType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No. KK", "NIK", "Nama", "Alamat" }));
        sType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCari(evt);
            }
        });

        iForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCari(evt);
            }
        });
        iForm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kCari(evt);
            }
        });

        bRefresh.setText(org.openide.util.NbBundle.getMessage(PemilihPanel.class, "PemilihPanel.bRefresh.text")); // NOI18N
        bRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eRefresh(evt);
            }
        });

        javax.swing.GroupLayout pPemilihLayout = new javax.swing.GroupLayout(pPemilih);
        pPemilih.setLayout(pPemilihLayout);
        pPemilihLayout.setHorizontalGroup(
            pPemilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPemilihLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPemilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pPemilihLayout.createSequentialGroup()
                        .addComponent(sType, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(iForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRefresh))
                    .addComponent(panelTombol1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        pPemilihLayout.setVerticalGroup(
            pPemilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPemilihLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPemilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTombol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPemilih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pPemilih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kCari(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kCari
        search();
    }//GEN-LAST:event_kCari

    private void eCari(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eCari
        search();
    }//GEN-LAST:event_eCari

    private void eRefresh(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eRefresh
        refresh();
    }//GEN-LAST:event_eRefresh
    public static void refresh(){
        panelTombol1.Terpilih(false);
        iForm.setText(null);
        sType.setSelectedIndex(0);
        loadData();
    }
    
    private void search(){
        pemilihs = MainUi.getMasterService().searchPemilih(sType.getSelectedIndex(),iForm.getText());        
        tData.setModel(new PemilihModel(pemilihs));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRefresh;
    private static javax.swing.JTextField iForm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lTitle;
    private javax.swing.JPanel pPemilih;
    private static com.voting.ui.panel.PanelTombol panelTombol1;
    private static javax.swing.JComboBox<String> sType;
    private static javax.swing.JTable tData;
    // End of variables declaration//GEN-END:variables
}
