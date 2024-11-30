/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lk.novanex.vendingMachine.Admin;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JFormattedTextField;
import lk.novanex.vendingMachine.model.MySQL;

/**
 *
 * @author Madusanka
 */
public class AddStock extends javax.swing.JPanel {

    public static String currentI;

    private static final int PANELS_PER_PAGE = 1; // Number of panels per page
    private int currentPage = 0; // Track the current page index
    private final List<JPanel> panelList = new ArrayList<>(); // Store all panels

    private HashMap<StockProductSelector, String> productMap = new HashMap<>();

    /**
     * Creates new form AddStock
     */
    public AddStock() {
        initComponents();
        init();
        loadProduct();
        navigatePanels(-1);
    }

    private void init() {
        roundPanel1.setBackground(new Color(245, 245, 245));
        this.setSize(1000, 680);
    }
    
    private void reset() {
        jDateChooser1.cleanup();
        jTextField1.setText("");
        jFormattedTextField1.setText("");
        jFormattedTextField2.setText("");
    }

    private void addStock() {
        Date d = jDateChooser1.getDate();
        String qty = jTextField1.getText();
        String sellingPrice = jFormattedTextField1.getText();
        String buyingPrice = jFormattedTextField2.getText();

        if (String.valueOf(d).isEmpty()) {

        } else if (qty.isEmpty()) {

        } else if (sellingPrice.isEmpty()) {
            
        } else if (buyingPrice.isEmpty()) {
            
        } else {
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date today = new Date();
                
                MySQL.executeIUD("INSERT INTO `stock` (`stockDate`, `exp`, `sellingPrice`, `qty`, `buyningPrice`, `product_id`) VALUES "+
                        " ('"+ format.format(today) +"', '"+ format.format(d) +"', '"+ sellingPrice +"', '"+ qty +"', '"+ buyingPrice +"', '"+ currentI +"')");
                System.out.println("stock updated");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void loadProduct() {
        try {
            ResultSet result = MySQL.execute("SELECT * FROM `product` INNER JOIN `flavor` ON `product`.`flavor_id` = `flavor`.`id`");
            while (result.next()) {
                String id = result.getString("product.id");
                String title = result.getString("product.title");
                String img = result.getString("product.img");
                String flavour = result.getString("flavor.flavorName");

                StockProductSelector panel = new StockProductSelector(id, title, img, flavour);
                productMap.put(panel, id);
                panelList.add(panel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Navigate through the panel list and update the grid.
     *
     * @param direction Direction of navigation: -1 for left, 1 for right
     */
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
        jPanel2.removeAll(); // Clear the grid panel

        // Calculate the start and end indices for the current page
        int startIndex = currentPage * PANELS_PER_PAGE;
        int endIndex = Math.min(startIndex + PANELS_PER_PAGE, panelList.size());

        // Add panels for the current page
        for (int i = startIndex; i < endIndex; i++) {
            jPanel2.add(panelList.get(i));
            currentI = productMap.get(panelList.get(i));
        }

        jPanel2.revalidate(); // Revalidate to refresh the layout
        jPanel2.repaint(); // Repaint to display changes
    }

    private void checkOnlyNumbers() {
        String txt = jTextField1.getText();
        System.out.println(txt);
        if (!txt.matches("^[0-9]*$")) {
            jTextField1.setText("");
            System.out.println("not match");
        } else {
            System.out.println("match");
        }
    }

    private void priceValidate(JFormattedTextField f) {

        String txt = f.getText();
        System.out.println(txt);
        if (!txt.matches("^[0-9]*$")) {
            f.setText("");
//            System.out.println("not match");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
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
                new AddStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
