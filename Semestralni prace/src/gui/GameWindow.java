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
    
    public class TextAngleField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            double value = Double.parseDouble(angle.getText());
            shot.setAngle(value);
            System.out.println("angle: " + shot.getAngle());
        }
    }
    
    public class TextSpeedField implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            double value = Double.parseDouble(speed.getText());
            shot.setSpeed(value);
            System.out.println("speed: " + shot.getSpeed());
        }
    }
    
    private JButton fire;
    private Arrow stay;
    private Arrow up;
    private Arrow down;
    private Arrow right;
    private Arrow left;
    private JTextField angle;
    private JTextField speed;

    public GameWindow() throws HeadlessException {

        super("Intro");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);

        fire = new JButton();
        fire.setBounds(20, 300, 80, 50);
        fire.setText("FIRE");
        this.add(fire);

        stay = new Arrow("stay");
        stay.setBounds(100, 100, 80, 50);
        stay.setText("stay");
        this.add(stay);

        up = new Arrow("up");
        up.setBounds(100, 48, 80, 50);
        up.setText("Up");
        this.add(up);

        down = new Arrow("down");
        down.setBounds(100, 152, 80, 50);
        down.setText("Down");
        this.add(down);

        right = new Arrow("right");
        right.setBounds(18, 100, 80, 50);
        right.setText("Right");
        this.add(right);

        left = new Arrow("left");
        left.setBounds(182, 100, 80, 50);
        left.setText("Left");
        this.add(left);

        angle = new JTextField();
        angle.setBounds(182, 400, 80, 50);
        angle.addActionListener(new TextAngleField());
        this.add(angle);
        
        speed = new JTextField();
        speed.setBounds(100, 400, 80, 50);
        speed.addActionListener(new TextSpeedField());
        this.add(speed);
    }
    
    
}
