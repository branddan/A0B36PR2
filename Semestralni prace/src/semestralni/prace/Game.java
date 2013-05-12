/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import gui.*;
import java.awt.*;
import javax.swing.UIManager;

/**
 *
 * @author Daniel
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    private Helicopter playerAt;
    private Helicopter playerDef;
    private Shot shot;

    public static void main(String[] args) {
        // TODO code application logic here


//        GameWindow o = new GameWindow();
//        o.setVisible(true);\

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        IntroWindow intro = new IntroWindow();
        intro.setVisible(true);




    }

    public Helicopter getPlayerAt() {
        return playerAt;
    }

    public void setPlayerAt(Helicopter playerAt) {
        this.playerAt = playerAt;
        shot.setPlayerAt(playerAt);
    }

    public Helicopter getPlayerDef() {
        return playerDef;
    }

    public void setPlayerDef(Helicopter playerDef) {
        this.playerDef = playerDef;
        shot.setPlayerDef(playerDef);
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }
    
    
}
