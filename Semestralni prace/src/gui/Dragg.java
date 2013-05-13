/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Daniel
 */
public class Dragg implements MouseMotionListener {

    private GameWindow g;
    private int x = 10;
    private int y = 10;
    private int x0;
    private int y0;

    public void paint(Graphics g) {
        g.clearRect(0, 0, 1500, 1500);
        g.drawLine(250, 350, x + 250, y + 350);
    }

    public void mouseDragged(MouseEvent e) {
//        System.out.println("x " + e.toString());

        x = e.getX();
        y = e.getY();
        JLabel l = (JLabel) e.getSource();
        g = (GameWindow) l.getParent().getParent().getParent().getParent();
        g.repaint();
//        System.out.println("x " + e.getX());
        x = e.getX() - x0;
        y = e.getY() - y0;
        int speed = (int)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        int angle;
        
        if (speed > g.getPlayerAt().getMaxShotSpeed()) {
            speed = (int)g.getPlayerAt().getMaxShotSpeed();
        }

        if (y == 0) {
            angle = 0;
        } else {
            angle = (int)Math.toDegrees(Math.atan(x / y));
        }

        g.getShotInfo().setText("<html>Speed: " + speed + "<br>Angle: " + angle);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }
}
