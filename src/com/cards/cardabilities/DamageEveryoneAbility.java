package com.cards.cardabilities;

import com.game.GameHandler;
import com.player.Player;

public class DamageEveryoneAbility extends CardAbility {
    private final int attackValue;

    public DamageEveryoneAbility(int attackValue) {
        this.attackValue = attackValue;
    }

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
    public String getDiscription() {
        return "Damage everyone on field and heros by " + attackValue;
    }
}
