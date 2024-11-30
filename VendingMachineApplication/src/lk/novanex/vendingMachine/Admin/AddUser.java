/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.novanex.vendingMachine.Admin;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.net.URLConnection;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author ASUS
 */
public class AddUser extends javax.swing.JPanel {

    /**
     * Creates new form AddUser
     */
    public AddUser() {
        initComponents();
        init();
        this.setVisible(true);
        
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:22");
        this.setSize(600, 400);
        this.setBackground(new Color(255, 255, 255, 0));
        roundPanel1.setSize(600, 400);
        roundPanel1.setBackground(new Color(245, 245, 245));
        
        ImageIcon close = new ImageIcon("src/img/close.png");
        jLabel7.setIcon(close);
        
        roundPanel4.setSize(100, 50);
        roundPanel4.setBackground(new Color(255, 165, 0));
        jLabel9.setForeground(new Color(245, 245, 245));
        
        jTextField1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "User name here");
        jTextField2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Mobile here");
    
        JTextField[] textFields = {jTextField1, jTextField2};
        for (JTextField textField : textFields) {
            textField.setForeground(new Color(41, 41, 41));
            textField.putClientProperty(FlatClientProperties.STYLE, "margin:0,10,0,10");
            textField.setBackground(new Color(245, 245, 245));
            textField.setBorder(BorderFactory.createEmptyBorder());
        }
        
        //jRadioButton1.put("RadioButton.focus", new Color(255, 165, 0)); // Optional, changes focus ring color
        //jRadioButton1.put("RadioButton.select", new Color(255, 165, 0)); // Set selection color to orange
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        roundPanel1 = new Componnent.RoundPanel();
        jLabel7 = new javax.swing.JLabel();
        roundPanel4 = new Componnent.RoundPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        customRadioButton1 = new lk.novanex.vendingMachine.component.CustomRadioButton();
        customRadioButton2 = new lk.novanex.vendingMachine.component.CustomRadioButton();

        jLabel7.setPreferredSize(new java.awt.Dimension(50, 50));

        roundPanel4.setBackground(new java.awt.Color(255, 165, 0));

        jLabel9.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(245, 245, 245));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Add");

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel1.setText("Name");

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel3.setText("Mobile");

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jLabel5.setText("Gender");

        jTextField1.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        buttonGroup1.add(customRadioButton1);
        customRadioButton1.setText("Male");
        customRadioButton1.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N

        buttonGroup1.add(customRadioButton2);
        customRadioButton2.setText("Female");
        customRadioButton2.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addContainerGap(450, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(customRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(customRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(customRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private lk.novanex.vendingMachine.component.CustomRadioButton customRadioButton1;
    private lk.novanex.vendingMachine.component.CustomRadioButton customRadioButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private Componnent.RoundPanel roundPanel1;
    private Componnent.RoundPanel roundPanel4;
    // End of variables declaration//GEN-END:variables
}
