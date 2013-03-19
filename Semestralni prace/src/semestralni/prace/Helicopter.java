/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;


/**
 *
 * @author user
 */
public class Helicopter {

    private Position poloha;
    private String playerName;
    private String type;
    private int pocetMicu;
    private double health = 0;
    private int skore2;

    public Helicopter(String jmeno) {
        this.playerName = jmeno;
        this.poloha = new Position();
        this.pocetMicu = 8;
    }

    public int zaokrouhlit() {
        this.skore2 = (int) health;
        return skore2;
    }

    public Position getPoloha() {
        return poloha;
    }

    public void setPoloha(Position poloha) {
        if (poloha != null) this.poloha = poloha;
    }

    public void novaPoloha() {
        poloha.vytvorRandom(1, 30, 1, 10);
    }

    public String getJmeno() {
        return playerName;
    }

    public void setJmeno(String jmeno) {
        if (jmeno != null) this.playerName = jmeno;
    }

    public double getSkore() {
        return health;
    }

    public void setSkore(double skore) {
        if (skore >= 0) this.health = skore;
    }

    public int getSkore2() {
        return skore2;
    }

    public void setSkore2(int skore2) {
        if (skore2 >= 0) this.skore2 = skore2;
    }

    public int getPocetMicu() {
        return pocetMicu;
    }

    public void setPocetMicu(int pocetMicu) {
        if (pocetMicu >= 0) this.pocetMicu = pocetMicu;
    }

    @Override
    public String toString() {
        return poloha.toString();
    }

    
}
