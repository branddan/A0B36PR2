/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author user
 */
public class Hod {

    private double rychlost; //rychlost
    private double uhel; // uhel
    private Podminky podminky;
    private Terc terc;
    private Helicopter hrac;

    public Hod(double rychlost, double uhel) { //konstrukter
        this.rychlost = rychlost;//rychlost
        this.uhel = uhel * Math.PI / 180; //prevod uhlu na radiany
    }

    public Hod() {
    }

    public int bod(int x) { //vrati y-ovou souradnici pro dane x
        double p1 = -podminky.getGravitace() / (2 * Math.pow(rychlost * Math.cos(uhel) + podminky.getVitr(), 2)); //pomocne konstanty
        double p2 = (rychlost * Math.sin(uhel)) / (rychlost * Math.cos(uhel) + podminky.getVitr());
        double p3 = (hrac.getPoloha()).getY();
        return (int) (p1 * Math.pow((terc.getPoloha()).getX() - (hrac.getPoloha()).getX(), 2) + p2 * ((terc.getPoloha()).getX() - (hrac.getPoloha()).getX()) + p3);
    }

    public boolean trefa() {

        double p1 = -podminky.getGravitace() / (2 * Math.pow(rychlost * Math.cos(uhel) + podminky.getVitr(), 2)); //pomocne konstanty
        double p2 = (rychlost * Math.sin(uhel)) / (rychlost * Math.cos(uhel) + podminky.getVitr());
        double p3 = (hrac.getPoloha()).getY();
        boolean trefa;
        hrac.setPocetMicu(hrac.getPocetMicu() - 1);

        if (Math.abs((p1 * Math.pow((terc.getPoloha()).getX() - (hrac.getPoloha()).getX(), 2) + p2 * ((terc.getPoloha()).getX() - (hrac.getPoloha()).getX()) + p3) - (terc.getPoloha()).getY()) <= terc.getR()) {
            return trefa = true;
        } else if (((p1 * Math.pow((terc.getPoloha()).getX() - (hrac.getPoloha()).getX(), 2) + p2 * ((terc.getPoloha()).getX() - (hrac.getPoloha()).getX()) + p3) - (terc.getPoloha()).getY()) >= terc.getR()) {
            if (hrac.getPocetMicu() != 0) {
                System.out.println("Moc vysoko, zkus to znovu.");
            } else {
                System.out.println("Moc vysoko, smula..");
            }

            return trefa = false;
        } else {
            if (hrac.getPocetMicu() != 0) {
                System.out.println("Moc nizko, zkus to znovu.");
            } else {
                System.out.println("Moc nizko, smula..");
            }

            return trefa = false;
        }
    }

    public void skore() {

        double p1 = -podminky.getGravitace() / (2 * Math.pow(rychlost * Math.cos(uhel) + podminky.getVitr(), 2)); //pomocne konstanty
        double p2 = (rychlost * Math.sin(uhel)) / (rychlost * Math.cos(uhel) + podminky.getVitr());
        double p3 = (hrac.getPoloha()).getY();

        double skore = (Math.abs((p1 * Math.pow((terc.getPoloha()).getX() - (hrac.getPoloha()).getX(), 2) + p2 * ((terc.getPoloha()).getX() - (hrac.getPoloha()).getX()) + p3) - (terc.getPoloha()).getY()) / terc.getR());
        double skore2 = (int) (Math.log(1 / skore) * 100);
        double skore3 = skore2 / 10;
        System.out.println("Zasah za " + skore3 + " bodu.");
        hrac.setSkore(hrac.getSkore() + skore3);
    }

    public double getRychlost() {
        return rychlost;
    }

    public void setRychlost(double rychlost) {
        if (rychlost > 45 || rychlost < 0) { // rychlost je omezena na 0-45
            System.out.println("Zadana hodnota mimo povoleny interval, zadej znovu.");
            System.out.println("");
        }else{
            this.rychlost = rychlost;
        }
    }

    public double getUhel() {
        return uhel;
    }

    public void setUhel(double uhel) {
        if (Math.abs(uhel) > 90) { // uhel je omezen na -90-90
            System.out.println("Zadana hodnota mimo povoleny interval, zadej znovu.");
            System.out.println("");
        }else{
            this.uhel = Math.PI * uhel / 180;
        }
    }

    public Podminky getPodminky() {
        return podminky;
    }

    public void setPodminky(Podminky podminky) {
        if (podminky != null) this.podminky = podminky;
    }

    public Terc getTerc() {
        return terc;
    }

    public void setTerc(Terc terc) {
        if (terc != null) this.terc = terc;
    }

    public Helicopter getHrac() {
        return hrac;
    }

    public void setHrac(Helicopter hrac) {
        if (hrac != null) this.hrac = hrac;
    }

    @Override
    public String toString() {
        return "Hod{" + "v=" + rychlost + ", a=" + uhel + '}';
    }
}
