package gamepoker;

import gamepoker.exception.IncorrectColorException;
import gamepoker.exception.PokerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    private static Color colorTr;
    private static Color colorPi;
    private static Color colorCo;
    private static Color colorCa;

    @BeforeAll
    public static void setup() throws PokerException {
        colorTr = new Color("Tr");
        colorPi = new Color("Pi");
        colorCo = new Color("Co");
        colorCa = new Color("Ca");
    }

    @Test
    void testNotEqualsBetweenColors() {
        assertNotEquals(colorCa, colorPi);
    }

    @Test
    void testEqualsBetweenDifferentTypes() {
        assertNotEquals(Value.HUIT, colorCo);
    }

    @Test
    void testEqualsBetweenColors() {
        assertEquals(colorTr, colorTr);
    }

    @Test
    void assertExceptionWithIncorrectColorTest() {
        assertThrows(IncorrectColorException.class, () -> new Color("T"));
        assertThrows(IncorrectColorException.class, () -> new Color("Tre"));
        assertThrows(IncorrectColorException.class, () -> new Color(""));
        assertThrows(IncorrectColorException.class, () -> new Color(null));
    }
}