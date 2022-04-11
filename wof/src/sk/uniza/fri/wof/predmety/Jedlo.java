package sk.uniza.fri.wof.predmety;

import sk.uniza.fri.wof.hra.Hrac;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Jedlo implements IPredmet {

    private final String nazov;
    private final int energia;

    public Jedlo(String nazov, int energia) {
        this.nazov = nazov;
        this.energia = energia;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouziSa(Hrac hrac) {
        hrac.zvysEnergiu(energia);
        System.out.println("Pouzil si " + this.nazov + " a zvysila sa ti energia o " + this.energia);
    }
}
