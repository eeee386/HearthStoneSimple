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
        System.out.println("Which character's do you want to send back? (Player and placement on the board)");

        String answer = ScannerUtils.readline();
        ArrayList<String> answerArray = new ArrayList<String>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        int cardIndex = Integer.parseInt(answerArray.get(1));
        SoldierCard card = player.getCardsOnField().remove(cardIndex);
        card.getEffects().stream().filter(Effect::isStartingEffect).forEach(e-> e.setActivated(false));
        player.getCardsInHand().add(card);
    }
}
