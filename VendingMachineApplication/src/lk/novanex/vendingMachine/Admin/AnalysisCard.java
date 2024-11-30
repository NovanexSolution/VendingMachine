/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.novanex.vendingMachine.Admin;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ASUS
 */
public class AnalysisCard extends javax.swing.JPanel {

    /**
     * Creates new form AnalysisCard
     */
    public AnalysisCard(String title, String price, String sellCount, String restCount, String img) {
        initComponents();
        init();
        setupCard(title, price, sellCount, restCount, img);
        this.setVisible(true);
    }
    
    private void setupCard(String title, String price, String sellCount, String restCount, String img) {
        jLabel2.setText(title);
        jLabel7.setText(price + " LKR   ");
        jLabel3.setText("Sell: "+sellCount + " Items");
        jLabel4.setText("Rest : "+ restCount +" Items   ");
        
        ImageIcon icon = new ImageIcon(img);
        jLabel1.setIcon(icon);
    }
    
    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:22");
        this.setSize(600, 100);
        this.setBackground(new Color(255, 255, 255, 0));
        roundPanel1.setSize(600, 100);
        roundPanel1.setBackground(new Color(233, 233, 233));
        ImageIcon chipsIcon = new ImageIcon("src/img/chips.png");
        jLabel1.setIcon(chipsIcon);
        
        JLabel[] labels = {jLabel2, jLabel3, jLabel4, jLabel7};
        for (JLabel label : labels) {
            label.setForeground(new Color(41, 41, 41));
        }
        
        jLabel3.setForeground(new Color(41, 211, 143));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Componnent.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chips.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel2.setText("Potato Chips");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("320 LKR");

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 26)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(41, 211, 143));
        jLabel3.setText("Sell : 15 Items");

        jLabel4.setFont(new java.awt.Font("Poppins", 1, 26)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Rest : 10 Items");

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private Componnent.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
