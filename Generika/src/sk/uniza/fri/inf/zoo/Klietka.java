package sk.uniza.fri.inf.zoo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 26. 4. 2022 - 8:09
 *
 * @author Michal
 */
public class Klietka<E extends IZviera> implements Iterable<E> {
    private ArrayList<E> zvierata;

    public Klietka() {
        this.zvierata = new ArrayList<>();
    }

    public void pridaj(E zviera) {
        this.zvierata.add(zviera);
    }

    public void odober(E zviera) {
        this.zvierata.remove(zviera);
    }

    public void zatras() {
        for (E zviera : this) {
            zviera.hovor();
        }
    }

    public E dajPrve() {
        return this.zvierata.get(0);
    }

    @Override
    public Iterator<E> iterator() {
        return this.zvierata.iterator();
    }
}
