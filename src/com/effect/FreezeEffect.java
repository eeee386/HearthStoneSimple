package com.effect;

/**
 * If this effect is on a Soldier Card and isActive a Soldier Card cannot attack even if it is active.
 */
public class FreezeEffect extends SoldierEffect {
    public FreezeEffect(boolean isIndefinite, int howManyTurnsIsItStillActive) {
        super(isIndefinite, howManyTurnsIsItStillActive, false, true);
    }

    public String getDescription() {
        return "Freezed for " + getHowManyTurnsIsItStillActive();
    }
}
