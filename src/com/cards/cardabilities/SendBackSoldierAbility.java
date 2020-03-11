package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.Effect;
import com.game.GameHandler;
import com.game.ScannerUtils;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

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
        CardAbility.PlayerAndIndex pi = getCardPlayerAndIndexFromTheField(gm, "Choose player");
        SoldierCard card = pi.player.getCardsOnField().remove(pi.index);
        card.getEffects().stream().filter(Effect::isStartingEffect).forEach(e-> e.setActivated(false));
        pi.player.getCardsInHand().add(card);
    }
}
