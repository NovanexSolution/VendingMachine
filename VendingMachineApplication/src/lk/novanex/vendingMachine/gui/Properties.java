package lk.novanex.vendingMachine.gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Madusanka
 */
public class Properties {

    
    
    public static void setMsgTitle(JLabel mainLabel, JLabel subLabel, String MainTxt, String subTxt) {
        Font mainFont = new Font("poppins", Font.BOLD, 48);
        Font subFont = new Font("poppins", Font.PLAIN, 32);
        
        mainLabel.setForeground(new Color(29, 29, 29));
        mainLabel.setFont(mainFont);
        mainLabel.setText(MainTxt);
        
        subLabel.setForeground(new Color(29, 29, 29));
        subLabel.setFont(subFont);
        subLabel.setText(subTxt);        
    }

}
