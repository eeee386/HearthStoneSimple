package com.effect;

public abstract class HeroEffect extends Effect {
    public HeroEffect(boolean isIndefinite, int howManyTurnsIsItStillActive, boolean isStartingEffect, boolean isActivated) {
        super(isIndefinite, howManyTurnsIsItStillActive, isStartingEffect, isActivated);
    }
}
