package com.heroes;

import com.game.GameHandler;

public class Hunter extends Hero {
    private final int hitDamage = 2;

    public void abilityHandler(GameHandler gm) {
        gm.getEnemyPlayer().getHero().hit(hitDamage);
    }
}
