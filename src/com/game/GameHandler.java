package com.game;

import com.cards.SoldierCard;
import com.heroes.*;
import com.player.Player;

import java.util.Scanner;

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

    public Player getActivePlayer(){
        return this.activePlayer;
    }

    public Player getEnemyPlayer(){
        return enemyPlayer;
    }

    public void activePlayerUseHeroAbility(){
        this.activePlayer.useHeroAbility(this);
    }

    private Player playerFactory(HeroTypes answer, String name) {
        switch(answer) {
            case CLERIC: return new Player(name, new Cleric());
            case MAGE: return new Player(name, new Mage());
            case PALADIN: return new Player(name, new Paladin());
            case WARLOCK: return new Player(name, new Warlock());
            case HUNTER: return new Player(name, new Hunter());
            default: return null;
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

    public void startFirstTurn(){
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

    public void writeOutWinner(){
        if(shouldEndGame()){
            String winner = !playerOne.isGameOver() ? playerOne.getName() : playerTwo.getName();
            System.out.println("The winner is " + winner);
        }
    }

    private HeroTypes heroChooseHandler(HeroTypes ans, int oneOrTwo) {
        Scanner scanner = new Scanner(System.in);
        while (ans == null){
            System.out.println("Player " + oneOrTwo + " which hero do you want to be? (Cleric, Mage, Paladin, Warlock, Hunter): ");
            String answer = scanner.next();
            if (answer != null) {
                ans = valueOf(answer.trim().toUpperCase());
            }
        }
//        scanner.close();
        return ans;
    }

    public void handleAttack() {
        Scanner scanner = new Scanner(System.in);
        int cardIndex = scanner.nextInt();
        SoldierCard card = activePlayer.getCardsOnField().get(cardIndex);
        System.out.println("Please choose which soldier do you want to attack (index): ");
        int enemyCardIndex = scanner.nextInt();
        SoldierCard enemyCard = enemyPlayer.getCardsOnField().get(enemyCardIndex);
        card.attack(enemyCard);
        scanner.close();
    }

    public void writeOutTable() {
        activePlayer.writeOutCardsInHand();
        activePlayer.writeOutCardsOnField();
        System.out.println("Enemy Player");
        enemyPlayer.writeOutCardsOnField();
    }
}
