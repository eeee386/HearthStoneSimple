package com.effect;

public abstract class Effect {
    private boolean isIndefinite;
    private int howManyTurnsIsItStillActive;
    private boolean isActivated;
    private boolean isStartingEffect;

    public Effect(boolean isIndefinite, int howManyTurnsIsItStillActive, boolean isStartingEffect, boolean isActivated) {
        this.isIndefinite = isIndefinite;
        this.howManyTurnsIsItStillActive = 2 * howManyTurnsIsItStillActive;
        this.isStartingEffect = isStartingEffect;
    }

    public boolean isActive() {
        return isIndefinite || howManyTurnsIsItStillActive > 0;
    }

    public boolean isIndefinite() {
        return isIndefinite;
    }

    public void handleTurn(){
        if(isActive() && !isIndefinite() && isActivated) {
            howManyTurnsIsItStillActive--;
        }
    }

    public int getHowManyTurnsIsItStillActive() {
        return howManyTurnsIsItStillActive;
    }

    public abstract String getDescription();

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean isStartingEffect() {
        return isStartingEffect;
    }
}
