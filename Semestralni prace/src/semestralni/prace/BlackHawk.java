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
        super.setPlayerName(jmeno);
        super.setType("Black Hawk");
        super.setHealth(50);
        super.setMaxShotSpeed(45);
        super.setFirepower(20);
        super.setSize(4);
        super.setMoves(2);
        super.setPosition(new Position());
    }
    
}
