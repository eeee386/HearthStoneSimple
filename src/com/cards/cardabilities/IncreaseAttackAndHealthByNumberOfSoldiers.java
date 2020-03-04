package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.effect.ChangeAttackEffect;
import com.effect.ChangeHealthEffect;
import com.game.GameHandler;
import com.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseAttackAndHealthByNumberOfSoldiers extends CardAbility {
    @Override
    public void useAbility(GameHandler gm) {
        int numberOfSoldiers = gm.getActivePlayer().getCardsOnField().size();
        SoldierCard card = getCardFromTheField(gm, "Which character's attack do you want to increase?");
        card.addEffect(new ChangeAttackEffect(numberOfSoldiers));
        card.addEffect(new ChangeHealthEffect(numberOfSoldiers));
    }

    public void useAbility(GameHandler gm, SoldierCard card) {
        int numberOfSoldiers = gm.getActivePlayer().getCardsOnField().size();
        card.addEffect(new ChangeAttackEffect(numberOfSoldiers));
    }

    @Override
    public String getDiscription() {
        return "Increases this soldier card attack and health by the number of other friendly soldiers on the field";
    }
}
