package gamepoker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ValueTest {
    private static Value valueEight;
    private static Value valueThree;
    private static Value valueAs;
    private static Value valueKing;
    private static Value valueTen;

    @BeforeAll
    public static void setupValue() {
        valueEight= new Value("8");
        valueThree = new Value("3");
        valueAs = new Value("A");
        valueKing = new Value("R");
        valueTen = new Value("10");
    }

    @Test
    void getValueTest() {
        assertEquals(8, valueEight.getPosition());
        assertEquals(3, valueThree.getPosition());
        assertEquals(14, valueAs.getPosition());
        assertEquals(13, valueKing.getPosition());
        assertEquals(10, valueTen.getPosition());
    }

    @Test
    void getNameTest() {
        assertEquals("8", valueEight.getName());
        assertEquals("3", valueThree.getName());
        assertEquals("A", valueAs.getName());
        assertEquals("R", valueKing.getName());
        assertEquals("10", valueTen.getName());
    }

    @Test
    void tostringTest() {
        assertEquals("8", valueEight.toString());
        assertEquals("3", valueThree.toString());
        assertEquals("A", valueAs.toString());
        assertEquals("R", valueKing.toString());
        assertEquals("10", valueTen.toString());
    }

    @Test
    void equalsTest() {
        assertEquals(Value.HUIT,valueEight);
        assertEquals(Value.TROIS,valueThree);
        assertEquals(Value.AS,valueAs);
        assertEquals(Value.ROI,valueKing);
        assertEquals(Value.DIX,valueTen);
        assertNotEquals("8",valueEight);
        assertEquals(new Value("8"),valueEight);
        assertNotEquals(valueEight,valueThree);
        assertNotEquals(new Value("9"),valueEight);
        assertEquals(valueEight,valueEight);
    }

}
