package gamepoker;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

 class ComparisonTest {
    private Card c1 = new Card(new Value("10"));
    private Card c2 = new Card(new Value("A"));

    @Test
    void testEquals() {
        assertFalse(c1.CompareHigherCard(c2));
        assertTrue(c2.CompareHigherCard(c1));
    }

}
