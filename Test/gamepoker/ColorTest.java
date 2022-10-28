package gamepoker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    private static Color colorTr;
    private static Color colorPi;
    private static Color colorCo;
    private static Color colorCa;


    @BeforeAll
    public static void setup() {
        colorTr = new Color("Tr");
        colorPi = new Color("Pi");
        colorCo = new Color("Co");
        colorCa = new Color("Ca");

    }

    @Test
    void testNotEqualsBetweenColors() {
        assertNotEquals(colorCa,colorPi);
    }

    @Test
    void testEqualsBetweenDifferentTypes(){
        Value value1 = new Value("8");
        assertNotEquals(value1,colorCo);
    }

    @Test
    void testEqualsBetweenColors(){
        assertEquals(colorTr,colorTr);
    }
}