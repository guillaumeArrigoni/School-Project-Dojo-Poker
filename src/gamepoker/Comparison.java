package gamepoker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class Comparison {
    /**
     * winningCombination give the number associate to the combination that is winning
     * The value are :
     * Equality : 0
     * Single Card : 1
     * Pair : 2
     * Double pair : 3
     * Brelan : 4
     * .....
     */
    public static final int EQUALITY = 0;
    public static final int SINGLE = 1;
    public static final int PAIR = 2;
    public static final int TWO_PAIR = 3;
    public static final int BRELAN = 4;

    private final HashMap<Integer, String> correspondanceCombinaisonEntierString = new HashMap<>();
    private int winningCombination;
    private ArrayList<Integer> winningValue;
    private Boolean firstWinningOnSecond;
    private HandPoker hand1;
    private HandPoker hand2;

    public Comparison(HandPoker firstHand, HandPoker secondHand) {
        initDictionary();
        this.hand1 = firstHand;
        this.hand2 = secondHand;
        this.firstWinningOnSecond = chooseWinningHand();
    }

    @Override
    public String toString() {
        String texte = correspondanceCombinaisonEntierString.get(winningCombination);
        if (winningCombination != 0){
            texte = texte + " of ";
        }
        /*Value value = new Value(winningValue.get(0));
        texte = texte + value.toString();
         */
        texte = texte + winningValue.get(0);
        return texte;
    }

    private void initDictionary(){
        correspondanceCombinaisonEntierString.put(1, "the highest card : ");
        correspondanceCombinaisonEntierString.put(2, "pair");
        correspondanceCombinaisonEntierString.put(3, "double pair");
        correspondanceCombinaisonEntierString.put(4, "three of a kind");
    }
    public Boolean getWinning() {
        return this.firstWinningOnSecond;
    }

    public List<Integer> getWinningValue() {
        return this.winningValue;
    }

    public int getWinningCombination() {
        return this.winningCombination;
    }

    private boolean haveSingle(HandPoker hand) {
        return hand.getHandOccurrence().containsValue(SINGLE);
    }

    private boolean havePair(HandPoker hand) {
        return hand.getHandOccurrence().containsValue(PAIR);
    }

    private boolean haveBrelan(HandPoker hand) {
        return hand.getHandOccurrence().containsValue(BRELAN);
    }

    private ArrayList<Integer> getSingle(HandPoker hand) {
        return hand.getHandCombination().get(SINGLE);
    }

    private ArrayList<Integer> getPair(HandPoker hand) {
        return hand.getHandCombination().get(PAIR);
    }

    private Integer getBrelan(HandPoker hand) {
        return hand.getHandCombination().get(BRELAN).get(0); /* only one brelan can be reach in any hand -> list of 1 element*/
    }

    /**
     * return the number to the higher combination
     * Single card : 1
     * Pair : 2
     * Two pairs : 3
     * Brelan : 4
     *
     * @return the number of the higher combination
     */
    private int chooseCombination(HandPoker hand) {
        if (haveBrelan(hand)) {
            return BRELAN;
        } else if (havePair(hand)) {
            return PAIR;
        } else {
            return SINGLE;
        }
    }

    /**
     * @return (true, false or null) if the first hand is (better, worst or equals) to the second hand
     */
    private Boolean chooseWinningHand() {
        if (chooseCombination(this.hand1) == chooseCombination(this.hand2)) {
            if (chooseCombination(this.hand1) == PAIR) {
                if (chooseWinningPair() == null) {
                    return chooseWinningSingle();
                } else {
                    return chooseWinningPair();
                }
            } else {
                return chooseWinningSingle();
            }
        } else {
            return chooseWinningCombination();
        }
    }

    /**
     * return the value according to the winningCombination
     *
     * @return an ArrayList that contain all the value that give the winningCombination
     */
    private ArrayList<Integer> correspondenceValueComposition(int number, HandPoker hand) {
        ArrayList<Integer> listValue = new ArrayList<>();
        if (number == BRELAN) {
            listValue.add(getBrelan(hand));
            return listValue;
        } else {
            return getPair(hand);
        }
    }

    /**
     * return a Boolean to know the winning combination between 2 hands
     * Update winningCombination and winningValue
     *
     * @return (true, false or null) if the first hand have a (higher, lower or equals) combination to the second hand
     */
    private Boolean chooseWinningCombination() {
        if (chooseCombination(this.hand1) > chooseCombination(this.hand2)) {
            this.winningCombination = chooseCombination(this.hand1);
            this.winningValue = correspondenceValueComposition(this.winningCombination, this.hand1);
            return true;
        } else if (chooseCombination(this.hand1) < chooseCombination(this.hand2)) {
            this.winningCombination = chooseCombination(this.hand2);
            this.winningValue = correspondenceValueComposition(this.winningCombination, this.hand2);
            return false;
        } else {
            return null;
        }
    }

    /**
     * return a Boolean to know the winning brelan between 2 brelans
     * Update winningCombination and winningValue
     *
     * @return (true, false or null) if the first brelan is (higher, lower or equals) to the second brelan
     */
    private Boolean chooseWinningBrelan() {
        if (getBrelan(this.hand1) > getBrelan(this.hand2)) {
            this.winningValue = new ArrayList<>(Collections.singletonList(getBrelan(this.hand1)));
            this.winningCombination = BRELAN;
            return true;
        } else if (getBrelan(this.hand1) < getBrelan(this.hand2)) {
            this.winningValue = new ArrayList<>(Collections.singletonList(getBrelan(this.hand2)));
            this.winningCombination = BRELAN;
            return false;
        } else {
            return null;
        }
    }

    /**
     * return a Boolean to know the winning pair between 2 brelans
     * Update winningCombination and winningValue
     * @return (true, false or null) if the first pair is (higher, lower or equals) to the second pair
     */
    private Boolean chooseWinningPair() {
        ArrayList<Integer> thisPairSorted = getPair(this.hand1);
        ArrayList<Integer> handPairSorted = getPair(this.hand2);
        thisPairSorted.sort(Collections.reverseOrder());
        handPairSorted.sort(Collections.reverseOrder());

        for (int i = 0; i < thisPairSorted.size(); i++) {
            if (thisPairSorted.get(i) != handPairSorted.get(i)) {
                if (thisPairSorted.get(i) > handPairSorted.get(i)) {
                    this.winningValue = new ArrayList<>(Collections.singletonList(thisPairSorted.get(i)));
                    this.winningCombination = PAIR;
                    return true;
                } else {
                    this.winningValue = new ArrayList<>(Collections.singletonList(handPairSorted.get(i)));
                    this.winningCombination = PAIR;
                    return false;
                }
            }
        }
        return null;
    }

    /**
     * return a Boolean to know the winning single card between 2 singles cards
     * Update winningCombination and winningValue
     * @return (true, false or null) if the first single card is (higher, lower or equals) to the second single card
     */
    private Boolean chooseWinningSingle() {
        ArrayList<Integer> thisSingleSorted = getSingle(this.hand1);
        ArrayList<Integer> handSingleSorted = getSingle(this.hand2);
        thisSingleSorted.sort(Collections.reverseOrder());
        handSingleSorted.sort(Collections.reverseOrder());

        for (int i = 0; i < (thisSingleSorted.size()); i++) {
            /*
            thisSingleSorted and handSingleSorted have the same size
             */
            if (thisSingleSorted.get(i) != handSingleSorted.get(i)) {
                if (thisSingleSorted.get(i) > handSingleSorted.get(i)) {
                    this.winningValue = new ArrayList<>(Collections.singletonList(thisSingleSorted.get(i)));
                    this.winningCombination = SINGLE;
                    return true;
                } else {
                    this.winningValue = new ArrayList<>(Collections.singletonList(handSingleSorted.get(i)));
                    this.winningCombination = SINGLE;
                    return false;
                }
            }
        }
        this.winningCombination = EQUALITY;
        return null;
    }
}


