package com.player;

import com.cards.*;
import com.cards.cardabilities.CardAbility;
import com.cards.cardabilities.FreezeAbility;
import com.cards.cardabilities.ManaFillAbility;
import com.effect.Effect;
import com.effect.FreezeEffect;
import com.game.GameHandler;
import com.game.ScannerUtils;
import com.game.Utils;
import com.heroes.Hero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Player {
    private boolean isOnTurn;
    private ArrayList<Card> cardsInHand = new ArrayList<>();
    private ArrayList<SoldierCard> cardsOnField = new ArrayList<>();
    private ArrayList<Card> cardsInDeck = new ArrayList<>();
    private ArrayList<SoldierCard> playedCards = new ArrayList<>();
    private Hero hero;
    private String name;

    public Player(String name, Hero hero){
        this.hero = hero;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int maxMana = 0;
    private int actualMana = 0;

    public boolean isOnTurn() {
        return isOnTurn;
    }

    private void setOnTurn(boolean onTurn) {
        isOnTurn = onTurn;
    }

    public ArrayList<Card> getCardsInHand() {
        return cardsInHand;
    }

    public ArrayList<SoldierCard> getCardsOnField() {
        return cardsOnField;
    }

    public ArrayList<Card> getCardsInDeck() {
        return cardsInDeck;
    }

    public Hero getHero() {
        return hero;
    }

    public boolean isGameOver(){
        return hero.isDead();
    }

    /**
     * Handles drawing card logic (drawing only one card)
     */
    public void drawCard(){
        cardsInHand.add(cardsInDeck.remove(0));
    }

    /**
     * Handles drawing card logic (drawing a specified amount of cards)
     * @param numberOfCards number of cards that will be drawn
     */
    public void drawCard(int numberOfCards) {
        cardsInHand.addAll(cardsInDeck.subList(0, numberOfCards));
        cardsInDeck.subList(0, numberOfCards).clear();
    }

    /**
     * Method to decide if the player can play a card
     * @return if the player can play card or not
     */
    public boolean canPlayCard() {
        return cardsInHand.size() > 0 && cardsInHand.stream().anyMatch(c -> c.getManaCost() <= actualMana);
    }

    /**
     * Method to decide if the player can attack
     * @return if the player can attack or not
     */
    public boolean canAttack() {
        return cardsOnField.stream().anyMatch(c -> {
            return c.getEffects().stream().noneMatch(e -> e instanceof FreezeEffect) && c.isActive();
        });
    }

    /**
     * Method to decide if the player can use hero ability or not
     * @return if the player can use hero ability or not
     */
    public boolean canUseHeroAbility() {
        return actualMana >= hero.getAbilityManaCost() && hero.isCanUseAbility();
    }

    /**
     * Method to decide if the player can play an action or not, used for ending a turn
     * @return if the player can use hero ability or not
     */
    public boolean canPlay() {
        return canPlayCard() || canAttack() || canUseHeroAbility();
    }

    /**
     * Play card (put card from hand to field, and activate its starting effects)
     * @param gm GameHandler for getting the card to play,
     *          and checking if the card can be played,
     *           and help use its ability if it has one
     * @param index the index of the card in hand
     */
    public void playCard(GameHandler gm, int index){
        if(cardsInHand.size() <= index){
            System.out.println("This is not a valid index");
        }
        Card cardInUse = cardsInHand.get(index);
        System.out.println(cardInUse.getName());
        if(cardInUse.getManaCost() > actualMana){
            System.out.println("You don't have enough mana to play this card");
            return;
        }
        if(cardInUse instanceof SoldierCard) {
            if(cardsOnField.size() == 5){
                System.out.println("You cannot put down more card on the field.");
                return;
            }
            if(cardInUse instanceof BattleCrySoldierCard) {
                cardInUse.useAbility(gm);
            }
            int indexOnField = getCardInHandIndex();
            cardsOnField.add(indexOnField, (SoldierCard) cardInUse);
            playedCards.add((SoldierCard) cardInUse);
            ((SoldierCard) cardInUse).getEffects().forEach(e-> {
                if(e.isStartingEffect()){
                    e.setActivated(true);
                }
            });
        } else {
            cardInUse.useAbility(gm);
        }
        cardsInHand.remove(cardInUse);
        useMana(cardInUse.getManaCost());
    }

    public void useHeroAbility(GameHandler gm){
        if(hero.getAbilityManaCost() <= actualMana) {
            hero.useAbility(gm);
        } else {
            System.out.println("You don't have enough mana!");
        }
    }

    /**
     * Handler for starting a turn
     */
    public void startTurn(){
        incrementMaxMana();
        setOnTurn(true);
        decrementEffectTurn();
        drawCard();
        hero.setCanUseAbility(true);
    }

    /**
     * Handler for ending a turn
     */
    public void endTurn() {
        setOnTurn(false);
        playedCards.clear();
        decrementEffectTurn();
    }

    /**
     * Filters out soldiers whose lifepoints are less than or equal zero
     */
    public void filterDeadSoldiers(){
        cardsOnField = (ArrayList<SoldierCard>) cardsOnField.stream().filter(SoldierCard::isAlive).collect(Collectors.toList());
    }

    /**
     * Calls all the active effects' handleTurn function
     */
    public void decrementEffectTurn() {
        cardsOnField.forEach(card -> {
            card.setActive(true);
            card.getEffects().forEach(Effect::handleTurn);
            card.setEffects(new ArrayList<>(card.getEffects().stream().filter(Effect::isActive).collect(Collectors.toList())));
        });
        hero.getEffects().forEach(Effect::handleTurn);
        hero.setEffects(new ArrayList<>(hero.getEffects().stream().filter(Effect::isActive).collect(Collectors.toList())));

    }

    /**
     * Logic for handling maxMana incrementing for every turn
     */
    private void incrementMaxMana() {
        if(maxMana < 10){
            maxMana++;
        }
        actualMana = maxMana;
    }

    /**
     * Calculates actual mana after using a card or hero ability
     * @param manaCost of played card and used hero ability
     */
    public void useMana(int manaCost){
        actualMana = actualMana - manaCost;
    }

    /**
     * Calculates actual mana after mana is added (from Spell card or Battlecry soldier)
     * @param manaValue the mana value that will be added to the actual mana
     */
    public void addMana(int manaValue){
        actualMana = actualMana + manaValue;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardsInDeck);
    }

    /**
     * Handles logic when player starts as the first player
     */
    public void startGameAsFirstPlayer() {
        this.cardsInHand = new ArrayList<>(this.cardsInDeck.subList(0, 2));
        cardsInDeck.subList(0, 2).clear();
    }

    /**
     * Handles logic when player starts as the second player
     */
    public void startGameAsSecondPlayer() {
        this.cardsInHand = new ArrayList<>(this.cardsInDeck.subList(0, 3));
        cardsInDeck.subList(0, 3).clear();
        ArrayList<CardAbility> manafillAbility = new ArrayList<>();
        manafillAbility.add(new ManaFillAbility(1));
        this.cardsInHand.add(new SpellCard(0, "Coin", manafillAbility));

    }

    public ArrayList<SoldierCard> getPlayedCards() {
        return playedCards;
    }

    /**
     * Preps deck for playing
     * @see CardFactory for more information
     */
    public void prepDeck(){
        cardsInDeck = CardFactory.getFullDeck();
        shuffleDeck();
    }

    /**
     * Utility for write out cards on field to System.out
     */
    public void writeOutCardsOnField(){
        System.out.println("Cards on field");
        StringBuilder cardDescription = new StringBuilder();
        int index = 0;
        for (Card card: cardsOnField) {
            cardDescription.append(index).append(". ").append(card.toString());
            index++;
        }
        System.out.println(cardDescription);
    }

    /**
     * Utility for writing out cards in hand
     */
    public void writeOutCardsInHand() {
        System.out.println("Cards in hand");
        StringBuilder cardDescription = new StringBuilder();
        int index = 0;
        for (Card card: cardsInHand) {
            cardDescription.append(index).append(". ").append(card.toString());
            index++;
        }
        System.out.println(cardDescription);
    }

    /**
     * Utility for writing out hero
     */
    public void writeOutHero() {
        System.out.println(hero.getDescription());
    }

    public boolean isAnyCardOnField() {
        return cardsOnField.size() > 0;
    }

    public boolean isAnyCardInHand() {
        return cardsInHand.size() > 0;
    }

    public int getActualMana() {
        return actualMana;
    }

    /**
     * Get a valid card in hand index (usually for playing a card)
     * @return the valid index in the list of cards in hand
     */
    private int getCardInHandIndex() {
        int indexOnField = 0;
        if(cardsOnField.size() > 0) {
            do {
                System.out.println("Where to (between 0 and " + cardsOnField.size() + "): ");
                indexOnField = ScannerUtils.readInt();
            } while(indexOnField > cardsOnField.size());
        }
        return indexOnField;
    }
}
