package com.effect;

public abstract class Effect {
    private EffectType type;
    private boolean isIndefinite;
    private int howManyTurnsIsItStillActive;

    public Effect(EffectType type, boolean isIndefinite, int howManyTurnsIsItStillActive) {
        this.type = type;
        this.isIndefinite = isIndefinite;
        this.howManyTurnsIsItStillActive = howManyTurnsIsItStillActive;
    }

    public EffectType getType() {
        return type;
    }

    public boolean isActive() {
        return isIndefinite || howManyTurnsIsItStillActive > 0;
    }
}
