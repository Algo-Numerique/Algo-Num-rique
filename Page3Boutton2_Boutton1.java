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

public class Page3Boutton2_Boutton1 {
    private JTextField textType3,textSize3,textType4;
    private JLabel matrixLabel3,matrixLabel4,resultMatrixLabel;
    private MatrixClass matrix3,matrix4;
     public void intializePage12P3(){
        JLabel labelT1= new JLabel("Type matrice 2:");
        labelT1.setFont(Application.MAIN_FONT);
        textType3=new JTextField();
        textType3.setFont(Application.MAIN_FONT);

        JLabel labelT2= new JLabel("Type matrice1:");
        labelT2.setFont(Application.MAIN_FONT);
        textType4=new JTextField();
        textType4.setFont(Application.MAIN_FONT);
        // saisir la taille
        JLabel labelSize2= new JLabel("Size:");
        labelSize2.setFont(Application.MAIN_FONT);
        textSize3=new JTextField();
        textSize3.setFont(Application.MAIN_FONT);

        JPanel entrePanel2= new JPanel();
        entrePanel2.setLayout(new GridLayout(4,1,5,5));
        entrePanel2.setOpaque(false);
        entrePanel2.add(labelT2);
        entrePanel2.add(textType4);
        entrePanel2.add(labelT1);
        entrePanel2.add(textType3);
        entrePanel2.add(labelSize2);
        entrePanel2.add(textSize3);

        matrixLabel3 = new JLabel();
        matrixLabel3.setFont(Application.MAIN_FONT);
        matrixLabel4 = new JLabel();
        matrixLabel4.setFont(Application.MAIN_FONT);
        resultMatrixLabel = new JLabel();
        resultMatrixLabel.setFont(Application.MAIN_FONT);

        JButton buttonMatrix4 = new JButton("create Matrix ");
        buttonMatrix4.setFont(Application.MAIN_FONT);
        buttonMatrix4.setBackground(new Color(0, 139, 139));
        buttonMatrix4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String type=textType4.getText();
                int size=Integer.parseInt(textSize3.getText());
                matrix4= new MatrixClass(type, size);
                String ch=matrix4.afficheMatrix();
                ch = ch.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
                // Ajoute également les retours à la ligne avec des balises <br>
                ch = ch.replaceAll("\n", "<br>");
                matrixLabel4.setText("<html>" + ch + "</html>");
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton buttonmatrix3 = new JButton("create Matrix ");
        buttonmatrix3.setFont(Application.MAIN_FONT);
        buttonmatrix3.setBackground(new Color(0, 139, 139));
        buttonmatrix3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String type=textType3.getText();
                int size=Integer.parseInt(textSize3.getText());
                matrix3= new MatrixClass(type, size);
                String ch=matrix3.afficheMatrix();
                ch = ch.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
                // Ajoute également les retours à la ligne avec des balises <br>
                ch = ch.replaceAll("\n", "<br>");
                matrixLabel3.setText("<html>" + ch + "</html>");
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
                MultiplicationMatrixMatrix m= new MultiplicationMatrixMatrix(matrix4,matrix3);
                String str=m.afficheMatrix();
                str = str.replaceAll("\n", "<br>");
                resultMatrixLabel.setText("<html>" + str + "</html>");

                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton pagePreButton = new JButton("<-- Page Précédente");
        pagePreButton.setFont(Application.MAIN_FONT);
        pagePreButton.setBackground(new Color(0, 139, 139));

        // Ajoutez un ActionListener au bouton pour revenir à la première "page"
        pagePreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.cardLayout.show( Application.cardPanel,"page1");
            }
        });
        JPanel buttonGlob= new JPanel();
        buttonGlob.setLayout(new GridLayout(1,2,5,5));
        buttonGlob.setOpaque(false);
        buttonGlob.add(pagePreButton);
        buttonGlob.add(buttonMatrix4);
        buttonGlob.add(buttonmatrix3);
        buttonGlob.add(buttonmultp);


        JPanel descriPanelMultiplication2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 50));
        descriPanelMultiplication2.setOpaque(false);
        descriPanelMultiplication2.add(matrixLabel4);
        descriPanelMultiplication2.add(matrixLabel3);
        descriPanelMultiplication2.add(resultMatrixLabel);


        JPanel page5= new JPanel(new BorderLayout());
        page5.setBackground(new Color(150,150,150));
        page5.add(entrePanel2, BorderLayout.NORTH);
        page5.add(descriPanelMultiplication2,BorderLayout.CENTER);
        page5.add(buttonGlob,BorderLayout.SOUTH);


        Application.cardPanel.add(page5, "page5");
    }
}
