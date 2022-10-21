package gamepoker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The poker game contains 52 cards without joker, a card is composed by a value and a color
 * @author Karim CHARLEUX & Yacine MERIOUA
 */
public class Card {
    /** The value of the card with a position between 2 and 14 to determine the highest to the lowest card */
    private Value value;

    /**
     * Create Card with a specified value
     * @param value The value's card
     */
    public Card(Value value) {
        this.value = value;
    }

    /**
     * @return The value object of the current card
     */
    public Value getValue() {
        return this.value;
    }

    /**
     * Allows to compare with another card on the current card the higher value
     * @param card2 The second card
     * @return an ArrayList with 2 parameters :
     * The first is a boolean with True, if the cards are equals and False otherwise
     * The second is the higher card
     */
    public Boolean CompareHigherCard(Card card2) {
        if (this.value.getPosition() == card2.getValue().getPosition()) {
            return null;
        } else {
            return (this.value.getPosition() > card2.getValue().getPosition());
        }
    }

    /**
     * Overriding equals() to compare two Card objects
     * @param object The Card object to compare to the current Card
     * @return True if object is equals to current Card value or False if not
     */
    @Override
    public boolean equals(Object object) {
        // If the object is compared with itself then return true
        if (object == this) {
            return true;
        }
        // Check if object is an instance of Card or not
        if (!(object instanceof Card)) {
            return false;
        }
        // Typecast object to Card so that we can compare data
        Card card2 = (Card) object;

        // Compare the card value data and return accordingly
        return card2.value.equals(this.value);
    }

    /**
     * Convert a card object in a string object to correct display
     * @return the card converted to a string
     */
    @Override
    public String toString() {
        return this.value.toString();
    }

}
