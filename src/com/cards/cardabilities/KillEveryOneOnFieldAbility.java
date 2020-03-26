package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import com.player.Player;

/**
 * Kill all soldier cards on the field
 */
public class KillEveryOneOnFieldAbility extends CardAbility {
    public KillEveryOneOnFieldAbility() {
    }

    /**
     * Hits a soldier card by its actualHealth, instantly killing it.
     *
     * This is a method that can be overridden if we want a condition which soldiers we want to kill.
     * @see KillEveryOneOnFieldByAttackValue
     *
     * @param e, general argument for soldier card
     */
    public void predicate(SoldierCard e) {
        e.hit(e.getActualHealth());
    }

    /**
     * Kill all soldier cards on the field
     * @param gm, GameHandler to find all cards on field
     */
    @Override
    public void useAbility(GameHandler gm) {
        Player player1 = gm.getPlayerOne();
        Player player2 = gm.getPlayerTwo();
        player1.getCardsOnField().forEach(this::predicate);
        player2.getCardsOnField().forEach(this::predicate);
    }

    @Override
    public String getDescription() {
        return "Kill everyone on field";
    }
}
