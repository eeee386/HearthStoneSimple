package com.effect;

public class InvincibleForNextTurnEffect extends HeroEffect {
    public InvincibleForNextTurnEffect() {
        super(false, 1, false, true);
    }

    public String getDescription() {
        return "Makes a hero invincible for the next turn.";
    }
}
