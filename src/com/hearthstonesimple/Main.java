package com.hearthstonesimple;

import com.cards.SoldierCard;
import com.game.GameHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameHandler gm = new GameHandler();
        gm.startNewGame();
        while(gm.getActivePlayer().canPlay()){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose action: (attack or play card)");
            String action = scanner.nextLine();
            if("attack".equals(action)){
                System.out.println("Please choose the soldier you want to attack with: ");
                int cardIndex = scanner.nextInt();
                SoldierCard card = gm.getActivePlayer().getCardsOnField().get(cardIndex);
                System.out.println("Please choose which soldier do ou want to attack: ");
                int enemyCardIndex = scanner.nextInt();
                SoldierCard enemyCard = gm.getEnemyPlayer().getCardsOnField().get(enemyCardIndex);
                card.attack(enemyCard);
            }
        }
    }
}
