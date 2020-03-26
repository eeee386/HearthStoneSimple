package com.heroes;

import com.game.GameHandler;
import com.game.Utils;

/**
 * Class to describe the Mage Hero
 * Hero ability: Attack any character on field with one attack points.
 */
public class Mage extends Hero {
    private final int hitDamage = 1;

    /**
     * Handles the ability (attack any character) logic
     * @param gm GameHandler to get the player's character on filed, be it hero or Soldier Card
     */
    public void abilityHandler(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexOrHeroFromTheField(gm, "Which player?");
        if(pi.isHero()){
            pi.getPlayer().getHero().hit(hitDamage);
        } else {
            pi.getPlayer().getCardsOnField().get(pi.getIndex()).hit(hitDamage);
        }
    }
}
