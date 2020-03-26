package com.cards.cardabilities;

import com.effect.ChangeAttackEffect;
import com.game.GameHandler;
import com.game.Utils;

/**
 * Add a ChangeAttackEffect with specified attack value on a SoldierCard
 */
public class ChangeAttackAbility extends CardAbility {
    private int attackValue;

    public ChangeAttackAbility(int attackValue) {
        this.attackValue = attackValue;
    }

    /**
     * Adds a change attack effect on a chosen card
     * @param gm, GameHandler to call the getCardFromTheField with it
     */
    @Override
    public void useAbility(GameHandler gm) {
        Utils.getCardFromTheField(gm, "Which character's attack do you want to increase?").addEffect(new ChangeAttackEffect(attackValue));
    }

    @Override
    public String getDescription() {
        return "Changes a chosen soldier's attack by " + (attackValue > 0 ? "+" : "") + attackValue;
    }
}
