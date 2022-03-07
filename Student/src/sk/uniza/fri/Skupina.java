package sk.uniza.fri;

import java.util.ArrayList;

/**
 * 22. 2. 2022 - 13:23
 *
 * @author Michal
 */
public class Skupina {
    private final String cislo;
    private final ArrayList<Student> studenti;

    public Skupina(String cislo) {
        this.cislo = cislo;
        this.studenti = new ArrayList<Student>();
    }

    public void pridajStudenta(Student student) {
        if (student == null) {
            return;
        }
        if (this.dajStudenta(student.getOsobneCislo()) != null) {
            return;
        }
        this.studenti.add(student);
    }

    public Student dajStudenta(String osCislo) {
        for (Student student : this.studenti) {
            if (student.getOsobneCislo().equals(osCislo)) {
                return student;
            }
        }
        return null;
    }

    public void odoberStudenta(String osCislo) {
        for (Student student : this.studenti) {
            if (student.getOsobneCislo().equals(osCislo)) {
                this.studenti.remove(student);
                return;
            }
        }
        return;
    }

    public void vypisStudentov() {
        for (Student student : this.studenti) {
            System.out.println(student.getMeno() + " " + student.getPriezvisko());
        }
    }

    public String getCislo() {
        return this.cislo;
    }

    public int dajPocetStudentov() {
        return this.studenti.size();
    }
}
