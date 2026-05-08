/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.ui.transaksi;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.twmacinta.util.MD5;
import com.voting.model.master.Pemilih;
import com.voting.model.master.Tps;
import com.voting.model.transaksi.Bilik;
import com.voting.model.transaksi.Tunggu;
import com.voting.service.TransactionService;
import com.voting.ui.frame.MainUi;
import com.voting.util.StringUtils;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import org.openide.util.Exceptions;

/**
 *
 * @author Rizal
 */
public class RegistrasiPanel extends javax.swing.JInternalFrame {
    Scan scan;
    private String induk;
    private javax.swing.Timer timer;
    TransactionService ts=MainUi.getTransactionService();
    private BufferedImage image;
    private static List<Tunggu> listss;
    Pemilih p; Bilik bilik;
    Tunggu t; Tps tps;

    /**
     * Creates new form RegistrasiPanel
     */
    public RegistrasiPanel() {
        initComponents();initListener();loadTabelData();
    }
    
    private void initListener() {
        tData.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if(tData.getSelectedRow()>=0){
                int indexModel = tData.convertRowIndexToModel(tData.getSelectedRow());
                t = listss.get(indexModel);checkBilik();p=t.getPemilih();btnBatal.setEnabled(true);
            }
        });
    }    
    private static class Scan implements Runnable, ThreadFactory {
        //<editor-fold defaultstate="collapsed" desc="Compiled Code">
        private final Executor executor = Executors.newSingleThreadExecutor(this);
        private final Webcam webcam;
        private final WebcamPanel panel;
        
        private String code="";
        
        public String getCode(){
            return code;
        }
        
        public void doClose(){
            panel.setVisible(false);webcam.close();scanPanel.remove(panel);            
        }
        
        public void setCode(String c){
            code=c;
        }
        
        @SuppressWarnings("LeakingThisInConstructor")
        private Scan(){
            //<editor-fold defaultstate="collapsed" desc="Compiled Code">
            super();
            Dimension size = WebcamResolution.QQVGA.getSize();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            webcam = MainUi.getQrCam();
            webcam.setViewSize(size);
            panel = new WebcamPanel(webcam);
            panel.setPreferredSize(size);
            panel.setFPSDisplayed(false);
            scanPanel.add(panel, gbc);
            panel.getParent().revalidate();
            panel.setVisible(true);
            scanPanel.setVisible(true);
            executor.execute(this);//</editor-fold>
        }
        
        @Override
        public void run() {
            //<editor-fold defaultstate="collapsed" desc="Compiled Code">
            do {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Exceptions.printStackTrace(ex);
                }
            
                Result result = null;
                BufferedImage image;

                if (webcam.isOpen()) {
                    if ((image = webcam.getImage()) == null) {
                        continue;
                    }
                    LuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                    try {
                        result = new MultiFormatReader().decode(bitmap);
                    } catch (NotFoundException e) {
                        // fall thru, it means there is no QR code in image
                    }
                }
            
                if (result != null) {
                    setCode(result.getText());doClose();
                }
            }
            while (true);//</editor-fold>
        }
        
        @Override
        public Thread newThread(Runnable r) {            
            //<editor-fold defaultstate="collapsed" desc="Compiled Code">
            Thread t = new Thread(r, "example-runner");
            t.setDaemon(true);
            return t;//</editor-fold>
        }//</editor-fold>
    }
    private static void loadTabelData(){
        listss = MainUi.getTransactionService().getTunggus();
        tData.setModel(new TungguModel(listss));        
    }
    private static class TungguModel extends AbstractTableModel{
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        private List<Tunggu> tungguModel = new ArrayList();

        public TungguModel(List<Tunggu> tungguModel) {
            this.tungguModel = tungguModel;
            fireTableDataChanged();
        }
        @Override
        public int getRowCount() {
            return tungguModel.size();
        }
        @Override
        public int getColumnCount() {
            return 5;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Tunggu t = tungguModel.get(rowIndex);
            Pemilih p = t.getPemilih();
            switch(columnIndex){
                case 0 : return rowIndex+1;
                case 1 : return p.getInduk();
                case 2 : return p.getNama();
                case 3 : return t.getTpsCode();
                case 4 : return t.getTime();
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
        lTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tData = new javax.swing.JTable();
        pembatas1 = new javax.swing.JSeparator();
        panelFoto = new com.voting.ui.panel.PanelFoto();
        jSeparator1 = new javax.swing.JSeparator();
        scanPanel = new javax.swing.JPanel();
        lNik = new javax.swing.JLabel();
        fNik = new javax.swing.JTextField();
        rQr = new javax.swing.JLabel();
        btnBilik = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnTunggu = new javax.swing.JButton();
        panelData = new javax.swing.JPanel();
        lNkk = new javax.swing.JLabel();
        lNama = new javax.swing.JLabel();
        lTtl = new javax.swing.JLabel();
        lStat = new javax.swing.JLabel();
        lAlamat = new javax.swing.JLabel();
        lDukuh = new javax.swing.JLabel();
        lRt = new javax.swing.JLabel();
        lDif = new javax.swing.JLabel();
        colom1 = new javax.swing.JLabel();
        colom2 = new javax.swing.JLabel();
        colom3 = new javax.swing.JLabel();
        colom4 = new javax.swing.JLabel();
        colom5 = new javax.swing.JLabel();
        colom6 = new javax.swing.JLabel();
        colom7 = new javax.swing.JLabel();
        fKk = new javax.swing.JLabel();
        fNama = new javax.swing.JLabel();
        fTtl = new javax.swing.JLabel();
        fStatus = new javax.swing.JLabel();
        fDukuh = new javax.swing.JLabel();
        fRtRw = new javax.swing.JLabel();
        fDif = new javax.swing.JLabel();
        pembatas3 = new javax.swing.JSeparator();
        lTitle2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();

        setTitle(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.title")); // NOI18N

        lTitle.setFont(new java.awt.Font("Futured", 1, 24)); // NOI18N
        lTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lTitle.text")); // NOI18N

        tData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Urut", "NIK", "Nama", "Kode TPS", "Waktu Registrasi"
            }
        ));
        jScrollPane1.setViewportView(tData);
        if (tData.getColumnModel().getColumnCount() > 0) {
            tData.getColumnModel().getColumn(0).setMinWidth(70);
            tData.getColumnModel().getColumn(0).setMaxWidth(70);
            tData.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.tData.columnModel.title0")); // NOI18N
            tData.getColumnModel().getColumn(1).setMinWidth(150);
            tData.getColumnModel().getColumn(1).setMaxWidth(150);
            tData.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.tData.columnModel.title1")); // NOI18N
            tData.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.tData.columnModel.title2")); // NOI18N
            tData.getColumnModel().getColumn(3).setMinWidth(150);
            tData.getColumnModel().getColumn(3).setMaxWidth(150);
            tData.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.tData.columnModel.title3")); // NOI18N
            tData.getColumnModel().getColumn(4).setMinWidth(150);
            tData.getColumnModel().getColumn(4).setMaxWidth(150);
            tData.getColumnModel().getColumn(4).setHeaderValue(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.tData.columnModel.title4_1")); // NOI18N
        }
        tData.setAutoCreateColumnsFromModel(false);

        panelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 218, Short.MAX_VALUE)
        );

        scanPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        scanPanel.setLayout(new java.awt.GridBagLayout());

        lNik.setFont(new java.awt.Font("Futured", 1, 14)); // NOI18N
        lNik.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lNik.text")); // NOI18N

        fNik.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.fNik.text")); // NOI18N
        fNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCheck(evt);
            }
        });

        rQr.setFont(new java.awt.Font("MS Gothic", 1, 18)); // NOI18N
        rQr.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.rQr.text")); // NOI18N
        rQr.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        btnBilik.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.btnBilik.text")); // NOI18N
        btnBilik.setEnabled(false);
        btnBilik.setVisible(false);
        btnBilik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eKirim(evt);
            }
        });

        btnCancel.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.btnCancel.text")); // NOI18N
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eBatal(evt);
            }
        });

        btnTunggu.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.btnTunggu.text")); // NOI18N
        btnTunggu.setEnabled(false);
        btnTunggu.setVisible(false);
        btnTunggu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eTunggu(evt);
            }
        });

        lNkk.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lNkk.text")); // NOI18N

        lNama.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lNama.text")); // NOI18N

        lTtl.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lTtl.text")); // NOI18N

        lStat.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lStat.text")); // NOI18N

        lAlamat.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lAlamat.text")); // NOI18N

        lDukuh.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lDukuh.text")); // NOI18N

        lRt.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lRt.text")); // NOI18N

        lDif.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lDif.text")); // NOI18N

        colom1.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.colom1.text")); // NOI18N

        colom2.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.colom2.text")); // NOI18N

        colom3.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.colom3.text")); // NOI18N

        colom4.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.colom4.text")); // NOI18N

        colom5.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.colom5.text")); // NOI18N

        colom6.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.colom6.text")); // NOI18N

        colom7.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.colom7.text")); // NOI18N

        fKk.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.fKk.text")); // NOI18N

        fNama.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.fNama.text")); // NOI18N

        fTtl.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.fTtl.text")); // NOI18N

        fStatus.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.fStatus.text")); // NOI18N

        fDukuh.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.fDukuh.text")); // NOI18N

        fRtRw.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.fRtRw.text")); // NOI18N

        fDif.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.fDif.text")); // NOI18N

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDataLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lDukuh)
                            .addComponent(lRt))
                        .addGap(30, 30, 30)
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDataLayout.createSequentialGroup()
                                .addComponent(colom5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fDukuh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDataLayout.createSequentialGroup()
                                .addComponent(colom4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDataLayout.createSequentialGroup()
                                .addComponent(colom3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fTtl, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDataLayout.createSequentialGroup()
                                .addComponent(colom2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fNama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDataLayout.createSequentialGroup()
                                .addComponent(colom1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fKk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelDataLayout.createSequentialGroup()
                                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(colom6)
                                    .addComponent(colom7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fDif, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fRtRw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNkk)
                            .addComponent(lNama)
                            .addComponent(lAlamat)
                            .addComponent(lDif)
                            .addComponent(lTtl)
                            .addComponent(lStat))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNkk)
                    .addComponent(colom1)
                    .addComponent(fKk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNama)
                    .addComponent(colom2)
                    .addComponent(fNama))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lTtl)
                    .addComponent(colom3)
                    .addComponent(fTtl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lStat)
                    .addComponent(colom4)
                    .addComponent(fStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lAlamat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDukuh)
                    .addComponent(colom5)
                    .addComponent(fDukuh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lRt)
                    .addComponent(colom6)
                    .addComponent(fRtRw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lDif)
                    .addComponent(fDif)
                    .addComponent(colom7))
                .addContainerGap())
        );

        lTitle2.setFont(new java.awt.Font("Futured", 1, 18)); // NOI18N
        lTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitle2.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.lTitle2.text")); // NOI18N

        btnExit.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.btnExit.text")); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eExit(evt);
            }
        });

        btnBatal.setText(org.openide.util.NbBundle.getMessage(RegistrasiPanel.class, "RegistrasiPanel.btnBatal.text")); // NOI18N
        btnBatal.setEnabled(false);
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eCancel(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pembatas3)
                    .addComponent(pembatas1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lNik, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fNik, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rQr)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBatal)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBilik)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTunggu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancel))
                            .addComponent(scanPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addComponent(lTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pembatas1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lNik)
                                .addComponent(fNik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rQr))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(scanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnCancel)
                                .addComponent(btnBilik)
                                .addComponent(btnTunggu))))
                    .addComponent(panelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pembatas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExit)
                    .addComponent(btnBatal))
                .addContainerGap())
        );

        rQr.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eExit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eExit
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(scan!=null){scan.doClose();}
        dispose();// </editor-fold>
    }//GEN-LAST:event_eExit
    private void eCheck(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eCheck
        //<editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(fNik.getText().length()!=0){
            if(ts.cekTps(fNik.getText(), tps)){
                scan = new Scan();setForm(true);Check();
                induk= new MD5(fNik.getText()).asHex();
            } else{
                if(tps!=null){
                    JOptionPane.showMessageDialog(this,
                        "<html>Pemilih Tidak Terdaftar di TPS Ini<br/>Kode TPS: "+tps+"</html>", "Tidak Terdaftar", JOptionPane.ERROR_MESSAGE);
                } else{                    
                    JOptionPane.showMessageDialog(this,
                        "Pemilih Tidak Terdaftar / Sudah Memilih", "Tidak Terdaftar", JOptionPane.ERROR_MESSAGE);
                }
            }
        }//</editor-fold>
    }//GEN-LAST:event_eCheck
    private void eBatal(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eBatal
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        image=null;setForm(false);scan.doClose();// </editor-fold>
    }//GEN-LAST:event_eBatal

    private void eKirim(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eKirim
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        bilik.setIdPemilih(p);p.setKet(3);
        ts.kirimPemilih(bilik, p);
        if(t!=null){ts.deleteTunggu(t);}
        refresh();// </editor-fold>
    }//GEN-LAST:event_eKirim

    private void eTunggu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eTunggu
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        t=new Tunggu(p,tps);
        p.setKet(2);
        ts.waitingList(t, p);
        refresh();// </editor-fold>
    }//GEN-LAST:event_eTunggu

    private void eCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eCancel
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        tData.clearSelection();refresh();btnBatal.setEnabled(false);// </editor-fold>
    }//GEN-LAST:event_eCancel

    private void Check(){
        //<editor-fold defaultstate="collapsed" desc="Compiled Code">
        timer = new javax.swing.Timer(1, new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String code = scan.getCode();
                if(code.length()!=0){
                    rQr.setVisible(true);
                    if(code.equals(induk)){
                        rQr.setText("✔");rQr.setForeground(new java.awt.Color(0, 153, 0));
                        setData(fNik.getText());checkBilik();
                    } else {
                        rQr.setText("✖");rQr.setForeground(new java.awt.Color(255, 0, 0));
                    }
                } else {
                    rQr.setVisible(false);Check();
                }
            }
        });        
        timer.setRepeats(false);
        timer.start();// </editor-fold>
    }
    private void setData(String s){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        p=ts.lookUpPemilih(s);setInfo(true);setFoto(p.getFoto());// </editor-fold>
    }
    private void setFoto(String s){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(s.length()!=0){
            try{
                URL url = new URL(s);
                image = ImageIO.read(url);
                panelFoto.setImage(image);
            } catch (IOException e) {
            }
        }//</editor-fold>        
    }
    private void setInfo(boolean b){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(b){
            fKk.setText(p.getNoKk());fNama.setText(p.getNama()+" ("+setJk(p.getJenisKelamin())+")");
            fTtl.setText(p.getTLahir()+", "+StringUtils.setTanggal(p.getTglLahir())+" ("+p.getUmur()+" Tahun)");
            fStatus.setText(p.getStatusCode().toString());fDukuh.setText(p.getAlamat());
            fRtRw.setText(p.getRt()+"/"+p.getRw());fDif.setText(setDif(p.getDifableCode().toString()));
        } else {
            if(p!=null){p=null;}
            Object[] o={fKk,fNama,fTtl,fStatus,fDukuh,fRtRw,fDif};
            for(Object l : o){
                ((javax.swing.JLabel) l).setText("-");
            }
            rQr.setVisible(b);
        }// </editor-fold>
    }
    private void setForm(boolean b){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        fNik.setEnabled(!b);btnCancel.setEnabled(b);panelFoto.setImage(image);
        btnTunggu.setVisible(false);btnBilik.setVisible(false);setInfo(false);// </editor-fold>
    }
    private String setJk(String s){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(s.equals("L")){
            return "Laki-Laki";
        } else {
            return "Perempuan";
        }// </editor-fold>
    }
    private String setDif(String d){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(d.length()!=0){
            return d;
        }
        return "-";// </editor-fold>
    }
    private void checkBilik(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        List<Bilik> biliks = ts.cekAktif(tps);
        if(!biliks.isEmpty()){
            bilik = biliks.get(0); btnBilik.setText("Bilik No. "+bilik.getNo());
            tunggu(false);
        }
        tunggu(biliks.isEmpty());// </editor-fold>
    }
    private void tunggu(boolean b){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        if(t==null){
            btnTunggu.setVisible(b);btnTunggu.setEnabled(b);
        } else{
            btnTunggu.setVisible(!b);btnTunggu.setEnabled(!b);
        }
        btnBilik.setVisible(!b);btnBilik.setEnabled(!b);// </editor-fold>
    }
    private void refresh(){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        p=null;bilik=null;
        t=null;image=null;
        setForm(false);fNik.setText("");
        loadTabelData();// </editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnBilik;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnTunggu;
    private javax.swing.JLabel colom1;
    private javax.swing.JLabel colom2;
    private javax.swing.JLabel colom3;
    private javax.swing.JLabel colom4;
    private javax.swing.JLabel colom5;
    private javax.swing.JLabel colom6;
    private javax.swing.JLabel colom7;
    private javax.swing.JLabel fDif;
    private javax.swing.JLabel fDukuh;
    private javax.swing.JLabel fKk;
    private javax.swing.JLabel fNama;
    private javax.swing.JTextField fNik;
    private javax.swing.JLabel fRtRw;
    private javax.swing.JLabel fStatus;
    private javax.swing.JLabel fTtl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lAlamat;
    private javax.swing.JLabel lDif;
    private javax.swing.JLabel lDukuh;
    private javax.swing.JLabel lNama;
    private javax.swing.JLabel lNik;
    private javax.swing.JLabel lNkk;
    private javax.swing.JLabel lRt;
    private javax.swing.JLabel lStat;
    private javax.swing.JLabel lTitle;
    private javax.swing.JLabel lTitle2;
    private javax.swing.JLabel lTtl;
    private javax.swing.JPanel panelData;
    private com.voting.ui.panel.PanelFoto panelFoto;
    private javax.swing.JSeparator pembatas1;
    private javax.swing.JSeparator pembatas3;
    private javax.swing.JLabel rQr;
    private static javax.swing.JPanel scanPanel;
    private static javax.swing.JTable tData;
    // End of variables declaration//GEN-END:variables
}
