package com.heroes;

import com.game.GameHandler;
import com.game.Utils;

/**
 * Class to describe the Cleric Hero
 * Hero ability: Heal any character on field with 2 lifepoints.
 */
public class Cleric extends Hero {
    private final int healValue = 2;

    /**
     * Handles the ability (heal) logic
     * @param gm GameHandler to get the player's character on filed, be it hero or Soldier Card
     */
    public void abilityHandler(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexOrHeroFromTheField(gm, "Which player?");
        if(pi.isHero()){
            pi.getPlayer().getHero().heal(healValue);
        } else {
            pi.getPlayer().getCardsOnField().get(pi.getIndex()).heal(healValue);
        }
    }
}
