package gamepoker;

import java.util.List;
import java.util.Scanner;

public class GamePoker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.print( "The card of player 1 : " );
        String cardsPlayer1 = scanner.nextLine();
        String[] cardString1 = cardsPlayer1.split(" ");

         Card Player1card1 = new Card(cardString1[0]);
         Card Player1card2 = new Card(cardString1[1]);
         Card Player1card3 = new Card(cardString1[2]);
         Card Player1card4 = new Card(cardString1[3]);
        Card Player1card5 = new Card(cardString1[4]);

        HandPoker hand1 = new HandPoker(Player1card1, Player1card2, Player1card3,Player1card4,Player1card5);

        System.out.print( "The card of player 2 : " );
        String cardsPlayer2 = scanner.nextLine();
        String[] cardString2 = cardsPlayer2.split(" ");


        Card Player2card1 = new Card(cardString2[0]);
        Card Player2card2 = new Card(cardString2[1]);
        Card Player2card3 = new Card(cardString2[2]);
        Card Player2card4 = new Card(cardString2[3]);
        Card Player2card5 = new Card(cardString2[4]);

        HandPoker hand2 = new HandPoker(Player2card1, Player2card2, Player2card3,Player2card4,Player2card5);

        Comparison c = new Comparison(hand1, hand2);
        int winningCombination = c.getWinningCombination();
        List<Integer> winValue = c.getWinningValue();

        if ( c.getWinning()== null) {
            System.out.println("Both player have same hand ! No one win");
        } else {
            if (c.getWinning()) {
                System.out.println("Player 1 win with "+ c.toString());
            } else {
                System.out.println("Player 2 win with "+ c.toString());
            }
        }
    }
}
