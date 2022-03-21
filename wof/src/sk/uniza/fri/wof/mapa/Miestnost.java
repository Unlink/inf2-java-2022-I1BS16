package sk.uniza.fri.wof.mapa;

import sk.uniza.fri.wof.predmety.IPredmet;

import java.util.HashMap;

/**
 * Trieda sk.uniza.fri.wof.mapa.Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private final String popisMiestnosti;
    private HashMap<String, Miestnost> vychody;
    private HashMap<String, IPredmet> predmety;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String popis) {
        this.popisMiestnosti = popis;
        this.vychody = new HashMap<String, Miestnost>();
        this.predmety = new HashMap<>();
    }

    public void pridajVychod(String nazovMiestnosti, Miestnost miestnost) {
        this.vychody.put(nazovMiestnosti, miestnost);
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    public void vypisInfo() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        System.out.print("Vychody: ");
        for (String smer : this.vychody.keySet()) {
            System.out.print(smer + " ");
        }
        System.out.println();
    }

    public Miestnost najdiMiestnostVSmere(String smer) {
        return this.vychody.get(smer);
    }

    public void pridajPredmet(IPredmet predmet) {
        this.predmety.put(predmet.getNazov(), predmet);
    }

    public void vypisPredmety() {
        if (this.predmety.isEmpty()) {
            System.out.println("V tejto miestnosti nič nieje");
            return;
        }
        System.out.println("Predmety v miestnosti:");
        for (String nazov : this.predmety.keySet()) {
            System.out.print(nazov + " ");
        }

        System.out.println();
    }

    public IPredmet vyberPredmet(String nazov) {
        return this.predmety.remove(nazov);
    }

    public IPredmet najdiPredmet(String nazov) {
        return this.predmety.get(nazov);
    }
}
