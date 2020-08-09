package ca.sheridancollege.project;

/**
 *
 * In this class player will play together till we have a winner
 *
 * @author Mustafa Shubbar, 2020
 * @author Melih Eren Arslan, 2020
 * @author Amirmahdi Ghasemi, 2020
 */
class Game {

    // Play method where players play with each other
    void play() {
        CardDeck cd = new CardDeck();
        cd.shuffle();
        p1 = new Player("Player 1");
        p2 = new Player("Player 2");

        while (cd.getSize() >= 2) {
            p1.collectCard(cd.deal());
            p2.collectCard(cd.deal());
        }
        p1.useWonPile();
        p2.useWonPile();
        GroupOfCards down = new GroupOfCards(); // GroupOfCards for cards in a war
        loop:
        for (int t = 1; t <= 100; t++) {
            if (!enoughCards(1)) {
                break loop;
            }
            Card c1 = p1.playCard();
            Card c2 = p2.playCard();
            System.out.println("\nTurn " + t + ": ");
            System.out.print(p1.getName() + ": " + c1 + " ");
            System.out.print(p2.getName() + ": " + c2 + " ");
            if (c1.compareTo(c2) > 0) {
                p1.collectCard(c1);
                p1.collectCard(c2);
            } else if (c1.compareTo(c2) < 0) {
                p2.collectCard(c1);
                p2.collectCard(c2);
            } else // War
            {
                down.clear();
                down.addCard(c1);
                down.addCard(c2);
                boolean done = false;
                do {
                    int num = c1.getRank();
                    if (!enoughCards(num)) {
                        break loop;
                    }

                    System.out.print("\nWar! Players put down ");
                    System.out.println(num + " card(s).");
                    for (int m = 1; m <= num; m++) {
                        c1 = p1.playCard();
                        c2 = p2.playCard();
                        down.addCard(c1);
                        down.addCard(c2);
                    }
                    System.out.print(p1.getName() + ": " + c1 + " ");
                    System.out.print(p2.getName() + ": " + c2 + " ");
                    if (c1.compareTo(c2) > 0) {
                        p1.collectCards(down);
                        done = true;
                    } else if (c1.compareTo(c2) < 0) {
                        p2.collectCards(down);
                        done = true;
                    }
                } while (!done);
            } // end of for t=1 to 100
            System.out.println(p1.numCards() + " to "
                    + p2.numCards());
        }
    }

    // enoughCards method which return a boolean and takes in an int
    boolean enoughCards(int n) {
        return !(p1.numCards() < n || p2.numCards() < n);
    }

    // getWinner method where the program will determine the winner
    Player getWinner() {
        if (p1.numCards() > p2.numCards()) {
            return p1;
        } else if (p2.numCards() > p1.numCards()) {
            return p2;
        } else {
            return null;
        }
    }
    private Player p1, p2;
}
