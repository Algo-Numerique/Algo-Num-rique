import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Page1 {
    private static final float BUTTON_CLICK_VOLUME = 1.5f;
    public void intializePage1() {
        Dimension tailleBouton = new Dimension(300, 150);

        JButton nextPageButton1 = new JButton("Multiplication");
        nextPageButton1.setFont(Application.MAIN_FONT);
        nextPageButton1.setBackground(new Color(0, 139, 139));
        nextPageButton1.setPreferredSize(tailleBouton);
        nextPageButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButtonClickSound();
                Application.cardLayout.show(Application.cardPanel, "page2");
            }
        });
        JButton nextPageButton2 = new JButton("Resolution");
        nextPageButton2.setFont(Application.MAIN_FONT);
        nextPageButton2.setBackground(new Color(0, 139, 139));
        nextPageButton2.setPreferredSize(tailleBouton);
        nextPageButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButtonClickSound();
                Application.cardLayout.show(Application.cardPanel, "page8");
            }
        });

        JPanel page1buttPanel = new JPanel();
        page1buttPanel.setOpaque(false);
        page1buttPanel.add(nextPageButton1);
        page1buttPanel.add(nextPageButton2);

        ImageIcon backgroundImage = new ImageIcon("./image3.gif");


        // Création du JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(backgroundImage.getIconWidth(), backgroundImage.getIconHeight()));

        // Panneau pour l'image en arrière-plan
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        imagePanel.setBounds(0, 0, 1000, 800);

        // Panneau pour les boutons superposés
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 300, 70));
        buttonPanel.setOpaque(false);
        buttonPanel.setBounds(0, 100, backgroundImage.getIconWidth()/2, backgroundImage.getIconHeight()/2);

        JLabel descLabel = new JLabel("Choisir SVP si tu veux faire une multiplication ou une resolution");
        descLabel.setFont(Application.MAIN_FONT);
        descLabel.setForeground(Color.WHITE);

        buttonPanel.add(descLabel);
        buttonPanel.add(page1buttPanel);

        // Ajout des panneaux au JLayeredPane
        layeredPane.add(imagePanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(buttonPanel, JLayeredPane.PALETTE_LAYER);

        Application.cardPanel.add(layeredPane, "page1");
    }
    private void playButtonClickSound() {
        try {
            // Chargement du fichier audio du clic de bouton
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./CilcBouton.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(20f * (float) Math.log10(BUTTON_CLICK_VOLUME));
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
