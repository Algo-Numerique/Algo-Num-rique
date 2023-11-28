
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu {
    public Menu(MatrixClass mat,JPanel panel){
        JMenuBar menuBar = new JMenuBar();

        JMenu TypeMenu = new JMenu("type");
        TypeMenu.setFont(Application.MAIN_FONT);
        JMenuItem MenuItem1 = new JMenuItem("Triangulaire Superieur");
        MenuItem1.setFont(Application.MAIN_FONT);
        MenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("triangsup");
            }
        });
        TypeMenu.add(MenuItem1);
        JMenuItem MenuItem2 = new JMenuItem("Triangulaire Inferieur");
        MenuItem2.setFont(Application.MAIN_FONT);
        MenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("trianginf");
            }
        });
        TypeMenu.add(MenuItem2);
        JMenuItem MenuItem3 = new JMenuItem("Dense");
        MenuItem3.setFont(Application.MAIN_FONT);
        MenuItem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("dense");
            }
        });
        TypeMenu.add(MenuItem3);
        JMenuItem MenuItem4 = new JMenuItem("Bande");
        MenuItem4.setFont(Application.MAIN_FONT);
        MenuItem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("bande");
            }
        });
        TypeMenu.add(MenuItem4);
        JMenuItem MenuItem5 = new JMenuItem("Bande Superieur");
        MenuItem5.setFont(Application.MAIN_FONT);
        MenuItem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("bandeSup");
            }
        });
        TypeMenu.add(MenuItem5);
        JMenuItem MenuItem6 = new JMenuItem("Bande Inferieur");
        MenuItem6.setFont(Application.MAIN_FONT);
        MenuItem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("bandeInf");
            }
        });
        TypeMenu.add(MenuItem6);
        JMenuItem MenuItem7 = new JMenuItem("Symetrique");
        MenuItem7.setFont(Application.MAIN_FONT);
        MenuItem7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("symetrique");
            }
        });
        TypeMenu.add(MenuItem7);

        JMenuItem MenuItem8 = new JMenuItem("Creuse ");
        MenuItem8.setFont(Application.MAIN_FONT);
        MenuItem8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("creuse");
            }
        });
        TypeMenu.add(MenuItem8);

        JMenuItem MenuItem9 = new JMenuItem("Symetrique Definie Positive ");
        MenuItem9.setFont(Application.MAIN_FONT);
        MenuItem9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("symetrique definiePositive");
            }
        });
        TypeMenu.add(MenuItem9);

        JMenuItem MenuItem10 = new JMenuItem("Definie Positive ");
        MenuItem10.setFont(Application.MAIN_FONT);
        MenuItem10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mat.setType("definiePositive");
            }
        });
        TypeMenu.add(MenuItem10);

        panel.add(menuBar);
    }
}
