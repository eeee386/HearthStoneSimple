package com.effect;

/**
 * Class to describe effects only affecting Soldier Cards
 */
public abstract class SoldierEffect extends Effect {
    public SoldierEffect(boolean isIndefinite, int howManyTurnsIsItStillActive, boolean isStartingEffect, boolean isActivated) {
        super(isIndefinite, howManyTurnsIsItStillActive, isStartingEffect, isActivated);
    }
}
