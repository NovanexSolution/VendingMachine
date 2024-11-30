/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.novanex.vendingMachine.Admin;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import lk.novanex.vendingMachine.model.MySQL;
import java.sql.ResultSet;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ASUS
 */
public class AddProduct extends javax.swing.JPanel {


    private String imgPath = null;
    HashMap<String, String> categoryMap = new HashMap<>();
    HashMap<String, String> flavourMap = new HashMap<>();

    /**
     * Creates new form AddProduct
     */
    public AddProduct() {
        initComponents();
        init();
        loadCategory();
        loadFlavor();
        this.setVisible(true);
    }

    public void loadCategory() {
        try {
            ResultSet result = MySQL.execute("SELECT * FROM `category`");
            Vector<String> vector = new Vector<>();
            vector.add("Select");
            while (result.next()) {
                String categoryId = result.getString("id");
                String category = result.getString("category");
                categoryMap.put(category, categoryId);
                vector.add(category);
            }
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox1.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFlavor() {
        try {
            ResultSet result = MySQL.execute("SELECT * FROM `flavor`");
             Vector<String> vector = new Vector<>();
            vector.add("Select");
            while (result.next()) {
                String flavorId = result.getString("id");
                String flavor = result.getString("flavorName");
                flavourMap.put(flavor, flavorId);
                 vector.add(flavor);
            }
            
            DefaultComboBoxModel model = new DefaultComboBoxModel(vector);
            jComboBox2.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:22");
        this.setSize(600, 400);
        this.setBackground(new Color(255, 255, 255, 0));
        roundPanel1.setSize(600, 400);
        roundPanel1.setBackground(new Color(245, 245, 245));

        ImageIcon UploadImg = new ImageIcon("src/img/UploadImg.png");
        jLabel6.setIcon(UploadImg);
        jTextField2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Product name here");
        jTextField2.putClientProperty(FlatClientProperties.STYLE, "margin:0,10,0,10");

        jTextField2.setForeground(new Color(41, 41, 41));
        jTextField2.setBackground(new Color(245, 245, 245));
        jTextField2.setBorder(BorderFactory.createEmptyBorder());

        JLabel[] labels = {jLabel1, jLabel2, jLabel3};
        for (JLabel label : labels) {
            label.setForeground(new Color(41, 41, 41));
        }

        roundPanel4.setSize(100, 50);
        roundPanel4.setBackground(new Color(41, 211, 143));
        roundPanel6.setBackground(new Color(253, 63, 95));
        jLabel12.setForeground(new Color(245, 245, 245));
    }

    private void reset() {
        ImageIcon icon = new ImageIcon("src/img/UploadImg.png");
        jLabel6.setIcon(icon);

        jTextField2.setText("");
        jComboBox1.setSelectedItem("Select");
        jComboBox2.setSelectedItem("Select");

    }

    private String addProduct() {
        String msg = "Invalid";
        String title = jTextField2.getText();
        String category = String.valueOf(jComboBox1.getSelectedItem());
        String flavour = String.valueOf(jComboBox2.getSelectedItem());

        if (imgPath == null) {
            msg = "select a image";
        } else if (title.isEmpty()) {
            msg = "add product Title";
        } else if (category.equals("Select")) {
            msg = "Select Your Product Category";
        } else if (flavour.equals("Select")) {
            msg = "Select Your Flavour";
        } else {
            try {
                String categoryId = categoryMap.get(category);
                String flavourId = flavourMap.get(flavour);
                MySQL.executeIUD("INSERT INTO `product` (`title`, `category_id`, `flavor_id`, `img`) VALUES ('" + title + "', '" + categoryId + "', '" + flavourId + "', '" + imgPath + "')");
                msg = "done";
                reset();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return msg;
    }

   private void uploadImage() {
        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        // Filter for PNG and JPG files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "png", "jpg");
        fileChooser.setFileFilter(filter);

        // Open the file chooser dialog
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            // Get the file name
            String fileName = selectedFile.getName();

            // Check if the selected file is a valid image type
            if (fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
                // Destination folder inside the project
                String destinationPath = "src/img/" + fileName;

                try {
                    // Read the image
                    BufferedImage originalImage = ImageIO.read(selectedFile);

                    // Resize the image to 100x100
                    BufferedImage resizedImage = resizeImage(originalImage, 150, 165);

                    // Create the destination folder if it doesn't exist
                    Path destinationFolder = Path.of("src/img");
                    if (!Files.exists(destinationFolder)) {
                        Files.createDirectories(destinationFolder);
                    }

                    // Save the resized image to the destination path
                    File destinationFile = new File(destinationPath);
                    String formatName = fileName.substring(fileName.lastIndexOf('.') + 1); // Get the file format
                    ImageIO.write(resizedImage, formatName, destinationFile);
                    
                    ImageIcon icon = new ImageIcon(destinationPath);
                    jLabel6.setIcon(icon);
                    imgPath = destinationPath;
                 } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Failed to process the image.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid file type. Please select a PNG or JPG image.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Image upload cancelled.");
        }
    }

    // Method to resize an image
    private static BufferedImage resizeImage(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose(); // Release resources
        return resizedImage;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        roundPanel1 = new Componnent.RoundPanel();
        roundPanel4 = new Componnent.RoundPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        roundPanel6 = new Componnent.RoundPanel();
        jLabel13 = new javax.swing.JLabel();

        jTextField1.setFont(new java.awt.Font("Poppins", 1, 20)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        roundPanel4.setBackground(new java.awt.Color(255, 165, 0));

        jLabel12.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(245, 245, 245));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Add");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout roundPanel4Layout = new javax.swing.GroupLayout(roundPanel4);
        roundPanel4.setLayout(roundPanel4Layout);
        roundPanel4Layout.setHorizontalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel4Layout.setVerticalGroup(
            roundPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Upload Product Image");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/UploadImg.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 22)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Product Title");
        jPanel2.add(jLabel2);

        jTextField2.setFont(new java.awt.Font("Poppins", 0, 22)); // NOI18N
        jPanel2.add(jTextField2);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 22)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Category");
        jPanel4.add(jLabel3);

        jComboBox1.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(260, 34));
        jPanel3.add(jComboBox1);

        jButton1.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jButton1.setText("Add New");
        jButton1.setMaximumSize(new java.awt.Dimension(103, 34));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel3.add(jButton1);

        jPanel4.add(jPanel3);

        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setFont(new java.awt.Font("Poppins", 1, 22)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Flavour");
        jPanel6.add(jLabel8);

        jComboBox2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(260, 34));
        jPanel5.add(jComboBox2);

        jButton2.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        jButton2.setText("Add New");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jPanel5.add(jButton2);

        jPanel6.add(jPanel5);

        roundPanel6.setBackground(new java.awt.Color(255, 165, 0));

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(245, 245, 245));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cancel");
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 37));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        roundPanel6.add(jLabel13);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(roundPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 436, Short.MAX_VALUE)
                        .addComponent(roundPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roundPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roundPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Admin_Product ap = new Admin_Product();
        AdminComponnentWindow.adminComponnent.removeAll();
        AdminComponnentWindow.adminComponnent.add(ap);
        SwingUtilities.updateComponentTreeUI(AdminComponnentWindow.adminComponnent.getParent());
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        uploadImage();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        String msg = addProduct();
        Notify notify = new Notify(msg);
        notify.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       AddCategory ac = new AddCategory();
       ac.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        AddFlavour af = new AddFlavour();
        af.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private Componnent.RoundPanel roundPanel1;
    private Componnent.RoundPanel roundPanel4;
    private Componnent.RoundPanel roundPanel6;
    // End of variables declaration//GEN-END:variables
}
