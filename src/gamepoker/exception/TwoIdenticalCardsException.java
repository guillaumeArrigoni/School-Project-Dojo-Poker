package gamepoker.exception;

public class TwoIdenticalCardsException extends PokerException {

    private final String identicalCard;

    public TwoIdenticalCardsException(String identicalCard) {
        super("You have entered \"" + identicalCard + "\" and it already exists. Each card can appear only once time.");
        this.identicalCard = identicalCard;
    }

    @Override
    public String getErrorTitle() {
        return "You have entered \"" + this.identicalCard + "\" and it already exists. Each card can appear only once time.";
    }
}
