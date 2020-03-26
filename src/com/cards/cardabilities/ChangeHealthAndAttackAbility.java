package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.ChangeAttackEffect;
import com.effect.ChangeHealthEffect;
import com.game.GameHandler;
import com.game.Utils;

/**
 *  Add a ChangeHealthEffect with specified health value
 *  and a ChangeAttackEffect with specified attack value on a SoldierCard
 */
public class ChangeHealthAndAttackAbility extends CardAbility {
    private int attackValue;
    private int healthValue;

    public ChangeHealthAndAttackAbility(int attackValue, int healthValue) {
        this.attackValue = attackValue;
        this.healthValue = healthValue;
    }
    /**
     * Adds a change health effect and a change attack effect on a chosen card
     * @param gm, GameHandler to call the getCardFromTheField with it
     */
    @Override
    public void useAbility(GameHandler gm) {
        SoldierCard card = Utils.getCardFromTheField(gm,"Which character's attack and health do you want to increase?");
        card.addEffect(new ChangeAttackEffect(attackValue));
        card.addEffect(new ChangeHealthEffect(healthValue));
    }

    @Override
    public String getDescription() {
        return "Changes a soldier's attack by " + (attackValue > 0 ? "+" : "") + attackValue + " and health by "+ (healthValue > 0 ? "+" : "") + healthValue;
    }
}
