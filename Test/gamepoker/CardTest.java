package gamepoker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CardTest {
    private static Card cardTenTr;
    private static Card cardAsPi;

    @BeforeAll
    public static void setupCard() {
        cardTenTr = new Card("10", "Tr");
        cardAsPi = new Card("A", "Pi");
    }

    @Test
    void getValueTest() {
        assertEquals(new Value("10"), cardTenTr.getValue());
        assertEquals(new Value("A"), cardAsPi.getValue());
    }

    @Test
    void getColorTest() {
        assertEquals(new Color("Tr"), cardTenTr.getColor());
    }

    @Test
    void equalsTest() {
        assertEquals(cardTenTr, cardTenTr);
        assertNotEquals(cardTenTr, cardAsPi);
    }

    @Test
    void toStringTest() {
        assertEquals("10", cardTenTr.toString());
        assertEquals("A", cardAsPi.toString());
    }

    @Test
    void compareToTest() {
        assertEquals(-1, cardTenTr.compareTo(cardTenTr));
        assertEquals(0, cardTenTr.compareTo(cardTenTr));
        assertEquals(1, cardAsPi.compareTo(cardTenTr));
    }

}
