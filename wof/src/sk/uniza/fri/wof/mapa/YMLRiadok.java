package sk.uniza.fri.wof.mapa;

/**
 * 28. 2. 2021 - 21:14
 *
 * @author janik
 */
public class YMLRiadok {
    /**
     * Retazec pred :
     */
    private String kluc;

    /**
     * Retazec za :
     */
    private String hodnota;
    private int odsadenie;

    /**
     * Riadok zacina "-"
     */
    private boolean jePrvokZoznamu;

    /**
     * Vypise riadok tak, ako bol pôvodne v subore
     * @return
     */
    @Override
    public String toString() {
        return "YMLRiadok{" +
                "kluc='" + kluc + '\'' +
                ", hodnota='" + hodnota + '\'' +
                ", odsadenie=" + odsadenie +
                ", jePrvokZoznamu=" + jePrvokZoznamu +
                '}';
    }
}
