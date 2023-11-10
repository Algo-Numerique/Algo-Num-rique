import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Page1 {
    public void intializePage1(){
        Dimension tailleBouton = new Dimension(300, 150);
       

        JButton nextPageButton1 = new JButton("Multiplication");
        nextPageButton1.setFont(Application.MAIN_FONT);
        nextPageButton1.setBackground(new Color(0, 139, 139));
        nextPageButton1.setPreferredSize(tailleBouton);
        nextPageButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                Application.cardLayout.show(Application.cardPanel, "page4");
            }
        });

         JPanel page1buttPanel= new JPanel();
        page1buttPanel.setOpaque(false);
        page1buttPanel.add(nextPageButton1);
        page1buttPanel.add(nextPageButton2);



        JPanel page1 =new JPanel();
        page1.setLayout(new FlowLayout(FlowLayout.CENTER, 300, 100));
        //ImageIcon backgroundImage = new ImageIcon("./image.jpg");
        //JLabel backgroundLabel = new JLabel(backgroundImage);
        //backgroundLabel.setLayout(new BorderLayout());
        page1.setBackground(new Color(150,150,150));
        JLabel descLabel=new JLabel("Choisir SVP si tu veux faire une multiplication ou une resolution");
        descLabel.setFont(Application.MAIN_FONT);
        page1.add(descLabel); 
        page1.add(page1buttPanel);
        Application.cardPanel.add(page1,"page1");
    }
}
