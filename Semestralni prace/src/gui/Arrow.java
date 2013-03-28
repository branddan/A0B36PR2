/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.*;
import javax.swing.*;
import semestralni.prace.*;

/**
 *
 * @author Daniel
 */
public class Arrow extends JButton implements ActionListener{

    private String direction;
    private Helicopter attackingPlayer;

    public Arrow(String direction) {
        if (direction != null) {
            this.direction = direction;
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        attackingPlayer.move(direction);
    }
    
}
