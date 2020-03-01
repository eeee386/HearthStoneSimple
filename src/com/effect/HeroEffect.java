package com.effect;

public abstract class HeroEffect extends Effect {
    public HeroEffect(EffectType type, boolean isIndefinite, int howManyTurnsIsItStillActive) {
        super(type, isIndefinite, howManyTurnsIsItStillActive);
    }
}
