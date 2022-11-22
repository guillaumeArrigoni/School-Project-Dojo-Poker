package gamepoker.exception;

public class IncorrectCardException extends PokerException {

    private final String wrongCard;

    public IncorrectCardException(String wrongCard) {
        super("The card \"" + wrongCard + "\" is not valid.");
        this.wrongCard = wrongCard;
    }

    @Override
    public String getErrorTitle() {
        return "The card \"" + wrongCard + "\" is not valid.";
    }
}