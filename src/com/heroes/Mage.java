package com.heroes;

import com.game.GameHandler;
import com.player.Player;

import java.util.Scanner;

public class Mage extends Hero {
    private final int hitDamage = 2;

    public void abilityHandler(GameHandler gm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which Card or Hero to hit");

        String answer = scanner.nextLine();
        String[] answerArray = answer.split(" ");
        Player player = answerArray[0].compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        if (answerArray[1] == null) {
            player.getHero().hit(hitDamage);
        } else {
            int cardIndex = Integer.parseInt(answerArray[1]);
            player.getCardsOnField().get(cardIndex).hit(hitDamage);
        }
        scanner.close();
    }
}
