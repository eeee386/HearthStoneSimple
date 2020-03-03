package com.cards;

import com.game.GameHandler;

public class ChargeSoldierCard extends SoldierCard {
    public ChargeSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.CHARGE, attack, maxHealth);
    }

    @Override
    public void useAbility(GameHandler gm) {

    }
}
