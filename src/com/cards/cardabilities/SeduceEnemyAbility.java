package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;

import java.util.Scanner;

public class SeduceEnemyAbility extends CardAbility {
    @Override
    public void useAbility(GameHandler gm) {
        if(gm.getActivePlayer().getCardsOnField().size() == 5){
            System.out.println("Your field is full.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which soldier do you want to take from the enemy? (Placement)");
        int cardIndex = scanner.nextInt();
        SoldierCard card = gm.getEnemyPlayer().getCardsOnField().remove(cardIndex);
        gm.getActivePlayer().getCardsOnField().add(card);
        scanner.close();
    }

    @Override
    public String getDiscription() {
        return "Takes an enemy soldier from the field and adds it to your field";
    }
}
