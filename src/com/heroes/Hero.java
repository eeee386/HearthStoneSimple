package com.heroes;

import com.game.GameHandler;

public abstract class Hero {
    private int lifePoints = 30;


    public boolean isDead() {
        return lifePoints <= 0;
    }

    public void hit(int damage) {
        this.lifePoints = this.lifePoints - damage;
    }

    public void heal(int healValue){
        lifePoints = lifePoints + healValue;
    }

    public abstract void useAbility(GameHandler gm);


}
