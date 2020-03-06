package com.effect;

public class ChangeHealthEffect extends SoldierEffect {
    public int changeHealth;
    public ChangeHealthEffect(int changeHealth) {
        super(true, 0);
        this.changeHealth = changeHealth;
    }

    public String getDescription() {
        return "Health value is changed by " + changeHealth;
    }
}
