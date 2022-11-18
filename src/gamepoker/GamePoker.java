package gamepoker;

import gamepoker.exception.PokerException;
import gamepoker.exception.TwoIdenticalCardsException;
import gamepoker.exception.WrongNumberOfCardsException;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GamePoker {

    public static final int NUMBER_OF_PLAYER = 2;
    public static final int PLAYER1 = 0;
    public static final int PLAYER2 = 1;

    public static void main(String[] args) throws PokerException {

        List<HandPoker> theHandsPoker = registerHandsPoker(NUMBER_OF_PLAYER);
        Comparison comparison = new Comparison(theHandsPoker.get(PLAYER1), theHandsPoker.get(PLAYER2));

        if (comparison.getWinning().isEmpty()) {
            System.out.println("Both player have same hand ! No one win");
        } else {
            if (comparison.getWinning().get()) {
                System.out.println("Player 1 win with " + comparison);
            } else {
                System.out.println("Player 2 win with " + comparison);
            }
        }
    }

    public static List<HandPoker> registerHandsPoker(int numberOfPlayer) throws PokerException {
        List<HandPoker> handsPoker = new ArrayList<>(numberOfPlayer);

        for (int playerNumber = 1; playerNumber <= numberOfPlayer; playerNumber++) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("The card of player " + playerNumber + " : ");
            String[] cardString = scanner.nextLine().split(" ");

            if (cardString.length != HandPoker.NBR_CARDS) {
                throw new WrongNumberOfCardsException();
            }

            ArrayList<Card> handCards = new ArrayList<>(HandPoker.NBR_CARDS);
            for (int cardNumber = 0; cardNumber < HandPoker.NBR_CARDS; cardNumber++) {
                handCards.add(new Card(cardString[cardNumber]));
            }
            handsPoker.add(new HandPoker(handCards));
        }

        checkIfCardAlreadyExist(handsPoker);
        return handsPoker;
    }


    private static void checkIfCardAlreadyExist(List<HandPoker> handPoker) throws TwoIdenticalCardsException {
        ArrayList<Card> AllCard = new ArrayList<>();
        for (int i = 0;i<handPoker.size();i++){
            AllCard.addAll(handPoker.get(i).getHandCards());
        }
        Map<Card, Long> existDouble = AllCard.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(existDouble);
        long a = 2;
        if (existDouble.containsValue(a)){
            throw new TwoIdenticalCardsException();
        }
    }
    /*private static void checkIfCardAlreadyExist(List<HandPoker> handPoker) throws TwoIdenticalCardsException {
        ArrayList<Card> AllCard = new ArrayList<>();
        for (int i = 0; i<handPoker.size();i++){
            for (int j=0; j<handPoker.get(i).getHandCards().size();j++){
                if (AllCard.contains(handPoker.get(i).getHandCards().get(j))){
                    throw new TwoIdenticalCardsException();
                } else {
                    AllCard.add(handPoker.get(i).getHandCards().get(j));
                }
            }
        }
    }*/
}
