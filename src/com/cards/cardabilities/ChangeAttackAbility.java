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
        getCardFromTheField(gm, "Which character's attack do you want to increase?").addEffect(new ChangeAttackEffect(attackValue));
    }

    @Override
    public String getDiscription() {
        return "Changes a chosen soldier's attack by " + (attackValue > 0 ? "+" : "") + attackValue;
    }
}
