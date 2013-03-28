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
        super.setPlayerName(jmeno);
        super.setType("Apache");
        super.setHealth(30);
        super.setMaxShotSpeed(55);
        super.setFirepower(15);
        super.setSize(2);
        super.setMoves(3);
        super.setPosition(new Position());
    }
}
