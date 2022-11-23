package gamepoker;

import gamepoker.exception.PokerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComparisonTest {

    private static Card neufPi;
    private static Card dixPi;
    private static Card valetPi;
    private static Card damePi;
    private static Card roiPi;
    private static Card cinqTr;
    private static Card cinqCo;
    private static Card sixCo;
    private static Card sixTr;
    private static Card septCo;
    private static Card huitCo;
    private static Card neufTr;
    private static Card dixTr;
    private static Card neufCo;
    private static Card deuxPi;
    private static Card quatrePi;
    private static  Card huitCa;
    private static Card cinqCa;
    private static Card dameCa;
    private static Card dameCo;
    private static Card septCa;
    private static Card roiCo;
    private static Card roiCa;
    private static Card valetCo;
    private static Card valetCa;
    private static Card dameTr;
    private static Card roiTr;
    private static Card valetTr;
    private static HandPoker straightFlushPi;
    private static HandPoker straightFlushCo;
    private static HandPoker flushPi;
    private static HandPoker straightRoi;
    private static HandPoker flushCo;
    private static HandPoker flushCa;
    private static HandPoker straightNeuf;
    private static HandPoker straightRoi2;
    private static HandPoker straightFlushTr;
    private static HandPoker doublePairDameValet2;
    private static HandPoker carreRoi;
    private static HandPoker carreValet;
    private static HandPoker fullRoiNeuf;
    private static HandPoker fullValetCinq;
    private static HandPoker brelanRoi;
    private static HandPoker brelanValet;
    private static HandPoker doublePaireRoiNeuf;
    private static HandPoker doublePairDameValet;
    private static HandPoker pairRoi;
    private static HandPoker pairValet;
    private static HandPoker pairSix;
    private static HandPoker pairValet2;
    private static HandPoker higherCardRoi;
    private static HandPoker higherCardRoi2;
    private static HandPoker higherCardDame;
    private static Comparison comparisonStraightFlushE;
    private static Comparison comparisonFlushE;
    private static Comparison comparisonStraightE;
    private static Comparison comparisonCarreE;
    private static Comparison comparisonBrelanE;
    private static Comparison comparisonDoublePairE;
    private static Comparison comparisonPairE;
    private static Comparison comparisonHigherCardE;
    private static Comparison comparisonStraightFlushW;
    private static Comparison comparisonCarreW;
    private static Comparison comparisonFullE;
    private static Comparison comparisonFullW;
    private static Comparison comparisonFlushW;
    private static Comparison comparisonStraightW;
    private static Comparison comparisonBrelanW;
    private static Comparison comparisonDoublePairW;
    private static Comparison comparisonPairW;
    private static Comparison comparisonSamePair;
    private static Comparison comparisonSameHigherCard;
    private static Comparison comparisonSameFlush;
    private static Comparison comparisonSameStraight;
    private static Comparison comparisonSameDoublePair;
    private static Comparison comparisonSameStraightFlush;

    @BeforeAll
    @Order(1)
    public static void setupCard() throws PokerException {
        cinqCa = new Card("5Ca");
        septCa = new Card("7Ca");
        huitCa = new Card("8Ca");
        cinqTr = new Card("5Tr");
        neufPi = new Card("9Pi");
        dixPi = new Card("10Pi");
        valetPi = new Card("VPi");
        damePi = new Card("DPi");
        roiPi = new Card("RPi");
        cinqCo = new Card("5Co");
        sixCo = new Card("6Co");
        sixTr = new Card("6Tr");
        septCo = new Card("7Co");
        huitCo = new Card("8Co");
        neufCo = new Card("9Co");
        neufTr = new Card("9Tr");
        deuxPi = new Card("2Pi");
        quatrePi = new Card("4Pi");
        roiCo = new Card("RCo");
        roiCa = new Card("RCa");
        valetCo = new Card("VCo");
        valetCa = new Card("VCa");
        valetTr = new Card("VTr");
        roiTr = new Card("RTr");
        dameTr = new Card("DTr");
        dixTr = new Card("10Tr");
        dameCa = new Card("DCa");
        dameCo = new Card("DCo");
    }

    @BeforeAll
    @Order(2)
    public static void setupHandPoker() {
        straightFlushPi = new HandPoker(new ArrayList<>(Arrays.asList(neufPi, dixPi, valetPi, damePi, roiPi)));
        straightFlushCo = new HandPoker(new ArrayList<>(Arrays.asList(cinqCo, sixCo, septCo, huitCo, neufCo)));
        flushPi = new HandPoker(new ArrayList<>(Arrays.asList(deuxPi, quatrePi, neufPi, dixPi, valetPi)));
        flushCo = new HandPoker(new ArrayList<>(Arrays.asList(cinqCo, septCo, huitCo, roiCo, valetCo)));
        flushCa = new HandPoker(new ArrayList<>(Arrays.asList(roiCa, valetCa, huitCa, septCa, cinqCa)));
        straightRoi = new HandPoker(new ArrayList<>(Arrays.asList(neufPi, dixPi, valetCa, damePi, roiCo)));
        straightNeuf = new HandPoker(new ArrayList<>(Arrays.asList(cinqCo, sixCo, septCo, huitCo, neufTr)));
        carreRoi = new HandPoker(new ArrayList<>(Arrays.asList(roiCo, roiCa, roiPi, roiTr, deuxPi)));
        carreValet = new HandPoker(new ArrayList<>(Arrays.asList(valetCo, valetTr, valetCa, valetPi, neufPi)));
        fullValetCinq = new HandPoker(new ArrayList<>(Arrays.asList(valetCa, valetTr, valetPi, cinqTr, cinqCo)));
        fullRoiNeuf = new HandPoker(new ArrayList<>(Arrays.asList(roiPi, roiCa, roiTr, neufCo, neufPi)));
        brelanRoi = new HandPoker(new ArrayList<>(Arrays.asList(roiPi, roiCa, roiTr, cinqCo, huitCo)));
        brelanValet = new HandPoker(new ArrayList<>(Arrays.asList(dameTr, valetTr, valetCa, valetCo, sixCo)));
        doublePaireRoiNeuf = new HandPoker(new ArrayList<>(Arrays.asList(roiCa, roiTr, neufPi, neufCo, deuxPi)));
        doublePairDameValet = new HandPoker(new ArrayList<>(Arrays.asList(dameTr, damePi, valetCo, valetTr, septCo)));
        doublePairDameValet2 = new HandPoker(new ArrayList<>(Arrays.asList(dameCa, dameCo, valetCa, valetPi, septCa)));
        pairRoi = new HandPoker(new ArrayList<>(Arrays.asList(roiTr, roiCa, dixPi, neufCo, cinqCo)));
        pairValet = new HandPoker(new ArrayList<>(Arrays.asList(valetTr, valetCa, dameTr, septCo, sixCo)));
        pairValet2 = new HandPoker(new ArrayList<>(Arrays.asList(valetPi, valetCo, damePi, septCa, sixTr)));
        pairSix = new HandPoker(new ArrayList<>(Arrays.asList(sixTr, sixCo, cinqTr, septCo, dameTr)));
        higherCardRoi = new HandPoker(new ArrayList<>(Arrays.asList(septCo, huitCo, neufPi, dameTr, roiPi)));
        higherCardDame = new HandPoker(new ArrayList<>(Arrays.asList(damePi, cinqCo, dixPi, neufCo, valetCa)));
        higherCardRoi2 = new HandPoker(new ArrayList<>(Arrays.asList(roiTr, damePi, neufTr, huitCa, septCa )));
        straightFlushTr = new HandPoker(new ArrayList<>(Arrays.asList(roiTr,dameTr, valetTr, dixTr, neufTr)));
        straightRoi2 = new HandPoker(new ArrayList<>(Arrays.asList(neufCo, dixTr, valetTr, dameTr, roiPi)));
    }

    @BeforeAll
    @Order(3)
    public static void setupComparison() {
        comparisonStraightFlushE = new Comparison(straightFlushPi, straightFlushCo);
        comparisonCarreE = new Comparison(carreRoi, carreValet);
        comparisonFullE = new Comparison(fullRoiNeuf, fullValetCinq);
        comparisonFlushE = new Comparison(flushCo, flushPi);
        comparisonStraightE = new Comparison(straightRoi, straightNeuf);
        comparisonBrelanE = new Comparison(brelanRoi, brelanValet);
        comparisonDoublePairE = new Comparison(doublePaireRoiNeuf, doublePairDameValet);
        comparisonPairE = new Comparison(pairRoi, pairValet);
        comparisonHigherCardE = new Comparison(higherCardRoi, higherCardDame);
        comparisonStraightFlushW = new Comparison(straightFlushCo, brelanValet);
        comparisonCarreW = new Comparison(carreValet, doublePairDameValet);
        comparisonFullW = new Comparison(fullRoiNeuf, pairSix);
        comparisonFlushW = new Comparison(flushCo, pairValet);
        comparisonStraightW = new Comparison(straightRoi, brelanRoi);
        comparisonBrelanW = new Comparison(brelanValet, doublePaireRoiNeuf);
        comparisonDoublePairW = new Comparison(doublePairDameValet, pairRoi);
        comparisonPairW = new Comparison(pairValet, higherCardRoi);
        comparisonSameHigherCard = new Comparison(higherCardRoi, higherCardRoi2);
        comparisonSamePair = new Comparison(pairValet, pairValet2);
        comparisonSameFlush = new Comparison(flushCa, flushCo);
        comparisonSameDoublePair = new Comparison(doublePairDameValet, doublePairDameValet2);
        comparisonSameStraightFlush = new Comparison(straightFlushPi, straightFlushTr);
        comparisonSameStraight = new Comparison(straightRoi, straightRoi2);

    }

    private static Stream<Arguments> provideComparison(){
        return Stream.of(
                Arguments.of(comparisonBrelanE, Combination.BRELAN),
                Arguments.of(comparisonCarreE, Combination.CARRE),
                Arguments.of(comparisonFullE, Combination.FULL),
                Arguments.of(comparisonFlushE, Combination.FLUSH),
                Arguments.of(comparisonDoublePairE, Combination.TWO_PAIR),
                Arguments.of(comparisonPairE, Combination.PAIR),
                Arguments.of(comparisonHigherCardE, Combination.HIGHCARD),
                Arguments.of(comparisonStraightE, Combination.SUITE),
                Arguments.of(comparisonStraightFlushE, Combination.STRAIGHT_FLUSH),
                Arguments.of(comparisonStraightFlushW, Combination.STRAIGHT_FLUSH),
                Arguments.of(comparisonCarreW, Combination.CARRE),
                Arguments.of(comparisonFullW, Combination.FULL),
                Arguments.of(comparisonFlushW, Combination.FLUSH),
                Arguments.of(comparisonStraightW, Combination.SUITE),
                Arguments.of(comparisonBrelanW, Combination.BRELAN),
                Arguments.of(comparisonDoublePairW, Combination.TWO_PAIR),
                Arguments.of(comparisonPairW, Combination.PAIR)
                );
    }
    private static Stream<Arguments> provideComparisonEquals(){
        return Stream.of(
                Arguments.of(comparisonSameFlush, Combination.EQUALITY),
                Arguments.of(comparisonSameDoublePair, Combination.EQUALITY),
                Arguments.of(comparisonSamePair, Combination.EQUALITY),
                Arguments.of(comparisonSameHigherCard, Combination.EQUALITY),
                Arguments.of(comparisonSameStraightFlush, Combination.EQUALITY),
                Arguments.of(comparisonSameStraight, Combination.EQUALITY)
        );
    }

    @ParameterizedTest
    @MethodSource("provideComparison")
    void testIfTheComparisonWinningValueIsTrue(Comparison comparison) {
        assertTrue(comparison.getWinning().get());
    }

    @ParameterizedTest
    @MethodSource({"provideComparisonEquals"})
    void testIfWinningValueIsEmptyWhenEquality(Comparison comparison) {
        assertTrue(comparison.getWinning().isEmpty());
    }

    @ParameterizedTest
    @MethodSource({"provideComparison", "provideComparisonEquals"})
    void testIfWinningCombinationCorrespondsToTheWinnerCombination(Comparison comparison, Combination combinationWinner) {
        assertEquals(combinationWinner, comparison.getWinningCombination());
    }
}