package sk.uniza.fri.inf.zoo;
/**
 * Created by IntelliJ IDEA.
 * User: Michal
 * Date: 26. 4. 2022
 * Time: 8:09
 */
public class Main {

    public static void main(String[] args) {
        Klietka<Macka> klietka = new Klietka<>();
        naplnKlietku(klietka);
        klietka.zatras();

        Macka macka = klietka.dajPrve();

        for (Macka zviera : klietka) {
            zviera.hovor();
        }

        FibonacciIterator it = new FibonacciIterator(10);
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (Integer integer : FibonacciGenerator.generuj(10)) {
            System.out.println(integer);
        }


        System.out.println(Excel.Max(1.2, 2.45, 45d));
        //System.out.println(Excel.Max("a", "m", "d"));

    }

    public static void naplnKlietku(Klietka<Macka> klietka) {
        //klietka.pridaj(new Papagaj());
        klietka.pridaj(new Macka());
    }
}
