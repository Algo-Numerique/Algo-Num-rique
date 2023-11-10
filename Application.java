//Application File
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;

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
        this.setSize(new Dimension(1000,800));
        this.setLocationRelativeTo(null);
        this.setName("Application des matrices");
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        //page1
        Page1 p1=new Page1();
        p1.intializePage1();
        Page2Boutton1 p2=new Page2Boutton1();
        p2.intializePage1P2();
        Page2Boutton2 p3= new Page2Boutton2();
        p3.initializePage2P2();
        Page3boutton1_Boutton1 p4=new Page3boutton1_Boutton1();
        p4.intializePage11P3();
        Page3Boutton2_Boutton1 p5= new Page3Boutton2_Boutton1();
        p5.intializePage12P3();
        this.getContentPane().add(cardPanel);
        this.setVisible(true);
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