package com.heroes;

import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cleric extends Hero {
    private final int healValue = 2;

    @Override
    public void useAbility(GameHandler gm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Card or Hero to heal");

        String answer = scanner.nextLine();
        ArrayList<String> answerArray = new ArrayList<String>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        if (answerArray.get(1) == null) {
            player.getHero().heal(healValue);
        } else {
            int cardIndex = Integer.parseInt(answerArray.get(1));
            player.getCardsOnField().get(cardIndex).heal(healValue);
        }
        scanner.close();
    }

}
