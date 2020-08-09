package ca.sheridancollege.project;

/**
 * A Card object is defined by its value (or rank) and its suit.
 *
 * @author Mustafa Shubbar, 2020
 * @author Melih Eren Arslan, 2020
 * @author Amirmahdi Ghasemi, 2020
 */
public class Card implements Comparable {

    Card(int r, int s) {
        rank = r;
        suit = s;
    }

    int getRank() {
        return rank;
    }

    int getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Object ob) {
        Card other = (Card) ob;
        int thisRank = this.getRank();
        int otherRank = other.getRank();
        if (thisRank == 1) {
            thisRank = 14; // make aces high
        }
        if (otherRank == 1) {
            otherRank = 14;
        }
        return thisRank - otherRank;
    }

    @Override
    public boolean equals(Object ob) {
        if (ob instanceof Card) {
            Card other = (Card) ob;
            return rank == other.rank && suit == other.suit;
        } else {
            return false;
        }
    }

    public String toString() {
        String val;
        String[] suitList
                = {"", "Clubs", "Diamonds", "Hearts", "Spades"};
        switch (rank) {
            case 1:
                val = "Ace";
                break;
            case 11:
                val = "Jack";
                break;
            case 12:
                val = "Queen";
                break;
            case 13:
                val = "King";
                break;
            default:
                val = String.valueOf(rank); // int to String
                break;
        }
        String s = val + " of " + suitList[suit];
        for (int k = s.length() + 1; k <= 17; k++) {
            s = s + " ";
        }
        return s;
    }
    private int rank;
    private int suit;
}
