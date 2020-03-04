package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.ChangeAttackEffect;
import com.effect.ChangeHealthEffect;
import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ChangeAttackAndHealthForAdjacentAbility extends CardAbility {
    private int attackValue;
    private int healthValue;

    public ChangeAttackAndHealthForAdjacentAbility(int attackValue, int healthValue) {
        this.attackValue = attackValue;
        this.healthValue = healthValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which soldier do you choose? (Player and placement on the board)");

        String answer = scanner.nextLine();
        ArrayList<String> answerArray = new ArrayList<String>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        int cardIndex = Integer.parseInt(answerArray.get(1));
        scanner.close();
        if(cardIndex - 1 >= 0){
            player.getCardsOnField().get(cardIndex - 1).addEffect(new ChangeAttackEffect(attackValue));
            player.getCardsOnField().get(cardIndex - 1).addEffect(new ChangeHealthEffect(healthValue));
        }
        if(cardIndex + 1 < 5){
            player.getCardsOnField().get(cardIndex + 1).addEffect(new ChangeAttackEffect(attackValue));
            player.getCardsOnField().get(cardIndex + 1).addEffect(new ChangeHealthEffect(healthValue));
        }
    }

    @Override
    public String getDiscription() {
        return "Changes a soldier's attack by " + (attackValue > 0 ? "+" : "") + attackValue + " and health by " + (healthValue > 0 ? "+": "") + healthValue;
    }
}
