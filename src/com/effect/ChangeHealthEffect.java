package com.effect;

/**
 * If this effect is on a Soldier Card and active it will Change the health value of a Soldier Card
 */
public class ChangeHealthEffect extends SoldierEffect {
    private final int changeHealth;

    public ChangeHealthEffect(int changeHealth) {
        super(true, 0, false, true);
        this.changeHealth = changeHealth;
    }

    public int getChangeHealth() {
        return changeHealth;
    }

    public String getDescription() {
        return "Health value is changed by " + changeHealth;
    }
}
