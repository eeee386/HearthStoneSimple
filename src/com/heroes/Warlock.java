package com.heroes;

import com.game.GameHandler;

public class Warlock extends Hero {
    private final int hitDamage = 2;
    @Override
    public void useAbility(GameHandler gm) {
        gm.getActivePlayer().drawCard();
        this.hit(hitDamage);
    }
}
