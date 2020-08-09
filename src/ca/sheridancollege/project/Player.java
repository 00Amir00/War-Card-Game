package ca.sheridancollege.project;

/**
 *
 * @author Mustafa Shubbar, 2020
 * @author Melih Eren Arslan, 2020
 * @author Amirmahdi Ghasemi, 2020
 */
class Player {

    Player(String n) {
        name = n;
        playPile = new GroupOfCards();
        wonPile = new GroupOfCards();
    }

    //If the player has no cards at all, an outcome that should
    //not happen if the game is played correctly, the method
    //playCard returns null.
    Card playCard() {
        if (playPile.getSize() == 0) {
            useWonPile();
        }
        if (playPile.getSize() > 0) {
            return playPile.nextCard();
        }
        return null;
    }

    // getName method which returns a String
    String getName() {
        return name;
    }

    // collectCard which collect the cards for the winner
    void collectCard(Card c) {
        wonPile.addCard(c);
    }

    // collectCard which collect the cards for the winner
    void collectCards(GroupOfCards p) {
        wonPile.addCards(p);
    }

    //The useWonPile method initializes the playing pile so that
    //its position variables, front and end, will not exceed its
    //array size, adds the cards from the pile of won cards, and
    //finally initializes (empties) that GroupOfCards.
    void useWonPile() {
        playPile.clear(); // reset front and end to 0
        playPile.addCards(wonPile);
        wonPile.clear(); // reset front and end to 0
    }

    // numCards method add the cards that player has won with the cards player had
    int numCards() {
        return playPile.getSize() + wonPile.getSize();
    }
    private GroupOfCards playPile, wonPile;
    private String name;
}
