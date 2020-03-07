package com.hearthstonesimple;

import com.cards.SoldierCard;
import com.game.ActionType;
import com.game.GameHandler;
import com.player.Player;

import java.util.Scanner;

import static com.game.ActionType.*;

public class Main {

    public static void main(String[] args) {
        GameHandler gm = new GameHandler();
        gm.startNewGame();
        Scanner scanner = new Scanner(System.in);
        while(!gm.shouldEndGame()) {
            Player activePlayer = gm.getActivePlayer();
            while(activePlayer.canPlay()){

                System.out.println("Choose action: (attack or playcard or heroaction)");
                String action = scanner.nextLine();
                ActionType actionType = valueOf(action.trim().toUpperCase());
                switch(actionType){
                    case ATTACK:
                        if(!activePlayer.isAnyCardOnField()){
                            System.out.println("You don't have a soldier to attack with");
                            continue;
                        }
                        System.out.println("Please choose the soldier you want to attack with (index): ");
                        gm.handleAttack();
                        break;
                    case PLAYCARD:
                        if(!activePlayer.isAnyCardInHand()){
                            System.out.println("You don't have a card in your hand");
                            continue;
                        }
                        System.out.println("Please choose the card you want to play (index)");
                        int playCardIndex = scanner.nextInt();
                        activePlayer.playCard(gm, playCardIndex);
                        break;
                    case HEROACTION:
                        activePlayer.getHero().useAbility(gm);
                    default:
                        System.out.println("Please choose from the 3 options");
                        break;
                }
            }
            gm.newTurn();
        }
        scanner.close();

        gm.writeOutWinner();


    }
}
