package com.effect;

/**
 * Class to describe effects only affecting Hero characters
 */
public abstract class HeroEffect extends Effect {
    public HeroEffect(boolean isIndefinite, int howManyTurnsIsItStillActive, boolean isStartingEffect, boolean isActivated) {
        super(isIndefinite, howManyTurnsIsItStillActive, isStartingEffect, isActivated);
    }
}
