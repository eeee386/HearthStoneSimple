package com.cards.cardabilities;

import com.effect.ChangeHealthEffect;
import com.game.GameHandler;
import com.game.Utils;

/**
 * Add a ChangeHealthEffect with specified health value on a SoldierCard
 */
public class ChangeHealthAbility extends CardAbility {
    private int healthValue;

    public ChangeHealthAbility(int attackValue) {
        this.healthValue = attackValue;
    }

    /**
     * Adds a change health effect on a chosen card
     * @param gm, GameHandler to call the getCardFromTheField with it
     */
    @Override
    public void useAbility(GameHandler gm) {
        Utils.getCardFromTheField(gm, "Which character's health do you want to increase?").addEffect(new ChangeHealthEffect(healthValue));
    }

    @Override
    public String getDescription() {
        return "Changes a chosen soldier's health by " + (healthValue > 0 ? "+" : "") + healthValue;
    }
}
