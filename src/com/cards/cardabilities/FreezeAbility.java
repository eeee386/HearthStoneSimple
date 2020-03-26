package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.FreezeEffect;
import com.game.GameHandler;
import com.game.Utils;

/**
 * Add a freeze effect on a Soldier card for a specified amount of turn
 */
public class FreezeAbility extends CardAbility {
    private final int freezedTurn;

    public FreezeAbility(int freezedTurn) {
        this.freezedTurn = freezedTurn;
    }

    /**
     * Add a freeze effect on a soldier, for a specified amount of turns (this.freezedTurn specifies this value)
     * @param gm, GameHandler to get a the card we want to add a Freeze effect on it.
     */
    @Override
    public void useAbility(GameHandler gm) {
        SoldierCard card = Utils.getCardFromTheField(gm, "Which soldier do you want to freeze?");
        card.addEffect(new FreezeEffect(false, freezedTurn));
    }

    @Override
    public String getDescription() {
        return "Freeze an enemy for " + freezedTurn + " turn(s)";
    }
}
