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
//page pour la resolution par Gauss
public class Page2Boutton2 {
    private JTextField textType,textSize;
    private JLabel matrixLabel,vectLabel,resultLabel;
    private MatrixClass matrix;
    private Vector vect;
    public void initializePage2P2(){
        JLabel labelType= new JLabel("Type:");
        labelType.setFont(Application.MAIN_FONT);
        textType=new JTextField();
        textType.setFont(Application.MAIN_FONT);
        // saisir la taille
        JLabel labelSize= new JLabel("Size:");
        labelSize.setFont(Application.MAIN_FONT);
        textSize=new JTextField();
        textSize.setFont(Application.MAIN_FONT);
        //matrixLabel
        matrixLabel= new JLabel();
        matrixLabel.setFont(Application.MAIN_FONT);
        
        //vecteur label
        vectLabel= new JLabel();
        vectLabel.setFont(Application.MAIN_FONT);
        // vecteur resultat label
        resultLabel=new JLabel();
        resultLabel.setFont(Application.MAIN_FONT);

        //panel pour les entrées
        JPanel entrePanel= new JPanel();
        entrePanel.setLayout(new GridLayout(2,1,5,5));
        entrePanel.setOpaque(false);
        entrePanel.add(labelType);
        entrePanel.add(textType);
        entrePanel.add(labelSize);
        entrePanel.add(textSize);

        

        JButton button = new JButton("create Vector");
        button.setFont(Application.MAIN_FONT);
        button.setBackground(new Color(0, 139, 139));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int size=Integer.parseInt(textSize.getText());
                //creation d'un vecteur
                vect=new Vector(size);
                String str=vect.afficheVector();
                str = str.replaceAll("\n", "<br>");
                vectLabel.setText("<html>" + str + "</html>");

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        
        JButton buttonMatrix = new JButton("create Matrix ");
        buttonMatrix.setFont(Application.MAIN_FONT);
        buttonMatrix.setBackground(new Color(0, 139, 139));
        buttonMatrix.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String type=textType.getText();
                int size=Integer.parseInt(textSize.getText());
                matrix= new MatrixClass(type, size);
                String ch=matrix.afficheMatrix();
                ch = ch.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
                // Ajoute également les retours à la ligne avec des balises <br>
                ch = ch.replaceAll("\n", "<br>");
                matrixLabel.setText("<html>" + ch + "</html>");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        
        
        JButton buttonres = new JButton("get Result resolution Matrix ");
        buttonres.setFont(Application.MAIN_FONT);
        buttonres.setBackground(new Color(0, 139, 139));
        buttonres.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ResolutionGauss res= new ResolutionGauss(matrix, vect);
                String str=res.afficheVector();
                str = str.replaceAll("\n", "<br>");
                resultLabel.setText("<html>" + str + "</html>");

                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton previousPageButton2 = new JButton("<-- Page Précédente");
        previousPageButton2.setFont(Application.MAIN_FONT);
        previousPageButton2.setBackground(new Color(0, 139, 139));

        // Ajoutez un ActionListener au bouton pour revenir à la première "page"
        previousPageButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.cardLayout.show(Application.cardPanel, "page1");
            }
        });

        
        

        JPanel buttResolPanel= new JPanel();
        buttResolPanel.setLayout(new GridLayout(1,2,5,5));
        buttResolPanel.setOpaque(false);
        buttResolPanel.add(previousPageButton2);
        buttResolPanel.add(buttonMatrix);
        buttResolPanel.add(button);
        buttResolPanel.add(buttonres);
        


        
        JPanel descriPanelResolution = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 50));
        descriPanelResolution.setOpaque(false);
        descriPanelResolution.add(matrixLabel);
        descriPanelResolution.add(vectLabel);
        descriPanelResolution.add(resultLabel);

        JPanel page4= new JPanel(new BorderLayout());
        page4.setBackground(new Color(150,150,150));
        page4.add(entrePanel, BorderLayout.NORTH);
        page4.add(descriPanelResolution,BorderLayout.WEST);
        page4.add(buttResolPanel,BorderLayout.SOUTH);

        Application.cardPanel.add(page4, "page4");

    }
}
