package com.effect;

public class FreezeEffect extends SoldierEffect {
    public FreezeEffect(boolean isIndefinite, int howManyTurnsIsItStillActive) {
        super(isIndefinite, howManyTurnsIsItStillActive, false, true);
    }

    public String getDescription() {
        return "Freezed for " + getHowManyTurnsIsItStillActive();
    }
}
