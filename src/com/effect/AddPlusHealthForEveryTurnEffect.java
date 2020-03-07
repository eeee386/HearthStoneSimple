package com.effect;

public class AddPlusHealthForEveryTurnEffect extends SoldierEffect {
    private final int healthValue;

    public AddPlusHealthForEveryTurnEffect( int healthValue) {
        super(true, 0, true, false);
        this.healthValue = healthValue;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public String getDescription() {
        return "Adds plus " + healthValue + " health for every turn";
    }
}
