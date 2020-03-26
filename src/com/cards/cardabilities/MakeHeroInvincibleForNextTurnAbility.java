package com.cards.cardabilities;

import com.effect.InvincibleForNextTurnEffect;
import com.game.GameHandler;

/**
 * Add an InvincibleForNextTurnEffect to the active player's hero
 */
public class MakeHeroInvincibleForNextTurnAbility extends CardAbility {
    /**
     * Add an InvincibleForNextTurnEffect to the active player's hero
     * @param gm, GameHandler, to get the active player's hero
     */
    @Override
    public void useAbility(GameHandler gm) {
        gm.getActivePlayer().getHero().getEffects().add(new InvincibleForNextTurnEffect());
    }

    @Override
    public String getDescription() {
        return "For the next turn your hero is invincible";
    }
}
