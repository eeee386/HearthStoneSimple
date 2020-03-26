package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.FreezeEffect;
import com.game.GameHandler;
import com.game.Utils;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Clear all beneficial effects from a card
 */
public class ClearBonusesAbility extends CardAbility {
    /**
     * Find and take down all effects from card which has a benefit
     * @param gm, GameHandler to call the getCardFromTheField with it
     */
    @Override
    public void useAbility(GameHandler gm) {
        SoldierCard card = Utils.getCardFromTheField(gm, "Which card to take away bonuses from?");
        card.setEffects(new ArrayList<>(card.getEffects().stream().filter(e -> e instanceof FreezeEffect).collect(Collectors.toList())));
    }

    @Override
    public String getDescription() {
        return "Clears all bonuses on a card.";
    }
}
