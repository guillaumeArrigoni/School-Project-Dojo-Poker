package gamepoker;

package gamepoker;

@org.junit.jupiter.api.Test

public class ValueTest {
    private Value value1 = new Value(8);
    private Value value2 = new Value(3);
    private Value value3 = new Value(14);
    private Value value4 = new Value(13);
    private Value value5 = new Value(12);

    void getValueTest() {

        assertEquals(value1.getValue(), 8  );
        assertEquals(value4.getValue(), 13);
        assertEquals(value2.getValue(), 3 );
        assertEquals(value3.getValue(), 14);
        assertEquals(value5.getValue(), 12);
    }
}
