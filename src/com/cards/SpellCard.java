package com.cards;

import com.cards.cardabilities.CardAbility;

import java.util.ArrayList;

public class SpellCard extends Card {

    public SpellCard(int manaCost, String name, ArrayList<CardAbility> cardAbility) {
        super(manaCost, name, cardAbility);
    }

    public String toString() {
        return getName() + ", mana: " + getManaCost() + " " + getFullDescription() + "\n";
    }
}
