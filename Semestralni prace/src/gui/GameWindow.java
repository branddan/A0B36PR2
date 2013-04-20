/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;
import semestralni.prace.*;

/**
 *
 * @author Daniel
 */
public class GameWindow extends JFrame {

    private Shot shot = new Shot();
    private JButton fire;
    private Arrow stay;
    private Arrow up;
    private Arrow down;
    private Arrow right;
    private Arrow left;
    private JTextField angle;
    private JTextField speed;
    private Helicopter playerAt;
    private Helicopter playerDef;
    private int movesLeft;

    public class TextAngleField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double value = Double.parseDouble(angle.getText());
            shot.setAngle(value);
            System.out.println("angle: " + shot.getAngle());
        }
    }

    public class TextSpeedField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double value = Double.parseDouble(speed.getText());
            shot.setSpeed(value);
            System.out.println("speed: " + shot.getSpeed());
        }
    }
    
    public class ShotResolve implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            shot.hit();
        }
    }

    public GameWindow() throws HeadlessException {

        super("Game");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);

        fire = new JButton();
        fire.setBounds(20, 300, 80, 50);
        fire.setText("FIRE");
        fire.addActionListener(new TextAngleField());
        fire.addActionListener(new TextSpeedField());
        fire.addActionListener(new ShotResolve());
        this.add(fire);

        stay = new Arrow("stay", "Stay");
        stay.setBounds(100, 100, 80, 50);
        this.add(stay);

        up = new Arrow("up","Up");
        up.setBounds(100, 48, 80, 50);
        this.add(up);

        down = new Arrow("down", "Down");
        down.setBounds(100, 152, 80, 50);
        this.add(down);

        left = new Arrow("left", "Left");
        left.setBounds(18, 100, 80, 50);
        this.add(left);

        right = new Arrow("right", "Right");
        right.setBounds(182, 100, 80, 50);
        this.add(right);

        angle = new JTextField();
        angle.setBounds(182, 400, 80, 50);
        this.add(angle);

        speed = new JTextField();
        speed.setBounds(100, 400, 80, 50);
        this.add(speed);
    }
    
    

    public Helicopter getPlayerAt() {
        return playerAt;
    }

    public void setPlayerAt(Helicopter playerAt) {
        this.playerAt = playerAt;
        shot.setPlayerAt(playerAt);
        movesLeft = playerAt.getSpeed();
    }

    public Helicopter getPlayerDef() {
        return playerDef;
        
    }

    public void setPlayerDef(Helicopter playerDef) {
        this.playerDef = playerDef;
        shot.setPlayerDef(playerDef);
    }

    public int getMovesLeft() {
        return movesLeft;
    }

    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }
}
