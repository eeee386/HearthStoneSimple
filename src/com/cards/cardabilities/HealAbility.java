package com.cards.cardabilities;

import com.game.GameHandler;
import com.game.Utils;

/**
 * Heal a character on field (Restore specified amount of health)
 */
public class HealAbility extends CardAbility {
    private final int healValue;

    public HealAbility(int healValue) {
        this.healValue = healValue;
    }

    /**
     * Heal a chosen character on field (soldier or hero) by this.healValue
     * @param gm, GameHandler to get the card or the hero
     */
    @Override
    public void useAbility(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexOrHeroFromTheField(gm, "Which character to heal");
        if(pi.isHero()){
            pi.getPlayer().getHero().heal(healValue);
        } else {
            pi.getPlayer().getCardsOnField().get(pi.getIndex()).heal(healValue);
        }
    }

    @Override
    public String getDescription() {
        return "Heal a chosen Soldier or hero by " + healValue;
    }
}
