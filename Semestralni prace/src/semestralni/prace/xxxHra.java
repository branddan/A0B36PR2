/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class xxxHra {


    public static void main(String[] args) {
        //inicializace
        xxxTerc terc = new xxxTerc();
        terc.novaPoloha();
        
        xxxPodminky podminky = new xxxPodminky();
        xxxLevely lvl = new xxxLevely(1);

        Scanner scan = new Scanner(System.in);
        System.out.print("Zadej sve jmeno: "); // hrac zapne hru, zada sve jmeno
        Helicopter hrac = new Helicopter(scan.nextLine());
        hrac.setRandomPosition();

        lvl.setHrac(hrac);
        lvl.setTerc(terc);
        lvl.setPodminky(podminky);
        lvl.tiskniInstrukce();


        //nastaveni hodnot v ostatnich tridach
        Shot hod = new Shot();
        xxxGraf graf = new xxxGraf();
        graf.setPodminky(podminky);
        hod.setPodminky(podminky);
        graf.setHrac(hrac);
        hod.setPlayerAt(hrac);
        graf.setTerc(terc);
        hod.setTerc(terc);
        int pocLvl = 0; // pocitadlo levelu, kdyz =5 prejde se na dalsi.
        int pocHod = 0; // pocitadlo neuspesnych hodu

        //tady zacina cyklus hodu
        while (hrac.getPocetMicu() != 0) { //hrac hazi dokud mu zbyvaji mice

            graf.setTerc(terc); // po kazdem uspesnem pokusu se meni terc
            hod.setTerc(terc);

            if (lvl.getLvl() == 3) { // na 3. lvl se fouka vitr silneji a staci se po kazdem hodu (i neuspesnem)
                podminky.novyVitr(20);
                podminky.toString();
                System.out.println("");
                if (pocHod != 0) {
                    graf.vykresliVitr(podminky);
                }
            }
            if (pocHod == 0) { // jestize se jedna o prvni pokus na danej terc, vykresli se polohy
                graf.vykresliUvod(hrac, terc);
            }

            System.out.print("Pocet zbyvajicich micu: " + hrac.getPocetMicu()); // informace pro hrace o micich a damage
            System.out.printf("  Aktualni skore: %.1f %n", hrac.getHealth());
            System.out.print("Zadej rychlost (0..45): "); // hrac zadava pocatecni rychlost sveho hodu
            double rychost = scan.nextDouble();
            hod.setSpeed(rychost);
            if (rychost < 0 || rychost > 45) continue;
            
            System.out.print("Zadej uhel ve stupnich (-90..90): ");
            double uhel = scan.nextDouble();
            hod.setAngle(uhel); // ve strupnich
            if (Math.abs(uhel) > 90) continue;

            graf.setV(hod.getSpeed());
            graf.setA(hod.getAngle());
            graf.vykresliPrubeh(hrac, terc); // vykresli se hod
            boolean trefa = hod.hit(); // vyhodnoti se hod
            if (trefa == true) {
                hod.damage();
                pocHod = 0;
                pocLvl++;
                if (pocLvl == 5 && lvl.getLvl() < 3) { // hrac postupuje do dalsiho lvl
                    pocLvl = 0; // znovu vynuluje pocitadlo
                    lvl.tiskniInstrukce();

                } else { //hrac dostava novy terc
                    hrac.setPocetMicu(hrac.getPocetMicu() + 2);
                    terc = new xxxTerc();
                    terc.novaPoloha();
                    System.out.println("Mas novy terc " + terc.toString() + ", ziskavas dva mice navic!");
                }
            } else {
                pocHod++;
            }


        }

        System.out.println("");
        System.out.println("GAME OVER. Ziskal jsi " + hrac.zaokrouhlit() + " bodu.");
        System.out.println("");

        //ukladani do souboru
        
        xxxVysledek prvni = xxxVysledek.nactiVysledky();
        xxxVysledek novy = new xxxVysledek(hrac.getPlayerName(), hrac.zaokrouhlit());
        prvni = prvni.ulozHraceDoVysledku(prvni, novy);
        System.out.println("");System.out.println("Vysledky:");
        xxxVysledek.tisk(prvni);
        xxxVysledek.zapisDat(prvni);
    }
}
