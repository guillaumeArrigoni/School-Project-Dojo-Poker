package gamepoker;

public enum Combination {
    EQUALITY(0, "a equality of "),
    HIGHCARD(1, "the highest card : "),
    PAIR(2, "a double pair of "),
    TWO_PAIR(3, "a double pair of "),
    BRELAN(4, "a three of a kind of "),
    SUITE(5, "a straight of "),
    FLUSH(6, "a flush of "),
    FULL(7, "a full of "),
    CARRE(8, "a four of a kind of "),
    STRAIGHT_FLUSH(9, "a straight flush of ");

    private final int rank;

    private final String description;

    Combination(int rank, String description) {
        this.rank = rank;
        this.description = description;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return this.description;
    }
}