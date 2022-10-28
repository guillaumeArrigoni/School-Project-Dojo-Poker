package gamepoker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CardTest {
    private static Card cardTen ;
    private static Card cardAs ;

    @BeforeAll
    public static void setupCard() {
        cardTen = new Card(new Value("10"));
        cardAs = new Card(new Value("A"));
    }

    @Test
    void getValueTest(){
        assertEquals(new Value("10"),cardTen.getValue());
        assertEquals(new Value("A"),cardAs.getValue());
    }

    @Test
    void equalsTest(){
        assertEquals(cardTen,cardTen);
        assertNotEquals(cardTen,cardAs);
    }

    @Test
    void toStringTest(){
        assertEquals("10",cardTen.toString());
        assertEquals("A", cardAs.toString());
    }

}
