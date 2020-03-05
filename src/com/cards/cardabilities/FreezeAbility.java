package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.FreezeEffect;
import com.game.GameHandler;

public class FreezeAbility extends CardAbility {
    private final int freezedTurn;

    public FreezeAbility(int freezedTurn) {
        this.freezedTurn = freezedTurn;
    }

    @Override
    public void useAbility(GameHandler gm) {
        SoldierCard card = getCardFromTheField(gm, "Which soldier do you want to freeze?");
        card.addEffect(new FreezeEffect(false, freezedTurn));
    }

    @Override
    public String getDiscription() {
        return null;
    }
}
