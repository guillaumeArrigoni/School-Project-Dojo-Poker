package gamepoker.exception;

public class IncorrectCardException extends PokerException {
    public IncorrectCardException() {
        super("Incorrect Card syntax");
    }
}