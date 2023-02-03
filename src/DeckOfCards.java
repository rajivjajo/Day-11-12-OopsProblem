import java.util.Random;

public class DeckOfCards {

    private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public static void main(String[] args) {
        String[][] deck = new String[SUITS.length * RANKS.length][2];
        int index = 0;

        // initialize deck of cards
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[index][0] = suit;
                deck[index][1] = rank;
                index++;
            }
        }

        // shuffle the deck
        Random random = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = random.nextInt(i);
            String[] temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }

        // distribute cards to players
        String[][] players = new String[4][9];
        int cardIndex = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 9; j++) {
                players[i][j] = deck[cardIndex][0] + " " + deck[cardIndex][1];
                cardIndex++;
            }
        }

        // print cards received by players
        for (int i = 0; i < 4; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < 9; j++) {
                System.out.print(players[i][j] + " ");
            }
            System.out.println();
        }
    }
}
