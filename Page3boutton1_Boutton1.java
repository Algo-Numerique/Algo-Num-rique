import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Page3boutton1_Boutton1 {
    private JTextField textType2,textSize2;
    private JLabel matrixLabel2,vectLabel2,resultLabel2;
    private Vector vect2;
    private MatrixClass matrix2;
     public void intializePage11P3(){
        JLabel labelType2= new JLabel("Type:");
        labelType2.setFont(Application.MAIN_FONT);
        textType2=new JTextField();
        textType2.setFont(Application.MAIN_FONT);
        // saisir la taille
        JLabel labelSize2= new JLabel("Size:");
        labelSize2.setFont(Application.MAIN_FONT);
        textSize2=new JTextField();
        textSize2.setFont(Application.MAIN_FONT);

        JPanel entrePanel2= new JPanel();
        entrePanel2.setLayout(new GridLayout(2,1,5,5));
        entrePanel2.setOpaque(false);
        entrePanel2.add(labelType2);
        entrePanel2.add(textType2);
        entrePanel2.add(labelSize2);
        entrePanel2.add(textSize2);

        matrixLabel2 = new JLabel();
        matrixLabel2.setFont(Application.MAIN_FONT);

        vectLabel2= new JLabel();
        vectLabel2.setFont(Application.MAIN_FONT);
        // vecteur resultat label
        resultLabel2=new JLabel();
        resultLabel2.setFont(Application.MAIN_FONT);


        JButton button2 = new JButton("create Vector");
        button2.setFont(Application.MAIN_FONT);
        button2.setBackground(new Color(0, 139, 139));
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int size=Integer.parseInt(textSize2.getText());
                //creation d'un vecteur
                vect2=new Vector(size);
                String str=vect2.afficheVector();
                str = str.replaceAll("\n", "<br>");
                vectLabel2.setText("<html>" + str + "</html>");

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton buttonMatrix2 = new JButton("create Matrix ");
        buttonMatrix2.setFont(Application.MAIN_FONT);
        buttonMatrix2.setBackground(new Color(0, 139, 139));
        buttonMatrix2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String type=textType2.getText();
                int size=Integer.parseInt(textSize2.getText());
                matrix2= new MatrixClass(type, size);
                String ch=matrix2.afficheMatrix();
                ch = ch.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
                // Ajoute également les retours à la ligne avec des balises <br>
                ch = ch.replaceAll("\n", "<br>");
                matrixLabel2.setText("<html>" + ch + "</html>");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton buttonmultp = new JButton("get Result Multiplication Matrix ");
        buttonmultp.setFont(Application.MAIN_FONT);
        buttonmultp.setBackground(new Color(0, 139, 139));
        buttonmultp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MultiplicationMatrixVector m= new MultiplicationMatrixVector(matrix2, vect2);
                String str=m.afficheResult();
                str = str.replaceAll("\n", "<br>");
                resultLabel2.setText("<html>" + str + "</html>");

                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton previousPageButton = new JButton("<-- Page Précédente");
        previousPageButton.setFont(Application.MAIN_FONT);
        previousPageButton.setBackground(new Color(0, 139, 139));

        // Ajoutez un ActionListener au bouton pour revenir à la première "page"
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.cardLayout.show( Application.cardPanel,"page1");
            }
        });
        JPanel buttPanel= new JPanel();
        buttPanel.setLayout(new GridLayout(1,2,5,5));
        buttPanel.setOpaque(false);
        buttPanel.add(previousPageButton);
        buttPanel.add(buttonMatrix2);
        buttPanel.add(button2);
        buttPanel.add(buttonmultp);


        JPanel descriPanelMultiplication = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 50));
        descriPanelMultiplication.setOpaque(false);
        descriPanelMultiplication.add(matrixLabel2);
        descriPanelMultiplication.add(vectLabel2);
        descriPanelMultiplication.add(resultLabel2);


        JPanel page3= new JPanel(new BorderLayout());
        page3.setBackground(new Color(150,150,150));
        page3.add(entrePanel2, BorderLayout.NORTH);
        page3.add(descriPanelMultiplication,BorderLayout.CENTER);
        page3.add(buttPanel,BorderLayout.SOUTH);


        Application.cardPanel.add(page3, "page3");
    }

}
