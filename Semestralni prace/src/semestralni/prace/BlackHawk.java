/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author Daniel
 */
public class BlackHawk extends Helicopter{

    
    public BlackHawk(String jmeno) {
        super(jmeno);
        super.setType("BlackHawk");
        super.setHealth(100);
        super.setMaxShotSpeed(100);
        super.setFirepower(1.5);
        super.setSize(0.25);
        super.setSpeed(4);
    }
    
}
