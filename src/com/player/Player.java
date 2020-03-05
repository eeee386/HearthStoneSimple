package com.player;

import com.cards.BattleCrySoldierCard;
import com.cards.Card;
import com.cards.SoldierCard;
import com.effect.Effect;
import com.effect.HeroEffect;
import com.game.GameHandler;
import com.heroes.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
    private boolean isOnTurn;
    private ArrayList<Card> cardsInHand = new ArrayList<>();
    private ArrayList<SoldierCard> cardsOnField = new ArrayList<>();
    private ArrayList<Card> cardsInDeck = new ArrayList<>();
    private ArrayList<SoldierCard> playedCards = new ArrayList<>();
    private Hero hero;

    public Player(Hero hero){
        this.hero = hero;
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

    public void playCard(GameHandler gm, int index){
        Card cardInUse = cardsInHand.get(index);
        if(cardInUse instanceof SoldierCard) {
            if(cardsOnField.size() == 5){
                System.out.println("You cannot put down more card on the field.");
                return;
            }
            if(cardInUse instanceof BattleCrySoldierCard) {
                cardInUse.useAbility(gm);
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Where to: ");

            int indexOnField = Integer.parseInt(scanner.nextLine());
            cardsOnField.add(indexOnField, (SoldierCard) cardInUse);
            playedCards.add((SoldierCard) cardInUse);
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

    }

    public void endTurn() {
        setOnTurn(false);
        playedCards.clear();
        decrementEffectTurn();
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
        this.cardsInHand = new ArrayList<>(this.cardsInDeck.subList(0, 3));
    }

    public void startGameAsSecondPlayer() {
        this.cardsInHand = new ArrayList<>(this.cardsInDeck.subList(0, 4));
    }

    public ArrayList<SoldierCard> getPlayedCards() {
        return playedCards;
    }
}
