package com.game;

import com.cards.SoldierCard;
import com.cards.TauntSoldierCard;
import com.heroes.*;
import com.player.Player;

import static com.heroes.HeroTypes.valueOf;

public class GameHandler {
    private Player playerOne;
    private Player playerTwo;
    private Player activePlayer;
    private Player enemyPlayer;

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getActivePlayer() {
        return this.activePlayer;
    }

    public Player getEnemyPlayer() {
        return enemyPlayer;
    }

    public void activePlayerUseHeroAbility() {
        this.activePlayer.useHeroAbility(this);
    }

    private Player playerFactory(HeroTypes answer, String name) {
        switch (answer) {
            case CLERIC:
                return new Player(name, new Cleric());
            case MAGE:
                return new Player(name, new Mage());
            case PALADIN:
                return new Player(name, new Paladin());
            case WARLOCK:
                return new Player(name, new Warlock());
            case HUNTER:
                return new Player(name, new Hunter());
            default:
                return null;
        }
    }

    public void startNewGame() {
        HeroTypes ans = null;
        ans = heroChooseHandler(ans, 1);

        playerOne = playerFactory(ans, "Player1");
        activePlayer = playerOne;
        activePlayer.prepDeck();
        activePlayer.startGameAsFirstPlayer();
        ans = null;

        ans = heroChooseHandler(ans, 2);
        playerTwo = playerFactory(ans, "Player2");
        enemyPlayer = playerTwo;
        enemyPlayer.prepDeck();
        enemyPlayer.startGameAsSecondPlayer();
        startFirstTurn();
    }

    public void startFirstTurn() {
        activePlayer.startTurn();
        System.out.println(activePlayer.getName() + "'s turn started\n");
    }

    public void newTurn() {
        activePlayer.endTurn();
        enemyPlayer.startTurn();
        Player temp = activePlayer;
        activePlayer = enemyPlayer;
        enemyPlayer = temp;
        System.out.println(activePlayer.getName() + "'s turn started\n");
    }

    public boolean shouldEndGame() {
        return playerOne.isGameOver() || playerTwo.isGameOver();
    }

    public void writeOutWinner() {
        if (shouldEndGame()) {
            String winner = !playerOne.isGameOver() ? playerOne.getName() : playerTwo.getName();
            System.out.println("The winner is " + winner);
        }
    }

    private HeroTypes heroChooseHandler(HeroTypes ans, int oneOrTwo) {
        while (ans == null) {
            String answer;
                System.out.println("Player " + oneOrTwo + " which hero do you want to be? (Cleric, Mage, Paladin, Warlock, Hunter): ");
                answer = ScannerUtils.readline();
            if (answer != null) {
                try {
                    ans = valueOf(answer.trim().toUpperCase());
                }
                catch (IllegalArgumentException e) {
                    System.out.println("This is not a valid hero type");
                    ans = null;
                }
            }
        }
        return ans;
    }

    public void handleAttack() {
        System.out.println("Please choose the soldier you want to attack with (index): ");
        int cardIndex = Utils.getCardIndex(activePlayer.getCardsOnField().size());

        SoldierCard card = activePlayer.getCardsOnField().get(cardIndex);
        if(enemyPlayer.getCardsOnField().stream().anyMatch(c -> c instanceof TauntSoldierCard)){
            attackWithTaunt(card);
        } else {
            attackWithoutTaunt(card);
        }
    }

    private void attackWithTaunt(SoldierCard card) {
        System.out.println("Please choose a taunt card (index): ");
        SoldierCard enemyCard = null;
        while(!(enemyCard instanceof TauntSoldierCard)){
            int enemyCardIndex = Utils.getCardIndex(enemyPlayer.getCardsOnField().size());
            enemyCard = enemyPlayer.getCardsOnField().get(enemyCardIndex);
            card.attack(enemyCard);
        }
    }

    private void attackWithoutTaunt(SoldierCard card) {
        System.out.println("Please choose which type of character do you want to attack (soldier, or hero): ");
        String answer = ScannerUtils.readline();
        while (!"hero".equals(answer) && !"soldier".equals(answer)) {
            System.out.println("Please write either soldier or hero.");
            answer = ScannerUtils.readline();
        }
        if ("hero".equals(answer)) {
            card.attack(enemyPlayer.getHero());
        } else {
            System.out.println("Please choose which soldier you want to attack (index): ");
            int enemyCardIndex = Utils.getCardIndex(enemyPlayer.getCardsOnField().size());
            SoldierCard enemyCard = enemyPlayer.getCardsOnField().get(enemyCardIndex);
            card.attack(enemyCard);
        }
    }

    public void writeOutTable() {
        activePlayer.writeOutHero();
        System.out.println("actualMana: " + activePlayer.getActualMana());
        activePlayer.writeOutCardsInHand();
        activePlayer.writeOutCardsOnField();
        System.out.println("Enemy Player");
        enemyPlayer.writeOutHero();
        enemyPlayer.writeOutCardsOnField();
    }

    public void filterDeadSoldiers() {
        activePlayer.filterDeadSoldiers();
        enemyPlayer.filterDeadSoldiers();
    }
}
