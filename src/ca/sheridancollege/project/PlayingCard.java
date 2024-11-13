/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author jksg1
 */
public class PlayingCard extends Card {
    private Suit suit;
    private CardNames cardName;

    public PlayingCard(Suit suit, CardNames cardName){
        this.suit=suit;
        this.cardName=cardName;
    };

  /**
     * Provides a string representation of the playing card.
     * @return A string that represents the card in the format "CardName of Suit".
     */
    @Override
    public String toString() {
        return cardName + " of " + suit;
    }
    
    public int getValue() {
        return cardName.getValue();
    }
}