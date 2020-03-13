package com.cards.cardabilities;

import com.game.GameHandler;

public class DrawCardAbility extends CardAbility {
    private final int numberOfCards;

    public DrawCardAbility(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    @Override
    public void useAbility(GameHandler gm) {
        gm.getActivePlayer().drawCard(numberOfCards);
    }

    @Override
    public String getDiscription() {
        return "Draw " + numberOfCards + " cards";
    }
}
