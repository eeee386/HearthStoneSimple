package com.effect;

/**
 * Descriptor for all buffs, debuff and other changes a Soldier Card or Hero has.
 */
public abstract class Effect {
    /**
     * This flag shows if the effect has a time it is effecting the card or not.
     * (if indefinite it can only be taken down with a specific ability)
     */
    private boolean isIndefinite;
    private int howManyHalfTurnsIsItStillActive;
    /**
     * Is this activated or not
     * @see AddPlusHealthForEveryTurnEffect
     * @see AddPlusHealthForEveryTurnEffect
     * That is already on the Soldier Card but only gets activated when the card plays.
     */
    private boolean isActivated;

    /**
     * Shows the effect is activated on start or added externally
     *
     * @see AddPlusHealthForEveryTurnEffect
     * @see AddPlusAttackForEveryTurnEffect
     * for Starting effect
     *
     * @see FreezeEffect
     * for non Starting effect
     */
    private boolean isStartingEffect;

    public Effect(boolean isIndefinite, int howManyTurnsIsItStillActive, boolean isStartingEffect, boolean isActivated) {
        this.isIndefinite = isIndefinite;
        this.howManyHalfTurnsIsItStillActive = 2 * howManyTurnsIsItStillActive;
        this.isStartingEffect = isStartingEffect;
        this.isActivated = isActivated;
    }

    /**
     * Checks if the effect is still is still active
     * @return
     */
    public boolean isActive() {
        return isIndefinite || howManyHalfTurnsIsItStillActive > 0;
    }

    public boolean isIndefinite() {
        return isIndefinite;
    }

    /**
     * Handles turn change in the Effect
     */
    public void handleTurn(){
        if(isActive() && !isIndefinite() && isActivated) {
            howManyHalfTurnsIsItStillActive--;
        }
    }

    public int getHowManyHalfTurnsIsItStillActive() {
        return howManyHalfTurnsIsItStillActive;
    }

    public int getHowManyTurnsIsItStillActive() {
        return howManyHalfTurnsIsItStillActive / 2;
    }

    public abstract String getDescription();

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean isStartingEffect() {
        return isStartingEffect;
    }
}
