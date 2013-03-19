/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author user
 */
public class Levely {

    private int lvl;
    private Helicopter hrac;
    private Terc terc;
    private Podminky podminky;

    public Levely(int lvl) {
        this.lvl = lvl;
    }

    public void tiskniInstrukce() {

        System.out.println("");
        for (int i = 0; i < 47; i++) {
            System.out.print(" ");
        }
        System.out.println("LEVEL " + lvl);
        System.out.println("");

        if (lvl == 1) {
            System.out.println(hrac.getJmeno() + ", stojis na pozici " + hrac.toString() + " a terc je v " + terc.toString() + ".");
            System.out.print("Polomer terce je " + terc.getR() + " metru. ");
            System.out.println(podminky.toString());
            System.out.println("");
        }
        if (lvl == 2) {
            System.out.println("Dostal jses na 2. uroven. Dostanes bonus 15 bodu a 3 mice!");
            System.out.println("");
            hrac.setSkore(hrac.getSkore() + 15);
            hrac.setPocetMicu(hrac.getPocetMicu() + 3);
            System.out.println("Jsi na mesici, gravitace je tu slabsi, zato vitr skoro nefouka.");
            System.out.println("");
            podminky.setGravitace(4.5);
            podminky.novyVitr(3);
        }
        if (lvl == 3) {
            System.out.println("Dostal jses na 3. uroven. Dostanes bonus 30 bodu a 3 mice!");
            System.out.println("");
            hrac.setSkore(hrac.getSkore() + 30);
            hrac.setPocetMicu(hrac.getPocetMicu() + 3);
            System.out.println("Dostal jses do boure, vitr fouka silneji a navic kazke kolo jinak.");
            podminky.setGravitace(9.8);
        }

    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int level) {
        if (level >= 1 || level <= 3) this.lvl = level;
    }

    public Helicopter getHrac() {
        return hrac;
    }

    public void setHrac(Helicopter hrac) {
        if (hrac != null) this.hrac = hrac;
    }

    public Terc getTerc() {
        return terc;
    }

    public void setTerc(Terc terc) {
        if (terc != null) this.terc = terc;
    }

    public Podminky getPodminky() {
        return podminky;
    }

    public void setPodminky(Podminky podminky) {
        if (podminky != null) this.podminky = podminky;
    }
}
