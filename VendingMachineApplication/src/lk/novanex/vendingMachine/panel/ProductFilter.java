/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.novanex.vendingMachine.panel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatLabelUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;
import lk.novanex.vendingMachine.component.RoundPanel;

/**
 *
 * @author Madusanka
 */
public class ProductFilter extends javax.swing.JPanel {

    Set<String> categorySet = new HashSet<String>();

    private int numOfCategory = 1;

    private void getCategory() {

        categorySet.add("Chips");
        categorySet.add("Choco");
    }

    /**
     * Creates new form ProductFilter
     */
    public ProductFilter() {
        initComponents();
        categorySet.add("All");
        getCategory();
        init();

    }

    private void setselectButton(JPanel btn, JLabel label) {
        btn.setBackground(new Color(255, 165, 0));
        label.setForeground(new Color(255, 255, 255));
    }

    private void unSetselectButton(JPanel btn1, JLabel lable1) {

        btn1.setBackground(new Color(245, 245, 245));
        lable1.setForeground(new Color(29, 29, 29));

    }

    private void init() {
        for (String s : categorySet) {
            createElement(s);
        }
    }

    private void createElement(String text) {

        RoundPanel roundPanel2 = new RoundPanel();
        JLabel jLabel1 = new javax.swing.JLabel();
        
        
        
        
        // Adding MouseListener to both label and panel
        MouseAdapter colorChangeListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Reset all panels to deselected color (Gray background, Black text)
//                System.out.println(text);
                for (Component comp : getComponents()) {
                    if (comp instanceof RoundPanel) {
                        comp.setBackground(new Color(245, 245, 245)); // Deselected background color
                        Component[] innerComponents = ((JPanel) comp).getComponents();
                        if (innerComponents.length > 0 && innerComponents[0] instanceof JLabel) {
                            innerComponents[0].setForeground(new Color(29, 29, 29)); // Deselected text color
                        }
                    }
                }

                // Set clicked panel to selected color (Orange background, White text)
                roundPanel2.setBackground(new Color(255, 165, 0)); // Selected background color
                jLabel1.setForeground(Color.WHITE); // Selected text color
            }
        };
        
        // Attach the listener to both the label and the panel
        roundPanel2.addMouseListener(colorChangeListener);
        jLabel1.addMouseListener(colorChangeListener);
        
        
            
            

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
                roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
                roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        if (text == "All") {
            roundPanel2.setBackground(new java.awt.Color(255, 165, 0));
        } else {
            roundPanel2.setBackground(new java.awt.Color(245, 245, 245));
        }

        roundPanel2.setPreferredSize(new java.awt.Dimension(100, 46));
        roundPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                System.out.println(text);
//                System.out.println(evt);
                
            }
        });

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        if (text == "All") {
            jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        } else {
            jLabel1.setForeground(new java.awt.Color(29, 29, 29));
        }
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(text);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.out.println(text);
                
            }
        });

        javax.swing.GroupLayout roundPanel2Layout = new javax.swing.GroupLayout(roundPanel2);
        roundPanel2.setLayout(roundPanel2Layout);
        roundPanel2Layout.setHorizontalGroup(
                roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        roundPanel2Layout.setVerticalGroup(
                roundPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        add(roundPanel2);

    }
    
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new lk.novanex.vendingMachine.component.RoundPanel();

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lk.novanex.vendingMachine.component.RoundPanel roundPanel1;
    // End of variables declaration//GEN-END:variables
}
