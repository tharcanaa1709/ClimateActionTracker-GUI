import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DashboardFrame extends JFrame {
    private JButton btnAddActivity, btnViewResult, btnRecommendation, btnSave, btnLogout;

    public DashboardFrame() {
        setTitle("Dashboard - Climate Action Tracker");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Dashboard", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setForeground(new Color(0, 120, 0));

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        btnAddActivity = new JButton("Add Activity");
        btnViewResult = new JButton("Calculate / View Result");
        btnRecommendation = new JButton("View Recommendation");
        btnSave = new JButton("Save Data");
        btnLogout = new JButton("Logout");

        buttonPanel.add(btnAddActivity);
        buttonPanel.add(btnViewResult);
        buttonPanel.add(btnRecommendation);
        buttonPanel.add(btnSave);
        buttonPanel.add(btnLogout);

        add(title, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        btnAddActivity.addActionListener((ActionEvent e) -> {
            new ActivityFrame().setVisible(true);
            dispose();
        });

        btnViewResult.addActionListener((ActionEvent e) -> {
            if (AppData.currentUser == null || AppData.currentUser.getActivities().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please add activities first.");
            } else {
                AppData.totalEmission = CarbonCalculator.calculateTotal(AppData.currentUser);
                new ResultFrame().setVisible(true);
                dispose();
            }
        });

        btnRecommendation.addActionListener((ActionEvent e) -> {
            if (AppData.currentUser == null || AppData.currentUser.getActivities().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please add activities first.");
            } else {
                AppData.totalEmission = CarbonCalculator.calculateTotal(AppData.currentUser);
                new RecommendationFrame().setVisible(true);
                dispose();
            }
        });

        btnSave.addActionListener((ActionEvent e) -> {
            if (AppData.currentUser == null || AppData.currentUser.getActivities().isEmpty()) {
                JOptionPane.showMessageDialog(this, "No data to save.");
            } else {
                AppData.totalEmission = CarbonCalculator.calculateTotal(AppData.currentUser);
                FileManager.saveData(AppData.currentUser, AppData.totalEmission);
                JOptionPane.showMessageDialog(this, "Data saved successfully!");
            }
        });

        btnLogout.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Logged out successfully.");
            new LoginFrame().setVisible(true);
            dispose();
        });
    }
}