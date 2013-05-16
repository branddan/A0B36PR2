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
    private GameWindow gameW;
    

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
        IntroWindow introW = new IntroWindow();
        introW.setVisible(true);
        



    }

    public Helicopter getPlayerAt() {
        return playerAt;
    }

    public void setPlayerAt(Helicopter playerAt) {
        this.playerAt = playerAt;
        this.playerAt.setGame(this);
        shot.setPlayerAt(playerAt);
        shot.setGame(this);
    }

    public Helicopter getPlayerDef() {
        return playerDef;
    }

    public void setPlayerDef(Helicopter playerDef) {
        this.playerDef = playerDef;
        this.playerDef.setGame(this);
        shot.setPlayerDef(playerDef);
    }

    public Shot getShot() {
        return shot;
    }

    public void setShot(Shot shot) {
        this.shot = shot;
    }

    public GameWindow getGameW() {
        return gameW;
    }

    public void setGameW(GameWindow gameW) {
        this.gameW = gameW;
    }
    
    
}
