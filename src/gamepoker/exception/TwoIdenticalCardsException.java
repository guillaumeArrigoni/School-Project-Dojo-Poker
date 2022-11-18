package gamepoker.exception;

public class TwoIdenticalCardsException extends PokerException {
    public TwoIdenticalCardsException() {
        super("You have entered two identical cards. Each card can appear only once time.");
    }
}
