/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.novanex.vendingMachine.component;

import com.formdev.flatlaf.FlatClientProperties;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class RoundPanel extends JPanel{
    public RoundPanel(){
    init();
    }

    private void init() {
        this.putClientProperty(FlatClientProperties.STYLE, "arc:22");
    }

}
