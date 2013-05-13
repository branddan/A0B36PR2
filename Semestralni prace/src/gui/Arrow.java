/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.GameWindow.*;
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
//        super(text);
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
        playerAt.move(direction);
        System.out.println(playerAt);
        g.setMovesLeft(g.getMovesLeft() - 1);
        System.out.println("moves " + g.getMovesLeft());
        System.out.println("moves " + playerAt.getSpeed());
        g.doMove();
        if (g.getMovesLeft() == 0) {
            System.out.println("konec kola");
            g.setPlayerAt(playerDef); // vymena hracu na konci kola
            HelicoIcon helico = g.getHelicoDef();
            g.setHelicoDef(g.getHelicoAt());
            g.setHelicoAt(helico);
            g.setPlayerDef(playerAt);
            g.setMovesLeft(playerDef.getSpeed());
        }
    }

    public void setImage(String imageName) {
        this.setIcon(new ImageIcon(path + "\\images\\" + imageName));
        validate();
    }
}
