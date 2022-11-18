package gamepoker;

import gamepoker.exception.*;

import java.util.*;

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

            boolean existError = true;
            ArrayList<Card> handCards = new ArrayList<>(HandPoker.NBR_CARDS);
            int nbCardRemaining = HandPoker.NBR_CARDS;
            String errorMessage = "";
            ArrayList<Card> allCard = new ArrayList<>();


            while (existError) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("The card of player " + playerNumber + " : ");
                System.out.println("Please enter " + nbCardRemaining + " card(s).");
                String[] cardString = scanner.nextLine().split(" ");

                try {
                    if (cardString.length != nbCardRemaining) {
                        throw new WrongNumberOfCardsException();
                    }
                    for (int cardNumber = 0; cardNumber < nbCardRemaining; cardNumber++) {
                        Card cardToAdd = new Card(cardString[cardNumber]);
                        checkIfCardAlreadyExist(allCard, cardToAdd);
                        handCards.add(cardToAdd);
                        allCard.add(cardToAdd);
                    }
                    handsPoker.add(new HandPoker(handCards));
                    existError = false;
                } catch (WrongNumberOfCardsException e) {
                    errorMessage = "You didn't have enter the number of card requested.";
                } catch (IncorrectColorException e) {
                    errorMessage = "The card " + cardString[handCards.size()] + " don't have a valid color.";
                } catch (IncorrectValueException e) {
                    errorMessage = "The card " + cardString[handCards.size()] + " don't have a valid value.";
                    e.printStackTrace();
                } catch (IncorrectCardException e) {
                    errorMessage = "The card " + cardString[handCards.size()] + " is not valid.";
                } catch (TwoIdenticalCardsException e){
                    errorMessage = "The card " + cardString[handCards.size()] + " already exist.";
                } finally {
                    if (existError){
                        System.out.println("\nAn error has occurred");
                        errorMessage = errorMessage + "\n";
                        System.out.println(errorMessage);
                    }
                    nbCardRemaining = HandPoker.NBR_CARDS - handCards.size();
                }
            }
        }
        return handsPoker;
    }

    private static void checkIfCardAlreadyExist(List<Card> cardList, Card cardToTest) throws TwoIdenticalCardsException{
        if (cardList.contains(cardToTest)) {
            throw new TwoIdenticalCardsException();
        }
    }
}
