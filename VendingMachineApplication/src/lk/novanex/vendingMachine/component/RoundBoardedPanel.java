/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.novanex.vendingMachine.component;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class RoundBoardedPanel extends JPanel{
    public RoundBoardedPanel(){
    init();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:22");
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        
        // Enable anti-aliasing for smooth edges
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the border color and stroke thickness
        g2d.setColor(Color.WHITE); // Border color
        g2d.setStroke(new BasicStroke(2)); // Border thickness

        // Draw a rounded rectangle with radius of 22
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 22, 22);

        g2d.dispose(); // Clean up the graphics object
    }
    

}