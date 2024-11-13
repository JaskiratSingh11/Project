/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author jksg1
 * @author jksg1 nov 13
 */
public class GroupOfCards {
    private ArrayList<Card> cards;
    private int size; // the size of the grouping, flexible for initialization

    /**
     * Constructs a group of cards with an optional size limit.
     * @param size the maximum size of the group or initial capacity
     */
    public GroupOfCards(int size) {
        this.size = size;
        this.cards = new ArrayList<>(size);
    }

    /**
     * Constructs a group of cards without an explicit size limit.
     */
    public GroupOfCards() {
        this.cards = new ArrayList<>();
    }

    /**
     * Adds a card to the group.
     * @param card the card to add to the group
     */
    public void addCard(Card card) {
        if (cards.size() < size || size == 0) { // size 0 indicates no limit
            cards.add(card);
        }
    }

    /**
     * Shuffles the cards within the group.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Draws the top card from the group, removing it from the group.
     * @return the drawn card, or null if the group is empty
     */
    public Card drawCard() {
        return cards.isEmpty() ? null : cards.remove(0);
    }

    /**
     * Gets the current size of the group.
     * @return the number of cards currently in the group
     */
    public int getSize() {
        return cards.size();
    }

    /**
     * Sets the maximum size of the group. Size 0 indicates no limit.
     * @param size the new maximum size of the group
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets all the cards currently in the group.
     * @return a copy of the cards list
     */
    public ArrayList<Card> getCards() {
        return new ArrayList<>(cards);
    }
}