package sk.uniza.fri.wof.hra;

import sk.uniza.fri.wof.hra.Hra;
import sk.uniza.fri.wof.mapa.NacitavacMapy;
import sk.uniza.fri.wof.mapa.YMLRiadok;

import java.io.IOException;

/**
 * Hlavna trieda hry WoF s metodou main - spustanie v NB
 *
 * @author Lubomir Sadlon
 * @version 21.2.2012
 */
public class Main {
    //TODO
    // Viac miestnosti
    // Prekazky v miestnostiach
    // Posun v rámci miestnosti
    // Pristup do miestnosti obmedzeny
    // Predmety (item)
    //  - zobrať (z miestnosti do vačku) novy prikaz zober
    //  - miestnost vypise co za predmety ma
    // Ciel hry - dostat sa vom
    // Prerobit mapu na bludisko
    // ...


    /**
     * @param args parametre programu
     */
    public static void main(String[] args) throws IOException {

        for (YMLRiadok ymlRiadok : NacitavacMapy.nacitajSubor("mapa.yml")) {
            System.out.println(ymlRiadok);
        }

        //Hra hra = new Hra();
        //hra.hraj();
    }
}
