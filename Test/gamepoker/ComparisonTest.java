package gamepoker;

import gamepoker.Card;

public class ComparisonTest {

    @org.junit.jupiter.api.Test
    void testEquals(){
    Card c1 = new Card(new Value("10",10));
    Card c3 = new Card(new Value("A",14));

    assertEquals(c1.CompareHigherCard(c3),c3);
    assertEquals(c3.CompareHigherCard(c1),c3);

}
