package com.hearthstonesimple;

import com.cards.SoldierCard;
import com.game.GameHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameHandler gm = new GameHandler();
        gm.startNewGame();
        while(!gm.shouldEndGame()) {
            gm.newTurn();
            while(gm.getActivePlayer().canPlay()){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choose action: (attack or play card or hero action)");
                String action = scanner.nextLine();
                switch(action){
                    case "attack":
                        System.out.println("Please choose the soldier you want to attack with (index): ");
                        int cardIndex = scanner.nextInt();
                        SoldierCard card = gm.getActivePlayer().getCardsOnField().get(cardIndex);
                        System.out.println("Please choose which soldier do you want to attack (index): ");
                        int enemyCardIndex = scanner.nextInt();
                        SoldierCard enemyCard = gm.getEnemyPlayer().getCardsOnField().get(enemyCardIndex);
                        card.attack(enemyCard);
                        break;
                    case "play card":
                        System.out.println("Please choose the card you want to play (index)");
                        int playCardIndex = scanner.nextInt();
                        gm.getActivePlayer().playCard(gm, playCardIndex);
                        break;
                    case "hero action":
                        gm.getActivePlayer().getHero().useAbility(gm);
                    default:
                        System.out.println("Please choose from the 3 options");
                        break;
                }
            }
        }


    }
}
