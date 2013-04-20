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

/**
 *
 * @author Daniel
 */
public class IntroWindow extends JFrame {

    JButton playerButton;
    JButton player2;
    JRadioButton apache;
    JRadioButton blackHawk;
    ButtonGroup chose;
    JTextField name;
    JLabel instrukce;
    Helicopter player;
    int playerNumber = 0;
    GameWindow game = new GameWindow();
    

    public class NewPlayer implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (apache.isSelected()) {
                player = new Apache(name.getText());
            } else if (blackHawk.isSelected()) {
                player = new BlackHawk(name.getText());
            }
            ((JButton) e.getSource()).setEnabled(false);

            System.out.println("position " + player);
            playerNumber++;
            if (playerNumber == 1) {
                player.getPosition().createRandom(10, 30, 30, 70);
                game.setPlayerAt(player);
            } else if (playerNumber == 2) {
                player.getPosition().createRandom(70, 90, 30, 70);
                game.setPlayerDef(player);
                JButton button = (JButton) e.getSource();
                IntroWindow i = (IntroWindow) button.getParent().getParent().getParent().getParent();
                i.setVisible(false);
                game.setVisible(true);
                System.out.println("name " + player.getPlayerName());
                System.out.println("type " + player.getType());
                System.out.println("Speed " + player.getMaxShotSpeed());
            }
            name.setText(null);
        }

        private void addActionListener(NewPlayer aThis) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    public IntroWindow() throws HeadlessException {

        super("Intro");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        instrukce = new JLabel();
        instrukce.setBounds(0, 500, 800, 100);
        instrukce.setText("Player number 1, enter your name and choose your helicopter.");
        instrukce.setForeground(Color.green);
        this.add(instrukce);
        chose = new ButtonGroup();

        apache = new JRadioButton();
        apache.setBounds(50, 20, 100, 30);
        apache.setText("Apache");
        chose.add(apache);
        this.add(apache);

        blackHawk = new JRadioButton();
        blackHawk.setBounds(50, 50, 100, 30);
        blackHawk.setText("Black Hawk");
        chose.add(blackHawk);
        this.add(blackHawk);

        playerButton = new JButton();
        playerButton.setBounds(20, 100, 130, 32);
        playerButton.setText("Player 1");
        playerButton.addActionListener(new NewPlayer());
        this.add(playerButton);

        name = new JTextField();
        name.setBounds(182, 400, 80, 50);
        this.add(name);
        
    }
    
    
}
