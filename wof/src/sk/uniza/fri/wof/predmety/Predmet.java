package sk.uniza.fri.wof.predmety;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Predmet {
    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }
}
