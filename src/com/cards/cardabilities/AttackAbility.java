package com.cards.cardabilities;

import com.game.GameHandler;
import com.game.Utils;

public class AttackAbility extends CardAbility {
    private int attackValue;

    public AttackAbility(int attackValue) {
        this.attackValue = attackValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexOrHeroFromTheField(gm, "Which to character to attack?");
        if(pi.isHero()){
            pi.getPlayer().getHero().hit(attackValue);
        } else {
            pi.getPlayer().getCardsOnField().get(pi.getIndex()).hit(attackValue);
        }
    }

    @Override
    public String getDiscription() {
        return "Damage a chosen Soldier or hero by " + attackValue;
    }
}
