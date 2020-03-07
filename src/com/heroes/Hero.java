package com.heroes;

import com.effect.HeroEffect;
import com.effect.InvincibleForNextTurnEffect;
import com.game.GameHandler;

import java.util.ArrayList;

public abstract class Hero {
    private int lifePoints = 30;
    private ArrayList<HeroEffect> effects = new ArrayList<>();
    private boolean canUseAbility = true;

    public boolean isDead() {
        return lifePoints <= 0;
    }

    public void hit(int damage) {
        if(effects.stream().anyMatch(e -> e instanceof InvincibleForNextTurnEffect)){
            return;
        }
        this.lifePoints = this.lifePoints - damage;
    }

    public void heal(int healValue){
        lifePoints = lifePoints + healValue;
    }

    public void useAbility(GameHandler gm){
        if(canUseAbility) {
            abilityHandler(gm);
            canUseAbility = false;
        } else {
            System.out.println("You have used up your ability");
        }
    }

    public abstract void abilityHandler(GameHandler gm);

    public ArrayList<HeroEffect> getEffects() {
        return effects;
    }

    public void setCanUseAbility(boolean canUseAbility) {
        this.canUseAbility = canUseAbility;
    }
}
