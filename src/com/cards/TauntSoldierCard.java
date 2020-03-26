package com.cards;

import com.effect.SoldierEffect;

import java.util.ArrayList;

/**
 * Class to describe Taunt Soldier Card
 * (if they are on a field, they are the only ones,
 * that can be attacked by enemy Soldier Cards)
 */
public class TauntSoldierCard extends SoldierCard {
    public TauntSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.TAUNT, new ArrayList<>(), attack, maxHealth);
    }

    public TauntSoldierCard(int manaCost, String name, int attack, int maxHealth, ArrayList<SoldierEffect> effects) {
        super(manaCost, name, SoldierTypes.TAUNT, new ArrayList<>(), attack, maxHealth, effects);
    }
}
