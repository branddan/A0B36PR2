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
    private int x;
    private int y;
    
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
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
