package ca.sheridancollege.project;

/**
 * A GroupOfCards object holds an array to contain its cards
 *
 * @author Mustafa Shubbar, 2020
 * @author Melih Eren Arslan, 2020
 * @author Amirmahdi Ghasemi, 2020
 */
public class GroupOfCards {

    /*
 * Defualt constructor
     */
    GroupOfCards() {
        // Variable Fields
        pile = new Card[52];
        front = 0;
        end = 0;
    }
    //  getSize method which returns an int 
    int getSize() {
        return end - front;
    }
    // Clear method
    void clear() {
        front = 0;
        end = 0;
    }
    // add card setter with one argument
    void addCard(Card c) {
        pile[end] = c;
        end++;
    }
   // add card setter with on parameter
    void addCards(GroupOfCards p) {
        while (p.getSize() > 0) {
            addCard(p.nextCard());
        }
    }
    
    Card nextCard() {
        if (front == end) {
            return null;
        }
        Card c = pile[front];
        front++;
        return c;
    }
    private Card[] pile;
    private int front, end;
}
