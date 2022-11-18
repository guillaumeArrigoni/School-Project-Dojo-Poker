package gamepoker;

import gamepoker.exception.PokerException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Comparison {
    /**
     * THE WINNING COMBINATION
     * winningCombination give the combination that is winning
     * THE VALUE ASSOCIATE TO THE COMBINATION IN THE DICO
     * Single : 1
     * Pair : 2
     * Brelan : 3
     * Carre : 4
     */
    public static final int SINGLE_FOR_DICO_KEY = 1;
    public static final int PAIR_FOR_DICO_KEY = 2;
    public static final int BRELAN_FOR_DICO_KEY = 3;
    public static final int CARRE_FOR_DICO_KEY = 4;

    private Combination winningCombination;
    private ArrayList<Integer> winningValue;
    private final Optional<Boolean> firstWinningOnSecond;
    private final HandPoker handP1;
    private final HandPoker handP2;

    public Comparison(HandPoker firstHand, HandPoker secondHand) {
        this.handP1 = firstHand;
        this.handP2 = secondHand;
        this.firstWinningOnSecond = chooseWinningHand();
    }

    @Override
    public String toString() {
        String combinationString = winningCombination.toString();
        if (winningCombination != Combination.HIGHCARD) {
            combinationString += " of ";
        }
        Value value = null;
        try {
            value = new Value(winningValue.get(0));
        } catch (PokerException e) {
            throw new RuntimeException(e);
        }
        combinationString = combinationString + value.toString();
        for (int i = 1; i<winningValue.size();i++){ /* dans le cas d'une doube pair ou d'une couleur par exemple*/
            combinationString = combinationString + ", ";
            Value valueMore = null;
            try {
                valueMore = new Value(winningValue.get(i));
            } catch (PokerException e) {
                throw new RuntimeException(e);
            }
            combinationString = combinationString + valueMore.toString();
        }
        return combinationString;
    }

    public Optional<Boolean> getWinning() {
        return this.firstWinningOnSecond;
    }

    public List<Integer> getWinningValue() {
        return this.winningValue;
    }

    public Combination getWinningCombination() {
        return this.winningCombination;
    }

    private boolean haveSingle(HandPoker hand) {
        return hand.getHandOccurrence().containsValue(SINGLE_FOR_DICO_KEY);
    }

    private boolean havePair(HandPoker hand) {
        return hand.getHandOccurrence().containsValue(PAIR_FOR_DICO_KEY);
    }

    private boolean haveBrelan(HandPoker hand) {
        return hand.getHandOccurrence().containsValue(BRELAN_FOR_DICO_KEY);
    }

    private boolean haveCarre(HandPoker hand) {
        return hand.getHandOccurrence().containsValue(CARRE_FOR_DICO_KEY);
    }

    private boolean haveDoublePair(HandPoker hand) {
        return havePair(hand) && hand.getHandCombination().get(PAIR_FOR_DICO_KEY).size() == 2;
    }

    private boolean haveStraight(HandPoker hand) {
        if (haveSingle(hand) && hand.getHandCombination().get(SINGLE_FOR_DICO_KEY).size() == 5) {
            int difference = getSingle(hand).get(0) - getSingle(hand).get(4);
            return difference == 4;
        }
        return false;
    }

    private boolean haveFull(HandPoker hand){
        return(haveBrelan(hand) && havePair(hand));
    }

    private  boolean haveFlush(HandPoker hand) {
        boolean bool = true;
        Color colorCard1 = hand.getHandCards().get(0).getColor();
        int i =1;
        while(bool && i < 5){
            bool = hand.getHandCards().get(i).getColor().equals(colorCard1);
            i++;
        }
        return bool;
    }

    private  boolean haveStraightFlush(HandPoker hand) {
        return haveStraight(hand) && haveFlush(hand);
    }

    private ArrayList<Integer> getSingle(HandPoker hand) {
        ArrayList<Integer> list = hand.getHandCombination().get(SINGLE_FOR_DICO_KEY);
        list.sort(Collections.reverseOrder());
        return list;
    }

    private ArrayList<Integer> getPair(HandPoker hand) {
        ArrayList<Integer> list = hand.getHandCombination().get(PAIR_FOR_DICO_KEY);
        list.sort(Collections.reverseOrder());
        return list;
    }

    private int getBrelan(HandPoker hand) {
        return hand.getHandCombination().get(BRELAN_FOR_DICO_KEY).get(0); /* only one brelan can be reach in any hand -> list of 1 element*/
    }

    private int getCarre(HandPoker hand) {
        return hand.getHandCombination().get(CARRE_FOR_DICO_KEY).get(0);
    }


    /**
     * @return the higher combination
     */
    private Combination chooseCombination(HandPoker hand) {
        if (haveStraightFlush(hand)) {
            return Combination.STRAIGHT_FLUSH;
        } else if (haveCarre(hand)) {
            return Combination.CARRE;
        } else if (haveFull(hand)){
            return Combination.FULL;
        } else if (haveFlush(hand)) {
            return Combination.FLUSH;
        } else if (haveStraight(hand)) {
            return Combination.SUITE;
        } else if (haveBrelan(hand)) {
            return Combination.BRELAN;
        } else if (havePair(hand)) {
            return doublePairOrUniquePair(hand);
        } else {
            return Combination.HIGHCARD;
        }
    }

    private Combination doublePairOrUniquePair(HandPoker hand) {
        if (haveDoublePair(hand)) {
            return Combination.TWO_PAIR;
        } else {
            return Combination.PAIR;
        }
    }

    /**
     * @return (true, false or empty) if the first hand is (better, worst or equals) to the second hand
     */
    private Optional<Boolean> chooseWinningHand() {
        if (chooseCombination(this.handP1) != chooseCombination(this.handP2)){
            return chooseWinningCombination();
        }

        switch (chooseCombination(this.handP1)) {
            case STRAIGHT_FLUSH:
                return chooseWinningStraightFlush();
            case CARRE:
                if (chooseWinningCarre().isEmpty()) {
                    return chooseWinningSingle();
                } else {
                    return chooseWinningCarre();
                }
            case FULL:
                return chooseWinningFull();
            case FLUSH:
                return chooseWinningFlush();
            case SUITE:
                return chooseWinningSuite();
            case BRELAN:
                if (chooseWinningBrelan().isEmpty()) {
                    return chooseWinningSingle(); /*car si la deuxième plus haute combinaison est une paire alors il s'agit d'un full et non un brelan*/
                } else {
                    return chooseWinningBrelan();
                }
            case PAIR, TWO_PAIR:
                if (chooseWinningPair().isEmpty()) {
                    return chooseWinningSingle();
                } else {
                    return chooseWinningPair();
                }
            default: /*when case equals to SINGLE_FOR_COMBINATION*/
                return chooseWinningSingle();
        }
    }

    /**
     * return the value according to the winningCombination
     *
     * @return an ArrayList that contain all the value that give the winningCombination
     */
    private ArrayList<Integer> correspondenceValueComposition(Combination combination, HandPoker hand) {
        ArrayList<Integer> listValue = new ArrayList<>();
        switch (combination) {
            case CARRE:
                listValue.add(getCarre(hand)); /* car getCarre ne renvoie pas une liste */
                return listValue;
            case FLUSH: case SUITE : case STRAIGHT_FLUSH :
                listValue.add(getSingle(hand).get(0));
                return listValue;
            case BRELAN: case FULL : /* car la valeur du full correspond à celle du brelan */
                listValue.add(getBrelan(hand)); /* car getBrelan ne renvoie pas une liste */
                return listValue;
            default:
                return getPair(hand);
        }
    }

    /**
     * return a Boolean to know the winning combination between 2 hands
     * Update winningCombination and winningValue
     *
     * @return (true, false or empty) if the first hand have a (higher, lower or equals) combination to the second hand
     */
    private Optional<Boolean> chooseWinningCombination() {
        if (chooseCombination(this.handP1).getRank() > chooseCombination(this.handP2).getRank()) {
            this.winningCombination = chooseCombination(this.handP1);
            this.winningValue = correspondenceValueComposition(this.winningCombination, this.handP1);
            return Optional.of(true);
        } else if (chooseCombination(this.handP1).getRank() < chooseCombination(this.handP2).getRank()) {
            this.winningCombination = chooseCombination(this.handP2);
            this.winningValue = correspondenceValueComposition(this.winningCombination, this.handP2);
            return Optional.of(false);
        } else {
            return Optional.empty();
        }
    }

    /**
     * return a Boolean to know the winning three of a kind between 2 three of a kind
     * Update winningCombination and winningValue
     *
     * @return (true, false or empty) if the first three of a kind is (higher, lower or equals) to the second one
     */
    private Optional<Boolean> chooseWinningBrelan() {
        if (getBrelan(this.handP1) > getBrelan(this.handP2)) {
            this.winningValue = new ArrayList<>(Collections.singletonList(getBrelan(this.handP1)));
            this.winningCombination = Combination.BRELAN;
            return Optional.of(true);
        } else if (getBrelan(this.handP1) < getBrelan(this.handP2)) {
            this.winningValue = new ArrayList<>(Collections.singletonList(getBrelan(this.handP2)));
            this.winningCombination = Combination.BRELAN;
            return Optional.of(false);
        } else {
            return Optional.empty();
        }
    }

    /**
     * return a Boolean to know the winning pair between 2 pairs
     * Update winningCombination and winningValue
     *
     * @return (true, false or empty) if the first pair is (higher, lower or equals) to the second pair
     */
    private Optional<Boolean> chooseWinningPair() {
        ArrayList<Integer> thisPairSorted = getPair(this.handP1);
        ArrayList<Integer> handPairSorted = getPair(this.handP2);
        thisPairSorted.sort(Collections.reverseOrder()); /* trier par ordre decroissant pour comparer en premier les plus hautes paires des deux mains*/
        handPairSorted.sort(Collections.reverseOrder());
        this.winningValue = new ArrayList<>();
        for (int i = 0; i < thisPairSorted.size(); i++) {
            if (thisPairSorted.get(i).equals(handPairSorted.get(i))) {
                this.winningValue.add(thisPairSorted.get(i));
            } else if (thisPairSorted.get(i) > handPairSorted.get(i)) {
                this.winningValue.add(thisPairSorted.get(i));
                this.winningCombination = doublePairOrUniquePair(this.handP1);
                return Optional.of(true);
            } else {
                this.winningValue.add(handPairSorted.get(i));
                this.winningCombination = doublePairOrUniquePair(this.handP2);
                return Optional.of(false);
            }
        }
        return Optional.empty();
    }

    /**
     * return a Boolean to know the winning single card between 2 singles cards
     * Update winningCombination and winningValue
     *
     * @return (true, false or empty) if the first single card is (higher, lower or equals) to the second single card
     */
    private Optional<Boolean> chooseWinningSingle() {
        ArrayList<Integer> thisSingleSorted = getSingle(this.handP1);
        ArrayList<Integer> handSingleSorted = getSingle(this.handP2);
        thisSingleSorted.sort(Collections.reverseOrder());
        handSingleSorted.sort(Collections.reverseOrder());

        for (int i = 0; i < (thisSingleSorted.size()); i++) {
            /*
            thisSingleSorted and handSingleSorted have the same size
             */
            if (!thisSingleSorted.get(i).equals(handSingleSorted.get(i))) {
                if (thisSingleSorted.get(i) > handSingleSorted.get(i)) {
                    this.winningValue = new ArrayList<>(Collections.singletonList(thisSingleSorted.get(i)));
                    this.winningCombination = Combination.HIGHCARD;
                    return Optional.of(true);
                } else {
                    this.winningValue = new ArrayList<>(Collections.singletonList(handSingleSorted.get(i)));
                    this.winningCombination = Combination.HIGHCARD;
                    return Optional.of(false);
                }
            }
        }
        this.winningCombination = Combination.EQUALITY;
        return Optional.empty();
    }

    /**
     * return a Boolean to know the winning four of a kind between 2 four of a kind
     * Update winningCombination and winningValue
     *
     * @return (true, false or empty) if the first four of a kind is (higher, lower or equals) to the second one
     */
    private Optional<Boolean> chooseWinningCarre() {
        if (getCarre(this.handP1) > getCarre(this.handP2)) {
            this.winningValue = new ArrayList<>(Collections.singletonList(getCarre(this.handP1)));
            this.winningCombination = Combination.CARRE;
            return Optional.of(true);
        } else if (getCarre(this.handP1) < getCarre(this.handP2)) {
            this.winningValue = new ArrayList<>(Collections.singletonList(getCarre(this.handP2)));
            this.winningCombination = Combination.CARRE;
            return Optional.of(false);
        } else {
            return Optional.empty();
        }
    }

    /**
     * return a Boolean to know the winning full between 2 full
     * Update winningCombination and winningValue
     *
     * @return (true, false or empty) if the first full is (higher, lower or equals) to the second one
     */
    private Optional<Boolean> chooseWinningFull(){
        Optional<Boolean> result2 = chooseWinningBrelan();
        this.winningCombination = Combination.FULL;
        return result2;
    }

    /**
     * return a Boolean to know the winning full between 2 full
     * Update winningCombination and winningValue
     *
     * @return (true, false or empty) if the first full is (higher, lower or equals) to the second one
     */
    private Optional<Boolean> chooseWinningFlush() {
        Optional<Boolean> result3 = chooseWinningSingle();
        this.winningCombination = Combination.FLUSH;
        return result3;
    }

    /**
     * return a Boolean to know the winning straight between 2 straight
     * Update winningCombination and winningValue
     *
     * @return (true, false or empty) if the first straight is (higher, lower or equals) to the second one
     */
    private Optional<Boolean> chooseWinningSuite() {
        if (chooseWinningSingle().isEmpty()) {
            return Optional.empty(); /*égalité*/
        } else {
            Optional<Boolean> result = chooseWinningSingle();
            this.winningCombination = Combination.SUITE; /*modifier après l'appel de chooseWinningSingle pour mettre Suite comme combinaison gagnante et non pas "carte la plus haute"*/
            return result;
        }
    }

    /**
     * return a Boolean to know the winning straight flush between 2 straight flush
     * Update winningCombination and winningValue
     *
     * @return (true, false or empty) if the first straight flush is (higher, lower or equals) to the second one
     */
    private Optional<Boolean> chooseWinningStraightFlush(){
        Optional<Boolean> result4 = chooseWinningSingle();
        this.winningCombination = Combination.STRAIGHT_FLUSH;
        return result4;
    }
}