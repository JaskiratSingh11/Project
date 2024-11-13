/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * A class to model the "War" card game.
 */

/**
 *
 * @author jksg1
 */
public class WarGame extends Game {
    private GroupOfCards deck;
    private Card tempCard1;  // Temporary storage for the first player's card
    private Card tempCard2;  // Temporary storage for the second player's card
    private Player player1, player2;  // To keep track of players

    public WarGame(String name) {
        super(name);
        this.deck = new GroupOfCards();
        initializeDeck();
        shuffleDeck();
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (CardNames name : CardNames.values()) {
                deck.addCard(new PlayingCard(suit, name));
            }
        }
    }

    private void shuffleDeck() {
        deck.shuffle();
    }

    public void dealCards() {
        player1 = getPlayers().get(0);
        player2 = getPlayers().get(1);
        while (deck.getSize() > 0) {
            player1.receiveCard(deck.drawCard());
            if (deck.getSize() > 0) {
                player2.receiveCard(deck.drawCard());
            }
        }
    }

    public void playCard(Player player, Card card) {
        if (tempCard1 == null) {
            tempCard1 = card;
            System.out.println(player.getName() + " has played a card waiting for " + player2.getName() + ".");
        } else {
            tempCard2 = card;
            System.out.println(player.getName() + " plays " + card.toString());
            resolveRound();
        }
    }

    private void resolveRound() {
    if (tempCard1 != null && tempCard2 != null) {
        System.out.println(player1.getName() + " played: " + tempCard1);
        System.out.println(player2.getName() + " played: " + tempCard2);
        
        int comparison = ((PlayingCard) tempCard1).getValue() - ((PlayingCard) tempCard2).getValue();
        if (comparison > 0) {
            System.out.println(player1.getName() + " wins the round.");
            player1.receiveCard(tempCard1);
            player1.receiveCard(tempCard2);
        } else if (comparison < 0) {
            System.out.println(player2.getName() + " wins the round.");
            player2.receiveCard(tempCard1);
            player2.receiveCard(tempCard2);
        } else {
            System.out.println("It's a tie! Each player takes their card back.");
            player1.receiveCard(tempCard1);
            player2.receiveCard(tempCard2);
        }
        // Clear the temporary storage after handling
        tempCard1 = null;
        tempCard2 = null;
    }
}

    @Override
    public void play() {
        dealCards();
        while (player1.hasCards() && player2.hasCards()) {
            player1.play(this);
            if (player2.hasCards()) {  // Ensure player2 still has cards to play
                player2.play(this);
            }
        }
        declareWinner();
    }

    @Override
    public void declareWinner() {
        int player1Cards = player1.hand.size();
        int player2Cards = player2.hand.size();
        if (player1Cards > player2Cards) {
            System.out.println(player1.getName() + " wins the game with " + player1Cards + " cards!");
        } else if (player2Cards > player1Cards) {
            System.out.println(player2.getName() + " wins the game with " + player2Cards + " cards!");
        } else {
            System.out.println("The game is a draw.");
        }
    }
}