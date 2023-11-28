import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class App extends JPanel implements ActionListener {
    private static final int WINDOW_WIDTH = 1000;
    private static final int WINDOW_HEIGHT = 800;
    private static final int ELEMENTS_COUNT = 100;
    private static final int ELEMENT_SIZE = 50;
    private ArrayList<PointWithElement> elements = new ArrayList<>();
    private Timer timer;
    private String[] mathSymbols = {"\u221A", "\u00F7", "\u00D7", "\u03A0", "\u2211", "\u220F"}; // Racine carrée, Division, Multiplication, Pi, Somme, Produit
    private Color symbolColor = Color.BLUE;
    private Color numberColor = Color.GREEN;

    public App() {
        timer = new Timer(50, this);
        timer.start();
        initializeElements();
    }

    private void initializeElements() {
        Random random = new Random();
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            int x = random.nextInt(WINDOW_WIDTH - ELEMENT_SIZE);
            int y = random.nextInt(WINDOW_HEIGHT - ELEMENT_SIZE);
            String element;
            Color color;

            if (random.nextBoolean()) { // Générer un entier aléatoire de 1 à 9 ou un symbole mathématique
                element = String.valueOf(random.nextInt(9) + 1);
                color = numberColor; // Couleur pour les entiers
            } else {
                element = mathSymbols[random.nextInt(mathSymbols.length)];
                color = symbolColor; // Couleur pour les symboles
            }
            elements.add(new PointWithElement(x, y, element, color));
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        for (PointWithElement pointWithElement : elements) {
            g2d.setColor(pointWithElement.color); // Définir la couleur avant de dessiner l'élément
            g2d.drawString(pointWithElement.element, pointWithElement.point.x, pointWithElement.point.y);
        }
    }

    public void actionPerformed(ActionEvent e) {
        moveElements();
        repaint();
    }

    private void moveElements() {
        Random random = new Random();
        for (PointWithElement pointWithElement : elements) {
            int dx = random.nextInt(5) - 2; // Changer aléatoirement la position horizontale
            int dy = random.nextInt(5) - 2; // Changer aléatoirement la position verticale
            pointWithElement.point.x += dx;
            pointWithElement.point.y += dy;
            // Assurer que les éléments restent à l'intérieur de la fenêtre
            pointWithElement.point.x = Math.max(0, Math.min(pointWithElement.point.x, WINDOW_WIDTH - ELEMENT_SIZE));
            pointWithElement.point.y = Math.max(0, Math.min(pointWithElement.point.y, WINDOW_HEIGHT - ELEMENT_SIZE));
        }
    }

    private static class PointWithElement {
        Point point;
        String element;
        Color color;

        PointWithElement(int x, int y, String element, Color color) {
            this.point = new Point(x, y);
            this.element = element;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animated Symbols and Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        App animatedSymbolsAndNumbers = new App();
        frame.add(animatedSymbolsAndNumbers);
        frame.setVisible(true);
    }
}
