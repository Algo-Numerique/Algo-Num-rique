//Application File
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
public class Application extends JFrame{
    final static Font MAIN_FONT=new Font("Segoe print",Font.BOLD,18);
    static CardLayout cardLayout;
    static JPanel cardPanel;
    
    public void initialize(){

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(1000, 800));
        this.setLocationRelativeTo(null);
        this.setName("Application des matrices");
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Ajout du son à l'initialisation de l'application
        playSound("./sonApp.wav");
        Page1 p1=new Page1();
        p1.intializePage1();
        Page2Boutton1 p2=new Page2Boutton1();
        p2.intializePage1P2();
        PageResolutionButton p7=new PageResolutionButton();
        p7.intializePage();
        Page2Boutton2 p3= new Page2Boutton2();
        p3.intializePage2P2();
        Page3boutton1_Boutton1 p4=new Page3boutton1_Boutton1();
        p4.intializePage11P3();
        Page3Boutton2_Boutton1 p5= new Page3Boutton2_Boutton1();
        p5.intializePage12P3();
        Page3Boutton1_Boutton2 p6=new Page3Boutton1_Boutton2();
        p6.initializePage21P3();
        PcontentResolutionJordon p8=new PcontentResolutionJordon();
        p8.initializePage();
        this.setResizable(false);
        this.getContentPane().add(cardPanel);
        this.setVisible(true);
    }
    public Dimension getApplicationSize() {
        return this.getSize();
    }
   private void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public static void playSoundbut() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("./clicSon.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
    public static void playSoundError() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("./ereurSon.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Application window= new Application();
        window.initialize();
    }
}