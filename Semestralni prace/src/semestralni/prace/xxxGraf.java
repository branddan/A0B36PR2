/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author user
 */
public class xxxGraf {

    private double v;
    private double a;
    private xxxPodminky podminky;
    private xxxTerc terc;
    private Helicopter hrac;

    public xxxGraf() {
    }

    public void vykresliVitr(xxxPodminky podminky) {
        //vykresli sipku vetru
        int delka = (int) (podminky.getVitr());

        if (delka >= 0) {
            for (int i = 0; i < 50 - 1; i++) {
                System.out.print(" ");
            }
            System.out.print("0");
            if (delka > 0) {
                for (int i = 0; i < delka; i++) {
                    System.out.print("-");
                }
                System.out.print(">");
            }
        } else {
            for (int i = 0; i < 50 + delka - 1; i++) {
                System.out.print(" ");
            }
            System.out.print("<");
            for (int i = 0; i < - delka; i++) {
                System.out.print("-");
            }
            System.out.print("0");
        }
        System.out.println("");

    }

    public void vykresliUvod(Helicopter hrac, xxxTerc terc) {
        
        vykresliVitr(podminky);
        int[][] rovina = new int[20][100];
        for (int i = 0; i < rovina.length; i++) { //y-ova osa
            int[] x = rovina[i];
            for (int j = 0; j < x.length; j++) { //x-ova osa
                if (rovina.length - i == ((hrac.getPosition()).getY()) && j == (hrac.getPosition()).getX()) {
                    System.out.print("H");
                } else if (rovina.length - i == ((terc.getPoloha()).getY()) && j == (terc.getPoloha()).getX()) {
                    System.out.print("T");
                } else if (i == rovina.length - 1 || i == 0 || j == x.length - 1 || j == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

    public void vykresliPrubeh(Helicopter hrac, xxxTerc terc) {
        
        vykresliVitr(podminky);
        double p1 = -podminky.getGravitace() / (2 * Math.pow(v * Math.cos(a) + podminky.getVitr(), 2)); //pomocne konstanty
        double p2 = (v * Math.sin(a)) / (v * Math.cos(a) + podminky.getVitr());
        double p3 = (hrac.getPosition()).getY();

        int[][] rovina = new int[20][100];
        for (int i = 0; i < rovina.length; i++) { //y-ova osa
            int[] x = rovina[i];
            for (int j = 0; j < x.length; j++) { //x-ova osa
                if (rovina.length - i == ((hrac.getPosition()).getY()) && j == (hrac.getPosition()).getX()) {
                    System.out.print("H");
                } else if (rovina.length - i == ((terc.getPoloha()).getY()) && j == (terc.getPoloha()).getX()) {
                    System.out.print("T");
                } else if (j > ((hrac.getPosition()).getX()) && ((int) (p1 * Math.pow(j - ((hrac.getPosition()).getX()), 2) + p2 * (j - ((hrac.getPosition()).getX())) + p3)) == rovina.length - i) {
                    System.out.print("*");
                } else if (i == rovina.length - 1 || i == 0 || j == x.length - 1 || j == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println("");
        }
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        if (v >= 0){
            this.v = v;
        }else{
            this.v = -v;
        }
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public xxxPodminky getPodminky() {
        return podminky;
    }

    public void setPodminky(xxxPodminky podminky) {
        if (podminky != null) this.podminky = podminky;
    }

    public xxxTerc getTerc() {
        return terc;
    }

    public void setTerc(xxxTerc terc) {
        if (terc != null) this.terc = terc;
    }

    public Helicopter getHrac() {
        return hrac;
    }

    public void setHrac(Helicopter hrac) {
        if (hrac != null) this.hrac = hrac;
    }
}
