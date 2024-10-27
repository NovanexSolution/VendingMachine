/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.novanex.vendingMachine.panel;

import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import lk.novanex.vendingMachine.model.MySQL;

/**
 *
 * @author Madusanka
 */
public class NormalProductView extends javax.swing.JPanel {

    /**
     * Creates new form NormalProductView
     */
//    HashMap<productID, Product data array> products = new HashMap<>();
    HashMap<String, ArrayList> products = new HashMap<>();

//    get productCountDetails
    HashMap<Integer, String> productMap = new HashMap<>();

    private int productCount = 1;
    private int productHasCreated = 0;
    private int mapStart = 1;
    private int mapEnd = 6;
    private int restProduct = 0;

    public NormalProductView() {
        initComponents();
        laodProducts("All");
        jPanel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        createGridItem();
    }

    private void createGridItem() {
        int mapSize = productMap.size();
        restProduct = mapSize - productHasCreated;

        if ((mapSize != 0) && (restProduct > 0)) {

            if (restProduct < 6) {
                mapEnd = mapSize;
            } else {
                mapEnd = productHasCreated + 6;
            }

            for (int i = mapStart; i <= mapEnd; i++) {
                createProducts(String.valueOf(i));
                mapStart++;
            }

        }
    }

    private void createProducts(String currentProduct) {

        Product productCard = new Product();
        jPanel1.add(productCard);

        productCard.setProductTitle(String.valueOf(products.get(currentProduct).get(0)));
        productCard.setProductPrice(String.valueOf(products.get(currentProduct).get(1)));
        productCard.setProductImg(String.valueOf(products.get(currentProduct).get(2)));
        productCard.setProductFlavor(String.valueOf(products.get(currentProduct).get(3)));

    }

    private void laodProducts(String type) {
        try {
            String querry = "SELECT * FROM `product` INNER JOIN `stock` ON `product`.`stock_id` = `stock`.`id` INNER JOIN `category` ON `product`.`category_id` = `category`.`id` INNER JOIN `flavor` ON `product`.`flavor_id` = `flavor`.`id` ";

            if (type != "All") {
                querry += "WHERE `category`.`category` = '" + type + "'";
            }

            ResultSet result = MySQL.execute(querry);

            int productFound = 0;

            while (result.next()) {
                productFound = 1;
                System.out.println("Found"); // temp comment product available

                ArrayList<String> productDetails = new ArrayList<>(); // tittle, price, img, flavor

//                Adding product Details
                productDetails.add(result.getString("product.title"));
                productDetails.add(String.valueOf((int) result.getInt("stock.sellingPrice")) + " LKR");
                productDetails.add(result.getString("product.img"));
                productDetails.add(result.getString("flavor.flavorName"));

//                add product by following id
                String product_Id = result.getString("product.id");
                products.put(product_Id, productDetails);

                productMap.put(productCount, result.getString("product.id"));

                productCount++;

            }

            if (productFound == 0) {
                System.out.println("Product Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1000, 750));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(2, 3, 25, 2));
        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
