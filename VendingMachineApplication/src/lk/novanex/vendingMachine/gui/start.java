

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import lk.novanex.vendingMachine.gui.Properties;

import lk.novanex.vendingMachine.panel.MemberCard;

/**
 *
 * @author Madusanka
 */
public class start extends javax.swing.JFrame {

    /**
     * Creates new form start
     */
    public start() {
        initComponents();


        Properties p = new Properties();        
   


        MemberCard mc = new MemberCard();
        mc.setUI("Please wait for the card to be Test.", "Please wait until Card Scanning.");
        this.add(mc, BorderLayout.CENTER);
        FlatLightLaf.updateUI();
    }   
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        memberCard1 = new lk.novanex.vendingMachine.panel.MemberCard();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 51));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1932, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1812, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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
                new start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private lk.novanex.vendingMachine.panel.MemberCard memberCard1;
    // End of variables declaration//GEN-END:variables
}
