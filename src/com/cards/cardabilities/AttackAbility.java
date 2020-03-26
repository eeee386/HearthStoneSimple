package com.cards.cardabilities;

import com.game.GameHandler;
import com.game.Utils;

/**
 * You can attack a character on board, if this ability is called
 */
public class AttackAbility extends CardAbility {
    private int attackValue;

    public AttackAbility(int attackValue) {
        this.attackValue = attackValue;
    }

    /**
     * Find a character, and damage it with the specified attack value.
     * @param gm, GameHandler to call the getCardPlayerAndIndexOrHeroFromTheField with it
     */
    @Override
    public void useAbility(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexOrHeroFromTheField(gm, "Which to character to attack?");
        if(pi.isHero()){
            pi.getPlayer().getHero().hit(attackValue);
        } else {
            pi.getPlayer().getCardsOnField().get(pi.getIndex()).hit(attackValue);
        }
    }

    @Override
    public String getDescription() {
        return "Damage a chosen Soldier or hero by " + attackValue;
    }
}
