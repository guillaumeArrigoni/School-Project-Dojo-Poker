package gamepoker;

import gamepoker.exception.PokerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HandPokerTest {

    private static HandPoker brelanCinq;
    private static HandPoker quinteFlushCo;
    private static HandPoker paireDeHuit;
    private static HandPoker deuxPairesDeHuitEtDeCinq;
    private static HandPoker carreDeHuit;

    @BeforeAll
    public static void setupComparison() throws PokerException {
        Card quatrePi = new Card("4Pi");
        Card cinqTr = new Card("5Tr");
        Card cinqPi = new Card("5Pi");
        Card cinqCo = new Card("5Co");
        Card sixCo = new Card("6Co");
        Card septCo = new Card("7Co");
        Card huitCo = new Card("8Co");
        Card huitTr = new Card("8Tr");
        Card huitCa = new Card("8Ca");
        Card huitPi = new Card("8Pi");
        Card neufPi = new Card("9Pi");
        Card neufCo = new Card("9Co");

        quinteFlushCo = new HandPoker(new ArrayList<>(Arrays.asList(cinqCo, sixCo, septCo, huitCo, neufCo)));
        brelanCinq = new HandPoker(new ArrayList<>(Arrays.asList(cinqCo, cinqPi, cinqTr, neufPi, quatrePi)));
        paireDeHuit = new HandPoker(new ArrayList<>(Arrays.asList(huitCo, huitPi, cinqTr, neufPi, quatrePi)));
        deuxPairesDeHuitEtDeCinq = new HandPoker(new ArrayList<>(Arrays.asList(huitCo, huitPi, cinqTr, cinqCo, quatrePi)));
        carreDeHuit = new HandPoker(new ArrayList<>(Arrays.asList(huitCo, huitPi, huitTr, huitCa, quatrePi)));
    }

    @Test
    void sameCardOccurrenceWithDifferentNumberOfCards() {
        int fiveValue = Value.CINQ.getPosition();
        int eightValue = Value.HUIT.getPosition();
        assertEquals(1, quinteFlushCo.getHandOccurrence().get(fiveValue));
        assertEquals(2, paireDeHuit.getHandOccurrence().get(eightValue));
        assertEquals(3, brelanCinq.getHandOccurrence().get(fiveValue));
        assertEquals(4, carreDeHuit.getHandOccurrence().get(eightValue));
    }

    @Test
    void checkIfEachCardIsDifferentTest() {
        assertEquals(HandPoker.NBR_CARDS, quinteFlushCo.getHandOccurrence().size());
    }

    @Test
    void checkDifferentHandCombination() {
        assertEquals(8, paireDeHuit.getHandCombination().get(Comparison.PAIR_FOR_DICO_KEY).get(0));
        List<Integer> huitEtCinqList = new ArrayList<>(Arrays.asList(5, 8)); //List need to be sorted
        assertEquals(huitEtCinqList, deuxPairesDeHuitEtDeCinq.getHandCombination().get(Comparison.PAIR_FOR_DICO_KEY));
        assertEquals(5, brelanCinq.getHandCombination().get(Comparison.BRELAN_FOR_DICO_KEY).get(0));
        assertEquals(8, carreDeHuit.getHandCombination().get(Comparison.CARRE_FOR_DICO_KEY).get(0));
    }
}

