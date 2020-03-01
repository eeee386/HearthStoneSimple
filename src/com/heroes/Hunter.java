package com.heroes;

import com.game.GameHandler;

public class Hunter extends Hero {
    private final int hitDamage = 2;

    @Override
    public void useAbility(GameHandler gm) {
        gm.getEnemyPlayer().getHero().hit(2);
    }
}
