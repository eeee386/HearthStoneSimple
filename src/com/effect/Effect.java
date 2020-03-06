package com.effect;

public abstract class Effect {
    private boolean isIndefinite;
    private int howManyTurnsIsItStillActive;

    public Effect(boolean isIndefinite, int howManyTurnsIsItStillActive) {
        this.isIndefinite = isIndefinite;
        this.howManyTurnsIsItStillActive = 2 * howManyTurnsIsItStillActive;
    }

    public boolean isActive() {
        return isIndefinite || howManyTurnsIsItStillActive > 0;
    }

    public boolean isIndefinite() {
        return isIndefinite;
    }

    public void effectActivityDecrement(){
        if(isActive() && !isIndefinite()) {
            howManyTurnsIsItStillActive--;
        }
    }

    public int getHowManyTurnsIsItStillActive() {
        return howManyTurnsIsItStillActive;
    }

    public abstract String getDescription();
}
