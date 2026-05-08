/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.voting.ui.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelFoto extends javax.swing.JPanel {
    private Image image;
    
    public PanelFoto() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        initComponents();// </editor-fold>
    }
    public void setImage(Image image){
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        this.image = image;
        MediaTracker mediaTracker = new MediaTracker(this);
        mediaTracker.addImage(image, 0);
        try {
            mediaTracker.waitForID(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanelFoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();// </editor-fold>
    }
    @Override
    protected void paintComponent(Graphics g) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        super.paintComponent(g);
        g.drawImage(image, 0, 0,getWidth(),getHeight(), this);// </editor-fold>
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(48, 61));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
