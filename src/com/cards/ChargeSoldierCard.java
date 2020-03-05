package com.cards;

import com.cards.cardabilities.CardAbility;
import com.effect.SoldierEffect;

import java.util.ArrayList;

public class ChargeSoldierCard extends SoldierCard {
    public ChargeSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.CHARGE, new ArrayList<>(), attack, maxHealth);
        this.setActive(true);
    }

    public ChargeSoldierCard(int manaCost, String name, int attack, int maxHealth, ArrayList<SoldierEffect> effects) {
        super(manaCost, name, SoldierTypes.CHARGE, new ArrayList<>(), attack, maxHealth, effects);
    }
}
