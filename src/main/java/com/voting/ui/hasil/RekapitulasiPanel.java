/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.ui.hasil;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.ChartTheme;
import org.openide.util.Exceptions;

import com.voting.model.master.Calon;
import com.voting.ui.frame.MainUi;

/**
 *
 * @author Rizal
 */
public class RekapitulasiPanel extends javax.swing.JInternalFrame {

    private final ResourceBundle bundle = ResourceBundle.getBundle("com.voting.ui.hasil.Bundle");

    private static List<Calon> calons;
    static String[][] dat;
    static String[] col_1 = {"Tidak Hadir", "Hadir", "Jumlah"};
    private static long count;

    /**
     * Creates new form RekapitulasiPanel
     */
    public RekapitulasiPanel() {
        initComponents();
        initListener();
        loadData();
        createChart(calons);
    }

    private void initListener() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        panelTombol1.invis();
        panelTombol1.getBtnNew().setText("Print");
        panelTombol1.getBtnNew().addActionListener((ActionEvent e) -> {
            System.out.println("Not Set");
        });
        panelTombol1.getBtnExit().addActionListener((ActionEvent e) -> {
            dispose();
        });// </editor-fold>
    }

    @SuppressWarnings("empty-statement")
    private static void loadData() {
        for (int i = 0; i < 3; i++) {
            dat[i][0] = col_1[i];
            dat[i][1] = Long.toString(MainUi.getMasterService().countP(i, "L"));
            dat[i][2] = Long.toString(MainUi.getMasterService().countP(i, "P"));
            dat[i][3] = Long.toString(MainUi.getMasterService().countP(i, "0"));
        }
        tData_2.setModel(new HadirModel(dat));
        count = MainUi.getMasterService().countP(1, "0");
        calons = MainUi.getMasterService().getAllCalon();
        tData.setModel(new CalonModel(calons));
    }

    private static class CalonModel extends AbstractTableModel {

        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        private List<Calon> calonModel = new ArrayList<>();

        public CalonModel(List<Calon> calonModel) {
            this.calonModel = calonModel;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return calonModel.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Class<?> getColumnClass(int column) {
            return switch (column) {
                case 1 ->
                    ImageIcon.class;
                default ->
                    String.class;
            };
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Calon c = calonModel.get(rowIndex);
            return switch (columnIndex) {
                case 0 ->
                    c.getId();
                case 1 ->
                    setImage(c.getFoto());
                case 2 ->
                    c.getNama();
                case 3 ->
                    c.getSuara();
                case 4 ->
                    c.getSuara() * 100 / count + " %";
                default ->
                    "";
            };
        }// </editor-fold>
    }

    private static class HadirModel extends AbstractTableModel {

        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        private final String[][] hadirs;

        private HadirModel(String[][] hadirs) {
            this.hadirs = hadirs;
            fireTableDataChanged();
        }

        @Override
        public int getRowCount() {
            return hadirs.length;
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int i, int j) {
            String[] dat = hadirs[i];
            return switch (j) {
                case 0 ->
                    dat[0];
                case 1 ->
                    dat[1];
                case 2 ->
                    dat[2];
                case 3 ->
                    dat[3];
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

        pnlRekap = new javax.swing.JPanel();
        lTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelTombol1 = new com.voting.ui.panel.PanelTombol();
        jScrollPane1 = new javax.swing.JScrollPane();
        tData = new javax.swing.JTable();
        calons = MainUi.getMasterService().getAllCalon();
        pChart = new XChartPanel<>(createChart(calons));
        jScrollPane2 = new javax.swing.JScrollPane();
        tData_2 = new javax.swing.JTable();

        setTitle(bundle.getString("RekapitulasiPanel.title")); // NOI18N

        lTitle.setFont(new java.awt.Font("Futured", 1, 24)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText(bundle.getString("RekapitulasiPanel.lTitle.text")); // NOI18N

        tData.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "No. Urut", "Foto", "Nama Calon", "Suara", "Persentase"
                }
        ));
        jScrollPane1.setViewportView(tData);
        if (tData.getColumnModel().getColumnCount() > 0) {
            tData.getColumnModel().getColumn(0).setMinWidth(60);
            tData.getColumnModel().getColumn(0).setMaxWidth(60);
            tData.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("RekapitulasiPanel.tData.columnModel.title0")); // NOI18N
            tData.getColumnModel().getColumn(1).setMinWidth(90);
            tData.getColumnModel().getColumn(1).setMaxWidth(90);
            tData.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("RekapitulasiPanel.tData.columnModel.title1")); // NOI18N
            tData.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("RekapitulasiPanel.tData.columnModel.title2")); // NOI18N
            tData.getColumnModel().getColumn(3).setMinWidth(80);
            tData.getColumnModel().getColumn(3).setMaxWidth(80);
            tData.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("RekapitulasiPanel.tData.columnModel.title3")); // NOI18N
            tData.getColumnModel().getColumn(4).setMinWidth(80);
            tData.getColumnModel().getColumn(4).setMaxWidth(80);
            tData.getColumnModel().getColumn(4).setHeaderValue(bundle.getString("RekapitulasiPanel.tData.columnModel.title4")); // NOI18N
        }
        tData.setRowHeight(82);
        tData.setAutoCreateColumnsFromModel(false);

        javax.swing.GroupLayout pChartLayout = new javax.swing.GroupLayout(pChart);
        pChart.setLayout(pChartLayout);
        pChartLayout.setHorizontalGroup(
                pChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 450, Short.MAX_VALUE)
        );
        pChartLayout.setVerticalGroup(
                pChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 244, Short.MAX_VALUE)
        );

        tData_2.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "", "Laki-Laki", "Perempuan", "Jumlah"
                }
        ));
        jScrollPane2.setViewportView(tData_2);
        if (tData_2.getColumnModel().getColumnCount() > 0) {
            tData_2.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("RekapitulasiPanel.tData_2.columnModel.title0")); // NOI18N
            tData_2.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("RekapitulasiPanel.tData_2.columnModel.title1")); // NOI18N
            tData_2.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("RekapitulasiPanel.tData_2.columnModel.title2")); // NOI18N
            tData_2.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("RekapitulasiPanel.tData_2.columnModel.title3")); // NOI18N
        }
        tData_2.setAutoCreateColumnsFromModel(false);

        javax.swing.GroupLayout pnlRekapLayout = new javax.swing.GroupLayout(pnlRekap);
        pnlRekap.setLayout(pnlRekapLayout);
        pnlRekapLayout.setHorizontalGroup(
                pnlRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlRekapLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnlRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelTombol1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRekapLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(pChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        pnlRekapLayout.setVerticalGroup(
                pnlRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlRekapLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlRekapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(pChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelTombol1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRekap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRekap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static ImageIcon setImage(String str) {
        ImageIcon ico = null;
        try {
            str = str.replace("address", MainUi.getAppsIp());
            URL url = new URL(str);
            Image image = ImageIO.read(url).getScaledInstance(60, 80, java.awt.Image.SCALE_SMOOTH);
            ico = new ImageIcon(image);
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        return ico;
    }

    private static PieChart createChart(List<Calon> calons) {
        PieChart chart = new PieChartBuilder().width(450).height(400).title("Hasil Perolehan Suara").theme(ChartTheme.GGPlot2).build();
        chart.getStyler().setLegendVisible(false);
        chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
        chart.getStyler().setAnnotationDistance(1.15);
        chart.getStyler().setPlotContentSize(.7);
        chart.getStyler().setStartAngleInDegrees(90);
        for (Calon c : calons) {
            chart.addSeries(c.getNama(), c.getSuara());
        }
        return chart;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lTitle;
    private static javax.swing.JPanel pChart;
    private static com.voting.ui.panel.PanelTombol panelTombol1;
    private javax.swing.JPanel pnlRekap;
    private static javax.swing.JTable tData;
    private static javax.swing.JTable tData_2;
    // End of variables declaration//GEN-END:variables
}
