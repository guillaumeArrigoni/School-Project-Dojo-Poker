package gamepoker;

import java.util.*;

public class HandPoker {

    public static final int NBR_CARDS = 3;
    private final ArrayList<Card> handCards;
    private HashMap<Integer, Integer> handOccurrence;
    private HashMap<Integer, ArrayList<Integer>> handCombination;

    public HandPoker(Card card1, Card card2, Card card3, Card card4) {
        this.handCards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4));
        this.handOccurrence = new HashMap<>();
        this.handCombination = new HashMap<>();
        registerInDictionary();
        reverseDictionary();
    }

    /**
     * Associate to each different value of the card in a hand the number of card that share the same value
     */
    private void registerInDictionary() {
        this.handCards.forEach((theCard -> {
            if (this.handOccurrence.containsKey(theCard.getValue().getPosition())) {
                this.handOccurrence.replace(theCard.getValue().getPosition(), this.handOccurrence.get(theCard.getValue().getPosition()) + 1);
            } else {
                this.handOccurrence.put(theCard.getValue().getPosition(), 1);
            }
        }));
    }

    /**
     * Associate to each value of a dictionary all the key in an ArrayList
     */
    private void reverseDictionary() {
        for (Map.Entry<Integer, Integer> entry : this.handOccurrence.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (this.handCombination.containsKey(value)) {
                this.handCombination.get(value).add(key);
            } else {
                this.handCombination.put(value, new ArrayList<>(Collections.singletonList(key)));
            }
        }
    }

    public List<Card> getHandCards() {
        return this.handCards;
    }

    public Map<Integer, Integer> getHandOccurrence() {
        return this.handOccurrence;
    }

    public Map<Integer, ArrayList<Integer>> getHandCombination() {
        return this.handCombination;
    }

    /**
     * Convert a hand object in a string object to correct display
     * @return all the card of a hand separate by a space
     */
    @Override
    public String toString() {
        String outputString = "";
        this.handCards.forEach((card -> outputString.concat(card.toString() + " ")));
        return outputString;
    }
}
