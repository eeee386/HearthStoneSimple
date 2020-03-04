package com.cards.cardabilities;

import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HealAbility extends CardAbility {
    private final int healValue;

    public HealAbility(int healValue) {
        this.healValue = healValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which hero or soldier do you want to heal? (Player or Player and placement on the board)");

        String answer = scanner.nextLine();
        ArrayList<String> answerArray = new ArrayList<String>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        scanner.close();
        if(answerArray.size() > 1) {
            int cardIndex = Integer.parseInt(answerArray.get(1));
            player.getCardsOnField().get(cardIndex).heal(this.healValue);
        }
        player.getHero().heal(this.healValue);
    }

    @Override
    public String getDiscription() {
        return "Damage a chosen Soldier or hero by " + healValue;
    }
}
