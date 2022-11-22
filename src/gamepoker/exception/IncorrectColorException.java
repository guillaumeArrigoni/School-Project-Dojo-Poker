package gamepoker.exception;

public class IncorrectColorException extends PokerException {

    private final String wrongColor;

    public IncorrectColorException(String wrongColor) {
        super("The color \"" + wrongColor + "\" don't have a valid syntax.");
        this.wrongColor = wrongColor;
    }

    @Override
    public String getErrorTitle() {
        return "The color \"" + wrongColor + "\" don't have a valid syntax.";
    }
}
