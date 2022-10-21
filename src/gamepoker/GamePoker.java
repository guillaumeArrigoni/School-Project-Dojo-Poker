package gamepoker;

import java.util.Scanner;

public class GamePoker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.print( "The card of player 1 : " );
        String cardString1 = scanner.nextLine();
        Card cardP1 = new Card(new Value(cardString1));

        System.out.print( "The card of player 2 : " );
        String cardString2 = scanner.nextLine();
        Card cardP2 = new Card(new Value(cardString2));

        if (cardP1.CompareHigherCard(cardP2) == null) {
            System.out.println("Both player have same card ! No one win");
        } else {
            if (cardP1.CompareHigherCard(cardP2)) {
                System.out.println("Player 1 win ! With higher card, a "+ cardP1);
            } else {
                System.out.println("Player 2 win ! With higher card, a "+ cardP2);
            }
        }
    }
}
