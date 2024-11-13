/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author jksg1
 */
public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the War game with a title
        WarGame game = new WarGame("War Card Game");

        // Prompt and read the name for Player 1
        System.out.print("Enter the name for Player 1: ");
        String player1Name = scanner.nextLine();
        Player player1 = new Player(player1Name) {
            @Override
            public void play(Game game) {
                if (hasCards()) {
                    System.out.println(getName() + "'s turn. Your hand:");
                    displayHand();
                    System.out.print("Select a card to play (1-" + hand.size() + "): ");
                    int index = scanner.nextInt() - 1;  // Adjust for zero-based index
                    while (index < 0 || index >= hand.size()) {
                        System.out.println("Invalid choice. Please select a number between 1 and " + hand.size() + ".");
                        index = scanner.nextInt() - 1;
                    }
                    Card playedCard = hand.remove(index);
                    System.out.println(getName() + " plays " + playedCard);
                    ((WarGame) game).playCard(this, playedCard);
                }
            }
        };

        // Prompt and read the name for Player 2
        System.out.print("Enter the name for Player 2: ");
        String player2Name = scanner.nextLine();
        Player player2 = new Player(player2Name) {
            @Override
            public void play(Game game) {
                if (hasCards()) {
                    System.out.println(getName() + "'s turn. Your hand:");
                    displayHand();
                    System.out.print("Select a card to play (1-" + hand.size() + "): ");
                    int index = scanner.nextInt() - 1;
                    while (index < 0 || index >= hand.size()) {
                        System.out.println("Invalid choice. Please select a number between 1 and " + hand.size() + ".");
                        index = scanner.nextInt() - 1;
                    }
                    Card playedCard = hand.remove(index);
                    System.out.println(getName() + " plays " + playedCard);
                    ((WarGame) game).playCard(this, playedCard);
                }
            }
        };

        // Add players to the game
        game.addPlayer(player1);
        game.addPlayer(player2);

        // Output initial state
        System.out.println("\nStarting the War Card Game between " + player1.getName() + " and " + player2.getName() + ".");
        
        // Start the game
        game.play();

        // Cleanup resources by closing the scanner
        scanner.close();
    }
}
