import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ResultFrame extends JFrame {
    private JLabel lblEmission, lblStatus;
    private JButton btnBack;

    public ResultFrame() {
        setTitle("Result");
        setSize(450, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Emission Result", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(0, 120, 0));

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        lblEmission = new JLabel("Total Carbon Emission: " + AppData.totalEmission + " kg CO2", JLabel.CENTER);

        String status;
        if (AppData.totalEmission > 15) {
            status = "HIGH";
        } else if (AppData.totalEmission > 8) {
            status = "MEDIUM";
        } else {
            status = "LOW";
        }

        lblStatus = new JLabel("Status: " + status, JLabel.CENTER);

        centerPanel.add(lblEmission);
        centerPanel.add(lblStatus);

        btnBack = new JButton("Back");
        btnBack.addActionListener((ActionEvent e) -> {
            new DashboardFrame().setVisible(true);
            dispose();
        });

        add(title, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(btnBack, BorderLayout.SOUTH);
    }
}