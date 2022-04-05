package sk.uniza.fri.vynimky;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Stefan
 */
public class Aplikacia {

    public static void main(String[] args) {
        ArrayList<String> aa = new ArrayList<String>();


        // Vysledok by mal byt 6
        BigInteger vysledok = sk.uniza.fri.vynimky.MatematickeOperacie.faktorial(3);
        System.out.println(vysledok);

        // Vysledok by mal byt 3628800
        vysledok = MatematickeOperacie.faktorial(10);
        System.out.println(vysledok);

        // TODO: Uloha 1.2 - Osetrite, aby nebolo mozne zadavat zaporne hodnoty (vyhodte v metode faktorial vynimku IllegalArgumentException, tu si to potom samozrejme zakomentujte)
        try {
            vysledok = MatematickeOperacie.faktorial(-10);
            System.out.println(vysledok);
        } catch (IllegalArgumentException e) {
            System.out.println("Zadane zaporne cislo");
        }
        // Vysledok by mal byt "5! = 120"
        MatematickeOperacie.vypisFaktorialCisla(5);

        MatematickeOperacie.vypisFaktorialCisla(100);

        System.out.print("Zadaj cislo: ");
        Scanner skener = new Scanner(System.in);
        // TODO: Uloha 1.5 - Nacitajte cele cislo pomocou skenera a vypiste jeho faktorial na obrazovku
        // TODO: Uloha 1.6 - Otesujte implementovany kod so zadanymi hodnotami: -10, 123, jeden, 10000

        // TODO: Uloha 1.7 - opravte chybu
        MatematickeOperacie.vypisVysledkyDelitela(100);

        System.out.println(MatematickeOperacie.vypocitaj(1.0, "+", 1.789));
        System.out.println(MatematickeOperacie.vypocitaj(1.0, "-", 1.789));
        System.out.println(MatematickeOperacie.vypocitaj(1.0, "*", 1.789));
        System.out.println(MatematickeOperacie.vypocitaj(1.0, "/", 1.789));
        System.out.println(MatematickeOperacie.vypocitaj(1.0, "/", 0));
        //System.out.println(MatematickeOperacie.vypocitaj(10, "a", 2));

        try {
            MatematickeOperacie.vyhodUmeluVynimku(MatematickeOperacie.TypVynimky.RUNTIME_EXCEPTION);
        } catch (Error e) {
            System.out.println("Mam error");
        } catch (Throwable e) {
            System.out.println("Mam throwable");
        } finally {
            System.out.println("finally");
        }

        System.out.println(MatematickeOperacie.superMetoda());

        //MatematickeOperacie.vyhodVlastnuKontrolovanuVynimku();
        //MatematickeOperacie.vyhodVlastnuNekontrolovanuVynimku();
    }

}
