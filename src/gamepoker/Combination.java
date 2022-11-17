package gamepoker;

public enum Combination {
    EQUALITY(0, "a equality"),
    HIGHCARD(1, "the highest card : "),
    PAIR(2, "a double pair"),
    TWO_PAIR(3, "a double pair"),
    BRELAN(4, "a three of a kind"),
    SUITE(5, "a straight"),
    FLUSH(6, "a flush"),
    FULL(7, "a full"),
    CARRE(8, "a four of a kind"),
    STRAIGHT_FLUSH(9, "a straight flush");

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