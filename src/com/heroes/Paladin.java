package com.heroes;

import com.cards.SimpleSoldierCard;
import com.game.GameHandler;

/**
 * Class to describe the Paladin Hero
 * Hero ability: Creates a new Soldier Card and puts it on the field
 */
public class Paladin extends Hero {
    /**
     * Handles the ability (create new Soldier card on field) logic
     * @param gm GameHandler to get the player's character on filed, be it hero or Soldier Card
     */
    @Override
    public void abilityHandler(GameHandler gm) {
        if(gm.getActivePlayer().getCardsOnField().size() == 5){
            System.out.println("You cannot put down anymore card");
            return;
        }
        gm.getActivePlayer().getCardsOnField().add(new SimpleSoldierCard(0, "Hand Recruit", 1, 1));
    }
}
