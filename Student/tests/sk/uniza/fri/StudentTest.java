package sk.uniza.fri;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 28. 2. 2022 - 12:57
 *
 * @author Michal
 */
class StudentTest {

    private Student fero;

    @BeforeEach
    void setUp() {
        this.fero = new Student("012345", "Fero", "Testovac");
    }

    @Test
    void vytvorenieStudenta() {
        assertNotNull(this.fero);
    }

    @Test
    void testGetterov() {
        assertEquals("012345", this.fero.getOsobneCislo());
        assertEquals("Fero", this.fero.getMeno());
        assertEquals("Testovac", this.fero.getPriezvisko());
        assertNull(this.fero.getCisloSkupiny());
    }

    @Test
    void setCisloSkupiny() {
        this.fero.setCisloSkupiny("0123");
        assertEquals("0123", this.fero.getCisloSkupiny());
        this.fero.setCisloSkupiny("ABC");
        assertEquals("ABC", this.fero.getCisloSkupiny());
        this.fero.setCisloSkupiny(null);
        assertNull(this.fero.getCisloSkupiny());
    }

    @Test
    void testToString() {
        assertEquals("Student{cisloSkupiny='null', osobneCislo='012345', meno='Fero', priezvisko='Testovac'}", this.fero.toString());
    }
}