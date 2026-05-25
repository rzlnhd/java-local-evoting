/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.ui.master;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;

import com.voting.model.master.Tps;
import com.voting.service.MasterService;
import com.voting.service.SecurityService;
import com.voting.ui.frame.MainUi;
import com.voting.ui.master.dialog.InputTps;
import com.voting.ui.master.dialog.ViewTps;
import com.voting.util.DataLogger;

/**
 *
 * @author Rizal
 */
public class TpsPanel extends javax.swing.JInternalFrame {

    private final ResourceBundle bundle = ResourceBundle.getBundle("com.voting.ui.master.Bundle");
    private static List<Tps> tpss;
    private Tps tps;
    private long count;
    MasterService ms = MainUi.getMasterService();
    SecurityService ss = MainUi.getSecurityService();

    /**
     * Creates new form TPSPanel
     */
    public TpsPanel() {
        initComponents();
        initListener();
        loadData();
    }

    private void initListener() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        tData.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (tData.getSelectedRow() >= 0) {
                int indexModel = tData.convertRowIndexToModel(tData.getSelectedRow());
                count = (long) tData.getValueAt(tData.getSelectedRow(), 7);
                tps = tpss.get(indexModel);
                panelTombol1.Terpilih(true);
                if (count != 0) {
                    panelTombol1.getBtnDelete().setEnabled(false);
                }
            }
        });
        panelTombol1.getBtnExit().addActionListener((ActionEvent e) -> {
            dispose();
        });
        panelTombol1.getBtnNew().addActionListener((ActionEvent e) -> {
            InputTps ts = new InputTps();
            ts.setVisible(true);
            panelTombol1.Disable();
        });
        panelTombol1.getBtnView().addActionListener((ActionEvent e) -> {
            ViewTps view = new ViewTps();
            panelTombol1.Disable();
            int data = view.setData(tps, count);
            if (data == 0) {
                panelTombol1.Terpilih(true);
            }
        });
        panelTombol1.getBtnEdit().addActionListener((ActionEvent e) -> {
            InputTps ts = new InputTps(tps);
            ts.setVisible(true);
            panelTombol1.Disable();
        });
        panelTombol1.getBtnDelete().addActionListener((ActionEvent e) -> {
            panelTombol1.Disable();
            int Pilih = JOptionPane.showConfirmDialog(this, "Apakah anda yakin akan menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (Pilih == JOptionPane.YES_OPTION) {
                ms.deleteTps(tps);
                refresh();
                ss.makeLog(DataLogger.makeLog(tps, DataLogger.DEL));
                JOptionPane.showMessageDialog(this, "PENGHAPUSAN BERHASIL");
            } else {
                panelTombol1.Terpilih(true);
            }
        });
        panelTombol1.getBtnCancel().addActionListener((ActionEvent e) -> {
            tData.clearSelection();
            tps = null;
            panelTombol1.Terpilih(false);
        });// </editor-fold>
    }

    private static void loadData() {
        tpss = MainUi.getMasterService().getAllTps();
        tData.setModel(new TpsModel(tpss));
    }

    private static class TpsModel extends AbstractTableModel {

        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        private List<Tps> tpsModel = new ArrayList<>();

        public TpsModel(List<Tps> tpsModel) {
            this.tpsModel = tpsModel;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return tpsModel.size();
        }

        @Override
        public int getColumnCount() {
            return 8;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Tps t = tpsModel.get(rowIndex);
            return switch (columnIndex) {
                case 0 ->
                    t.getProvCode();
                case 1 ->
                    t.getKabCode();
                case 2 ->
                    t.getKecCode();
                case 3 ->
                    t.getDesCode();
                case 4 ->
                    "<HTML>" + t.getDesk().replaceAll("\n", " ") + "</HTML>";
                case 5 ->
                    t.getNo();
                case 6 ->
                    t.getCode();
                case 7 ->
                    countP(t);
                default ->
                    "";
            };
        }// </editor-fold>
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tData = new javax.swing.JTable();
        sType = new javax.swing.JComboBox<>();
        iForm = new javax.swing.JTextField();
        bRefresh = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        panelTombol1 = new com.voting.ui.panel.PanelTombol();

        setTitle(bundle.getString("TpsPanel.title")); // NOI18N

        lTitle.setFont(new java.awt.Font("Futured", 1, 24)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText(bundle.getString("TpsPanel.lTitle.text")); // NOI18N

        tData.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Provinsi", "Kabupaten", "Kecamatan", "Desa/Kelurahan", "Deskripsi", "Nomor", "Kode TPS", "Jumlah DPT"
                }
        ));
        jScrollPane1.setViewportView(tData);
        if (tData.getColumnModel().getColumnCount() > 0) {
            tData.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("TpsPanel.tData.columnModel.title0_1")); // NOI18N
            tData.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("TpsPanel.tData.columnModel.title1_1")); // NOI18N
            tData.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("TpsPanel.tData.columnModel.title2_1")); // NOI18N
            tData.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("TpsPanel.tData.columnModel.title3_1")); // NOI18N
            tData.getColumnModel().getColumn(4).setHeaderValue(bundle.getString("TpsPanel.tData.columnModel.title7")); // NOI18N
            tData.getColumnModel().getColumn(5).setMinWidth(75);
            tData.getColumnModel().getColumn(5).setMaxWidth(75);
            tData.getColumnModel().getColumn(5).setHeaderValue(bundle.getString("TpsPanel.tData.columnModel.title4_1")); // NOI18N
            tData.getColumnModel().getColumn(6).setMinWidth(120);
            tData.getColumnModel().getColumn(6).setMaxWidth(120);
            tData.getColumnModel().getColumn(6).setHeaderValue(bundle.getString("TpsPanel.tData.columnModel.title5_1")); // NOI18N
            tData.getColumnModel().getColumn(7).setMinWidth(100);
            tData.getColumnModel().getColumn(7).setMaxWidth(100);
            tData.getColumnModel().getColumn(7).setHeaderValue(bundle.getString("TpsPanel.tData.columnModel.title6_1")); // NOI18N
        }
        tData.setAutoCreateColumnsFromModel(false);

        sType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Provinsi", "Kabupaten", "Kecamatan", "Desa/Kelurahan", "Kode TPS", "Deskripsi"}));
        sType.addActionListener(e -> search());

        iForm.addActionListener(e -> search());
        iForm.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search();
            }
        });

        bRefresh.setText(bundle.getString("TpsPanel.bRefresh.text")); // NOI18N
        bRefresh.addActionListener(e -> refresh());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(sType, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(iForm)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bRefresh))
                                        .addComponent(panelTombol1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(iForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bRefresh))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelTombol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void refresh() {
        panelTombol1.Terpilih(false);
        iForm.setText(null);
        sType.setSelectedIndex(0);
        loadData();
    }

    private static long countP(Tps t) {
        return MainUi.getMasterService().countT(t);
    }

    private void search() {
        tpss = MainUi.getMasterService().searchTps(sType.getSelectedIndex(), iForm.getText());
        tData.setModel(new TpsModel(tpss));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRefresh;
    private static javax.swing.JTextField iForm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lTitle;
    private static com.voting.ui.panel.PanelTombol panelTombol1;
    private static javax.swing.JComboBox<String> sType;
    private static javax.swing.JTable tData;
    // End of variables declaration//GEN-END:variables
}
