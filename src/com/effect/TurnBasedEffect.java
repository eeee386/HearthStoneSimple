package com.effect;

public abstract class TurnBasedEffect extends SoldierEffect {
    private int turnCounter = 0;

    public TurnBasedEffect(boolean isStartingEffect, boolean isActivated) {
        super(true, 0, isStartingEffect, isActivated);
    }

    @Override
    public void handleTurn() {
        turnCounter++;
    }

    public int getTurnCounter() {
        return turnCounter;
    }
}
