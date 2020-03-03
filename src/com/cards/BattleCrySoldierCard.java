package com.cards;

import com.game.GameHandler;

public class BattleCrySoldierCard extends SoldierCard {
    public BattleCrySoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.BATTLECRY, attack, maxHealth);
    }

    @Override
    public void useAbility(GameHandler gm) {

    }
}
