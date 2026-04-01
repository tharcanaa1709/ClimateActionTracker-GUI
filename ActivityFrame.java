import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActivityFrame extends JFrame {
    private JTextField txtDistance, txtElectricity, txtWaste;
    private JButton btnAdd, btnClear, btnBack;

    public ActivityFrame() {
        setTitle("Add Activity");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Add Climate Activities", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(0, 120, 0));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        formPanel.add(new JLabel("Transport Distance (km):"));
        txtDistance = new JTextField();
        formPanel.add(txtDistance);

        formPanel.add(new JLabel("Electricity Usage (units):"));
        txtElectricity = new JTextField();
        formPanel.add(txtElectricity);

        formPanel.add(new JLabel("Waste Produced (kg):"));
        txtWaste = new JTextField();
        formPanel.add(txtWaste);

        JPanel buttonPanel = new JPanel();
        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnBack = new JButton("Back");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnBack);

        add(title, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        btnAdd.addActionListener((ActionEvent e) -> addActivity());
        btnClear.addActionListener((ActionEvent e) -> clearFields());
        btnBack.addActionListener((ActionEvent e) -> {
            new DashboardFrame().setVisible(true);
            dispose();
        });
    }

    private void addActivity() {
        try {
            double distance = Double.parseDouble(txtDistance.getText().trim());
            double electricity = Double.parseDouble(txtElectricity.getText().trim());
            double waste = Double.parseDouble(txtWaste.getText().trim());

            AppData.currentUser.getActivities().clear();
            AppData.currentUser.addActivity(new TransportActivity(distance));
            AppData.currentUser.addActivity(new ElectricityUsage(electricity));
            AppData.currentUser.addActivity(new WasteManagement(waste));

            JOptionPane.showMessageDialog(this, "Activities added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers only.");
        }
    }

    private void clearFields() {
        txtDistance.setText("");
        txtElectricity.setText("");
        txtWaste.setText("");
    }
}