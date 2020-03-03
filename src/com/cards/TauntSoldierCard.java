package com.cards;

import com.game.GameHandler;

public class TauntSoldierCard extends SoldierCard {
    public TauntSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.TAUNT, attack, maxHealth);
    }

    @Override
    public void useAbility(GameHandler gm) {

    }
}
