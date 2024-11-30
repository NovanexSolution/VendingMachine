package lk.novanex.vendingMachine.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lk.novanex.vendingMachine.component.RoundPanel;

public class Test extends javax.swing.JPanel {

    Set<String> categorySet = new HashSet<>();

    private void getCategory() {
        categorySet.add("Chips");
        categorySet.add("Choco");
    }

    public Test() {
        initComponents();
        categorySet.add("All");
        getCategory();
        init();
    }

    private void init() {
        for (String category : categorySet) {
            createElement(category);
        }
    }

    private void createElement(String text) {
        // Creating a new RoundPanel and JLabel for each category
        RoundPanel roundPanel2 = new RoundPanel();
        JLabel jLabel1 = new JLabel();

        // Initial background and text color based on category
        if (text.equals("All")) {
            roundPanel2.setBackground(new Color(255, 165, 0)); // Orange for "All"
            jLabel1.setForeground(Color.WHITE);
        } else {
            roundPanel2.setBackground(new Color(245, 245, 245)); // Light gray for others
            jLabel1.setForeground(new Color(29, 29, 29));
        }

        // Setting dimensions and text properties for jLabel1
        roundPanel2.setPreferredSize(new java.awt.Dimension(100, 46));
        jLabel1.setFont(new java.awt.Font("Poppins", 1, 20));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(text);

        // Adding MouseListener to both label and panel
        MouseAdapter colorChangeListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Reset all panels to deselected color (Gray background, Black text)
                for (Component comp : getComponents()) {
                    if (comp instanceof RoundPanel) {
                        comp.setBackground(Color.GRAY); // Deselected background color
                        Component[] innerComponents = ((JPanel) comp).getComponents();
                        if (innerComponents.length > 0 && innerComponents[0] instanceof JLabel) {
                            innerComponents[0].setForeground(Color.BLACK); // Deselected text color
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

        // Setting layout and adding label to roundPanel2
        roundPanel2.setLayout(new javax.swing.BoxLayout(roundPanel2, javax.swing.BoxLayout.Y_AXIS));
        roundPanel2.add(jLabel1);

        // Adding the dynamically created RoundPanel to the main panel
        add(roundPanel2);
    }

    private void initComponents() {
        // Initialize roundPanel1
        roundPanel1 = new lk.novanex.vendingMachine.component.RoundPanel();
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));
    }

    private lk.novanex.vendingMachine.component.RoundPanel roundPanel1;
}
