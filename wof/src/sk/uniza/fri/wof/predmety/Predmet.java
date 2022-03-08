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
public class Predmet {
    private final String nazov;

    public Predmet(String nazov) {
        this.nazov = nazov;
    }

    public String getNazov() {
        return this.nazov;
    }

    public void pouziSa(Hrac hrac) {
        switch (this.nazov) {
            case "hodinky":
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                System.out.println(dateFormat.format(date));
                break;
            case "mineralka":
                hrac.zvysEnergiu(20);
                System.out.println("Pouzil si mineralku a zvysila sa ti energia o 20");
                break;
            default:
                System.out.println("Neviem pouzit " + this.nazov);
        }
    }
}
