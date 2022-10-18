package gamepoker;

/**
 * The value of the cards depends on the strength of each card, this is one of the rules of classic poker.
 * There is a hierarchy of cards that determines strength in poker.
 * The best card is the Ace and the worst is the 2, among the 13 of each suit.
 */
public class Value {
    /** The name of the value */
    private String name;
    /** The position of the value between 2 and 14 to determine the highest to the lowest */
    private int position;

    /**
     * Constructor of Value card
     * @param name of the value object
     * @param position of the value object
     */
    public Value(String name, int position) {
        this.name = name;
        this.position = position;
    }

    /**
     * @return The name of current value object
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return The position of current value object
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Overriding equals() to compare two Value objects
     * @param object The Value object to compare to the current Value
     * @return False or true if object is equals to current Value
     */
    @Override
    public boolean equals(Object object) {
        // If the object is compared with itself then return true
        if (object == this) {
            return true;
        }
        // Check if o is an instance of Value or not
        if (!(object instanceof Value)) {
            return false;
        }
        // Typecast object to Value so that we can compare both data
        Value value2 = (Value) object;

        // Compare the data members and return accordingly
        return value2.name.equals(this.name) && value2.position == this.position;
    }

    /**
     * Give a value object in a string object
     * @return the card value
     */
    @Override
    public String toString() {
        return this.name;
    }
}
