package com.effect;

/**
 * If this effect is on a Soldier Card and isActive,
 * it will give plus specified amount of attack for every turn that Soldier Card
 */
public class AddPlusAttackForEveryTurnEffect extends TurnBasedEffect {
    private final int attackValue;

    public AddPlusAttackForEveryTurnEffect(int attackValue) {
        super(true, false);
        this.attackValue = attackValue;
    }

    /**
     * Handles logic for adding the specified attack value in every turn
     * @return new attack value times the turn
     */
    public int getAttackValue() {
        return getTurnCounter() * attackValue;
    }

    public String getDescription() {
        return "Adds plus " + attackValue + " attack for every turn";
    }
}
