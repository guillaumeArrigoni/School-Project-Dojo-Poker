package gamepoker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CardTest {
    private Card c1 = new Card(new Value("10"));
    private Card c2 = new Card(new Value("10"));
    private Card c3 = new Card(new Value("A"));

    @Test
    void testGetValue(){
        assertEquals(new Value("10"),c1.getValue());
        assertEquals(new Value("10"),c2.getValue());
        assertEquals(new Value("A"),c3.getValue());
    }

    @Test
    void testEquals(){
        assertEquals(c1,c2);
        assertNotEquals(c1,c3);
    }

    @Test
    void testToString(){
        assertEquals("10",c1.toString());
        assertEquals("10", c2.toString());
        assertEquals("A", c3.toString());
    }

}
