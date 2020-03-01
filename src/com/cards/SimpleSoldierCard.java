package com.cards;

import com.game.GameHandler;

public class SimpleSoldierCard extends SoldierCard {

    public SimpleSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, "Simple", attack, maxHealth);
    }

    @Override
    public void useAbility(GameHandler gm) {

    }
}
