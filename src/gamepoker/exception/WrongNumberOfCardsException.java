package gamepoker.exception;

import gamepoker.HandPoker;

public class WrongNumberOfCardsException extends PokerException {

    public WrongNumberOfCardsException() {
        super("You have too much or too little card, you just need " + HandPoker.NBR_CARDS + " cards, separated with spaces.");
    }
}