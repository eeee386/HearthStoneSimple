package com.effect;

public class AddPlusAttackForEveryTurnEffect extends SoldierEffect {
    private final int attackValue;
    public AddPlusAttackForEveryTurnEffect(int attackValue) {
        super(true, 0);
        this.attackValue = attackValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public String getDescription() {
        return "Adds plus " + attackValue + " attack for every turn";
    }
}
