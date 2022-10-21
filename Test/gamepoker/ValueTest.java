package gamepoker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ValueTest {
    private static Value value1;
    private static Value value2;
    private static Value value3;
    private static Value value4;
    private static Value value5;

    @BeforeAll
    public static void setup() {
        value1= new Value("8");
        value2 = new Value("3");
        value3 = new Value("A");
        value4 = new Value("R");
        value5 = new Value("10");

    }
    @Test
    void getValueTest() {
        assertEquals(8, value1.getPosition());
        assertEquals(3, value2.getPosition());
        assertEquals(14, value3.getPosition());
        assertEquals(13, value4.getPosition());
        assertEquals(10, value5.getPosition());
    }
    @Test
    void getNameTest() {
        assertEquals("8", value1.getName());
        assertEquals("3", value2.getName());
        assertEquals("A", value3.getName());
        assertEquals("R", value4.getName());
        assertEquals("10", value5.getName());
    }

    @Test
    void tostringTest() {
        assertEquals("8", value1.toString());
        assertEquals("3", value2.toString());
        assertEquals("A", value3.toString());
        assertEquals("R", value4.toString());
        assertEquals("10", value5.toString());
    }

    @Test
    void equalsTest() {
        assertNotEquals("8",value1);
        assertNotEquals(value1,value2);
        assertNotEquals(new Value("9"),value1);

        assertEquals(value1,value1);
        assertEquals(new Value("8"),value1);
    }

}
