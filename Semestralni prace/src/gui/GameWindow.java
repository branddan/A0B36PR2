/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Control control;
    private JLabel instructions;
    private HelicoIcon helicoAt;
    private HelicoIcon helicoDef;
    private Helicopter playerAt;
    private Helicopter playerDef;
    private Screen screen;
    private int movesLeft;
    private int x = 250;
    private int y = 350;
    private Dragg d = new Dragg();
    private DraggingListener dl = new DraggingListener();
    private Background background;
    private JLabel player1Info;
    private JLabel player2Info;
    private boolean hit = false;
    private Save save;

    private class Save extends JButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Writer out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(playerAt.getPlayerName() + " vs. " + playerDef.getPlayerName() + ".txt"), "UTF8"));
                out.write(playerAt.getType() + " " + playerAt.getPlayerName() + " " + (int) playerAt.getHealth() + " " + (int) playerAt.getPosition().getX() + " " + (int) playerAt.getPosition().getY() + " " + playerDef.getType() + " " + playerDef.getPlayerName() + " " + (int) playerDef.getHealth() + " " + (int) playerDef.getPosition().getX() + " " + (int) playerDef.getPosition().getY());
                out.close();
                GameWindow g = (GameWindow) this.getParent().getParent().getParent().getParent();
                System.exit(0);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public class HelicoIcon extends JPanel {

        public HelicoIcon(Helicopter helico) {
            this.setBounds((int) helico.getPosition().getX(), (int) helico.getPosition().getY(), 60, 40);
            JLabel image = new JLabel();
            image.setIcon(new ImageIcon("" + System.getProperty("user.dir") + "\\images\\" + helico.getType() + "Icon.jpg"));
            this.add(image);
//            System.out.println("icon: " + helico);
            validate();
        }
    }

    public class ShotResolve implements ActionListener {

        int x;
        int y;

        @Override
        public void actionPerformed(ActionEvent e) {
            game.getShot().hit(x, y);
        }
    }

    public class Screen extends JPanel {

        private int x;
        private int y;
        private int x0;
        private int y0;
        private boolean fire = false;

        public void paint(Graphics g) {
            if (fire) {
                super.paint(g);
                g.setColor(Color.red);
                if (hit) {
//                    g.drawLine(x0, y0, (int) (x + x0), (int) (y + y0));
                    g.drawLine(x0, y0, (int) (playerDef.getPosition().getX() + 30 + (Math.random() - 0.5) * 20), (int) (playerDef.getPosition().getY() + 20 + (Math.random() - 0.5) * 20));
                    g.setColor(Color.orange);
                    g.fillOval((int) playerDef.getPosition().getX() + 5, (int) playerDef.getPosition().getY() - 5, 50, 50);
                } else {
                    g.drawLine(x0, y0, (int) (x + x0), (int) (y + y0));
                }

//                System.out.println("x,y : " + x0 + ", " + y0);

                fire = false;
            }
        }

        public void setXY(int x, int y) {
            this.x = x + 30;
            this.y = y + 20;
            fire = true;
        }

        public void setXY0(int x0, int y0) {
            this.x0 = x0 + 30;
            this.y0 = y0 + 20;
        }
    }

    public class Control extends JPanel {

        private int x;
        private int y;
        private int speed = 0;
        private double angle;
        private double thickness = (speed / 20 + 1);

        public void paint(Graphics g) {
            if (dl.isPressed()) {
                super.paint(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke((speed / 20 + 1)));
//                if (speed <= playerAt.getMaxShotSpeed()) {
                g2.drawLine(105, 105, x, y);
//                }else{
//                    g2.drawLine(105, 105, (int)(playerAt.getMaxShotSpeed()*x/speed), (int)(playerAt.getMaxShotSpeed()*y/speed));
//                }
            }
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setAngle(double angle) {
            this.angle = angle;
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

        control = new Control();
        control.setBounds(210, 330, 210, 210);
        control.addMouseListener(dl);
        control.addMouseMotionListener(d);
        control.setOpaque(true);
        JLabel l = new JLabel();
        l.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\zamerovac.jpg"));
        control.add(l);
        this.add(control);



        instructions = new JLabel();
        instructions.setBounds(0, 543, 800, 30);
        instructions.setForeground(Color.green);
        this.add(instructions);
        instructions.setOpaque(true);
        instructions.setBackground(Color.BLACK);

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

        screen = new Screen();
        screen.setBounds(0, 0, 800, 320);
        screen.setOpaque(false);
        this.add(screen);

        player1Info = new JLabel();
        player1Info.setBounds(440, 330, 150, 210);
        this.add(player1Info);

        save = new Save();
        save.setBounds(692, 440, 100, 100);
        save.addActionListener(save);
        save.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\images\\save-icon.jpg"));
        this.add(save);

        background = new Background("Desert.png");
        background.setBounds(0, 0, 800, 600);
        background.setOpaque(false);
        this.add(background);


    }

    public void open() {
        this.setVisible(true);
        helicoAt = new HelicoIcon(playerAt);
        helicoDef = new HelicoIcon(playerDef);
        this.add(helicoAt); //pak se pridaji do screen
        this.add(helicoDef);
        instructions.setText("Player " + playerAt.getPlayerName() + ", it's your turn, you can move (for 1 move point) of fire (2 moves).");
        player1Info.setText("<html><h3>" + playerAt.getPlayerName() + "</h3><br>HP: " + playerAt.getHealth() + "<br><br><h3>" + playerDef.getPlayerName() + "</h3><br>HP: " + playerDef.getHealth());
    }

    public JLabel getPlayer1Info() {
        return player1Info;
    }

    public void setPlayer1Info(JLabel player1Info) {
        this.player1Info = player1Info;
    }

    public void move() {
        helicoAt.setLocation((int) playerAt.getPosition().getX(), (int) playerAt.getPosition().getY());
        screen.setXY0((int) playerAt.getPosition().getX(), (int) playerAt.getPosition().getY());
//        System.out.println("X: " + (int) playerAt.getPosition().getX());
    }

    public Helicopter getPlayerAt() {
        return playerAt;
    }

    public void setPlayerAt(Helicopter playerAt) {
        this.playerAt = playerAt;
        game.setShot(new Shot());
        game.setPlayerAt(playerAt);
        game.setGameW(this);
        movesLeft = playerAt.getSpeed();
    }

    public Helicopter getPlayerDef() {
        return playerDef;

    }

    public void setPlayerDef(Helicopter playerDef) {
        this.playerDef = playerDef;
        game.setPlayerDef(playerDef);
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

    public JPanel getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public JLabel getInstructions() {
        return instructions;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}
