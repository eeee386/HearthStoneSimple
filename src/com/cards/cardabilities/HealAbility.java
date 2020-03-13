package com.cards.cardabilities;

import com.game.GameHandler;
import com.game.Utils;

public class HealAbility extends CardAbility {
    private final int healValue;

    public HealAbility(int healValue) {
        this.healValue = healValue;
    }

    //TODO: this needs fixing
    @Override
    public void useAbility(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexOrHeroFromTheField(gm, "Which character to heal");
        if(pi.isHero()){
            pi.getPlayer().getHero().heal(healValue);
        } else {
            pi.getPlayer().getCardsOnField().get(pi.getIndex()).heal(healValue);
        }
    }

    @Override
    public String getDiscription() {
        return "Heal a chosen Soldier or hero by " + healValue;
    }
}
