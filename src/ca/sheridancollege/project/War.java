package ca.sheridancollege.project;

/**
 * This class instantiate a Game object, call its play method, and report who
 * won the game.
 *
 * @author Mustafa Shubbar, 2020
 * @author Melih Eren Arslan, 2020
 * @author Amirmahdi Ghasemi, 2020
 */
// Defualt Constructor 
public class War {

    // Main method
    public static void main(String[] args) {
        // Instantiate a Game object
        Game g = new Game();
        g.play();
        Player winner = g.getWinner();
        if (winner == null) {
            System.out.println("Tie game.");
        } else {
            System.out.println("\nWinner = " + winner.getName());
        }
    }
}
