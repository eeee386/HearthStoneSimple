package com.cards;

import java.util.ArrayList;

public abstract class SoldierCard extends Card {

    private int health;
    private int attack;
    private int maxHealth;
    //private ArrayList<SoldierEffect> effect;

    public SoldierCard(int manaCost, String name, String type, int attack, int maxHealth) {
        super(manaCost, name, type);
        this.health = maxHealth;
        this.attack = attack;
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void hit(int damage){
        health = health - damage;
    }

    public void heal(int healValue) {
        int tempHealth = this.health + healValue;
        this.health = tempHealth > maxHealth ? maxHealth: tempHealth;
    }

    public void increaseHealth(int plusHealth) {
        this.health = this.health + plusHealth;
        this.maxHealth = this.maxHealth + plusHealth;
    }

    public void increaseAttack(int plusAttackValue) {
        this.attack = this.attack + plusAttackValue;
    }

    public void attack(SoldierCard card) {
        card.hit(attack);
        this.hit(card.attack);
    }

    public String toString() {
        return getName() + " " + getAttack() + " " + getHealth() + " " + getManaCost() + " " + getType();
    }
}
