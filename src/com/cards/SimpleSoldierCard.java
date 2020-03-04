package com.cards;

import java.util.ArrayList;

public class SimpleSoldierCard extends SoldierCard {
    public SimpleSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.SIMPLE, new ArrayList<>(), attack, maxHealth);
    }
}
