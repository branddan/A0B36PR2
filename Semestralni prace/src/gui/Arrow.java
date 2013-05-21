/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.GameWindow.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import semestralni.prace.*;

/**
 *
 * @author Daniel
 */
public class Arrow extends JButton implements ActionListener {

    private String direction;
    private GameWindow g;
    private Helicopter playerAt;
    private Helicopter playerDef;
    private String path = System.getProperty("user.dir");

    public Arrow(String direction) {
        this.setImage(direction + ".png");
        if (direction != null) {
            this.direction = direction;
        }
        this.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        g = (GameWindow) this.getParent().getParent().getParent().getParent();
        playerAt = g.getPlayerAt();
        playerDef = g.getPlayerDef();
        boolean out = false;
        switch (direction) {
            case "up": {
                if (playerAt.getPosition().getY() + 10 - 20 <= 0) {
                    this.outofScreen(g);
                    out = true;
                }
            }
            break;
            case "down": {
                if (playerAt.getPosition().getY() + 20 >= 320) {
                    outofScreen(g);
                    out = true;
                }
            }
            break;
            case "left": {
                if (playerAt.getPosition().getX() + 23 - 30 <= 0) {
                    outofScreen(g);
                    out = true;
                }
            }
            break;
            case "right": {
                if (playerAt.getPosition().getX() + 50 + 30 >= 800) {
                    outofScreen(g);
                    out = true;
                }
            }
            break;
        }
        if (!out) {
            playerAt.move(direction);
            g.move();
            g.setMovesLeft(g.getMovesLeft() - 1);
            g.getScreen().repaint();
            g.getInstructions().setForeground(Color.green);
            g.getInstructions().setText("Player " + playerAt.getPlayerName() + ", you have " + g.getMovesLeft() + " moves left, you can move (for 1 move point) of fire (2 moves).");
            if (g.getMovesLeft() <= 0) {
                g.setPlayerAt(playerDef); // vymena hracu na konci kola
                HelicoIcon helico = g.getHelicoDef();
                g.setHelicoDef(g.getHelicoAt());
                g.setHelicoAt(helico);
                g.setPlayerDef(playerAt);
                g.setMovesLeft(playerDef.getSpeed());
                g.getInstructions().setText("Player " + playerAt.getPlayerName() + ", it's your turn, you can move (for 1 move point) of fire (2 moves).");
            }
//        }

    }
    }
    private void outofScreen(GameWindow gw) {
        gw.getInstructions().setForeground(Color.orange);
        gw.getInstructions().setText("You cannot move further");
    }

    public void setImage(String imageName) {
        this.setIcon(new ImageIcon(path + "\\images\\" + imageName));
        validate();
    }
}
