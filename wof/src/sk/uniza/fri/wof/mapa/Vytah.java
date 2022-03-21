package sk.uniza.fri.wof.mapa;

import sk.uniza.fri.wof.predmety.VytahovaKonzola;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class Vytah extends Miestnost {

    private final Miestnost[] poschodia;
    private int poschodie;
    private boolean ideHore;

    public Vytah(Miestnost... poschodia) {
        super("Plechovy vytah");
        this.poschodia = poschodia;
        for (Miestnost miestnost : poschodia) {
            miestnost.pridajVychod("vytah", this);
        }
        this.poschodie = 1;

        this.pridajVychod("von", poschodia[this.poschodie]);
        this.pridajPredmet(new VytahovaKonzola());
    }

    public void posun() {
        if (this.ideHore) {
            if (this.poschodie == this.poschodia.length - 1) {
                this.ideHore = false;
                this.poschodie--;
            } else {
                this.poschodie++;
            }
        } else {
            if (this.poschodie == 0) {
                this.ideHore = true;
                this.poschodie++;
            } else {
                this.poschodie--;
            }
        }
        this.pridajVychod("von", this.poschodia[this.poschodie]);
        System.out.println("Si na poschodi " + this.poschodie);
    }
}
