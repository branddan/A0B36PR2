/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;
import semestralni.prace.*;

/**
 *
 * @author Daniel
 */
public class GameWindow extends JFrame {

//    private Shot shot = new Shot();
    private Game game = new Game();
    private JButton fire;
    private Arrow stay;
    private Arrow up;
    private Arrow down;
    private Arrow right;
    private Arrow left;
    private JLabel control;
    private JTextField angle;
    private JTextField speed;
    private HelicoIcon helico1;
    private HelicoIcon helico2;
    private Helicopter playerAt;
    private Helicopter playerDef;
    private int movesLeft;
    private int x = 250;
    private int y = 350;
    Dragg d = new Dragg();
    Background background;

//    public void paint(Graphics g){
////        g.clearRect(0, 0, 1500, 1500);
////        g.drawLine(250, 350, x + 250, y + 350);
////        validate();
//        
//        d.paint(g);
////        repaint();
//    }
    public class HelicoIcon extends JPanel {

        public HelicoIcon(Helicopter helico) {
            this.setBounds((int) helico.getPosition().getX() + 400, (int) helico.getPosition().getY() + 200, 60, 20);
            JLabel image = new JLabel();
            image.setIcon(new ImageIcon("" + System.getProperty("user.dir") + "\\images\\" + helico.getType() + "Icon.jpg"));
            this.add(image);
            System.out.println("icon: " + helico);

        }
    }

    public class Dragg2 implements MouseMotionListener {

        private GameWindow g;

        public void mouseDragged(MouseEvent e) {
//        System.out.println("x " + e.toString());
            x = e.getX();
            y = e.getY();
            System.out.println("x: " + x);
            JLabel l = (JLabel) e.getSource();
            g = (GameWindow) l.getParent().getParent().getParent().getParent();
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    public class TextAngleField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double value = Double.parseDouble(angle.getText());
            game.getShot().setAngle(value);
            System.out.println("angle: " + game.getShot().getAngle());
        }
    }

    public class TextSpeedField implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double value = Double.parseDouble(speed.getText());
            game.getShot().setSpeed(value);
            System.out.println("speed: " + game.getShot().getSpeed());
        }
    }

    public class ShotResolve implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getShot().hit();
        }
    }

    public GameWindow() throws HeadlessException {


        super("Game");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);

        fire = new JButton();
        fire.setBounds(20, 300, 80, 50);
        fire.setText("FIRE");
        fire.addActionListener(new TextAngleField());
        fire.addActionListener(new TextSpeedField());
        fire.addActionListener(new ShotResolve());
        this.add(fire);

        control = new JLabel();
        control.setBounds(200, 300, 100, 100);
        control.addMouseListener(new DraggingListener());
        control.addMouseMotionListener(d);
        control.setText("control");
        control.setOpaque(true);
        control.setBackground(Color.red);
        this.add(control);

        stay = new Arrow("stay");
        stay.setBounds(72, 72, 70, 70);
        this.add(stay);

        up = new Arrow("up");
        up.setBounds(72, 2, 70, 70);
        this.add(up);

        down = new Arrow("down");
        down.setBounds(72, 143, 70, 70);
        this.add(down);

        left = new Arrow("left");
        left.setBounds(2, 72, 70, 70);
        this.add(left);

        right = new Arrow("right");
        right.setBounds(143, 72, 70, 70);
        this.add(right);

        angle = new JTextField();
        angle.setBounds(182, 400, 80, 50);
        this.add(angle);

        speed = new JTextField();
        speed.setBounds(100, 400, 80, 50);
        this.add(speed);

        background = new Background("Desert.jpg");
        background.setBounds(0, 0, 800, 600);
        background.setOpaque(false);
//        this.add(background);
    }

    public void open() {
        this.setVisible(true);
        this.add(helico1);
        this.add(helico2);
    }

    public Helicopter getPlayerAt() {
        return playerAt;
    }

    public void setPlayerAt(Helicopter playerAt) {
        this.playerAt = playerAt;
        game.setShot(new Shot());
        game.setPlayerAt(playerAt);
        movesLeft = playerAt.getSpeed();

        helico1 = new HelicoIcon(playerAt);
    }

    public Helicopter getPlayerDef() {
        return playerDef;

    }

    public void setPlayerDef(Helicopter playerDef) {
        this.playerDef = playerDef;
        game.setPlayerDef(playerDef);

        helico2 = new HelicoIcon(playerDef);
    }

    public int getMovesLeft() {
        return movesLeft;
    }

    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
