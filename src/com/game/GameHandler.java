package com.game;

import com.heroes.*;
import com.player.Player;

import java.util.Scanner;

import static com.heroes.HeroTypes.valueOf;

public class GameHandler {
    private Player playerOne;
    private Player playerTwo;
    private Player activePlayer;
    private Player enemyPlayer;

    public GameHandler(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

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

    private Player playerFactory(HeroTypes answer) {
        switch(answer) {
            case CLERIC: return new Player(new Cleric());
            case MAGE: return new Player(new Mage());
            case PALADIN: return new Player(new Paladin());
            case WARLOCK: return new Player(new Warlock());
            case HUNTER: return new Player(new Hunter());
            default: return null;
        }
    }

    public void startNewGame() {
        Scanner scanner = new Scanner(System.in);
        HeroTypes ans = null;
        ans = heroChooseHandler(ans, 1);

        playerOne = playerFactory(ans);
        activePlayer = playerOne;
        activePlayer.startGameAsFirstPlayer();
        ans = null;

        ans = heroChooseHandler(ans, 2);
        playerTwo = playerFactory(ans);
        enemyPlayer = playerTwo;
        enemyPlayer.startGameAsSecondPlayer();

    }

    public void newTurn() {
        activePlayer.endTurn();
        enemyPlayer.startTurn();
        Player temp = activePlayer;
        activePlayer = enemyPlayer;
        enemyPlayer = temp;
    }

    public boolean shouldEndGame() {
        return playerOne.isGameOver() || playerTwo.isGameOver();
    }

    private HeroTypes heroChooseHandler(HeroTypes ans, int oneOrTwo) {
        Scanner scanner = new Scanner(System.in);
        while (ans == null){
            System.out.println("Player " + oneOrTwo + " which hero do you want to be? (Cleric, Mage, Paladin, Warlock, Hunter): ");
            String answer = scanner.nextLine();
            ans = valueOf(answer);
            System.out.println("Please choose: Cleric, Mage, Paladin, Warlock, Hunter");
        }
        scanner.close();
        return ans;
    }
}
