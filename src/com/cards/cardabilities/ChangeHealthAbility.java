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
        getCardFromTheField(gm, "Which character's health do you want to increase?").addEffect(new ChangeHealthEffect(healthValue));
    }

    @Override
    public String getDiscription() {
        return "Changes a chosen soldier's health by " + (healthValue > 0 ? "+" : "") + healthValue;
    }
}
