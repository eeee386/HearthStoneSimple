package com.heroes;

import com.game.GameHandler;

/**
 * Class to describe the Hunter Hero
 * Hero ability: Attack the enemy hero with two attack points.
 */
public class Hunter extends Hero {
    private final int hitDamage = 2;

    /**
     * Handles the ability (attack hero) logic
     * @param gm GameHandler to get the player's character on filed, be it hero or Soldier Card
     */
    public void abilityHandler(GameHandler gm) {
        gm.getEnemyPlayer().getHero().hit(hitDamage);
    }
}
