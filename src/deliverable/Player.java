package deliverable;

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

    Card playCard() {
        if (playPile.getSize() == 0) {
            useWonPile();
        }
        if (playPile.getSize() > 0) {
            return playPile.nextCard();
        }
        return null;
    }

    String getName() {
        return name;
    }

    void collectCard(Card c) {
        wonPile.addCard(c);
    }

    void collectCards(GroupOfCards p) {
        wonPile.addCards(p);
    }

    void useWonPile() {
        playPile.clear(); // reset front and end to 0
        playPile.addCards(wonPile);
        wonPile.clear(); // reset front and end to 0
    }

    int numCards() {
        return playPile.getSize() + wonPile.getSize();
    }
    private GroupOfCards playPile, wonPile;
    private String name;
}
