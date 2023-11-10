import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
//page pour choisir la multiplication
public class Page2Boutton1 {
     public void intializePage1P2(){

        Dimension tailleBouton = new Dimension(300, 150);

        JButton nextPageButton3 = new JButton("Multiplication matrice vecteur");
        nextPageButton3.setFont(Application.MAIN_FONT);
        nextPageButton3.setBackground(new Color(0, 139, 139));
        nextPageButton3.setPreferredSize(tailleBouton);
        nextPageButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.cardLayout.show(Application.cardPanel, "page3");
            }
        });
       
        JButton nextPageButton4 = new JButton("Multiplication matrice matrice");
        nextPageButton4.setFont(Application.MAIN_FONT);
        nextPageButton4.setBackground(new Color(0, 139, 139));
        nextPageButton4.setPreferredSize(tailleBouton);
        nextPageButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.cardLayout.show(Application.cardPanel, "page5");
            }
        });
        JPanel page2buttPanel= new JPanel();
        page2buttPanel.setOpaque(false);
        page2buttPanel.add(nextPageButton3);
        page2buttPanel.add(nextPageButton4); 

        JPanel page2 =new JPanel();
        page2.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 100));
        page2.setBackground(new Color(150,150,150));
        JLabel descLabel2=new JLabel("Choisir SVP quelle multiplication voulez-vous :");
        descLabel2.setFont(Application.MAIN_FONT);
        page2.add(descLabel2); 
        page2.add(page2buttPanel);
        Application.cardPanel.add(page2,"page2");

    }
}
