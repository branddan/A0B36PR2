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
public class Hra {


    public static void main(String[] args) {
        //inicializace
        Terc terc = new Terc();
        terc.novaPoloha();
        
        Podminky podminky = new Podminky();
        Levely lvl = new Levely(1);

        Scanner scan = new Scanner(System.in);
        System.out.print("Zadej sve jmeno: "); // hrac zapne hru, zada sve jmeno
        Helicopter hrac = new Helicopter(scan.nextLine());
        hrac.novaPoloha();

        lvl.setHrac(hrac);
        lvl.setTerc(terc);
        lvl.setPodminky(podminky);
        lvl.tiskniInstrukce();


        //nastaveni hodnot v ostatnich tridach
        Hod hod = new Hod();
        Graf graf = new Graf();
        graf.setPodminky(podminky);
        hod.setPodminky(podminky);
        graf.setHrac(hrac);
        hod.setHrac(hrac);
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

            System.out.print("Pocet zbyvajicich micu: " + hrac.getPocetMicu()); // informace pro hrace o micich a skore
            System.out.printf("  Aktualni skore: %.1f %n", hrac.getSkore());
            System.out.print("Zadej rychlost (0..45): "); // hrac zadava pocatecni rychlost sveho hodu
            double rychost = scan.nextDouble();
            hod.setRychlost(rychost);
            if (rychost < 0 || rychost > 45) continue;
            
            System.out.print("Zadej uhel ve stupnich (-90..90): ");
            double uhel = scan.nextDouble();
            hod.setUhel(uhel); // ve strupnich
            if (Math.abs(uhel) > 90) continue;

            graf.setV(hod.getRychlost());
            graf.setA(hod.getUhel());
            graf.vykresliPrubeh(hrac, terc); // vykresli se hod
            boolean trefa = hod.trefa(); // vyhodnoti se hod
            if (trefa == true) {
                hod.skore();
                pocHod = 0;
                pocLvl++;
                if (pocLvl == 5 && lvl.getLvl() < 3) { // hrac postupuje do dalsiho lvl
                    pocLvl = 0; // znovu vynuluje pocitadlo
                    lvl.tiskniInstrukce();

                } else { //hrac dostava novy terc
                    hrac.setPocetMicu(hrac.getPocetMicu() + 2);
                    terc = new Terc();
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
        
        Vysledek prvni = Vysledek.nactiVysledky();
        Vysledek novy = new Vysledek(hrac.getJmeno(), hrac.zaokrouhlit());
        prvni = prvni.ulozHraceDoVysledku(prvni, novy);
        System.out.println("");System.out.println("Vysledky:");
        Vysledek.tisk(prvni);
        Vysledek.zapisDat(prvni);
    }
}
