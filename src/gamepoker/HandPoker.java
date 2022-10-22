package gamepoker;

import java.util.*;

public class HandPoker {
    private final ArrayList<Card> hand;
    HashMap<Integer, Integer> handOccurrence ;
    HashMap<Integer, ArrayList<Integer>> handCombination ;

    public HandPoker(Card card1, Card card2, Card card3){
        this.hand = new ArrayList<>();
        this.hand.add(card1);
        this.hand.add(card2);
        this.hand.add(card3);
        registerInDictionary(this.hand);
        reverseDictionary(this.handOccurrence);
    }

    /**
     * Associate to each different value of the card in a hand the number of card that share the same value
     */
    private void registerInDictionary(ArrayList<Card> hand){
        for (int i = 0;i<hand.size();i++){
            if (handOccurrence.containsKey(hand.get(i).getValue().getPosition())) {
                handOccurrence.replace(hand.get(i).getValue().getPosition(),handOccurrence.get(hand.get(i).getValue().getPosition())+1);
            } else {
                handOccurrence.put(hand.get(i).getValue().getPosition(),1);
            }
        }
    }

    /**
     * Associate to each value of a dictionary all the key in an ArrayList
     * @param dico : the dictionary we want to reverse
     */
    private void reverseDictionary(HashMap<Integer,Integer> dico){
        for (Map.Entry<Integer,Integer> entry : dico.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (handCombination.containsKey(value)){
                handCombination.get(value).add(key);
            } else {
                handCombination.put(value,new ArrayList<>(Collections.singletonList(key)));
            }
        }
    }

    public List<Card> getHand(){
        return this.hand;
    }

    public HashMap<Integer,Integer> getHandOccurrence(){
        return this.handOccurrence;
    }

    public HashMap<Integer,ArrayList<Integer>> getHandCombination(){
        return this.handCombination;
    }

    /**
     * Convert a hand object in a string object to correct display
     * @return all the card of a hand separate by a space
     */
    @Override
    public String toString() {
        return (hand.get(0).toString() + " " + hand.get(1).toString());
    }
}
