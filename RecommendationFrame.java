import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RecommendationFrame extends JFrame {
    private JTextArea textArea;
    private JButton btnBack;

    public RecommendationFrame() {
        setTitle("Recommendation");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Climate Action Recommendation", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(new Color(0, 120, 0));

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        textArea.setText(RecommendationEngine.getSuggestions(AppData.totalEmission));

        JScrollPane scrollPane = new JScrollPane(textArea);

        btnBack = new JButton("Back");
        btnBack.addActionListener((ActionEvent e) -> {
            new DashboardFrame().setVisible(true);
            dispose();
        });

        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(btnBack, BorderLayout.SOUTH);
    }
}