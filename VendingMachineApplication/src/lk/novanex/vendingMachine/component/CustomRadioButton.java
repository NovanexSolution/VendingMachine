/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.novanex.vendingMachine.component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JRadioButton;

public class CustomRadioButton extends JRadioButton {

    public CustomRadioButton() {
        setOpaque(false);
        //setBackground(new Color(69, 124, 235));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        JRadioButton radioButton = new JRadioButton("Male");
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int ly = (getHeight() - 18) / 2;
        //JRadioButton radioButton = new JRadioButton("Male");
        if (isSelected()) {
            if (isEnabled()) {
                g2.setColor(new Color(255, 165, 0));
            } else {
                g2.setColor(Color.GRAY);
            }
            g2.fillOval(1, ly, 18, 18);
            g2.setColor(Color.WHITE);
            g2.fillOval(5, ly + 5, 9, 9);
            if (isEnabled()) {
                g2.setColor(new Color(255, 165, 0));
            } else {
                g2.setColor(Color.GRAY);
            }
            g2.fillOval(5, ly + 3, 0, 0);

        }
        g2.dispose();

    }

}
