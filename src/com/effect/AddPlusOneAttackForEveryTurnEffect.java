package com.effect;

public class AddPlusOneAttackForEveryTurnEffect extends Effect {
    public AddPlusOneAttackForEveryTurnEffect(boolean isIndefinite, int howManyTurnsIsItStillActive) {
        super(isIndefinite, howManyTurnsIsItStillActive);
    }

    @Override
    public String toString() {
        return "Adds plus one attack for every turn";
    }
}
