package com.cards;

import com.cards.cardabilities.CardAbility;
import com.game.GameHandler;

import java.util.ArrayList;

public abstract class Card {
    private int manaCost;
    private String name;
    private CardTypes type;
    private ArrayList<CardAbility> cardAbility;

    public Card(int manaCost, String name, CardTypes type, ArrayList<CardAbility> cardAbility) {
        this.manaCost = manaCost;
        this.name = name;
        this.type = type;
        this.cardAbility = cardAbility;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName(){
        return this.name;
    }

    public CardTypes getType() {
        return type;
    }

    public void useAbility(GameHandler gm) {
        cardAbility.forEach(ca -> ca.useAbility(gm));
    }
}
