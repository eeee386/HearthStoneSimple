package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AttackAbility extends CardAbility {
    private int attackValue;

    public AttackAbility(int attackValue) {
        this.attackValue = attackValue;
    }

    @Override
    public void useAbility(GameHandler gm) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which hero or soldier do you want to attack? (Player or Player and placement on the board)");

        String answer = scanner.nextLine();
        ArrayList<String> answerArray = new ArrayList<String>(Arrays.asList(answer.split(" ")));
        Player player = answerArray.get(0).compareTo("Player1") == 0 ? gm.getPlayerOne() : gm.getPlayerTwo();
        scanner.close();
        if(answerArray.size() > 1) {
            int cardIndex = Integer.parseInt(answerArray.get(1));
            player.getCardsOnField().get(cardIndex).hit(this.attackValue);
        }
        player.getHero().hit(this.attackValue);
    }

    @Override
    public String getDiscription() {
        return "Damage a chosen Soldier or hero by " + attackValue;
    }
}
