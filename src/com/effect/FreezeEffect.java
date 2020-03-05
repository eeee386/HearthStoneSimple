package com.effect;

public class FreezeEffect extends SoldierEffect {
    public FreezeEffect(boolean isIndefinite, int howManyTurnsIsItStillActive) {
        super(isIndefinite, howManyTurnsIsItStillActive);
    }

    @Override
    public String toString() {
        return "Freezed for " + getHowManyTurnsIsItStillActive();
    }
}
