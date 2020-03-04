package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import com.player.Player;

public class KillEveryOneOnFieldAbility extends CardAbility {
    public KillEveryOneOnFieldAbility() {
    }

    public void predicate(SoldierCard e) {
        e.hit(e.getActualHealth());
    }

    @Override
    public void useAbility(GameHandler gm) {
        Player player1 = gm.getPlayerOne();
        Player player2 = gm.getPlayerTwo();
        player1.getCardsOnField().forEach(this::predicate);
        player2.getCardsOnField().forEach(this::predicate);
    }

    @Override
    public String getDiscription() {
        return "Kill everyone on field";
    }
}
