package com.cards.cardabilities;

import com.game.GameHandler;
import com.player.Player;

/**
 * Damage Everyone on field by a specified attack value
 */
public class DamageEveryoneAbility extends CardAbility {
    private final int attackValue;

    public DamageEveryoneAbility(int attackValue) {
        this.attackValue = attackValue;
    }

    /**
     * Find and damage every character on field
     * @param gm, GameHandler to get players and all of their cards
     */
    @Override
    public void useAbility(GameHandler gm) {
        Player player1 = gm.getPlayerOne();
        Player player2 = gm.getPlayerTwo();
        player1.getHero().hit(attackValue);
        player2.getHero().hit(attackValue);
        player1.getCardsOnField().forEach(e-> e.hit(attackValue));
        player2.getCardsOnField().forEach(e-> e.hit(attackValue));
    }

    @Override
    public String getDescription() {
        return "Damage everyone on field and heros by " + attackValue;
    }
}
