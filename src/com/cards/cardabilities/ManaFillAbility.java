package com.cards.cardabilities;

import com.game.GameHandler;

public class ManaFillAbility extends CardAbility {
    private int manaFillValue;

    public ManaFillAbility(int manaFillValue) {
        this.manaFillValue = manaFillValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        gm.getActivePlayer().addMana(manaFillValue);
    }

    @Override
    public String getDiscription() {
        return null;
    }
}
