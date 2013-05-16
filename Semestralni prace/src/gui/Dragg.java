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
    private double pomer = x / y;
    private final int x0 = 105;
    private final int y0 = 105;

    public void mouseDragged(MouseEvent e) {
//        System.out.println("x " + e.toString());

        x = e.getX();
        y = e.getY();
        GameWindow.Control p = (GameWindow.Control) e.getSource();
        g = (GameWindow) p.getParent().getParent().getParent().getParent();
        x = e.getX() - x0;
        y = e.getY() - y0;
        int speed = (int) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        int angle;
        p.setSpeed(speed);

        if (speed > g.getPlayerAt().getMaxShotSpeed()) {
            speed = (int) g.getPlayerAt().getMaxShotSpeed();
        }
        p.setSpeed(speed);
        if (y == 0) {
            angle = 0;
        } else {
            angle = (int) Math.toDegrees(Math.atan(pomer));
        }
        p.setX(x + 105);
        p.setY(y + 105);

        p.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }
}
