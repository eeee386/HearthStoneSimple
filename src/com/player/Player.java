package com.player;

import com.cards.BattleCrySoldierCard;
import com.cards.Card;
import com.cards.CardFactory;
import com.cards.SoldierCard;
import com.effect.Effect;
import com.game.GameHandler;
import com.game.ScannerUtils;
import com.game.Utils;
import com.heroes.Hero;

import java.util.ArrayList;
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

    public void drawCard(){
        cardsInHand.add(cardsInDeck.remove(0));
    }

    public void drawCard(int numberOfCards) {
        cardsInHand.addAll(cardsInDeck.subList(0, numberOfCards));
        cardsInDeck.subList(0, numberOfCards).clear();
    }

    public void playerChooseCard(GameHandler gm) {
        if(!canPlayCard()){
            System.out.println("You don't have enough mana to play any card");
            return;
        }
        System.out.println("Choose a card from your hand (index of card)");
        int index = Utils.getCardIndex(cardsInHand.size());
        playCard(gm, index);
    }

    public boolean canPlayCard() {
        return cardsInHand.size() > 0 && cardsInHand.stream().anyMatch(c -> c.getManaCost() <= actualMana);
    }

    public boolean canAttack() {
        return cardsOnField.stream().anyMatch(SoldierCard::isActive);
    }

    public boolean canUseHeroAbility() {
        return actualMana >= hero.getAbilityManaCost();
    }

    public boolean canPlay() {
        return canPlayCard() || canAttack() || canUseHeroAbility();
    }

    public void playCard(GameHandler gm, int index){
        Card cardInUse = cardsInHand.get(index);
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
            cardsInHand.remove(cardInUse);
            playedCards.add((SoldierCard) cardInUse);
            ((SoldierCard) cardInUse).getEffects().forEach(e-> {
                if(e.isStartingEffect()){
                    e.setActivated(true);
                }
            });
            cardInUse.useAbility(gm);
        } else {
            cardInUse.useAbility(gm);
        }
        useMana(cardInUse.getManaCost());
    }

    public void useHeroAbility(GameHandler gm){
        hero.useAbility(gm);
    }

    public void startTurn(){
        incrementMaxMana();
        setOnTurn(true);
        decrementEffectTurn();
        drawCard();
        hero.setCanUseAbility(true);
    }

    public void endTurn() {
        setOnTurn(false);
        playedCards.clear();
        decrementEffectTurn();
    }

    public void filterDeadSoldiers(){
        cardsOnField = (ArrayList<SoldierCard>) cardsOnField.stream().filter(SoldierCard::isAlive).collect(Collectors.toList());
    }

    public void decrementEffectTurn() {
        cardsOnField.forEach(card -> {
            card.setActive(true);
            card.getEffects().forEach(Effect::effectActivityDecrement);
        });
        hero.getEffects().forEach(Effect::effectActivityDecrement);
    }

    private void incrementMaxMana() {
        maxMana++;
        actualMana = maxMana;
    }

    public void useMana(int manaCost){
        actualMana = actualMana - manaCost;
    }

    public void addMana(int manaValue){
        actualMana = actualMana + manaValue;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardsInDeck);
    }

    public void startGameAsFirstPlayer() {
        this.cardsInHand = new ArrayList<>(this.cardsInDeck.subList(0, 2));
        cardsInDeck.subList(0, 2).clear();
    }

    public void startGameAsSecondPlayer() {
        this.cardsInHand = new ArrayList<>(this.cardsInDeck.subList(0, 3));
        cardsInDeck.subList(0, 3).clear();
    }

    public ArrayList<SoldierCard> getPlayedCards() {
        return playedCards;
    }

    public void prepDeck(){
        cardsInDeck = CardFactory.getFullDeck();
        shuffleDeck();
    }

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

    public void setActualMana(int actualMana) {
        this.actualMana = actualMana;
    }

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
