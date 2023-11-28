import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PcontentResolutionJordon {
    private JTextField textSize;
    private JLabel matrixLabel,vectLabel,resultLabel;
    private MatrixClass matrix;
    private Vector vect;
    private String type;
    public void initializePage(){
        JLabel labelTitre= new JLabel("                             Page Resolution GaussJordon matrice vecteur:");
        labelTitre.setFont(Application.MAIN_FONT);
        labelTitre.setForeground(Color.WHITE);
        JLabel labelType= new JLabel("Type de la matrice:");
        labelType.setFont(Application.MAIN_FONT);
        labelType.setForeground(Color.WHITE);
        // saisir la taille
        JLabel labelSize= new JLabel("Size:");
        labelSize.setFont(Application.MAIN_FONT);
        labelSize.setForeground(Color.WHITE);
        textSize=new JTextField();
        textSize.setFont(Application.MAIN_FONT);
        //matrixLabel
        matrixLabel= new JLabel();
        matrixLabel.setFont(Application.MAIN_FONT);
        matrixLabel.setForeground(Color.WHITE);
        
        //vecteur label
        vectLabel= new JLabel();
        vectLabel.setFont(Application.MAIN_FONT);
        vectLabel.setForeground(Color.WHITE);
        // vecteur resultat label
        resultLabel=new JLabel();
        resultLabel.setFont(Application.MAIN_FONT);
        resultLabel.setForeground(Color.WHITE);


        JMenuBar menuBar = new JMenuBar();

        JMenu TypeMenu = new JMenu("Type de la matrice");
        TypeMenu.setFont(Application.MAIN_FONT);
        JMenuItem MenuItem1 = new JMenuItem("Triangulaire Superieur");
        MenuItem1.setFont(Application.MAIN_FONT);
        MenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="triangsup";
                TypeMenu.setText(MenuItem1.getText());
            }
        });
        TypeMenu.add(MenuItem1);
        JMenuItem MenuItem2 = new JMenuItem("Triangulaire Inferieur");
        MenuItem2.setFont(Application.MAIN_FONT);
        MenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="trianginf";
                TypeMenu.setText(MenuItem2.getText());
            }
        });
        TypeMenu.add(MenuItem2);
        JMenuItem MenuItem3 = new JMenuItem("Dense");
        MenuItem3.setFont(Application.MAIN_FONT);
        MenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="dense";
                TypeMenu.setText(MenuItem3.getText());
            }
        });
        TypeMenu.add(MenuItem3);
        JMenuItem MenuItem4 = new JMenuItem("Bande");
        MenuItem4.setFont(Application.MAIN_FONT);
        MenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="bande";
                TypeMenu.setText(MenuItem4.getText());
            }
        });
        TypeMenu.add(MenuItem4);
        JMenuItem MenuItem5 = new JMenuItem("Bande Superieur");
        MenuItem5.setFont(Application.MAIN_FONT);
        MenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="bandeSup";
                TypeMenu.setText(MenuItem5.getText());
            }
        });
        TypeMenu.add(MenuItem5);
        JMenuItem MenuItem6 = new JMenuItem("Bande Inferieur");
        MenuItem6.setFont(Application.MAIN_FONT);
        MenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="bandeInf";
                TypeMenu.setText(MenuItem6.getText());
            }
        });
        TypeMenu.add(MenuItem6);
        JMenuItem MenuItem7 = new JMenuItem("Symetrique");
        MenuItem7.setFont(Application.MAIN_FONT);
        MenuItem7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="symetrique";
                TypeMenu.setText(MenuItem7.getText());
            }
        });
        TypeMenu.add(MenuItem7);

        JMenuItem MenuItem8 = new JMenuItem("Creuse ");
        MenuItem8.setFont(Application.MAIN_FONT);
        MenuItem8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="creuse";
                TypeMenu.setText(MenuItem8.getText());
            }
        });
        TypeMenu.add(MenuItem8);

        JMenuItem MenuItem9 = new JMenuItem("Symetrique Definie Positive ");
        MenuItem9.setFont(Application.MAIN_FONT);
        MenuItem9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="symetrique definiePositive";
                TypeMenu.setText(MenuItem9.getText());
            }
        });
        TypeMenu.add(MenuItem9);

        JMenuItem MenuItem10 = new JMenuItem("Definie Positive ");
        MenuItem10.setFont(Application.MAIN_FONT);
        MenuItem10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                type="definiePositive";
                TypeMenu.setText(MenuItem10.getText());
            }
        });
        TypeMenu.add(MenuItem10);
        menuBar.add(TypeMenu);
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.DARK_GRAY);
        menuBar.setPreferredSize(new Dimension(100,50));


        //panel pour les entrées
        JPanel entrePanel2= new JPanel();
        entrePanel2.setLayout(new GridLayout(5,1,5,5));
        entrePanel2.setOpaque(false);
        entrePanel2.add(labelType);
        entrePanel2.add(menuBar);
        entrePanel2.add(labelSize);
        entrePanel2.add(textSize);

        JPanel entreGlobPanel= new JPanel( new BorderLayout());
        entreGlobPanel.setOpaque(false);
        entreGlobPanel.add(labelTitre,BorderLayout.CENTER);
        entreGlobPanel.add(entrePanel2,BorderLayout.SOUTH);

        JButton button = new JButton("créer vecteur");
        button.setFont(Application.MAIN_FONT);
        button.setBackground(new Color(0, 139, 139));
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                int size=Integer.parseInt(textSize.getText());
                //creation d'un vecteur
                vect=new Vector(size);
                String str=vect.afficheVector();
                str = str.replaceAll("\n", "<br>");
                vectLabel.setText("<html>" + str + "</html>");

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        
        JButton buttonMatrix = new JButton("créer matrice ");
        buttonMatrix.setFont(Application.MAIN_FONT);
        buttonMatrix.setBackground(new Color(0, 139, 139));
        buttonMatrix.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                int size=Integer.parseInt(textSize.getText());if (type.equals("bande")||type.equals("bandeSup") ||type.equals("bandeInf")) {
                    int maxLarge = (size - 1) / 2;
                    while (true) {
                        String input = JOptionPane.showInputDialog(null, "Entrez la largeur :");
                        try {
                            int number = Integer.parseInt(input);
                            if (number <= maxLarge) {
                                MatrixClass.setBandWith(number);
                                break; // Sort de la boucle while car la saisie est valide
                            } else {
                                JOptionPane.showMessageDialog(null, "La largeur doit être inférieure ou égale à " + maxLarge);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                Application.playSoundbut();
                matrix= new MatrixClass(type, size);
                String ch = matrix.afficheMatrix();
                ch = ch.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
                ch = ch.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                ch = ch.replaceAll("</td></tr>", "</td></tr><br>");  // Ajoutez un retour à la ligne après chaque ligne
                // Ajoute également les retours à la ligne avec des balises <br>
                ch = ch.replaceAll("\n", "<br>");

                matrixLabel.setText("<html>" + ch + "</html>");
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton buttonLect = new JButton("lire matrice ");
        buttonLect.setFont(Application.MAIN_FONT);
        buttonLect.setBackground(new Color(0, 139, 139));
        buttonLect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                int size=Integer.parseInt(textSize.getText());if (type.equals("bande")||type.equals("bandeSup") ||type.equals("bandeInf")) {
                    int maxLarge = (size - 1) / 2;
                    while (true) {
                        String input = JOptionPane.showInputDialog(null, "Entrez la largeur :");
                        try {
                            int number = Integer.parseInt(input);
                            if (number <= maxLarge) {
                                MatrixClass.setBandWith(number);
                                break; // Sort de la boucle while car la saisie est valide
                            } else {
                                JOptionPane.showMessageDialog(null, "La largeur doit être inférieure ou égale à " + maxLarge);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                LectureMatrix lectMat= new LectureMatrix(type, size);
                matrix= new MatrixClass(type, size,lectMat.convertirMatriceEntiers());
                String ch=matrix.afficheMatrix();
                ch = ch.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                ch = ch.replaceAll("</td></tr>", "</td></tr><br>");  // Ajoutez un retour à la ligne après chaque ligne
                // Ajoute également les retours à la ligne avec des balises <br>
                ch = ch.replaceAll("\n", "<br>");
                matrixLabel.setText("<html>" + ch + "</html>");
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton lectvect = new JButton("lire vecteur");
        lectvect.setFont(Application.MAIN_FONT);
        lectvect.setBackground(new Color(0, 139, 139));
        lectvect.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                int size=Integer.parseInt(textSize.getText());
                LectureVector lectureVector=new LectureVector(size);
                vect=new Vector(size,lectureVector.getVector());
                String str=vect.afficheVector();
                str = str.replaceAll("\n", "<br>");
                vectLabel.setText("<html>" + str + "</html>");

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        
        JButton buttonres = new JButton("Resolution G_Jordon ");
        buttonres.setFont(Application.MAIN_FONT);
        buttonres.setBackground(new Color(0, 139, 139));
        buttonres.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                ResolutionGaussJordon res= new ResolutionGaussJordon(matrix, vect);
                String str=res.afficheVector();
                str = str.replaceAll("<td>", "&nbsp;&nbsp;&nbsp;&nbsp;<td>");  // Ajoutez de l'espace avant chaque cellule
                str = str.replaceAll("</td></tr>", "</td></tr><br>");
                resultLabel.setText("<html>" + str + "</html>");

                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });
        JButton previousPageButton2 = new JButton("<-- Page Principale");
        previousPageButton2.setFont(Application.MAIN_FONT);
        previousPageButton2.setBackground(new Color(0, 139, 139));

        // Ajoutez un ActionListener au bouton pour revenir à la première "page"
        previousPageButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                Application.cardLayout.show(Application.cardPanel, "page1");
            }
        });

        
        JButton clearButton = new JButton("Effacer Contenu");
        clearButton.setFont(Application.MAIN_FONT);
        clearButton.setBackground(new Color(0, 139, 139));
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.playSoundbut();
                // Réinitialiser les composants
                TypeMenu.setText("Type de la matrice ");
                textSize.setText("");
                vectLabel.setText("");
                matrixLabel.setText("");
                resultLabel.setText("");

                // Remettre à zéro les objets vect2 et matrix2 si nécessaire
                vect = null;
                matrix = null;
            }
        });

         


        JPanel buttResolPanel= new JPanel();
        buttResolPanel.setLayout(new GridLayout(2,2,5,5));
        buttResolPanel.setOpaque(false);
        buttResolPanel.add(clearButton);
        buttResolPanel.add(buttonMatrix);
        buttResolPanel.add(button);
        buttResolPanel.add(buttonres);
        buttResolPanel.add(previousPageButton2);
        buttResolPanel.add(buttonLect);
        buttResolPanel.add(lectvect);
        
        JPanel matPanel= new JPanel();
        matPanel.setOpaque(false);
        matPanel.add(matrixLabel);

        JPanel vectPanel = new JPanel();
        vectPanel.setOpaque(false);
        vectPanel.add(vectLabel);

        JPanel resultPanel= new JPanel();
        resultPanel.setOpaque(false);
        resultPanel.add(resultLabel);


        
        JPanel descriPanelResolution = new JPanel(new FlowLayout(FlowLayout.LEFT, 100, 50));
        descriPanelResolution.setOpaque(false);
        descriPanelResolution.add(matPanel);
        descriPanelResolution.add(vectPanel);
        descriPanelResolution.add(resultPanel);


        JPanel viewportBackgroundPanel = new JPanel();
        viewportBackgroundPanel.setOpaque(false);
        viewportBackgroundPanel.setLayout(new BorderLayout());
        viewportBackgroundPanel.add(descriPanelResolution, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(viewportBackgroundPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        ImageIcon backgroundImage = new ImageIcon("./image2.gif");

        // Création du JLayeredPane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(990, 760));

        // Panneau pour l'image en arrière-plan
        JPanel imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        imagePanel.setBounds(0, 0, 990, 760);

        // Panneau pour les boutons superposés
        JPanel page7 = new JPanel(new BorderLayout());
        page7.setOpaque(false);
        page7.setBounds(0, 0, 1000, 750);
        page7.add(entreGlobPanel, BorderLayout.NORTH);
        page7.add(scrollPane,BorderLayout.CENTER);
        page7.add(buttResolPanel,BorderLayout.SOUTH);



        // Ajout des panneaux au JLayeredPane
        layeredPane.add(imagePanel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(page7, JLayeredPane.PALETTE_LAYER);

        Application.cardPanel.add(layeredPane, "page7");
    }

}
