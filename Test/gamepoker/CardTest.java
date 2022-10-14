package gamepoker;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    private Card c1 = new Card(new Value("10",10));
    private Card c2 = new Card(new Value("10",10));
    private Card c3 = new Card(new Value("A",14));


    @org.junit.jupiter.api.Test
    void testGetValue(){
        Card c1 = new Card(new Value("10",10));
        assertEquals(c1.getValue(), 10);
    }

    @org.junit.jupiter.api.Test
    void testEquals(){
        Card c1 = new Card(new Value("10",10));
        Card c2 = new Card(new Value("10",10));
        Card c3 = new Card(new Value("A",14));
        assertEquals(c1.equals(c2),true);
        assertEquals(c1.equals(c3),false);
    }

    @org.junit.jupiter.api.Test
    void testToString(){
        Card c1 = new Card(new Value("10",10));
        assertEquals(c1.toString(),"10");
    }







}
