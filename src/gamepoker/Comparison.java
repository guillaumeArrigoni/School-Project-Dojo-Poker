package gamepoker;

import java.util.*;

public class Comparison {
    /**
     * winningCombination give the number associate to the combination that is winning
     * The value are :
     * Equality : 0
     * Single Card : 1
     * Pair : 2
     * .....
     */
    int winningCombination ;
    ArrayList<Integer> winningValue;
    Boolean firstWinningOnSecond;

    public Comparison(HandPoker hand1, HandPoker hand2){
        firstWinningOnSecond = chooseWinningHand(hand1,hand2);
    }

    public Boolean getWinning(){
        return this.firstWinningOnSecond;
    }

    public List<Integer> getWinningValue(){
        return this.winningValue;
    }

    public int getWinningCombination(){
        return this.winningCombination;
    }

    private boolean haveSingle(HandPoker hand){
        return hand.getHandOccurrence().containsValue(1);
    }

    private boolean havePair(HandPoker hand){
        return hand.getHandOccurrence().containsValue(2);
    }

    private boolean haveBrelan(HandPoker hand){
        return hand.getHandOccurrence().containsValue(3);
    }

    private ArrayList<Integer> getSingle(HandPoker hand){
        return hand.getHandCombination().get(1);
    }

    private ArrayList<Integer> getPair(HandPoker hand){
        return hand.getHandCombination().get(2);
    }

    private Integer getBrelan(HandPoker hand){
        return hand.getHandCombination().get(3).get(0); /* only one brelan can be reach in any hand -> list of 1 element*/
    }

    /**
     * return the number to the higher combination
     * Single card : 1
     * Pair : 2
     * Two pairs : 3
     * Brelan : 4
     * @return the number of the higher combination
     */
    private int chooseCombination(HandPoker hand){
        if (haveBrelan(hand)) {
            return 4;
        } else if (havePair(hand)) {
            return 2;
        } else {
            return 1;
        }
    }

    /**
     * @return (true, false or null) if the first hand is (better, worst or equals) to the second hand
     */
    private Boolean chooseWinningHand(HandPoker hand1, HandPoker hand2) {
        if (chooseCombination(hand1) == chooseCombination(hand2)) {
            if (chooseCombination(hand1) == 2 || chooseCombination(hand2) == 3) {
                if (chooseWinningPair(hand1, hand2) == null ){
                    return chooseWinningSingle(hand1,hand2);
                } else {
                    return chooseWinningPair(hand1,hand2);
                }
            } else {
                return chooseWinningSingle(hand1,hand2);
            }
        } else {
            return chooseWinningCombination(hand1,hand2);
        }
    }

    /**
     * return the value according to the winningCombination
     * @return an ArrayList that contain all the value that give the winningCombination
     */
    private ArrayList<Integer> correspondanceValeurComposition(int number, HandPoker hand){
        ArrayList<Integer> listValue = new ArrayList<>();
        if (number == 4){
            listValue.add(getBrelan(hand));
            return listValue;
        } else {
            return getPair(hand);
        }
    }

    /**
     * return a Boolean to know the winning combination between 2 hands
     * Update winningCombination and winningValue
     * @return (true, false or null) if the first hand have a (higher, lower or equals) combination to the second hand
     */
    private Boolean chooseWinningCombination(HandPoker hand1, HandPoker hand2){
        if (chooseCombination(hand1) > chooseCombination(hand2)){
            this.winningCombination = chooseCombination(hand1);
            this.winningValue = correspondanceValeurComposition(this.winningCombination,hand1);
            return true;
        } else if (chooseCombination(hand1) < chooseCombination(hand2)) {
            this.winningCombination = chooseCombination(hand2);
            this.winningValue = correspondanceValeurComposition(this.winningCombination,hand2);
            return false;
        } else {
            return null;
        }
    }

    /**
     * return a Boolean to know the winning brelan between 2 brelans
     * Update winningCombination and winningValue
     * @return (true, false or null) if the first brelan is (higher, lower or equals) to the second brelan
     */
    private Boolean chooseWinningBrelan(HandPoker hand1,HandPoker hand2){
        if (getBrelan(hand1) > getBrelan(hand2)){
            this.winningValue = new ArrayList<>(Collections.singletonList(getBrelan(hand1))) ;
            this.winningCombination = 4;
            return true;
        } else if (getBrelan(hand1) < getBrelan(hand2)) {
            this.winningValue = new ArrayList<>(Collections.singletonList(getBrelan(hand2)));
            this.winningCombination = 4;
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
    private Boolean chooseWinningPair(HandPoker hand1, HandPoker hand2){
        ArrayList<Integer> thisPairSorted = getPair(hand1);
        ArrayList<Integer> handPairSorted = getPair(hand2);
        thisPairSorted.sort(Collections.reverseOrder());
        handPairSorted.sort(Collections.reverseOrder());
        for (int i = 0; i<thisPairSorted.size(); i++){
            if (thisPairSorted.get(i) != handPairSorted.get(i)){
                if (thisPairSorted.get(i) > handPairSorted.get(i)){
                    this.winningValue = new ArrayList<>(Collections.singletonList(thisPairSorted.get(i)));
                    this.winningCombination = 2;
                    return true;
                } else {
                    this.winningValue = new ArrayList<>(Collections.singletonList(handPairSorted.get(i)));
                    this.winningCombination = 2;
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
    private Boolean chooseWinningSingle(HandPoker hand1, HandPoker hand2){
        ArrayList<Integer> thisSingleSorted = getSingle(hand1);
        ArrayList<Integer> handSingleSorted = getSingle(hand2);
        thisSingleSorted.sort(Collections.reverseOrder());
        handSingleSorted.sort(Collections.reverseOrder());
        for (int i =0;i<(thisSingleSorted.size());i++){
            /*
            thisSingleSorted and handSingleSorted have the same size
             */
            if (thisSingleSorted.get(i) != handSingleSorted.get(i)) {
                if (thisSingleSorted.get(i) > handSingleSorted.get(i)){
                    this.winningValue = new ArrayList<>(Collections.singletonList(thisSingleSorted.get(i)));
                    this.winningCombination = 1;
                    return true;
                } else {
                    this.winningValue = new ArrayList<>(Collections.singletonList(handSingleSorted.get(i)));
                    this.winningCombination = 1;
                    return false;
                }
            }
        }
        this.winningCombination = 0;
        return null;
    }
}


