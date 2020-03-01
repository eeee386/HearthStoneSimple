package com.cards;

import com.game.GameHandler;

public class ManaFillCard extends SpellCard {
    private int manaFillValue;

    public ManaFillCard(int manaCost, String name, int manaFillValue) {
        super(manaCost, name, "ManaFill");
        this.manaFillValue = manaFillValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        gm.getActivePlayer().addMana(manaFillValue);
    }
}
