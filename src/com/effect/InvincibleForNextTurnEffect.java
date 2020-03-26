package com.effect;

/**
 * If this Effect is on a Hero and isActive then the hero cannot be damaged
 */
public class InvincibleForNextTurnEffect extends HeroEffect {
    public InvincibleForNextTurnEffect() {
        super(false, 1, false, true);
    }

    public String getDescription() {
        return "Makes a hero invincible for the next turn.";
    }
}
