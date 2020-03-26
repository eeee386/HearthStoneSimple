package com.cards.cardabilities;

import com.game.GameHandler;

/**
 * Make a player Draw a specified amount of cards
 */
public class DrawCardAbility extends CardAbility {
    private final int numberOfCards;

    public DrawCardAbility(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    /**
     * If this ability is called the active player draws a specified amount of cards (specified in this.numberOfCards)
     * @param gm, GameHandler to get the player and call its drawCard(int numberOfCards) method
     */
    @Override
    public void useAbility(GameHandler gm) {
        gm.getActivePlayer().drawCard(numberOfCards);
    }

    @Override
    public String getDescription() {
        return "Draw " + numberOfCards + " cards";
    }
}
