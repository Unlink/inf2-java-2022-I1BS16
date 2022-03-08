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
public class Hodinky implements IPredmet {
    @Override
    public String getNazov() {
        return "hodinky";
    }

    @Override
    public void pouziSa(Hrac hrac) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
