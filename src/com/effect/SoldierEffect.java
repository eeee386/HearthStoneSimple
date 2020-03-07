package com.effect;

public abstract class SoldierEffect extends Effect {
    public SoldierEffect(boolean isIndefinite, int howManyTurnsIsItStillActive, boolean isStartingEffect, boolean isActivated) {
        super(isIndefinite, howManyTurnsIsItStillActive, isStartingEffect, isActivated);
    }
}
