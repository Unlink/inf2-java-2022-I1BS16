package sk.uniza.fri.wof.predmety;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class JedloTovaren implements ITovarenNaPredmety {
    @Override
    public IPredmet vytvor(String nazov, String parametre) {
        return new Jedlo(nazov, Integer.parseInt(parametre));
    }
}
