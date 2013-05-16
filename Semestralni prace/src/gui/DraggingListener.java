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

    private Position coordinatesPress;
    private Position coordinatesRelease;
    private double angle;
    private double speed;
    private boolean pressed;
    
    public DraggingListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
        coordinatesPress = new Position(105, 105);
//        System.out.println("Press " + coordinatesPress);
        GameWindow.Control p = (GameWindow.Control) e.getSource();
        GameWindow g = (GameWindow) p.getParent().getParent().getParent().getParent();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
        coordinatesRelease = new Position(e.getX(), e.getY());
//        System.out.println("Release ( " + e.getX() + " , " + e.getY() + " )");
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
//        System.out.println("");
//        System.out.println("speed ( " + speed + " , angle " + Math.toDegrees(angle) + " )");
//        System.out.println("");
        
        
        GameWindow.Control p = (GameWindow.Control) e.getSource();
        GameWindow g = (GameWindow) p.getParent().getParent().getParent().getParent();
        g.getGame().getShot().setAngle(angle);
        g.getGame().getShot().setSpeed(speed);
        GameWindow.Screen s = (GameWindow.Screen) g.getScreen();
        s.setXY(100*(int)x,100*(int)y);
        s.repaint();
        g.getGame().getShot().setPlayerAt(g.getPlayerAt());
        g.getGame().getShot().setPlayerDef(g.getPlayerDef());
        g.setHit(g.getGame().getShot().hit(x, y));
        
        
        g.setMovesLeft(g.getMovesLeft() - 2);
    }

    public boolean isPressed() {
        return pressed;
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
