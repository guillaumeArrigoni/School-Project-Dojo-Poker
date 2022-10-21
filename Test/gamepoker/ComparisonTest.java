package gamepoker;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComparisonTest {
    private Card c1 = new Card(new Value("10"));
    private Card c2 = new Card(new Value("A"));
    private Card c3 = new Card(new Value("A"));

    @Test
    void testEquals() {
        ArrayList<Object> comparaisonTest1 = new ArrayList<Object>();
        comparaisonTest1.add(false);
        comparaisonTest1.add(c2);
        ArrayList<Object> comparaisonTest2 = new ArrayList<Object>();
        comparaisonTest2.add(false);
        comparaisonTest2.add(c2);
        ArrayList<Object> comparaisonTest3 = new ArrayList<Object>();
        comparaisonTest3.add(true);
        comparaisonTest3.add(c2);

        assertEquals(comparaisonTest1,c1.CompareHigherCard(c2));
        assertEquals(comparaisonTest2,c2.CompareHigherCard(c1));
        assertEquals(comparaisonTest3,c3.CompareHigherCard(c2));

    }

}
