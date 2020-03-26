package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import com.game.Utils;

/**
 * Sets Soldier Card on field to initial position, and sends it back to hand of its owner
 */
public class SendBackSoldierAbility extends CardAbility {

    /**
     * Find card add back to owner's hand
     * @param gm, GameHandler which has the information about the whole game util functions to do utility. Usually an argument of a Utils method.
     */
    @Override
    public void useAbility(GameHandler gm) {
        sendBackCardFromFieldToHand(gm);
    }

    @Override
    public String getDescription() {
        return "Send back soldier to its owner";
    }

    /**
     * Utility method to
     * @param gm, GameHandler to get the player, and the card, then set card to initial position,
     *           and send it back from field to hand.
     */
    private void sendBackCardFromFieldToHand(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexFromTheField(gm, "Which soldier to send back?");
        SoldierCard card = pi.getPlayer().getCardsOnField().remove(pi.getIndex());
        card.setToStartPosition();
        pi.getPlayer().getCardsInHand().add(card);
    }
}
