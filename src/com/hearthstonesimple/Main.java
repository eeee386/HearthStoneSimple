package com.hearthstonesimple;

import com.game.ActionType;
import com.game.GameHandler;
import com.game.ScannerUtils;
import com.game.Utils;

import static com.game.ActionType.valueOf;

public class Main {

    public static void main(String[] args) {
        GameHandler gm = new GameHandler();
        gm.startNewGame();
        while(!gm.shouldEndGame()) {
            //TODO: check why this mix up the players.
            //Player activePlayer = gm.getActivePlayer();
            boolean shouldBeNewTurn = true;
            while(gm.getActivePlayer().canPlay()){
                gm.writeOutTable();
                System.out.println("Choose action: (attack, playcard, heroaction or endturn)");
                String action = ScannerUtils.readline();
                ActionType actionType;
                try{
                    actionType = valueOf(action.trim().toUpperCase());
                } catch (IllegalArgumentException e) {
                    System.out.println("This is not a valid command");
                    continue;
                }

                switch(actionType){
                    case ATTACK:
                        if(!gm.getActivePlayer().isAnyCardOnField()){
                            System.out.println("You don't have a soldier to attack with");
                            continue;
                        }
                        gm.handleAttack();
                        break;
                    case PLAYCARD:
                        if(!gm.getActivePlayer().isAnyCardInHand()){
                            System.out.println("You don't have a card in your hand");
                            continue;
                        }
                        if(!gm.getActivePlayer().canPlayCard()){
                            System.out.println("You don't have enough mana to play any card");
                            continue;
                        }
                        System.out.println("Please choose the card you want to play (index)");
                        int index = Utils.getCardIndex(gm.getActivePlayer().getCardsInHand().size());
                        gm.getActivePlayer().playCard(gm, index);
                        break;
                    case HEROACTION:
                        gm.getActivePlayer().useHeroAbility(gm);
                        break;
                    case ENDTURN:
                        shouldBeNewTurn = false;
                        System.out.println("\nnew turn\n");
                        gm.newTurn();
                        break;
                    default:
                        System.out.println("Please choose from the 3 options");
                        break;
                }
                gm.filterDeadSoldiers();
                if(gm.shouldEndGame()){
                    break;
                }
            }
            if(shouldBeNewTurn && !gm.shouldEndGame()){
                System.out.println("\nnew turn\n");
                gm.newTurn();
            }
        }
        ScannerUtils.closeScanner();
        gm.writeOutWinner();
    }
}
