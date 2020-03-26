package com.heroes;

import com.effect.Effect;
import com.effect.HeroEffect;
import com.effect.InvincibleForNextTurnEffect;
import com.game.GameHandler;

import java.util.ArrayList;

/**
 * Class to model the hero behaviour
 */
public abstract class Hero {
    private int lifePoints = 30;
    private ArrayList<HeroEffect> effects = new ArrayList<>();
    private boolean canUseAbility = true;
    private final int abilityManaCost = 2;

    public int getAbilityManaCost() {
        return abilityManaCost;
    }

    /**
     * Checks if hero is dead
     * @return is lifePoints is 0 or lower
     */
    public boolean isDead() {
        return lifePoints <= 0;
    }

    /**
     * Calculates the new current health after an attack
     * @param damage the damage that the hero will suffer
     */
    public void hit(int damage) {
        if(effects.stream().anyMatch(e -> e instanceof InvincibleForNextTurnEffect)){
            return;
        }
        this.lifePoints = this.lifePoints - damage;
    }

    /**
     * Calculates the new current health after a heal
     * @param healValue the heal value
     */
    public void heal(int healValue){
        lifePoints = lifePoints + healValue;
        if(lifePoints > 30){
            lifePoints = 30;
        }
    }

    /**
     * Checks if the hero can use the ability and calls its abilityHandler
     * Handles ability logic
     * @param gm GameHandler to be added to the abilityHandler
     */
    public void useAbility(GameHandler gm){
        if(canUseAbility) {
            abilityHandler(gm);
            canUseAbility = false;
        } else {
            System.out.println("You have used up your ability");
        }
        gm.getActivePlayer().useMana(abilityManaCost);
    }

    /**
     * Implements the unique ability of the hero
     * @param gm, GameHandler to get information about the game
     * @see Cleric
     * @see Hunter
     * @see Paladin
     * @see Mage
     * @see Warlock
     */
    public abstract void abilityHandler(GameHandler gm);

    public ArrayList<HeroEffect> getEffects() {
        return effects;
    }

    public void setEffects(ArrayList<HeroEffect> effects) {
        this.effects = effects;
    }

    public void setCanUseAbility(boolean canUseAbility) {
        this.canUseAbility = canUseAbility;
    }

    public String getDescription(){
        StringBuilder effectsDescription = new StringBuilder();
        for (Effect effect: effects) {
            effectsDescription.append(effect.getDescription());
        }
        return getClass().getSimpleName() + " life: " + lifePoints + " " + effectsDescription;
    }

    public boolean isCanUseAbility() {
        return canUseAbility;
    }
}
