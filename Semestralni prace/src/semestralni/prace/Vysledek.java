/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;

/**
 *
 * @author user
 */

public class Vysledek {
    
    private String jmeno;
    private int skore;
    private Vysledek next;
    
    //nasledujou metody pro ukladani do souboru
    
    public Vysledek(String jmeno, int skore) {
        this.jmeno = jmeno;
        this.skore = skore;
        this.next = null;
    }

    public static Vysledek nactiVysledky() {
        try {
            Scanner scan = new Scanner(new FileInputStream("TOP10.txt"), "UTF8");
            Vysledek[] poleVysledku = new Vysledek[10];
            for (int i = 0; i < poleVysledku.length; i++) {
                poleVysledku[i] = new Vysledek(scan.next(),0);
                poleVysledku[i].setSkore(scan.nextInt());
            }
            for (int i = 0; i < poleVysledku.length - 1; i++) {
                poleVysledku[i].setNext(poleVysledku[i + 1]);
            }
            return poleVysledku[0];
        } catch (IOException e) {
        }
        return null;
    }

    public static Vysledek ulozHraceDoVysledku(Vysledek prvni, Vysledek novy) {
        int pocitadlo = 10;
        if (novy.getSkore() > prvni.getSkore()) {
            Vysledek aktualni = prvni;
            while (aktualni != null) {
                if (aktualni.getNext() == null) {
                    aktualni.setNext(novy);
                    break;
                } else if (aktualni.getNext().getSkore() > novy.getSkore()) {
                    novy.setNext(aktualni.getNext());
                    aktualni.setNext(novy);
                    break;
                } else {
                    pocitadlo--;
                    aktualni = aktualni.getNext();
                }
            }
            System.out.println("Blahopreji, dostal jses na " + pocitadlo + ". misto v tabulkach!");
            if (novy == prvni.getNext()) {
                return novy;
            } else {
                return prvni.getNext();
            }
        } else {
            return prvni;
        }
    }

    public static void zapisDat(Vysledek start) {
        //zapíšeme textově data
        try {
            Writer out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("TOP10.txt"), "UTF8"));
            Vysledek aktualni = start;
            while (aktualni != null) {
                out.write((String) (aktualni.getJmeno() + " " + aktualni.getSkore() + " \n"));
                aktualni = aktualni.getNext();
            }
            out.close();
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
    }

    public static void tisk(Vysledek start) {
        Vysledek aktualni = start;
        int poc = 10;
        System.out.println("poradi | jmeno |  body");
        while (aktualni != null) {
            System.out.printf(" %3d. %9s %8d %n", poc, aktualni.getJmeno(), aktualni.getSkore());
            poc--;
            aktualni = aktualni.getNext();
        }
        System.out.println("");
    }

    public Vysledek getNext() {
        return next;
    }

    public void setNext(Vysledek next) {
        this.next = next;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getSkore() {
        return skore;
    }

    public void setSkore(int skore) {
        this.skore = skore;
    }
    
}
