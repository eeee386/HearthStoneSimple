package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import com.game.Utils;

public class SendBackSoldierAbility extends CardAbility {

    @Override
    public void useAbility(GameHandler gm) {
        sendBackCardFromFieldToHand(gm);
    }

    @Override
    public String getDiscription() {
        return "Send back soldier to its owner";
    }

    private void sendBackCardFromFieldToHand(GameHandler gm) {
        Utils.PlayerAndIndexOrHero pi = Utils.getCardPlayerAndIndexFromTheField(gm, "Which soldier to send back?");
        SoldierCard card = pi.getPlayer().getCardsOnField().remove(pi.getIndex());
        card.setToStartPosition();
        pi.getPlayer().getCardsInHand().add(card);
    }
}
