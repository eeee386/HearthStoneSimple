package com.cards;

import com.cards.cardabilities.CardAbility;

import java.util.ArrayList;

public class BattleCrySoldierCard extends SoldierCard {
    public BattleCrySoldierCard(int manaCost, String name, ArrayList<CardAbility> cardAbility, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.BATTLECRY, cardAbility, attack, maxHealth);
    }
}
