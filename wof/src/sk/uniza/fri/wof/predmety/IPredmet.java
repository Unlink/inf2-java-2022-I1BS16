package sk.uniza.fri.wof.predmety;

import sk.uniza.fri.wof.hra.Hrac;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public interface IPredmet {
    String getNazov();

    void pouziSa(Hrac hrac);
}
