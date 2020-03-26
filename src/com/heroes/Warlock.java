package com.heroes;

import com.game.GameHandler;

/**
 * Class to describe the Warlock Hero
 * Hero ability: Draws a card from deck but damages the hero with two lifepoints
 */
public class Warlock extends Hero {
    private final int hitDamage = 2;

    /**
     * Handles the ability (Draw card, but damages the hero with two lifepoints) logic
     * @param gm GameHandler to get the player's character on filed, be it hero or Soldier Card
     */
    public void abilityHandler(GameHandler gm) {
        gm.getActivePlayer().drawCard();
        this.hit(hitDamage);
    }
}
