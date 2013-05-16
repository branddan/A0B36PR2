/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author Daniel
 */
public class Apache extends Helicopter {

    
    public Apache(String jmeno) {
        super(jmeno);
        super.setType("Apache");
        super.setHealth(60);
        super.setMaxShotSpeed(120);
        super.setFirepower(1);
        super.setSize(0.06);
        super.setSpeed(5);
    }
}
