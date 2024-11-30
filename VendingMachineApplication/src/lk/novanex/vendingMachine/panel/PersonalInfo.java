/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.novanex.vendingMachine.panel;

import com.formdev.flatlaf.FlatClientProperties;
import com.mysql.cj.jdbc.result.ResultSetFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lk.novanex.vendingMachine.gui.editUserDetail;
import lk.novanex.vendingMachine.model.MySQL;

/**
 *
 * @author ASUS
 */
public class PersonalInfo extends javax.swing.JPanel {

    
    /**
     * Creates new form PersonalInfo
     */
    public PersonalInfo() {
        initComponents();
        init();
        loadUser();
        this.setVisible(true);
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:22");
        this.setSize(650, 650);
        this.setBackground(new Color(255, 255, 255, 0));
        roundPanel1.setSize(650, 650);
        roundPanel1.setBackground(new Color(217, 217, 217, 60));

        JLabel[] labels = {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6};
        for (JLabel label : labels) {
            label.setForeground(new Color(41, 41, 41));
        }

        ImageIcon editIcon = new ImageIcon("src/img/edit.png");
        jLabel10.setIcon(editIcon);
        ImageIcon editIcon2 = new ImageIcon("src/img/edit.png");
        jLabel11.setIcon(editIcon2);
    }

    public void loadUser() {
        String cardNo = "147852369852";
        try {
            ResultSet rs = MySQL.execute("SELECT * FROM `user` INNER JOIN `gender` ON "
                    + "`user`.`gender_id` = `gender`.`id` INNER JOIN `account` ON "
                    + "`user`.`id` = `account`.`user_id` INNER JOIN `card` ON "
                    + "`account`.`id` = `card`.`account_id` WHERE `card`.`cardNo` = '" + cardNo + "' "
                    + "AND `user`.`userStatus_id` = '1' AND `Card`.`cardStatus_id` = '1'");

            if (rs.next()) {
                String name = rs.getString("user.name");
                String email = rs.getString("user.email");
                String gender = rs.getString("gender");
                String mobile = rs.getString("user.mobile");
                String username = rs.getString("user.username");

                jLabel7.setText(name);
                jLabel8.setText(email);
                jLabel9.setText(gender);
                jLabel12.setText(mobile);
                jLabel13.setText(username);

            } else {
                ResultSet rs1 = MySQL.execute("SELECT * FROM `user` INNER JOIN `gender` ON "
                        + "`user`.`gender_id` = `gender`.`id` INNER JOIN `account` ON "
                        + "`user`.`id` = `account`.`user_id` INNER JOIN `card` ON "
                        + "`account`.`id` = `card`.`account_id` WHERE `card`.`cardNo` = '" + cardNo + "'");

                if (rs1.next()) {
                    String userStatusId = rs1.getString("userStatus_id");
                    String cardStatusId = rs1.getString("cardStatus_id");

                    if ("2".equals(userStatusId)) {
                        System.out.println("inactive user");
                    } else if ("2".equals(cardStatusId)) {
                        System.out.println("inactive card");
                    }
                }
                // System.out.println("inactive");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Componnent.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(650, 650));

        roundPanel1.setPreferredSize(new java.awt.Dimension(650, 650));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabel1.setText("Your Personal Information");

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel2.setText("Name :");

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel3.setText("Email :");

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel4.setText("Gender :");

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel5.setText("Mobile :");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel6.setText("Username :");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel7.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel8.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel9.setEnabled(false);

        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel12.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Poppins", 0, 24)); // NOI18N
        jLabel13.setEnabled(false);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(22, 22, 22)
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(roundPanel1Layout.createSequentialGroup()
                                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(45, 45, 45)))))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                .addContainerGap(254, Short.MAX_VALUE))
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

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        JDialog dialog = new JDialog((Frame) null, "Edit Mobile Number", true);
        dialog.setSize(300, 160);
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Create a panel for the JTextField
        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JTextField textField = new JTextField();
        textField.setText(jLabel12.getText());

        textField.setBackground(new Color(255, 255, 255, 0));
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        textField.setSelectionColor(new Color(255, 165, 0));
        textField.setForeground(new Color(41, 41, 41));
        textField.setFont(new Font("Poppins", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setPreferredSize(new Dimension(200, 40));
        textFieldPanel.add(textField);
        dialog.add(textFieldPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Save button
        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(41, 211, 143));
        saveButton.setForeground(new Color(245, 245, 245));
        Font boldFont1 = new Font("Poppins", Font.BOLD, 14);
        saveButton.setFont(boldFont1);
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    String email = jLabel8.getText();
                    String resetMobile = textField.getText();

                    if (resetMobile.isEmpty()) {
                        JOptionPane.showMessageDialog(dialog, "Please enter your mobile", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else if (!resetMobile.matches("^07[1245678]{1}[0-9]{7}$")) {
                        JOptionPane.showMessageDialog(dialog, "Invalid mobile number", "Warning", JOptionPane.WARNING_MESSAGE);
                        textField.setText("");
                    } else {
                        MySQL.executeIUD("UPDATE `user` SET `mobile` = '" + resetMobile + "' "
                                + "WHERE `email` = '" + email + "'");

                        JOptionPane.showMessageDialog(dialog, "Saved Successfully!", "Save", JOptionPane.INFORMATION_MESSAGE);
                        dialog.dispose();
                        loadUser();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(253, 63, 95));
        cancelButton.setForeground(new Color(245, 245, 245));
        Font boldFont = new Font("Poppins", Font.BOLD, 14);
        cancelButton.setFont(boldFont);
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("Cancel button clicked!");
                //JOptionPane.showMessageDialog(dialog, "Operation Cancelled.", "Cancel", JOptionPane.WARNING_MESSAGE);
                dialog.dispose();
            }
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        JDialog dialog = new JDialog((Frame) null, "Edit Username", true);
        dialog.setSize(300, 160);
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Create a panel for the JTextField
        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JTextField textField = new JTextField();
        textField.setText(jLabel13.getText());

        textField.setBackground(new Color(255, 255, 255, 0));
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        textField.setSelectionColor(new Color(255, 165, 0));
        textField.setForeground(new Color(41, 41, 41));
        textField.setFont(new Font("Poppins", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setPreferredSize(new Dimension(200, 40));
        textFieldPanel.add(textField);
        dialog.add(textFieldPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Save button
        JButton saveButton = new JButton("Save");
        saveButton.setBackground(new Color(41, 211, 143));
        saveButton.setForeground(new Color(245, 245, 245));
        Font boldFont1 = new Font("Poppins", Font.BOLD, 14);
        saveButton.setFont(boldFont1);
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    String email = jLabel8.getText();
                    String resetUsername = textField.getText();

                    if (resetUsername.isEmpty()) {
                        JOptionPane.showMessageDialog(dialog, "Please enter your username", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        MySQL.executeIUD("UPDATE `user` SET `username` = '@" + resetUsername + "' "
                                + "WHERE `email` = '" + email + "'");

                        JOptionPane.showMessageDialog(dialog, "Saved Successfully!", "Save", JOptionPane.INFORMATION_MESSAGE);
                        dialog.dispose();
                        loadUser();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //Cancel button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(253, 63, 95));
        cancelButton.setForeground(new Color(245, 245, 245));
        Font boldFont = new Font("Poppins", Font.BOLD, 14);
        cancelButton.setFont(boldFont);
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                System.out.println("Cancel button clicked!");
                dialog.dispose();
            }
        });

        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private Componnent.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
