package gamepoker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePoker {

    public static final int NUMBER_OF_PLAYER = 2;
    public static final int PLAYER1 = 0;
    public static final int PLAYER2 = 1;

    public static void main(String[] args) {

        List<HandPoker> theHandsPoker = registerHandsPoker(NUMBER_OF_PLAYER);
        Comparison comparison = new Comparison(theHandsPoker.get(PLAYER1), theHandsPoker.get(PLAYER2));

        if (comparison.getWinning().isPresent()) {
            System.out.println("Both player have same hand ! No one win");
        } else {
            if (comparison.getWinning().isPresent()) {
                System.out.println("Player 1 win with " + comparison);
            } else {
                System.out.println("Player 2 win with " + comparison);
            }
        }
    }

    public static List<HandPoker> registerHandsPoker(int numberOfPlayer) {
        List<HandPoker> handsPoker = new ArrayList<>(numberOfPlayer);

        for (int playerNumber = 1; playerNumber <= numberOfPlayer; playerNumber++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("The card of player " + playerNumber + " : ");
            String[] cardString = scanner.nextLine().split(" ");

            ArrayList<Card> handCards = new ArrayList<>(HandPoker.NBR_CARDS);
            for (int cardNumber = 0; cardNumber < HandPoker.NBR_CARDS; cardNumber++) {
                handCards.add(new Card(cardString[cardNumber]));
            }
            handsPoker.add(new HandPoker(handCards));
        }

        return handsPoker;
    }
}
