package com.cards;

import com.effect.SoldierEffect;

import java.util.ArrayList;

/**
 * Class to describe Charge Soldier Cards, They can attack after they are played.
 */
public class ChargeSoldierCard extends SoldierCard {
    public ChargeSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.CHARGE, new ArrayList<>(), attack, maxHealth);
        this.setActive(true);
    }

    public ChargeSoldierCard(int manaCost, String name, int attack, int maxHealth, ArrayList<SoldierEffect> effects) {
        super(manaCost, name, SoldierTypes.CHARGE, new ArrayList<>(), attack, maxHealth, effects);
    }
}
