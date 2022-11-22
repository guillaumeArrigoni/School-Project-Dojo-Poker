package gamepoker.exception;

public class PokerException extends Exception {

    private final String errorTitle;

    public PokerException(String message) {
        super(message);
        this.errorTitle = "An error has occurred";
    }

    public String getErrorTitle() {
        return this.errorTitle;
    }
}
