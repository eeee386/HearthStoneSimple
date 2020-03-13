package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.FreezeEffect;
import com.game.GameHandler;
import com.game.Utils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ClearBonusesAbility extends CardAbility {
    @Override
    public void useAbility(GameHandler gm) {
        SoldierCard card = Utils.getCardFromTheField(gm, "Which card to take away bonuses from?");
        card.setEffects(new ArrayList<>(card.getEffects().stream().filter(e -> e instanceof FreezeEffect).collect(Collectors.toList())));
    }

    @Override
    public String getDiscription() {
        return "Clears all bonuses on a card.";
    }
}
