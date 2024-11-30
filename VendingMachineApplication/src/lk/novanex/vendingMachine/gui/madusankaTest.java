/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lk.novanex.vendingMachine.gui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import javax.swing.JPanel;
import lk.novanex.vendingMachine.panel.CartItem;
import lk.novanex.vendingMachine.panel.Cart;
import lk.novanex.vendingMachine.panel.CartItemSideCart;
import lk.novanex.vendingMachine.panel.Product;

/**
 *
 * @author Madusanka
 */
public class madusankaTest extends javax.swing.JFrame {

    /**
     * Creates new form madusankaTest
     */
    public madusankaTest() {
        initComponents();
//      jPanel1.setBackground(new Color(245, 245, 245));                  
//      CartItem ci = new CartItem();
//      jPanel1.add(ci);

       Date d = new Date(2024,01,05);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        String date = format.format(d);
        
        System.out.println(date);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        normalProductView1 = new lk.novanex.vendingMachine.panel.NormalProductView();
        normalProductView2 = new lk.novanex.vendingMachine.panel.NormalProductView();
        welcome1 = new lk.novanex.vendingMachine.panel.Welcome();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new madusankaTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lk.novanex.vendingMachine.panel.NormalProductView normalProductView1;
    private lk.novanex.vendingMachine.panel.NormalProductView normalProductView2;
    private lk.novanex.vendingMachine.panel.Welcome welcome1;
    // End of variables declaration//GEN-END:variables
}
