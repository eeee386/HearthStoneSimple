package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import com.game.Utils;

/**
 * Take an enemy soldier's card and add it to you field
 */
public class SeduceEnemyAbility extends CardAbility {
    /**
     * Find card to take from enemy field, and add to your field
     * @param gm, GameHandler, to find the enemy card, and check you field size
     */
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
    public String getDescription() {
        return "Takes an enemy soldier from the field and adds it to your field";
    }
}
