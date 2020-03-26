package com.effect;

/**
 * If this effect is on a Soldier Card and isActive,
 * it will give plus specified amount of health for every turn that Soldier Card
 */
public class AddPlusHealthForEveryTurnEffect extends TurnBasedEffect {
    private final int healthValue;

    public AddPlusHealthForEveryTurnEffect(int healthValue) {
        super( true, false);
        this.healthValue = healthValue;
    }

    /**
     * Handles logic for adding the specified health value in every turn
     * @return new health value times the turn
     */
    public int getHealthValue() {
        return getTurnCounter() * healthValue;
    }

    public String getDescription() {
        return "Adds plus " + healthValue + " health for every turn";
    }


}
