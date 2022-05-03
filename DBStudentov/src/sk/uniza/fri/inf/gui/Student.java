package sk.uniza.fri.inf.gui;

/**
 * 3. 5. 2022 - 7:47
 *
 * @author Michal
 */
public class Student {

    private String meno;
    private String priezvisko;

    public String getMeno() {
        return this.meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return this.priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public int getVek() {
        return this.vek;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }

    private int vek;

    public Student(String meno, String priezvisko, int vek) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.vek = vek;
    }


    @Override
    public String toString() {
        return "Student{" +
                "meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                ", vek=" + vek +
                '}';
    }
}
