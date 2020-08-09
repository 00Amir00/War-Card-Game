package deliverable;

/**
 *
 * @author Mustafa Shubbar, 2020
 * @author Melih Eren Arslan, 2020
 * @author Amirmahdi Ghasemi, 2020
 */
public class War {

    public static void main(String[] args) {
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
