/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;
import semestralni.prace.*;
import gui.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Daniel
 */
public class IntroWindow extends JFrame {

    Background background;
    JButton playerButton;
    JButton player2;
    JRadioButton apache;
    JRadioButton blackHawk;
    ButtonGroup chose;
    JTextField name;
    JLabel instrukce;
    Helicopter player;
    JLabel text;
    JPanel scheme;
    JLabel img;
    int playerNumber = 0;
    GameWindow game = new GameWindow();
    String path = System.getProperty("user.dir");

    public class NewPlayer implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if ((apache.isSelected() == false && blackHawk.isSelected() == false)) {
                instrukce.setText("You need to select first your helicopter type.");
                instrukce.setForeground(Color.orange);
            } else if (name.getText().length() == 0) {
                instrukce.setText("You need to write your name.");
                instrukce.setForeground(Color.orange);
            } else {

                if (apache.isSelected()) {
                    player = new Apache(name.getText());
                } else if (blackHawk.isSelected()) {
                    player = new BlackHawk(name.getText());
                }

                playerNumber++;

                if (playerNumber == 1) {
                    player.getPosition().createRandom(10, 30, 30, 70);
                    game.setPlayerAt(player);
                    playerButton.setText("Create 2nd player");
                    instrukce.setText("Player number 2, enter your name and choose your helicopter.");
                    instrukce.setForeground(Color.green);
                    System.out.println("1: " + player);
                } else if (playerNumber == 2) {
                    player.getPosition().createRandom(70, 90, 30, 70);
                    game.setPlayerDef(player);
                    JButton button = (JButton) e.getSource();
                    IntroWindow i = (IntroWindow) button.getParent().getParent().getParent().getParent();
                    i.setVisible(false);
                    game.setVisible(true);
                    game.open();
                    System.out.println("2: " + player);
                }
                name.setText("Player 2");
            }
        }

        private void addActionListener(NewPlayer aThis) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    public class Details implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == apache) {
                background.setImageName("apache.jpg");
                text.setText("<html><h2>AH-64 Apache</h2> <br> <i>The Boeing AH-64 Apache is a four-blade, twin-engine attack helicopter with a tailwheel-type landing gear arrangement, and a tandem cockpit for a two-man crew.</i> <br> <br> Swift and light, the Apache is ideal for outmaneuvre it's oponent. However, it’s reduced firepower and hull strength makes it vulnerable in frontal assaults.");
                img.setIcon(new ImageIcon(path + "\\images\\apacheScheme.png"));
            } else if (e.getSource() == blackHawk) {
                background.setImageName("blackHawk.jpg");
                text.setText("<html><h2>UH-60 Black Hawk</h2> <br> <i>The Sikorsky UH-60 Black Hawk is a four-bladed, twin-engine, medium-lift utility helicopter manufactured by Sikorsky Aircraft. The Black Hawk's consists of two pilots, two gunners and up to 11 troops. </i> <br> <br> Heavily armored and armed, the Black Hawk is a flying colossus with a great firepower but somewhat slow and clumsy.");
                img.setIcon(new ImageIcon(path + "\\images\\blackHawkScheme.png"));
            }
            
            JRadioButton button = (JRadioButton) e.getSource();
            IntroWindow i = (IntroWindow) button.getParent().getParent().getParent().getParent();
            i.add(background);
            
        }
    }

    public IntroWindow() throws HeadlessException {

        super("Intro");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);



        text = new JLabel();
        text.setBounds(0, 276, 200, 245);
        this.add(text);

        scheme = new JPanel();
        scheme.setBounds(0, 141, 200, 134);
        img = new JLabel();
        scheme.setBackground(Color.white);
        scheme.setOpaque(false);
        scheme.add(img);
        this.add(scheme);

        instrukce = new JLabel();
        instrukce.setBounds(0, 543, 800, 30);
        instrukce.setText("Player number 1, enter your name and choose your helicopter.");
        instrukce.setForeground(Color.green);
        this.add(instrukce);
        instrukce.setOpaque(true);
        instrukce.setBackground(Color.BLACK);
        chose = new ButtonGroup();

        apache = new JRadioButton();
        apache.setBounds(0, 50, 200, 30);
        apache.setText("Apache");
        apache.addActionListener(new Details());
        chose.add(apache);
        this.add(apache);

        blackHawk = new JRadioButton();
        blackHawk.setBounds(0, 80, 200, 30);
        blackHawk.setText("Black Hawk");
        blackHawk.addActionListener(new Details());
        chose.add(blackHawk);
        this.add(blackHawk);

        playerButton = new JButton();
        playerButton.setBounds(0, 110, 200, 32);
        playerButton.setText("Create 1st player");
        playerButton.addActionListener(new NewPlayer());
        this.add(playerButton);

        name = new JTextField("Player 1");
        name.setBounds(0, 0, 200, 50);
        this.add(name);

        background = new Background("blackHawk.jpg");
        background.setBounds(0, 0, 800, 600);
        background.setOpaque(false);
        this.add(background);
    }
}
