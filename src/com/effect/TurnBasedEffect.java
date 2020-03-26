package com.effect;

/**
 * Class to describe Effects that have a turn based change
 */
public abstract class TurnBasedEffect extends SoldierEffect {
    private int halfTurnCounter = 0;

    public TurnBasedEffect(boolean isStartingEffect, boolean isActivated) {
        super(true, 0, isStartingEffect, isActivated);
    }

    @Override
    public void handleTurn() {
        halfTurnCounter++;
    }

    public int getHalfTurnCounter() {
        return halfTurnCounter;
    }

    public int getTurnCounter(){
        return halfTurnCounter/2;
    }
}
