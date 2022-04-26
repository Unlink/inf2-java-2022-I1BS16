package sk.uniza.fri.inf.zoo;

import java.util.Iterator;

/**
 * 26. 4. 2022 - 8:09
 *
 * @author Michal
 */
public class FibonacciIterator implements Iterator<Integer> {

    private int pocetCisel;
    private int a;
    private int b;

    public FibonacciIterator(int pocetCisel) {
        this.pocetCisel = pocetCisel;
        this.a = -1;
        this.b = 1;
    }

    @Override
    public boolean hasNext() {
        return this.pocetCisel > 0;
    }

    @Override
    public Integer next() {
        int dalsie = this.a + this.b;
        this.a = this.b;
        this.b = dalsie;
        this.pocetCisel--;
        return dalsie;
    }
}
