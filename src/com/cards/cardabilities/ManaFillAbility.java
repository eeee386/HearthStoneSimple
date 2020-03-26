package com.cards.cardabilities;

import com.game.GameHandler;

/**
 * Fills the active player's mana by specified amount
 */
public class ManaFillAbility extends CardAbility {
    private int manaFillValue;

    public ManaFillAbility(int manaFillValue) {
        this.manaFillValue = manaFillValue;
    }

    /**
     * Fills the active player's mana by specified amount
     * @param gm, GameHandler to find the active player
     */
    @Override
    public void useAbility(GameHandler gm) {
        gm.getActivePlayer().addMana(manaFillValue);
    }

    @Override
    public String getDescription() {
        return "Adds " + manaFillValue + " mana for this turn";
    }
}
