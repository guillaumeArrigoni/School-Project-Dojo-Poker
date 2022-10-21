package gamepoker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ComparisonTest {
    private Card c1 = new Card(new Value("10"));
    private Card c2 = new Card(new Value("A"));
    private Card c3 = new Card(new Value("A"));

    @Test
    void testEquals() {


        assertNull(c2.CompareHigherCard(c3));
        assertTrue(c2.CompareHigherCard(c1));
        assertFalse(c1.CompareHigherCard(c2));
    }

}
