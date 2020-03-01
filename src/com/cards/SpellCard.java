package com.cards;

public abstract class SpellCard extends Card {

    public SpellCard(int manaCost, String name, String type) {
        super(manaCost, name, type);
    }

    public String toString() {
        return getName() + " " + getManaCost() + " " + getType();
    }
}
