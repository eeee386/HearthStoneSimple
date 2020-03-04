package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import java.util.Scanner;

public class GetEnemySoldierAbility extends CardAbility {
    @Override
    public void useAbility(GameHandler gm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which soldier do you want to take from the enemy? (placement on the board)");
        int cardIndex = scanner.nextInt();
        scanner.close();
        if(gm.getActivePlayer().getCardsOnField().size() >= 5){
            System.out.println("Field is full, cannot take enemy soldier");
        } else {
            SoldierCard cardToTake = gm.getEnemyPlayer().getCardsOnField().get(cardIndex);
            gm.getActivePlayer().getCardsOnField().add(cardToTake);
        }


    }

    @Override
    public String getDiscription() {
        return null;
    }
}
