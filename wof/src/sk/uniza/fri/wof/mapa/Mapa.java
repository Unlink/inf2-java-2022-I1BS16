package sk.uniza.fri.wof.mapa;

import sk.uniza.fri.wof.predmety.Jedlo;
import sk.uniza.fri.wof.predmety.ZakladnyPredmet;

public class Mapa {
    private Miestnost startovaciaMiestnost;

    public Mapa() {
        this.vytvorMiestnosti();
    }

    private void vytvorMiestnosti() {
        //pridajMiestnost("terasa", "terasa - hlavny vstup na fakultu");
        //prepojMiestnosti("terasa", "aula");


        // vytvorenie miestnosti
        Miestnost terasa = new Miestnost("terasa - hlavny vstup na fakultu");
        Miestnost aula = new Miestnost("aula");
        Miestnost bufet = new Miestnost("bufet");
        Miestnost labak = new Miestnost("pocitacove laboratorium");
        Miestnost kancelaria = new Miestnost("kancelaria spravcu pocitacoveho laboratoria");

        Miestnost chodbaPodzemie = new Miestnost("chodba na podzemii");
        Miestnost chodba1Poschode = new Miestnost("chodba 1. poschodi");
        Miestnost chodba2Poschode = new Miestnost("chodba 2. poschodi");

        Vytah vytah = new Vytah(chodbaPodzemie, terasa, chodba1Poschode, chodba2Poschode);

        //Todo pridat minieralku
        terasa.pridajPredmet(new Jedlo("mineralka", 20));


        // inicializacia miestnosti = nastavenie vychodov
        terasa.pridajVychod("aula", aula);
        terasa.pridajVychod("labak", labak);
        terasa.pridajVychod("bufet", bufet);

        aula.pridajVychod("terasa", terasa);

        bufet.pridajVychod("terasa", terasa);

        labak.pridajVychod("terasa", terasa);
        labak.pridajVychod("kancelaria", kancelaria);
        kancelaria.pridajVychod("labak", labak);

        this.startovaciaMiestnost = terasa;  // startovacia miestnost hry
    }

    public Miestnost getStartovaciaMiestnost() {
        return this.startovaciaMiestnost;
    }
}
