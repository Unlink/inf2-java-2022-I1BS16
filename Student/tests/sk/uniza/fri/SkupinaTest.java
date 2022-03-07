package sk.uniza.fri;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 28. 2. 2022 - 12:57
 *
 * @author Michal
 */
class SkupinaTest {

    @Test
    void pridavanieStudentov() {
        Skupina skupina1 = new Skupina("123");
        Student student1 = new Student("012345", "Fero", "Testovac");
        Student student2 = new Student("564788", "Jozef", "Testovac");
        assertEquals(0, skupina1.dajPocetStudentov());
        skupina1.pridajStudenta(student1);
        assertEquals(1, skupina1.dajPocetStudentov());
        skupina1.pridajStudenta(student2);
        assertEquals(2, skupina1.dajPocetStudentov());
    }

    @Test
    void pridavanieStudentovNull() {
        Skupina skupina1 = new Skupina("123");
        assertEquals(0, skupina1.dajPocetStudentov());
        skupina1.pridajStudenta(null);
        assertEquals(0, skupina1.dajPocetStudentov());
    }

    @Test
    void pridavanieStudentovDuplicity() {
        Skupina skupina1 = new Skupina("123");
        Student student1 = new Student("012345", "Fero", "Testovac");
        Student student2 = new Student("012345", "Fero", "Testovac");
        assertEquals(0, skupina1.dajPocetStudentov());
        skupina1.pridajStudenta(student1);
        assertEquals(1, skupina1.dajPocetStudentov());
        skupina1.pridajStudenta(student1);
        assertEquals(1, skupina1.dajPocetStudentov());
        skupina1.pridajStudenta(student2);
        assertEquals(1, skupina1.dajPocetStudentov());
    }
}