package com.cards;

import com.cards.cardabilities.CardAbility;
import com.game.GameHandler;

import java.util.ArrayList;

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

    public void useAbility(GameHandler gm) {
        cardAbility.forEach(ca -> ca.useAbility(gm));
    }

    public ArrayList<CardAbility> getCardAbility() {
        return cardAbility;
    }

    public String getFullDescription() {
        StringBuilder description = new StringBuilder();
        for (CardAbility ability:
             cardAbility) {
            description.append(", ").append(ability.getDiscription());
        }
        return String.valueOf(description);
    }
}
