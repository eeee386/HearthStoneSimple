package com.cards;

import java.util.ArrayList;

public class TauntSoldierCard extends SoldierCard {
    public TauntSoldierCard(int manaCost, String name, int attack, int maxHealth) {
        super(manaCost, name, SoldierTypes.TAUNT, new ArrayList<>(), attack, maxHealth);
    }
}
