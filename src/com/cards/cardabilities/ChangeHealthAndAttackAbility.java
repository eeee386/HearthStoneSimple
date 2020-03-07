package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.ChangeAttackEffect;
import com.effect.ChangeHealthEffect;
import com.game.GameHandler;

public class ChangeHealthAndAttackAbility extends CardAbility {
    private int attackValue;
    private int healthValue;

    public ChangeHealthAndAttackAbility(int attackValue, int healthValue) {
        this.attackValue = attackValue;
        this.healthValue = healthValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        SoldierCard card = getCardFromTheField(gm,"Which character's attack and health do you want to increase?");
        card.addEffect(new ChangeAttackEffect(attackValue));
        card.addEffect(new ChangeHealthEffect(healthValue));
    }

    @Override
    public String getDiscription() {
        return "Changes a soldier's attack by " + (attackValue > 0 ? "+" : "") + attackValue + " and health by "+ (healthValue > 0 ? "+" : "") + healthValue;
    }
}
