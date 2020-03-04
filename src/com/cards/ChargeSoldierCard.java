package com.cards;

import java.util.ArrayList;

public class ChargeSoldierCard extends SoldierCard {
    public ChargeSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.CHARGE, new ArrayList<>(), attack, maxHealth);
        this.setActive(true);
    }
}
