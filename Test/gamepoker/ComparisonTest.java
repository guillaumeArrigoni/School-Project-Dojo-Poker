package gamepoker;
import static org.junit.jupiter.api.Assertions.*;

public class ComparisonTest {

    private Card c1 = new Card(new Value("10",10));
    private Card c2 = new Card(new Value("A",14));

    @org.junit.jupiter.api.Test
    void testEquals() {
        assertEquals(c1.CompareHigherCard(c2), c2);
        assertEquals(c2.CompareHigherCard(c1), c2);
    }
}
