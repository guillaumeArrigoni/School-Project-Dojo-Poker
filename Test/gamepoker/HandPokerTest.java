package gamepoker;

import gamepoker.exception.PokerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HandPokerTest {

    public static HandPoker handASPoker;
    public static HandPoker brelanCinq;
    private static Card neufPi;
    private static Card dixPi;
    private static Card valetPi;
    private static Card damePi;
    private static Card roiPi;
    private static Card sixCo;
    private static Card septCo;
    private static Card huitCo;
    private static Card neufCo;
    private static Card deuxPi;
    private static Card quatrePi;
    private static Card roiCo;
    private static Card roiCa;
    private static Card valetCo;
    private static Card valetCa;
    private static Card cinqTr;
    private static Card cinqPi;
    private static Card cinqCo;
    private static Card huitPi;
    private static Card huitTr;
    private static Card huitCa;



    private static HandPoker straightFlushCo;

    private static HandPoker pairOfEight;
    private static HandPoker carreOfEight;
    public static Card cardAS;

    @BeforeAll
    public static void setupComparison() throws PokerException {
        cardAS = new Card("ATr");
        cinqPi = new Card("5Pi");
        cinqTr = new Card("5Tr");
        deuxPi = new Card("2Pi");
        quatrePi = new Card("4Pi");
        neufPi = new Card("9Pi");
        dixPi = new Card("10Pi");
        valetPi = new Card("VPi");
        damePi = new Card("DPi");
        roiPi = new Card("RPi");
        cinqCo = new Card("5Co");
        sixCo = new Card("6Co");
        septCo = new Card("7Co");
        huitCo = new Card("8Co");
        neufCo = new Card("9Co");
        roiCo = new Card("RCo");
        roiCa = new Card("RCa");
        valetCo = new Card("VCo");
        valetCa = new Card("VCa");
        huitTr = new Card("8Tr");
        huitCa = new Card("8Ca");
        huitPi = new Card("8Pi");

        handASPoker = new HandPoker(new ArrayList<>(Arrays.asList(cardAS, cardAS, cardAS, cardAS, cardAS)));
        straightFlushCo = new HandPoker(new ArrayList<>(Arrays.asList(cinqCo, sixCo, septCo, huitCo, neufCo)));
        brelanCinq = new HandPoker(new ArrayList<>(Arrays.asList(cinqCo, cinqPi, cinqTr, neufPi, quatrePi)));
        pairOfEight = new HandPoker(new ArrayList<>(Arrays.asList(huitCo, huitPi, cinqTr, neufPi, quatrePi)));
        carreOfEight = new HandPoker(new ArrayList<>(Arrays.asList(huitCo, huitPi, huitTr, huitCa, quatrePi)));

    }

    @Test
    void HandOccurenceTestWith() {
        int testCinqCo = cinqCo.getValue().getPosition();
        int testHuit = huitPi.getValue().getPosition();
        assertEquals(straightFlushCo.getHandOccurrence().get(testCinqCo), 1);
        assertEquals(pairOfEight.getHandOccurrence().get(testHuit), 2);
        assertEquals(brelanCinq.getHandOccurrence().get(testCinqCo), 3);
        assertEquals(carreOfEight.getHandOccurrence().get(testHuit),4);
    }


    @Test
    void getHandCombination() {
        assertEquals(brelanCinq.getHandCombination().get(Comparison.BRELAN_FOR_DICO_KEY).get(0), 5);
        assertEquals(carreOfEight.getHandCombination().get(Comparison.CARRE_FOR_DICO_KEY).get(0), 8);
    }
}

