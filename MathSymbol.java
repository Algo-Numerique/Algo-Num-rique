
import javax.swing.*;
import java.awt.*;

public class MathSymbol extends JFrame {
    public MathSymbol() {
        setTitle("Exemple de superposition de JPanel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 200));

        // Création des deux panneaux à superposer
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setBounds(50, 50, 200, 150);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.setBounds(100, 100, 150, 100);

        // Utilisation d'un JLayeredPane pour superposer les panneaux
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 200));
        layeredPane.add(panel1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(panel2, JLayeredPane.PALETTE_LAYER);

        // Ajout du JLayeredPane à la fenêtre principale
        add(layeredPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MathSymbol example = new MathSymbol();
            example.setVisible(true);
        });
    }
}
