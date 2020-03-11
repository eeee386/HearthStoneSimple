package com.heroes;

import com.effect.Effect;
import com.effect.HeroEffect;
import com.effect.InvincibleForNextTurnEffect;
import com.game.GameHandler;

import java.util.ArrayList;

public abstract class Hero {
    private int lifePoints = 30;
    private ArrayList<HeroEffect> effects = new ArrayList<>();
    private boolean canUseAbility = true;
    private final int abilityManaCost = 2;

    public int getAbilityManaCost() {
        return abilityManaCost;
    }

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
        if(lifePoints > 30){
            lifePoints = 30;
        }
    }

    public void useAbility(GameHandler gm){
        System.out.println("canUseAbility: " + canUseAbility);
        if(canUseAbility) {
            abilityHandler(gm);
            canUseAbility = false;
        } else {
            System.out.println("You have used up your ability");
        }
        gm.getActivePlayer().useMana(abilityManaCost);
    }

    public abstract void abilityHandler(GameHandler gm);

    public ArrayList<HeroEffect> getEffects() {
        return effects;
    }

    public void setCanUseAbility(boolean canUseAbility) {
        this.canUseAbility = canUseAbility;
        System.out.println("canUseAbility: "+ canUseAbility);
    }

    public String getDescription(){
        StringBuilder effectsDescription = new StringBuilder();
        for (Effect effect: effects) {
            effectsDescription.append(effect.getDescription());
        }
        return getClass().getSimpleName() + " life: " + lifePoints + effectsDescription;
    }

    public boolean isCanUseAbility() {
        return canUseAbility;
    }
}
