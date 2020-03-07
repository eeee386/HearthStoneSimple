package com.cards;

import com.cards.cardabilities.CardAbility;
import com.effect.*;

import java.util.ArrayList;

public abstract class SoldierCard extends Card {

    private int health;
    private int attack;
    private int maxHealth;
    private ArrayList<SoldierEffect> effects = new ArrayList<>();
    private boolean isActive;
    private SoldierTypes type;

    public SoldierCard(int manaCost, String name, SoldierTypes type, ArrayList<CardAbility> cardAbility, int attack, int maxHealth) {
        super(manaCost, name, cardAbility);
        this.health = maxHealth;
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.isActive = false;
        this.type = type;
    }

    public SoldierCard(int manaCost, String name, SoldierTypes type, ArrayList<CardAbility> cardAbility, int attack, int maxHealth, ArrayList<SoldierEffect> effects) {
        super(manaCost, name, cardAbility);
        this.health = maxHealth;
        this.attack = attack;
        this.maxHealth = maxHealth;
        this.effects = effects;
        this.type = type;
    }

    public CardTypes getType() {
        return type;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
                .map(e -> ((ChangeHealthEffect) e).getChangeHealth())
                .reduce(0, (acc, health) -> acc + health);
    }

    public int getActualAttack() {
        return attack + effects
                .stream()
                .filter(e -> e instanceof ChangeAttackEffect)
                .map(e-> ((ChangeAttackEffect) e).getChangeAttack())
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

    public void setEffects(ArrayList<SoldierEffect> effects) {
        this.effects = effects;
    }

    public void attack(SoldierCard card) {
        if(effects.stream().anyMatch(e -> e instanceof FreezeEffect)){
            System.out.println("This soldier is freezed!");
            return;
        }
        if(!isActive) {
            System.out.println("This soldier is already spent!");
        }
        card.hit(getActualAttack());
        this.hit(card.attack);
    }

    public boolean isDead() {
        return getActualHealth() <= 0;
    }

    public String getActiveDescription() {
        return isActive ? "Active" : "Inactive";
    }

    public String toString() {
        StringBuilder allEffects = new StringBuilder();
        for (Effect effect :
                effects) {
            allEffects.append(effect.getDescription());
        }
        return getName() + ", attack: " + getAttack() + ", health: " + getHealth() + ", mana: " + getManaCost() + " " + getType().toString().toLowerCase() + " " + getActiveDescription() + " " + getFullDescription() + " " + allEffects + "\n";
    }
}
