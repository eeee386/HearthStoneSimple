package com.cards.cardabilities;

import com.effect.ChangeAttackEffect;
import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChangeAttackAbility extends CardAbility {
    private int attackValue;

    public ChangeAttackAbility(int attackValue) {
        this.attackValue = attackValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which character's attack do you want to increase? (Player and placement on the board)");

        String answer = scanner.nextLine();
        ArrayList<String> answerArray = new ArrayList<String>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        int cardIndex = Integer.parseInt(answerArray.get(1));
        player.getCardsOnField().get(cardIndex).addEffect(new ChangeAttackEffect(attackValue));
        scanner.close();
    }

    @Override
    public String getDiscription() {
        return "Changes a chosen soldier's attack by " + (attackValue > 0 ? "+" : "") + attackValue;
    }
}
