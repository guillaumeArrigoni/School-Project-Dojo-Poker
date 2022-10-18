package gamepoker;

import static org.junit.jupiter.api.Assertions.assertEquals;

@org.junit.jupiter.api.Test



public class ValueTest {
    private Value value1 = new Value("8", 8);
    private Value value2 = new Value("3", 3);
    private Value value3 = new Value("A", 14);
    private Value value4 = new Value("R", 13);
    private Value value5 = new Value("10", 10);

    void getValueTest() {

        assertEquals(8, value1.getValue());
        assertEquals(3, value2.getValue());
        assertEquals(14, value3.getValue());
        assertEquals(13, value4.getValue());
        assertEquals(10, value5.getValue());
    }

    void getNameTest() {
        assertEquals("8", value1.getName());
        assertEquals("3", value2.getName());
        assertEquals("A", value3.getName());
        assertEquals("R", value4.getName());
        assertEquals("10", value5.getName());
    }
}
