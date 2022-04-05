package sk.uniza.fri.vynimky;

import java.math.BigInteger;

/**
 * @author Stefan
 */
public class MatematickeOperacie {

    // TODO: Uloha 1.1 - opravte chybu (java.lang.StackOverflowError) vo vypocte faktorialu
    // TODO: Uloha 1.3 - pridajte sem dokumentacny komentar a popise o com je tato metoda a ake vynimky vyhadzuje (inspirovat sa mozete napr. triedou Scanner a metodou nextInt())

    /**
     * Vypocita faktorial
     * @param cislo
     * @throws IllegalArgumentException ked cislo < 0
     * @return faktorial cisla cislo
     */
    public static BigInteger faktorial(BigInteger cislo) throws IllegalArgumentException {
        if (cislo.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("Parametrer cislo nemoze byt zaporny, cislo bolo " + cislo);
        }

        if (cislo.compareTo(BigInteger.ZERO) <= 0) {
            return BigInteger.ONE;
        }
        return cislo.multiply(faktorial(cislo.subtract(BigInteger.ONE)));
    }

    public static BigInteger faktorial(int cislo) {
        return faktorial(BigInteger.valueOf(cislo));
    }

    // TODO: Uloha 1.4 - vypiste do konzoly retazec v tomto formate: "cislo! = vysledok"
    public static void vypisFaktorialCisla(int cislo) {
        System.out.println(cislo + "! = " + faktorial(cislo));
    }

    public static void vypisVysledkyDelitela(int delenec) {
        for (int delitel = 1; delitel < 10; delitel++) {
            System.out.println(delenec + " / " + delitel + " = " + delenec / delitel);
        }
    }

    public static double vypocitaj(double cislo1, String znamienko, double cislo2) {

        if (znamienko == null) {
            throw new NullPointerException("Znamienko je null");
        }

        switch (znamienko) {
            case "+":
                return cislo1 + cislo2;
            case "-":
                return cislo1 - cislo2;
            case "*":
                return cislo1 * cislo2;
            case "/":
                return cislo1 / cislo2;
        }
        throw new IllegalArgumentException("Neplatne znamienko " + znamienko);

        // TODO: Uloha 1.9 - v pripade null, vyhodte vynimku NullPointerException
        // TODO: Uloha 1.10 - v pripade, ze znamienko obsahuje neplatny znak, vyhodte vyninmku IllegalArgumentException
    }

    public static int superMetoda() {
        try {
            faktorial(-5);
            return 1;
        } catch (IllegalArgumentException ex) {
            return 2;
        } finally {
            return 3;
        }
    }



    public enum TypVynimky {
        THROWABLE,
        ERROR,
        EXCEPTION,
        RUNTIME_EXCEPTION,
        RUNTIME_NULL_POINTER_EXCEPTION,
        VLASTNA_KONTROLOVANA_VYNIMKA,
        VLASTNA_NEKONTROLOVANA_VYNIMKA,
    }

    public static void vyhodUmeluVynimku(TypVynimky typVynimky) throws Throwable, Error {
        switch (typVynimky) {
            case THROWABLE:
                throw new Throwable();
            case ERROR:
                throw new Error();
            case EXCEPTION:
                throw new Exception("Testovacia kontrolovana vynimka");
            case RUNTIME_EXCEPTION:
                throw new RuntimeException("Testovacia nekontrolovana runtime vynimka");
            case RUNTIME_NULL_POINTER_EXCEPTION:
                throw new NullPointerException("Testovacia nekontrolovana runtime vynimka");
            case VLASTNA_KONTROLOVANA_VYNIMKA:
                throw new KontrolovanaException();
            case VLASTNA_NEKONTROLOVANA_VYNIMKA:
                 throw new NekontrolovanaException();
        }
    }

    public static void vyhodVlastnuKontrolovanuVynimku() {
        //TODO: Uloha 1.16 - vyhodte vlastnu kontrolovanu vynimku
        throw new UnsupportedOperationException();
    }

    public static void vyhodVlastnuNekontrolovanuVynimku() {
        //TODO: Uloha 1.17 - vyhodte vlastnu nekontrolovanu vynimku
        throw new UnsupportedOperationException();
    }

}
