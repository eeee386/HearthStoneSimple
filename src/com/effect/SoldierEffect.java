package com.effect;

public abstract class SoldierEffect extends Effect {
    public SoldierEffect(EffectType type, boolean isIndefinite, int howManyTurnsIsItStillActive) {
        super(type, isIndefinite, howManyTurnsIsItStillActive);
    }
}
