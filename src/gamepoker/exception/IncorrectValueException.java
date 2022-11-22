package gamepoker.exception;

public class IncorrectValueException extends PokerException {

    private final String wrongValue;

    public IncorrectValueException(String wrongValue) {
        super("The value \"" + wrongValue + "\" don't have a valid syntax.");
        this.wrongValue = wrongValue;
    }

    public IncorrectValueException() {
        super("The value don't have a valid syntax.");
        wrongValue = "";
    }

    @Override
    public String getErrorTitle() {
        return "The value \"" + this.wrongValue + "\" don't have a valid syntax.";
    }
}
