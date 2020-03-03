package com.cards.cardabilities;

import com.effect.ChangeAttackEffect;
import com.effect.ChangeHealthEffect;
import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChangeHealthAndAttackAbility extends CardAbility {
    private int attackValue;
    private int healthValue;

    public ChangeHealthAndAttackAbility(int attackValue, int healthValue) {
        this.attackValue = attackValue;
        this.healthValue = healthValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which character's attack and health do you want to increase? (Player and placement on the board)");

        String answer = scanner.nextLine();
        ArrayList<String> answerArray = new ArrayList<>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        int cardIndex = Integer.parseInt(answerArray.get(1));
        player.getCardsOnField().get(cardIndex).addEffect(new ChangeAttackEffect(attackValue));
        player.getCardsOnField().get(cardIndex).addEffect(new ChangeHealthEffect(healthValue));
        scanner.close();
    }

    @Override
    public String getDiscription() {
        return "Changes a soldier's attack by " + (attackValue > 0 ? "+" : "") + attackValue + " and health by ";
    }
}
