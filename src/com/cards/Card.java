package com.cards;

import com.cards.cardabilities.CardAbility;
import com.game.GameHandler;

import java.util.ArrayList;

/**
 * The blueprint of all type of cards in this implementation of the game
 */
public abstract class Card {
    private int manaCost;
    private String name;
    private ArrayList<CardAbility> cardAbility;

    public Card(int manaCost, String name, ArrayList<CardAbility> cardAbility) {
        this.manaCost = manaCost;
        this.name = name;
        this.cardAbility = cardAbility;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName(){
        return this.name;
    }

    /**
     * Calls the card's cardAbilitys' handler
     * @param gm
     */
    public void useAbility(GameHandler gm) {
        cardAbility.forEach(ca -> ca.useAbility(gm));
    }

    public ArrayList<CardAbility> getCardAbility() {
        return cardAbility;
    }

    /**
     * Creates an easy to read description for the card
     * @return The description
     */
    public String getFullDescription() {
        StringBuilder description = new StringBuilder();
        for (CardAbility ability:
             cardAbility) {
            description.append(", ").append(ability.getDescription());
        }
        return String.valueOf(description);
    }
}
