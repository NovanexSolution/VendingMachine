/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.novanex.vendingMachine.Admin;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static lk.novanex.vendingMachine.Admin.AdminComponnentWindow.adminComponnent;
import lk.novanex.vendingMachine.component.ComponnentLoadingWindow;
import lk.novanex.vendingMachine.model.MySQL;

/**
 *
 * @author ASUS
 */
public class Admin_Product extends javax.swing.JPanel {

    private static final int PANELS_PER_PAGE = 4; // Number of panels per page
    private int currentPage = 0; // Track the current page index
    private final List<JPanel> panelList = new ArrayList<>(); // Store all panels

    /**
     * Creates new form Admin_Product
     */
    public Admin_Product() {
        initComponents();
        init();
        loadProducts();
        navigatePanels(-1);
        this.setVisible(true);
    }

    private void loadProducts() {
        try {
            ResultSet result = MySQL.execute("SELECT * FROM `product` INNER JOIN `category` ON `product`.`category_id` = `category`.`id`");
            while (result.next()) {
                String title = result.getString("product.title");
                String category = result.getString("category.category");
                String img = result.getString("product.img");

                ProductCard productCard = new ProductCard(title, category, img);
                panelList.add(productCard);
//                SwingUtilities.updateComponentTreeUI(jPanel1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void deleteAll() {
        try {
            System.out.println("befor q");
            MySQL.executeIUD("SET FOREIGN_KEY_CHECKS = 0;");
            MySQL.executeIUD("TRUNCATE TABLE `product`;");
            MySQL.executeIUD("SET FOREIGN_KEY_CHECKS = 1;");
            System.out.println("after q");
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

        removeBtn1.setBackground(new Color(236, 236, 236));
        removeBtn1.putClientProperty(FlatClientProperties.STYLE, "arc:22");

        jLabel2.setForeground(new Color(253, 63, 95));
        jLabel1.setForeground(new Color(41, 41, 41));
        jLabel5.setForeground(new Color(245, 245, 245));

        roundPanel2.setBackground(new Color(41, 211, 143));
    }

    ///////////////////////////////////////////
    private void navigatePanels(int direction) {
        int totalPages = (int) Math.ceil((double) panelList.size() / PANELS_PER_PAGE);

        // Update the current page index
        currentPage += direction;
        if (currentPage < 0) {
            currentPage = 0; // Prevent going below the first page
        } else if (currentPage >= totalPages) {
            currentPage = totalPages - 1; // Prevent going beyond the last page
        }

        // Update the grid
        updateGrid();
    }

    /**
     * Update the grid panel with the current set of panels based on the current
     * page.
     */
    private void updateGrid() {
        jPanel1.removeAll(); // Clear the grid panel

        // Calculate the start and end indices for the current page
        int startIndex = currentPage * PANELS_PER_PAGE;
        int endIndex = Math.min(startIndex + PANELS_PER_PAGE, panelList.size());

        // Add panels for the current page
        for (int i = startIndex; i < endIndex; i++) {
            jPanel1.add(panelList.get(i));
        }

        jPanel1.revalidate(); // Revalidate to refresh the layout
        jPanel1.repaint(); // Repaint to display changes
    }
    ////////////////////////////////////

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new Componnent.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        removeBtn1 = new lk.novanex.vendingMachine.component.RemoveBtn();
        jLabel2 = new javax.swing.JLabel();
        roundPanel2 = new Componnent.RoundPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 30)); // NOI18N
        jLabel1.setText("Product Management");

        removeBtn1.setPreferredSize(new java.awt.Dimension(130, 45));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(253, 63, 95));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Remove All");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout removeBtn1Layout = new javax.swing.GroupLayout(removeBtn1);
        removeBtn1.setLayout(removeBtn1Layout);
        removeBtn1Layout.setHorizontalGroup(
            removeBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        removeBtn1Layout.setVerticalGroup(
            removeBtn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
        );

        roundPanel2.setBackground(new java.awt.Color(41, 211, 143));
        roundPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                roundPanel2MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(245, 245, 245));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("+ Add Product");

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

        jPanel1.setLayout(new java.awt.GridLayout(4, 1, 6, 6));

        jPanel2.setBackground(new java.awt.Color(255, 204, 51));

        jButton1.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jButton1.setText("Back");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jButton2.setText("Next");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel2.add(jButton2);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(removeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
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

    private void roundPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_roundPanel2MouseClicked
        AddProduct ap = new AddProduct();
        AdminComponnentWindow.adminComponnent.removeAll();
        AdminComponnentWindow.adminComponnent.add(ap);
        SwingUtilities.updateComponentTreeUI(AdminComponnentWindow.adminComponnent);
    }//GEN-LAST:event_roundPanel2MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        deleteAll();
        Admin_Product ap = new Admin_Product();
        AdminComponnentWindow.adminComponnent.removeAll();
        AdminComponnentWindow.adminComponnent.add(ap);
        SwingUtilities.updateComponentTreeUI(AdminComponnentWindow.adminComponnent.getParent());
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        navigatePanels(-1);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        navigatePanels(1);
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private lk.novanex.vendingMachine.component.RemoveBtn removeBtn1;
    private Componnent.RoundPanel roundPanel1;
    private Componnent.RoundPanel roundPanel2;
    // End of variables declaration//GEN-END:variables
}
