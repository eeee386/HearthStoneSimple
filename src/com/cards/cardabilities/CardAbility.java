package com.cards.cardabilities;

import com.game.GameHandler;

/**
 * CardAbility adds abilities to Battlecry Soldier Cards (for battlecry) and SpellCards (for spells)
 */
public abstract class CardAbility {
    /**
     * Method to handle abilities, when they are called.
     * @param gm, GameHandler which has the information about the whole game util functions to do utility. Usually an argument of a Utils method.
     */
    public abstract void useAbility(GameHandler gm);

    /**
     * Add a description to describe the what the ability will do, when called.
     * @return The defined description for the child object
     */
    public abstract String getDescription();
}
