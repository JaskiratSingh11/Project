/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author jksg1
 *  date Nov 13
 */
public abstract class Player {
    private String name;
    protected List<Card> hand;
      private Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void receiveCard(Card card) {
        hand.add(card);
    }

   public Card playCard() {
        displayHand();
        System.out.print("Choose a card to play (1-" + hand.size() + "): ");
        int choice = scanner.nextInt() - 1;
        while (choice < 0 || choice >= hand.size()) {
            System.out.print("Invalid choice. Choose a card to play (1-" + hand.size() + "): ");
            choice = scanner.nextInt() - 1;
        }
        return hand.remove(choice);
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }
    public void displayHand() {
        System.out.println(name + "'s hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + ": " + hand.get(i).toString());
        }
    // Abstract method to be implemented by each specific player type
    } 
    public abstract void play(Game game);
}