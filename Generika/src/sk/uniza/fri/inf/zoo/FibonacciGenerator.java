package sk.uniza.fri.inf.zoo;

import java.util.Iterator;

/**
 * 26. 4. 2022 - 8:09
 *
 * @author Michal
 */
public class FibonacciGenerator implements Iterable<Integer> {
    private final int pocet;

    private FibonacciGenerator(int pocet) {
        this.pocet = pocet;
    }

    public static Iterable<Integer> generuj(int pocet) {
        return new FibonacciGenerator(pocet);
        //return () -> new FibonacciIterator(pocet);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(pocet);
    }
}
