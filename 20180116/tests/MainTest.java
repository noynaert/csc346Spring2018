import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    public static final double DELTA = 0.0001;

    @Test
    void add() {
        assertEquals(5,Main.add(2,3));
        assertEquals(0,Main.add(-5,5));
        assertEquals(-3,Main.add(8,-11));
        assertEquals(0,Main.add(0,0));
        assertEquals(7,Main.add(2,0));

    }

    @Test
    void findMinimum() {
    }

    @Test
    void isEvenLength() {
        assertTrue(Main.isEvenLength("rock"));
        assertTrue(Main.isEvenLength(""));
        assertTrue(!Main.isEvenLength("dog"));
        assertFalse(Main.isEvenLength("horse"));
    }

    @Test
    void log5() {
        assertEquals(2.0, Main.log5(25.0), DELTA);
        assertEquals(1.43067, Main.log5(10.0),0.001);
    }

}