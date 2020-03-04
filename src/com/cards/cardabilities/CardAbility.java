package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public abstract class CardAbility {
    public abstract void useAbility(GameHandler gm);
    public abstract String getDiscription();

    public SoldierCard getCardFromTheField(GameHandler gm, String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message + "(Player and placement on the board)");

        String answer = scanner.nextLine();
        ArrayList<String> answerArray = new ArrayList<String>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        int cardIndex = Integer.parseInt(answerArray.get(1));
        scanner.close();
        return player.getCardsOnField().get(cardIndex);
    }



}