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

    public YMLRiadok(String key, String value, int odsadenie, boolean jePrvokZoznamu) {
        this.kluc = key;
        this.hodnota = value;
        this.odsadenie = odsadenie;
        this.jePrvokZoznamu = jePrvokZoznamu;
    }

    public int getOdsadenie() {
        return this.odsadenie;
    }

    public String getKluc() {
        return this.kluc;
    }

    public String getHodnota() {
        return this.hodnota;
    }

    public boolean isPrvokZoznamu() {
        return this.jePrvokZoznamu;
    }
    /**
     * Vypise riadok tak, ako bol pôvodne v subore
     * @return
     */
    @Override
    public String toString() {
        return " ".repeat(this.odsadenie) + (jePrvokZoznamu ? "- " : "") + kluc + (hodnota != null ? ": " + hodnota : "");
    }
}
