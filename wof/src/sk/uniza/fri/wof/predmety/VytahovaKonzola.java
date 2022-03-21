package sk.uniza.fri.wof.predmety;

import sk.uniza.fri.wof.hra.Hrac;
import sk.uniza.fri.wof.mapa.Vytah;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class VytahovaKonzola implements IStatickyPredmet {
    @Override
    public String getNazov() {
        return "ovladanie";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        ((Vytah)hrac.getAktualnaMiestnost()).posun();
    }
}
