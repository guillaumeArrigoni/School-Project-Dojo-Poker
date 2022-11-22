package gamepoker;

import gamepoker.exception.PokerException;
import gamepoker.exception.TwoIdenticalCardsException;
import gamepoker.exception.WrongNumberOfCardsException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GamePoker {

    public static final int NUMBER_OF_PLAYER = 2;
    public static final int PLAYER1 = 0;
    public static final int PLAYER2 = 1;

    public static void main(String[] args) throws InterruptedException {

        List<HandPoker> theHandsPoker = registerHandsPoker();

        Comparison comparisonTwoHands = new Comparison(theHandsPoker.get(PLAYER1), theHandsPoker.get(PLAYER2));

        System.out.println("\n" + comparisonTwoHands);
    }

    public static List<HandPoker> registerHandsPoker() throws InterruptedException {
        List<HandPoker> allHandsPoker = new ArrayList<>(NUMBER_OF_PLAYER);

        for (int playerNumber = 1; playerNumber <= NUMBER_OF_PLAYER; playerNumber++) {
            boolean existError = true;

            while (existError) {
                try {
                    HandPoker handPokerCurrentPlayer = registerCards(playerNumber);
                    allHandsPoker.add(handPokerCurrentPlayer);
                    checkIfaCardAlreadyExist(allHandsPoker);
                    existError = false;
                } catch (PokerException e) {
                    System.err.println("\n  -> An error has occurred : " + e.getErrorTitle() + "\n");
                    TimeUnit.SECONDS.sleep(1); // Wait 1s for retry
                }
            }
        }
        return allHandsPoker;
    }

    public static HandPoker registerCards(int playerNumber) throws PokerException {
        Scanner scannerCards = new Scanner(System.in);
        System.out.print("The cards of player " + playerNumber + " : ");
        String[] allCardsString = scannerCards.nextLine().split(" ");

        if (allCardsString.length != HandPoker.NBR_CARDS) {
            throw new WrongNumberOfCardsException();
        }

        ArrayList<Card> handCards = new ArrayList<>(HandPoker.NBR_CARDS);
        for (String cardString : allCardsString) {
            handCards.add(new Card(cardString));
        }
        return new HandPoker(handCards);
    }

    private static void checkIfaCardAlreadyExist(List<HandPoker> handsPokerList) throws PokerException {
        ArrayList<Card> allCardsInAllHands = new ArrayList<>();

        handsPokerList.forEach(handPoker -> allCardsInAllHands.addAll(handPoker.getHandCards())); //Get all cards in all hands

        Map<Card, Long> cardsOccurrence = allCardsInAllHands.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())); // Group by card and count how many appear (like SQL)
        for (Map.Entry<Card, Long> cardAndCount : cardsOccurrence.entrySet()) {
            if (cardAndCount.getValue() >= 2)
                throw new TwoIdenticalCardsException(cardAndCount.getKey().toString());
        }
    }
}
