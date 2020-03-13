package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import com.game.Utils;

public class SeduceEnemyAbility extends CardAbility {
    @Override
    public void useAbility(GameHandler gm) {
        if(gm.getActivePlayer().getCardsOnField().size() == 5){
            System.out.println("Your field is full.");
            return;
        }
        System.out.println("Which soldier do you want to take from the enemy? (Placement)");
        int cardIndex = Utils.getCardIndex(gm.getEnemyPlayer().getCardsOnField().size());
        SoldierCard card = gm.getEnemyPlayer().getCardsOnField().remove(cardIndex);
        gm.getActivePlayer().getCardsOnField().add(card);
    }

    @Override
    public String getDiscription() {
        return "Takes an enemy soldier from the field and adds it to your field";
    }
}
