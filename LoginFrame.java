import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin, btnExit;

    public LoginFrame() {
        setTitle("Climate Action Tracker System - Login");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Climate Action Tracker System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(0, 100, 0));

        JLabel subtitle = new JLabel("SDG 13: Climate Action", JLabel.CENTER);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(title);
        topPanel.add(subtitle);

        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        centerPanel.add(new JLabel("Username:"));
        txtUsername = new JTextField();
        centerPanel.add(txtUsername);

        centerPanel.add(new JLabel("Password:"));
        txtPassword = new JPasswordField();
        centerPanel.add(txtPassword);

        JPanel bottomPanel = new JPanel();
        btnLogin = new JButton("Login");
        btnExit = new JButton("Exit");
        bottomPanel.add(btnLogin);
        bottomPanel.add(btnExit);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        btnLogin.addActionListener((ActionEvent e) -> login());
        btnExit.addActionListener((ActionEvent e) -> System.exit(0));
    }

    private void login() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        if (username.equals("admin") && password.equals("1234")) {
            AppData.currentUser = new User(username);
            JOptionPane.showMessageDialog(this, "Login Successful!");
            new DashboardFrame().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password!");
        }
    }
}