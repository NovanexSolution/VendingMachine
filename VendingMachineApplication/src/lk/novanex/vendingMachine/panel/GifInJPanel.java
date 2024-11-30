import javax.swing.*;
import java.awt.*;

public class GifInJPanel extends JFrame {

    public GifInJPanel() {
        // Create a JPanel
        JPanel panel = new JPanel();

        // Load the GIF image using ImageIcon
        ImageIcon gifImage = new ImageIcon("src/img/card.gif");
       
        // Create a JLabel and set the icon to the gifImage
        JLabel gifLabel = new JLabel(gifImage);
        gifLabel.setSize(100, 100);

        // Add the JLabel to the JPanel
        panel.add(gifLabel);

        // Add the JPanel to the JFrame
        add(panel);
        
//        gifLabel.setBackground(Color.red);
//        panel.setBackground(Color.BLACK);

        // Basic JFrame settings
        setTitle("GIF in JPanel Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
        this.setBackground(Color.BLACK);
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> new GifInJPanel());
    }
}
