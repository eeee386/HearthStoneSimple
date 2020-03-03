package com.cards.cardabilities;

import com.effect.ChangeHealthEffect;
import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChangeHealthAbility extends CardAbility {
    private int healthValue;

    public ChangeHealthAbility(int attackValue) {
        this.healthValue = attackValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which character's health do you want to increase? (Player and placement on the board)");

        String answer = scanner.nextLine();
        ArrayList<String> answerArray = new ArrayList<String>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        int cardIndex = Integer.parseInt(answerArray.get(1));
        player.getCardsOnField().get(cardIndex).addEffect(new ChangeHealthEffect(healthValue));
        scanner.close();
    }

    @Override
    public String getDiscription() {
        return "Changes a chosen soldier's health by " + (healthValue > 0 ? "+" : "") + healthValue;
    }
}
