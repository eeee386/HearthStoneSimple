package com.effect;

public class AddPlusHealthForEveryTurnEffect extends TurnBasedEffect {
    private final int healthValue;

    public AddPlusHealthForEveryTurnEffect(int healthValue) {
        super( true, false);
        this.healthValue = healthValue;
    }

    public int getHealthValue() {
        return getTurnCounter()/2 * healthValue;
    }

    public String getDescription() {
        return "Adds plus " + healthValue + " health for every turn";
    }


}
