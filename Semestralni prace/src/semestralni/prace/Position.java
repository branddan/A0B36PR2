/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author user
 */
public class Position {
    private double x;
    private double y;

    public Position() { // vytvori nulovou polohu
        x = 0;
        y = 0;        
    }

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    
    public void createRandom (double x1, double x2, double y1, double y2){ //naplni polohu nahodnymi hodnotami z intervalu
        this.x = (int) (x1 + (x2-x1) * Math.random());
        this.y = (int) (y1 + (y2-y1) * Math.random());
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
    
}
