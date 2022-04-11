package sk.uniza.fri.wof.predmety;

import sk.uniza.fri.wof.hra.Hrac;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class ZakladnyPredmet implements IPredmet {
    private final String nazov;

    public ZakladnyPredmet(String nazov) {
        this.nazov = nazov;
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public void pouziSa(Hrac hrac) {
        System.out.println("Neviem pouzit " + this.nazov);
    }
}
