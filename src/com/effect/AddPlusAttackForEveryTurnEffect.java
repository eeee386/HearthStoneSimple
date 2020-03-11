package com.effect;

public class AddPlusAttackForEveryTurnEffect extends TurnBasedEffect {
    private final int attackValue;

    public AddPlusAttackForEveryTurnEffect(int attackValue) {
        super(true, false);
        this.attackValue = attackValue;
    }

    public int getAttackValue() {
        return getTurnCounter()/2 * attackValue;
    }

    public String getDescription() {
        return "Adds plus " + attackValue + " attack for every turn";
    }
}
