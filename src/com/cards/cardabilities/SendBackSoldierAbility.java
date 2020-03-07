package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.Effect;
import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SendBackSoldierAbility extends CardAbility {

    @Override
    public void useAbility(GameHandler gm) {
        sendBackCardFromFieldToHand(gm, "Which character's do you want to send back?");
    }

    @Override
    public String getDiscription() {
        return "Send back soldier to its owner";
    }

    public void sendBackCardFromFieldToHand(GameHandler gm, String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message + "(Player and placement on the board)");

        String answer = scanner.nextLine();
        ArrayList<String> answerArray = new ArrayList<String>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        int cardIndex = Integer.parseInt(answerArray.get(1));
        scanner.close();
        SoldierCard card = player.getCardsOnField().remove(cardIndex);
        card.getEffects().stream().filter(Effect::isStartingEffect).forEach(e-> e.setActivated(false));
        player.getCardsInHand().add(card);
    }
}
