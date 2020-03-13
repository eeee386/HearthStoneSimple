package com.heroes;

import com.cards.SimpleSoldierCard;
import com.game.GameHandler;

public class Paladin extends Hero {
    @Override
    public void abilityHandler(GameHandler gm) {
        if(gm.getActivePlayer().getCardsOnField().size() == 5){
            System.out.println("You cannot put down anymore card");
            return;
        }
        gm.getActivePlayer().getCardsOnField().add(new SimpleSoldierCard(0, "Hand Recruit", 1, 1));
    }
}
