package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.ChangeAttackEffect;
import com.effect.ChangeHealthEffect;
import com.game.GameHandler;
import com.game.Utils;

/**
 * Increase attack value and max health in a Soldier Card by the number of soldiers the active player has.
 */
public class IncreaseAttackAndHealthByNumberOfSoldiers extends CardAbility {
    /**
     * Add change health and attack effect to a selected card by every friendly soldier on field
     * @param gm, GameHandler to find the card and to get the number of soldier cards of active player on field
     */
    @Override
    public void useAbility(GameHandler gm) {
        int numberOfSoldiers = gm.getActivePlayer().getCardsOnField().size();
        SoldierCard card = Utils.getCardFromTheField(gm, "Which character's attack do you want to increase?");
        card.addEffect(new ChangeAttackEffect(numberOfSoldiers));
        card.addEffect(new ChangeHealthEffect(numberOfSoldiers));
    }

    /**
     * Self add change health and attack effect, by every friendly soldier on field
     * @param gm, GameHandler to get the number of soldier cards of active player on field
     * @param card, the card who called the Ability
     */
    public void useAbility(GameHandler gm, SoldierCard card) {
        int numberOfSoldiers = gm.getActivePlayer().getCardsOnField().size();
        card.addEffect(new ChangeAttackEffect(numberOfSoldiers));
    }

    @Override
    public String getDescription() {
        return "Increases this soldier card attack and health by the number of other friendly soldiers on the field";
    }
}
