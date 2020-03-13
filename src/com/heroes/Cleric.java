package com.heroes;

import com.game.GameHandler;
import com.game.Utils;

public class Cleric extends Hero {
    private final int healValue = 2;

    public void abilityHandler(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexOrHeroFromTheField(gm, "Which player?");
        if(pi.isHero()){
            pi.getPlayer().getHero().heal(healValue);
        } else {
            pi.getPlayer().getCardsOnField().get(pi.getIndex()).heal(healValue);
        }
    }
}
