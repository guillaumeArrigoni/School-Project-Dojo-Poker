package gamepoker;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HandPokerTest {

    public static HandPoker handASPoker;
    private static Card cardAS = new Card("A");

    @BeforeAll
    static void setupHandPokerWithCards(){
        handASPoker = new HandPoker(new ArrayList<>(Arrays.asList(cardAS,cardAS,cardAS,cardAS,cardAS)));
    }

    @Test
    void getHandCardsMethodTest() {
        assertEquals(HandPoker.NBR_CARDS,handASPoker.getHandCards().size());
        assertTrue(handASPoker.getHandCards().containsAll(new ArrayList<>(Arrays.asList(cardAS,cardAS,cardAS,cardAS,cardAS))));
    }

    @Test
    void getHandOccurrence() {
        //TODO : Finish this
    }

    @Test
    void getHandCombination() {
        //TODO : Finish this
    }

    @Test
    void testToString() {
        //TODO : Finish this
    }

    //TODO : Finish test
}