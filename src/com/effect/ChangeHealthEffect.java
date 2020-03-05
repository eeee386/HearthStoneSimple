package com.effect;

public class ChangeHealthEffect extends SoldierEffect {
    public int changeHealth;
    public ChangeHealthEffect(int changeHealth) {
        super(true, 0);
        this.changeHealth = changeHealth;
    }

    @Override
    public String toString() {
        return "Health value is changed by " + changeHealth;
    }
}
