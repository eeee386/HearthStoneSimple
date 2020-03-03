package com.effect;

public abstract class Effect {
    private boolean isIndefinite;
    private int howManyTurnsIsItStillActive;

    public Effect(boolean isIndefinite, int howManyTurnsIsItStillActive) {
        this.isIndefinite = isIndefinite;
        this.howManyTurnsIsItStillActive = howManyTurnsIsItStillActive;
    }

    public boolean isActive() {
        return isIndefinite || howManyTurnsIsItStillActive > 0;
    }
}
