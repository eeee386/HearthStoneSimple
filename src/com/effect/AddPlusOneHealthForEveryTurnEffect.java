package com.effect;

public class AddPlusOneHealthForEveryTurnEffect extends SoldierEffect {
    public AddPlusOneHealthForEveryTurnEffect() {
        super(true, 0);
    }

    @Override
    public String toString() {
        return "Adds plus one health for every turn";
    }
}
