package com.cards;

import com.game.GameHandler;

public abstract class Card {
    private int manaCost;
    private String name;
    private String type;

    public Card(int manaCost, String name, String type) {
        this.manaCost = manaCost;
        this.name = name;
        this.type = type;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName(){
        return this.name;
    }

    public String getType() {
        return type;
    }

    public abstract void useAbility(GameHandler gm);
}
