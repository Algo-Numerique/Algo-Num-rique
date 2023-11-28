import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
//page pour choisir la multiplication
public class Page2Boutton2 {
    private static final float BUTTON_CLICK_VOLUME = 1.5f;
     public void intializePage2P2(){

        Dimension tailleBouton = new Dimension(300, 150);

        JButton nextPageButton3 = new JButton("Resolution Gauss/Gauss Pivotage");
        nextPageButton3.setFont(Application.MAIN_FONT);
        nextPageButton3.setBackground(new Color(0, 139, 139));
        nextPageButton3.setPreferredSize(tailleBouton);
        nextPageButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButtonClickSound();
                Application.cardLayout.show(Application.cardPanel, "page4");
            }
        });
       
        JButton nextPageButton4 = new JButton("Resolution GaussJordon");
        nextPageButton4.setFont(Application.MAIN_FONT);
        nextPageButton4.setBackground(new Color(0, 139, 139));
        nextPageButton4.setPreferredSize(tailleBouton);
        nextPageButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playButtonClickSound();
                Application.cardLayout.show(Application.cardPanel, "page7");
            }
        });
        JPanel page2buttPanel= new JPanel();
        page2buttPanel.setOpaque(false);
        page2buttPanel.add(nextPageButton3);
        page2buttPanel.add(nextPageButton4); 
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


        JPanel page2 =new JPanel();
        page2.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 100));
        page2.setBackground(new Color(150,150,150));
        JLabel descLabel2=new JLabel("Choisir SVP quelle Resolution voulez-vous :");
        descLabel2.setFont(Application.MAIN_FONT);
        descLabel2.setForeground(Color.WHITE);

        buttonPanel.add(descLabel2);
        buttonPanel.add(page2buttPanel);

        // Ajout des panneaux au JLayeredPane
        layeredPane.add(imagePanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(buttonPanel, JLayeredPane.PALETTE_LAYER);

        Application.cardPanel.add(layeredPane, "page6");



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
