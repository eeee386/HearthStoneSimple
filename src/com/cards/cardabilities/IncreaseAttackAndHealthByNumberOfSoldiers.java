package com.cards.cardabilities;

import com.game.GameHandler;

public class IncreaseAttackAndHealthByNumberOfSoldiers extends CardAbility {
    @Override
    public void useAbility(GameHandler gm) {
        int numberOfSoldiers = gm.getActivePlayer().getCardsOnField().size();

    }
}
