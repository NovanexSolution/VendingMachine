/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package lk.novanex.vendingMachine.panel;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
import javax.swing.SwingUtilities;
import javax.swing.text.html.HTML;
import lk.novanex.vendingMachine.model.MySQL;

/**
 *
 * @author Madusanka
 */
public class NormalProductViewPlusCart extends javax.swing.JPanel {

    /**
     * Creates new form NormalProductView
     */
//    cart addedd products id
    Set<String> cartProducts = new HashSet<String>();

//    HashMap<productID, Product data array> products = new HashMap<>();
    HashMap<String, ArrayList> products = new HashMap<>();

//    get productCountDetails
    HashMap<Integer, String> productMap = new HashMap<>();

    private int productCount = 1;
    private int productHasCreated = 0;
    private int mapStart = 1;
    private int mapEnd = 4;
    private int restProduct = 0;
    int emtyProduct;

    public NormalProductViewPlusCart(String selectedProduct) {
        initComponents();
        init(selectedProduct);
        laodProducts("All");
        jPanel1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        createGridItem();

    }

    private void init(String selectedProduct) {
        jPanel2.setSize(320, 650);
        cartProducts.add(selectedProduct);
        SideCart sideCart = new SideCart(cartProducts);
        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(sideCart);
    }

    public void createCartItem(String selectedProduct) {
        cartProducts.add(selectedProduct);
        System.out.println(cartProducts);
        SideCart sideCartNew = new SideCart(cartProducts);
        jPanel2.setLayout(new BorderLayout());
        jPanel2.removeAll();
        jPanel2.add(sideCartNew);
        SwingUtilities.updateComponentTreeUI(jPanel2);
    }

    private void createGridItem() {
        int mapSize = productMap.size();
        restProduct = mapSize - productHasCreated;

        if ((mapSize != 0) && (restProduct > 0)) {

            if (restProduct < 4) {
                mapEnd = mapSize;
                emtyProduct = 4 - restProduct;

            } else {
                mapEnd = productHasCreated + 4;
            }

            for (int i = mapStart; i <= mapEnd; i++) {
                createProducts(String.valueOf(i));
                mapStart++;
            }

            if (emtyProduct < 4) {

                for (int y = 0; y < emtyProduct; y++) {
                    EmtyProduct ep = new EmtyProduct();
                    jPanel1.add(ep);
                }
            }

        }
    }

    private void createProducts(String currentProduct) {

        Product productCard = new Product(currentProduct);
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
        productFilter1 = new lk.novanex.vendingMachine.panel.ProductFilter();
        productNext2 = new lk.novanex.vendingMachine.panel.ProductNext();
        productBack1 = new lk.novanex.vendingMachine.panel.ProductBack();
        jPanel2 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1000, 750));

        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(productBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productNext2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(productFilter1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productFilter1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productNext2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addComponent(productBack1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private lk.novanex.vendingMachine.panel.ProductBack productBack1;
    private lk.novanex.vendingMachine.panel.ProductFilter productFilter1;
    private lk.novanex.vendingMachine.panel.ProductNext productNext2;
    // End of variables declaration//GEN-END:variables
}
