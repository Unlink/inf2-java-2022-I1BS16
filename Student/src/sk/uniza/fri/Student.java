package sk.uniza.fri;

/**
 * 22. 2. 2022 - 13:23
 *
 * @author Michal
 */
public class Student {
    private String cisloSkupiny;
    private final String osobneCislo;
    private final String meno;
    private final String priezvisko;

    public Student(String osobneCislo, String meno, String priezvisko) {
        this.osobneCislo = osobneCislo;
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.cisloSkupiny = null;
    }

    public String getOsobneCislo() {
        return this.osobneCislo;
    }

    public String getMeno() {
        return this.meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    public String getCisloSkupiny() {
        return this.cisloSkupiny;
    }

    public void setCisloSkupiny(String cisloSkupiny) {
        this.cisloSkupiny = cisloSkupiny;
    }

    @Override
    public String toString() {
        return "Student{" +
                "cisloSkupiny='" + cisloSkupiny + '\'' +
                ", osobneCislo='" + osobneCislo + '\'' +
                ", meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                '}';
    }
}
