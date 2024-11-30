import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private static final int PANELS_PER_PAGE = 1; // Number of panels per page
    private int currentPage = 0; // Track the current page index
    private final List<JPanel> panelList = new ArrayList<>(); // Store all panels
    private final JPanel gridPanel = new JPanel(new GridLayout(4, 1)); // Grid panel to display panels
    private final JButton leftButton = new JButton("Left");
    private final JButton rightButton = new JButton("Right");

    public Test() {
        // Create the main frame
        JFrame frame = new JFrame("Grid Panel Navigation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLayout(new BorderLayout());

        // Populate the panel list with sample panels
        for (int i = 1; i <= 10; i++) {
            JPanel panel = new JPanel();
            panel.setBackground(new Color(100 + i * 10, 100 + i * 15, 200)); // Random color
            panel.add(new JLabel("Panel " + i)); // Label for identification
            panelList.add(panel);
        }

        // Add navigation buttons
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        navigationPanel.add(leftButton);
        navigationPanel.add(rightButton);

        // Add action listeners to buttons
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigatePanels(-1); // Go to the previous set of panels
            }
        });

        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigatePanels(1); // Go to the next set of panels
            }
        });

        // Add components to the frame
        frame.add(gridPanel, BorderLayout.CENTER);
        frame.add(navigationPanel, BorderLayout.SOUTH);

        // Load the first set of panels
        updateGrid();

        frame.setVisible(true);
    }

    /**
     * Navigate through the panel list and update the grid.
     *
     * @param direction Direction of navigation: -1 for left, 1 for right
     */
    private void navigatePanels(int direction) {
        int totalPages = (int) Math.ceil((double) panelList.size() / PANELS_PER_PAGE);

        // Update the current page index
        currentPage += direction;
        if (currentPage < 0) {
            currentPage = 0; // Prevent going below the first page
        } else if (currentPage >= totalPages) {
            currentPage = totalPages - 1; // Prevent going beyond the last page
        }

        // Update the grid
        updateGrid();
    }

    /**
     * Update the grid panel with the current set of panels based on the current page.
     */
    private void updateGrid() {
        gridPanel.removeAll(); // Clear the grid panel

        // Calculate the start and end indices for the current page
        int startIndex = currentPage * PANELS_PER_PAGE;
        int endIndex = Math.min(startIndex + PANELS_PER_PAGE, panelList.size());

        // Add panels for the current page
        for (int i = startIndex; i < endIndex; i++) {
            gridPanel.add(panelList.get(i));
        }

        gridPanel.revalidate(); // Revalidate to refresh the layout
        gridPanel.repaint(); // Repaint to display changes
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Test::new);
    }
}
