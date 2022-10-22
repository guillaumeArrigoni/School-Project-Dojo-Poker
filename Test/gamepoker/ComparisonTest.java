package gamepoker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComparisonTest {
    private static Card c1;
    private static Card c2;
    private static Card c3;

    @BeforeAll
    public static void setup() {
        c1 = new Card(new Value("10"));
        c2 = new Card(new Value("A"));
        c3 = new Card(new Value("A"));
    }

    @Test
    void testEquals() {
        assertNull(c2.CompareHigherCard(c3));
        assertTrue(c2.CompareHigherCard(c1));
        assertFalse(c1.CompareHigherCard(c2));
    }
}
