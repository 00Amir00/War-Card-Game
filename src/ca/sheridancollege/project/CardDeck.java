package ca.sheridancollege.project;

/**
 * The job of creating the 52 cards is relegated to a private method fill that
 * uses nested for loops to generate the 13 values and 4 suits.
 *
 * @author Mustafa Shubbar, 2020
 * @author Melih Eren Arslan, 2020
 * @author Amirmahdi Ghasemi, 2020
 */
public class CardDeck {

    // Default constructor
    CardDeck() {
        // Variable fields
        deck = new Card[52];
        fill();
    }

    // Shuffle method which shuffle the cards
    void shuffle() {
        for (int next = 0; next < numCards - 1; next++) {
            int r = myRandom(next, numCards - 1);
            Card temp = deck[next];
            deck[next] = deck[r];
            deck[r] = temp;
        }
    }

    Card deal() {
        if (numCards == 0) {
            return null;
        }
        numCards--;
        return deck[numCards];
    }

    // getSize method which returns an int
    int getSize() {
        return numCards;
    }

    // The method that generates the cards
    private void fill() {
        int index = 0;
        for (int r = 1; r <= 13; r++) {
            for (int s = 1; s <= 4; s++) {
                deck[index] = new Card(r, s);
                index++;
            }
        }
        numCards = 52;
    }

    // myRandom method which has 2 arguments and return an int
    private static int myRandom(int low, int high) {
        return (int) ((high + 1 - low) * Math.random() + low);
    }
    private Card[] deck;
    private int numCards;
}
