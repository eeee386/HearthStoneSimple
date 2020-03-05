package com.cards;

import com.effect.SoldierEffect;

import java.util.ArrayList;

public class SimpleSoldierCard extends SoldierCard {
    public SimpleSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.SIMPLE, new ArrayList<>(), attack, maxHealth);
    }

    public SimpleSoldierCard(int manaCost, String name, int attack, int maxHealth, ArrayList<SoldierEffect> effects) {
        super(manaCost, name, SoldierTypes.SIMPLE, new ArrayList<>(), attack, maxHealth, effects);
    }
}
