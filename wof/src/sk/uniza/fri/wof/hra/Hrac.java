package sk.uniza.fri.wof.hra;

import sk.uniza.fri.wof.mapa.Miestnost;
import sk.uniza.fri.wof.predmety.Hodinky;
import sk.uniza.fri.wof.predmety.IPredmet;
import sk.uniza.fri.wof.predmety.IStatickyPredmet;
import sk.uniza.fri.wof.predmety.ZakladnyPredmet;
import sk.uniza.fri.wof.prikazy.Prikaz;

import java.util.HashMap;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Hrac {
    private Miestnost aktualnaMiestnost;
    private HashMap<String, IPredmet> inventar;
    private int energia;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.energia = 100;
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
        this.inventar.put("isic", new ZakladnyPredmet("Isic"));
        this.inventar.put("hodinky", new Hodinky());
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }

    /**
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     */
    public void chodDoMiestnosti(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();

        Miestnost novaMiestnost = aktualnaMiestnost.najdiMiestnostVSmere(smer);

        if (novaMiestnost == null) {
            System.out.println("Tam nie je vychod!");
        } else {
            this.aktualnaMiestnost = novaMiestnost;
            aktualnaMiestnost.vypisInfo();
            this.energia--;
        }
    }

    public void zobrazInventar() {
        if (this.inventar.isEmpty()) {
            System.out.println("V inventari nemas nic");
            return;
        }
        System.out.println("Predmety v inventari:");
        for (String nazov : this.inventar.keySet()) {
            System.out.print(nazov + " ");
        }

        System.out.println();
    }

    public void zoberPredmet(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            System.out.println("Zober co?");
            return;
        }

        IPredmet predmet = this.aktualnaMiestnost.najdiPredmet(prikaz.getParameter());
        if (predmet instanceof IStatickyPredmet) {
            System.out.println("Nekradni");
        } else if (predmet != null) {
            this.aktualnaMiestnost.vyberPredmet(predmet.getNazov());
            this.inventar.put(predmet.getNazov(), predmet);
        } else {
            System.out.println("Tento predmet nieje v miestnosti");
        }
    }

    public void pouzi(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            System.out.println("Pouzi co?");
            return;
        }

        IPredmet predmet = this.inventar.get(prikaz.getParameter());
        if (predmet == null) {
            predmet = this.aktualnaMiestnost.najdiPredmet(prikaz.getParameter());
            if ((predmet != null) && !(predmet instanceof IStatickyPredmet)) {
                System.out.println("Najskôr ho zober a az potom pouzi");
                return;
            }
        }

        if (predmet == null) {
            System.out.println("Nemam " + prikaz.getParameter());
            return;
        }

        predmet.pouziSa(this);
    }

    public void zvysEnergiu(int mnozstvo) {
        this.energia += mnozstvo;
    }
}
