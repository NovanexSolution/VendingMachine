/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.novanex.vendingMachine.component;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author ASUS
 */
public class RoundPanel extends JPanel {

    public RoundPanel() {
        init();
    }

    private void init() {
        LineBorder border = new LineBorder(new Color(255, 165, 0), 1, true);
        this.setBorder(border);

    }

}
