/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.novanex.vendingMachine.Admin;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;
import lk.novanex.vendingMachine.model.MySQL;

/**
 *
 * @author ASUS
 */
public class Admin_Stock extends javax.swing.JPanel {

    /**
     * Creates new form Admin_Stock
     */
    public Admin_Stock() {
        initComponents();
        init();
        loadStock();
        this.setVisible(true);
    }

    private void loadStock() {
        try {
            ResultSet result = MySQL.execute("SELECT * FROM `stock`  INNER JOIN `product` ON `product`.`id` = `stock`.`product_id`");

            while (result.next()) {
                String name = result.getString("product.title");
                String pDate = result.getString("stock.stockDate");
                String endDate = result.getString("stock.exp");
                String price = result.getString("stock.sellingPrice");
                String qty = result.getString("stock.qty");
                String img = result.getString("product.img");

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String purcheseDate = format.format(format.parse(pDate));
                String expDateDate = format.format(format.parse(endDate));

                StockCard stockCard = new StockCard(name, purcheseDate, expDateDate, price, qty, img);
                jPanel1.add(stockCard);
                SwingUtilities.updateComponentTreeUI(jPanel1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:22");
        this.setSize(650, 650);
        this.setBackground(new Color(255, 255, 255, 0));
        roundPanel1.setSize(650, 650);
        roundPanel1.setBackground(new Color(217, 217, 217, 60));
        jLabel1.setForeground(new Color(41, 41, 41));

        roundPanel2.setBackground(new Color(41, 211, 143));
        jLabel5.setForeground(new Color(245, 245, 245));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Componnent.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        roundPanel2 = new Componnent.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabel1.setText("Stock Management");

        roundPanel2.setBackground(new java.awt.Color(41, 211, 143));

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(245, 245, 245));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("+ Add Stock");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
        );
        roundPanel2Layout.setVerticalGroup(
            roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.setLayout(new java.awt.GridLayout(3, 1, 6, 6));

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 517, Short.MAX_VALUE)
                .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        AddStockNew ap = new AddStockNew();
        AdminComponnentWindow.adminComponnent.removeAll();
        AdminComponnentWindow.adminComponnent.add(ap);
        SwingUtilities.updateComponentTreeUI(AdminComponnentWindow.adminComponnent);
    }//GEN-LAST:event_jLabel5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private Componnent.RoundPanel roundPanel1;
    private Componnent.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
