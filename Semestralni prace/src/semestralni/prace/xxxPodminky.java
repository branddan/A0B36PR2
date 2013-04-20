/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author user
 */
public class xxxPodminky {
    //prirodni podminky

    private double vitr;
    private double gravitace;

    public xxxPodminky() {
        this.vitr = 10 - (int) (20 * Math.random());
        this.gravitace = 9.8;
    }

    public void novyVitr(int max) {
        vitr = max - (int) (2 * max * Math.random());
    }

    public double getVitr() {
        return vitr;
    }

    public void setVitr(double vitr) {
        if (Math.abs(vitr) <= 20) {
            this.vitr = vitr;
        }
    }

    public double getGravitace() {
        return gravitace;
    }

    public void setGravitace(double gravitace) {
        if (gravitace >= 0) {
            this.gravitace = gravitace;
        }
    }

    @Override
    public String toString() {
        return "Vitr fouka rychlosti " + vitr + " m/s a gravitacni konstanta ma hodnotu " + gravitace + '.';
    }
}
