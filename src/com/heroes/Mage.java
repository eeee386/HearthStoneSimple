package com.heroes;

import com.game.GameHandler;
import com.game.Utils;

public class Mage extends Hero {
    private final int hitDamage = 2;

    public void abilityHandler(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexOrHeroFromTheField(gm, "Which player?");
        if(pi.isHero()){
            pi.getPlayer().getHero().hit(hitDamage);
        } else {
            pi.getPlayer().getCardsOnField().get(pi.getIndex()).hit(hitDamage);
        }
    }
}
