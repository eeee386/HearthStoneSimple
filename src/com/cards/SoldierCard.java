package com.cards;

import com.cards.cardabilities.CardAbility;
import com.effect.*;
import com.heroes.Hero;

import java.util.ArrayList;

/**
 * Class to describe the abstract soldier card
 * Implements all essential functionalities, for a soldier card.
 */
public abstract class SoldierCard extends Card {

    private int health;
    private int attack;
    private int maxHealth;
    private ArrayList<SoldierEffect> effects = new ArrayList<>();
    /**
     * This property describes if the Soldier Card can attack or not.
     */
    private boolean isActive;
    /**
     * Describes the type of soldier
     * @see SoldierTypes
     */
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

    /**
     * Adds all health effect change to the current health
     * @return the health and health effect changes.
     */
    public int getActualHealth() {
        return health + getHealthEffectChange();
    }

    /**
     * Adds all health effect change to the current max health
     * @return the max health puls all health effect changes
     */
    public int getActualMaxHealth() {
        return maxHealth + getHealthEffectChange();
    }

    /**
     * Adds up all the health changes from the Change Health Effects on the card
     * @return All health changes sumed up.
     */
    public int getHealthEffectChange() {
        return effects
                .stream()
                .filter(e -> e instanceof ChangeHealthEffect || e instanceof AddPlusHealthForEveryTurnEffect)
                .map(e -> {
                    if (e instanceof ChangeHealthEffect) {
                        return ((ChangeHealthEffect) e).getChangeHealth();
                    } else {
                        return ((AddPlusHealthForEveryTurnEffect) e).getHealthValue();
                    }
                })
                .reduce(0, (acc, health) -> acc + health);
    }

    /**
     * Adds up all the attack changes from the Change Attack Effects on the card
     * @return All attack changes sumed up.
     */
    public int getActualAttack() {
        return attack + effects
                .stream()
                .filter(e -> e instanceof ChangeAttackEffect || e instanceof AddPlusAttackForEveryTurnEffect)
                .map(e-> {
                    if (e instanceof ChangeAttackEffect) {
                        return ((ChangeAttackEffect) e).getChangeAttack();
                    } else {
                        return ((AddPlusAttackForEveryTurnEffect) e).getAttackValue();
                    }
                })
                .reduce(0, (acc, attack) -> acc + attack);
    }

    public int getAttack() {
        return attack;
    }

    /**
     * Calculates and saves the new current health, after card is attacked, and saves it to current health
     * @param damage, the attack damage
     */
    public void hit(int damage){
        health = health - damage;
    }

    /**
     * Calculates and saves the new current health, after card is healed, and saves it to current health (cannot be more than maxHealth)
     * @param healValue, the amount of heal which will be added to the Soldier Card
     */
    public void heal(int healValue) {
        int actualHealth = getActualHealth();
        int actualMaxHealth = getActualMaxHealth();
        int tempHealth = actualHealth + healValue;
        this.health = tempHealth > actualMaxHealth ? actualMaxHealth: tempHealth;
    }

    /**
     * Adds effect onto a Soldier Card
     * @param effect, the new effect that will  be added to the Soldier Card
     */
    public void addEffect(SoldierEffect effect) {
        effects.add(effect);
    }

    public ArrayList<SoldierEffect> getEffects(){
        return effects;
    }

    public void setEffects(ArrayList<SoldierEffect> effects) {
        this.effects = effects;
    }

    /**
     * Checks if a soldier could attack in this turn or not
     * @return a boolean value true if the soldire could attack false if not.
     */
    public boolean checkIfSoldierCardCouldAttack() {
        if(effects.stream().anyMatch(e -> e instanceof FreezeEffect)){
            System.out.println("This soldier is freezed!");
            return false;
        }
        if(!isActive) {
            System.out.println("This soldier is already spent!");
            return false;
        }
        return true;
    }

    /**
     * Handles attack logic of a Soldier Card, when attacking an other Soldier Card
     * @param card, the card that will be attacked by this card
     */
    public void attack(SoldierCard card) {
        if(checkIfSoldierCardCouldAttack()){
            card.hit(getActualAttack());
            this.hit(card.getActualAttack());
            setActive(false);
        }
    }

    /**
     * Handles attack logic of a Soldier Card, when attackign a Hero character
     * @param hero Hero to attack
     */
    public void attack(Hero hero){
        if(checkIfSoldierCardCouldAttack()){
            hero.hit(getActualAttack());
            setActive(false);
        }

    }

    /**
     * Checks if the soldier is alive or not.
     * @return true if alive, false if not.
     */
    public boolean isAlive() {
        return getActualHealth() > 0;
    }

    /**
     * Writes out if the Soldier card is active or Inactive depending on the valu of this.isActive.
     * @return see the code.
     */
    public String getActiveDescription() {
        return isActive ? "Active" : "Inactive";
    }

    /**
     * Adds an easy to read description to the Soldier Card
     * @return description
     */
    public String toString() {
        StringBuilder allEffects = new StringBuilder();
        for (Effect effect :
                effects) {
            allEffects.append(", ").append(effect.getDescription());
        }
        return getName() + ", attack: " + getActualAttack() + ", health: " + getActualHealth() + ", mana: " + getManaCost() + ", " + getType().toString().toLowerCase() + ", " + getActiveDescription() + " " + getFullDescription() + " " + allEffects + "\n";
    }

    /**
     * Sets the card to its starting position (as it was originally in the deck)
     */
    public void setToStartPosition(){
        effects.stream().filter(Effect::isStartingEffect).forEach(e-> e.setActivated(false));
        if(!(this instanceof ChargeSoldierCard)){
            isActive = false;
        }
        health = maxHealth;
    }
}
