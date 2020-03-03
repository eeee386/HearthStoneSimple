package com.cards;

import com.cards.cardabilities.CardAbility;
import com.effect.ChangeAttackEffect;
import com.effect.ChangeHealthEffect;
import com.effect.FreezeEffect;
import com.effect.SoldierEffect;

import java.util.ArrayList;

public abstract class SoldierCard extends Card {

    private int health;
    private int attack;
    private int maxHealth;
    private ArrayList<SoldierEffect> effects = new ArrayList<>();

    public SoldierCard(int manaCost, String name, CardTypes type, ArrayList<CardAbility> cardAbility, int health, int attack, int maxHealth) {
        super(manaCost, name, type, cardAbility);
        this.health = health;
        this.attack = attack;
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getActualHealth() {
        return health + getHealthEffectChange();
    }

    public int getActualMaxHealth() {
        return maxHealth + getHealthEffectChange();
    }

    public int getHealthEffectChange() {
        return effects
                .stream()
                .filter(e -> e instanceof ChangeHealthEffect)
                .map(e -> ((ChangeHealthEffect) e).changeHealth)
                .reduce(0, (acc, health) -> acc + health);
    }

    public int getActualAttack() {
        return attack + effects
                .stream()
                .filter(e -> e instanceof ChangeAttackEffect)
                .map(e-> ((ChangeAttackEffect) e).changeAttack)
                .reduce(0, (acc, health) -> acc + health);
    }

    public int getAttack() {
        return attack;
    }

    public void hit(int damage){
        health = health - damage;
    }

    public void heal(int healValue) {
        int actualHealth = getActualHealth();
        int actualMaxHealth = getActualMaxHealth();
        int tempHealth = actualHealth + healValue;
        this.health = tempHealth > actualMaxHealth ? actualMaxHealth: tempHealth;
    }

    public void addEffect(SoldierEffect effect) {
        effects.add(effect);
    }

    public ArrayList<SoldierEffect> getEffects(){
        return effects;
    }

    public void attack(SoldierCard card) {
        if(effects.stream().anyMatch(e -> e instanceof FreezeEffect)){
            return;
        }
        card.hit(getActualAttack());
        this.hit(card.attack);
    }

    public String toString() {
        return getName() + " " + getAttack() + " " + getHealth() + " " + getManaCost() + " " + getType();
    }
}
