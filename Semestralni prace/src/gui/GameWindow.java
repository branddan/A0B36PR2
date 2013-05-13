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

    private Game game = new Game();
    private JButton fire;
    private Arrow stay;
    private Arrow up;
    private Arrow down;
    private Arrow right;
    private Arrow left;
    private JLabel control;
    private JLabel shotInfo;
    private JLabel instrukce;
    private HelicoIcon helicoAt;
    private HelicoIcon helicoDef;
    private Helicopter playerAt;
    private Helicopter playerDef;
    private int movesLeft;
    private int x = 250;
    private int y = 350;
    private Dragg d = new Dragg();
    private Background background;

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
            this.setBounds((int) helico.getPosition().getX(), (int) helico.getPosition().getY(), 60, 20);
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
        fire.addActionListener(new ShotResolve());
//        this.add(fire);

        control = new JLabel();
        control.setBounds(210, 400, 140, 140);
        control.addMouseListener(new DraggingListener());
        control.addMouseMotionListener(d);
        control.setText("control");
        control.setOpaque(true);
        control.setBackground(Color.red);
        this.add(control);

        shotInfo = new JLabel("<html>Speed: " + 0 + "<br>Angle: " + 0);
        shotInfo.setBounds(210, 330, 140, 70);
        this.add(shotInfo);

        instrukce = new JLabel();
        instrukce.setBounds(0, 543, 800, 30);
        instrukce.setText("Player number 1, enter your name and choose your helicopter.");
        instrukce.setForeground(Color.green);
        this.add(instrukce);
        instrukce.setOpaque(true);
        instrukce.setBackground(Color.BLACK);

        stay = new Arrow("stay");
        stay.setBounds(70, 400, 70, 70);
        this.add(stay);

        up = new Arrow("up");
        up.setBounds(70, 330, 70, 70);
        this.add(up);

        down = new Arrow("down");
        down.setBounds(70, 470, 70, 70);
        this.add(down);

        left = new Arrow("left");
        left.setBounds(0, 400, 70, 70);
        this.add(left);

        right = new Arrow("right");
        right.setBounds(140, 400, 70, 70);
        this.add(right);




        background = new Background("Desert.jpg");
        background.setBounds(0, 0, 800, 600);
        background.setOpaque(false);
//        this.add(background);
    }

    public void open() {
        this.setVisible(true);
        this.add(helicoAt);
        this.add(helicoDef);
    }
    
    public void doMove(){
        helicoAt.setLocation((int)playerAt.getPosition().getX(), (int)playerAt.getPosition().getY());
    }

    public Helicopter getPlayerAt() {
        return playerAt;
    }

    public void setPlayerAt(Helicopter playerAt) {
        this.playerAt = playerAt;
        game.setShot(new Shot());
        game.setPlayerAt(playerAt);
        movesLeft = playerAt.getSpeed();

        helicoAt = new HelicoIcon(playerAt);
    }

    public Helicopter getPlayerDef() {
        return playerDef;

    }

    public void setPlayerDef(Helicopter playerDef) {
        this.playerDef = playerDef;
        game.setPlayerDef(playerDef);

        helicoDef = new HelicoIcon(playerDef);
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

    public JLabel getShotInfo() {
        return shotInfo;
    }

    public void setShotInfo(JLabel shotInfo) {
        this.shotInfo = shotInfo;
    }

    public Dragg getD() {
        return d;
    }

    public void setD(Dragg d) {
        this.d = d;
    }

    public HelicoIcon getHelicoAt() {
        return helicoAt;
    }

    public void setHelicoAt(HelicoIcon helicoAt) {
        this.helicoAt = helicoAt;
    }

    public HelicoIcon getHelicoDef() {
        return helicoDef;
    }

    public void setHelicoDef(HelicoIcon helicoDef) {
        this.helicoDef = helicoDef;
    }
    
}
