/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author user
 */
public class Terc {

    private Position poloha; // souradnice
    private double r; // polomer terce

    public Terc() {
        this.poloha = new Position();
        this.r = 2;
    }

    public Position getPoloha() {
        return poloha;
    }

    public void setPoloha(Position poloha) {
        if (poloha != null) this.poloha = poloha;
    }

    public void novaPoloha() {
        poloha.vytvorRandom(70, 99, 1, 17);
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        if (r > 0) this.r = r;
    }

    @Override
    public String toString() {
        return poloha.toString();
    }
}