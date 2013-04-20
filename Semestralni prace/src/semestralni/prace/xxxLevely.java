/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author user
 */
public class xxxLevely {

    private int lvl;
    private Helicopter hrac;
    private xxxTerc terc;
    private xxxPodminky podminky;

    public xxxLevely(int lvl) {
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
            System.out.println(hrac.getPlayerName() + ", stojis na pozici " + hrac.toString() + " a terc je v " + terc.toString() + ".");
            System.out.print("Polomer terce je " + terc.getR() + " metru. ");
            System.out.println(podminky.toString());
            System.out.println("");
        }
        if (lvl == 2) {
            System.out.println("Dostal jses na 2. uroven. Dostanes bonus 15 bodu a 3 mice!");
            System.out.println("");
            hrac.setHealth(hrac.getHealth() + 15);
            System.out.println("Jsi na mesici, gravitace je tu slabsi, zato vitr skoro nefouka.");
            System.out.println("");
            podminky.setGravitace(4.5);
            podminky.novyVitr(3);
        }
        if (lvl == 3) {
            System.out.println("Dostal jses na 3. uroven. Dostanes bonus 30 bodu a 3 mice!");
            System.out.println("");
            hrac.setHealth(hrac.getHealth() + 30);
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

    public xxxTerc getTerc() {
        return terc;
    }

    public void setTerc(xxxTerc terc) {
        if (terc != null) this.terc = terc;
    }

    public xxxPodminky getPodminky() {
        return podminky;
    }

    public void setPodminky(xxxPodminky podminky) {
        if (podminky != null) this.podminky = podminky;
    }
}
