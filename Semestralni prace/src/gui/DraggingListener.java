/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.*;
import javax.swing.*;
import semestralni.prace.*;
import java.awt.Graphics;

/**
 *
 * @author Daniel
 */
public class DraggingListener implements MouseListener {

    Position coordinatesPress;
    Position coordinatesRelease;
    double angle;
    double speed;
    boolean pressed;

    public DraggingListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
        coordinatesPress = new Position(e.getX(), e.getY());
        System.out.println("Press ( " + e.getX() + " , " + e.getY() + " )");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
        coordinatesRelease = new Position(e.getX(), e.getY());
        System.out.println("Release ( " + e.getX() + " , " + e.getY() + " )");
        double x = coordinatesRelease.getX() - coordinatesPress.getX();
        double y = coordinatesRelease.getY() - coordinatesPress.getY();
        speed = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        angle = (Math.atan(x / y));
        if (x > 0) {
            speed = -speed;
        }
        if (speed == 0) {
            angle = 0;
        }
        System.out.println("");
        System.out.println("speed ( " + speed + " , angle " + Math.toDegrees(angle) + " )");
        System.out.println("");

        JLabel l = (JLabel) e.getSource();
        GameWindow g = (GameWindow) l.getParent().getParent().getParent().getParent();
        
        g.getGame().setShot(new Shot(speed, angle));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
