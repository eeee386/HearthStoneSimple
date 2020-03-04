package com.cards;

import com.cards.cardabilities.CardAbility;
import com.cards.cardabilities.ChangeAttackAndHealthForAdjacentAbility;
import com.cards.cardabilities.ChangeHealthAndAttackAbility;

import java.util.ArrayList;

public class CardFactory {
    public static ArrayList<Card> cards = new ArrayList<>();
    public static void createCards() {
        ArrayList<CardAbility> blessOfChampions = abilityListFactory(new ChangeHealthAndAttackAbility(3, 3));

        ArrayList<CardAbility> spellOfArgus = CardFactory.abilityListFactory(new ChangeAttackAndHealthForAdjacentAbility(1, 1));

        cards.add(
                new SpellCard(
                        3,
                        "Blessing of Champions",blessOfChampions
                        ));
        cards.add(new SpellCard(3, "Spell of Argus", spellOfArgus));
    }

    private static ArrayList<CardAbility> abilityListFactory(CardAbility ability){
        ArrayList<CardAbility> temp = new ArrayList<>();
        temp.add(ability);
        return temp;
    }
}
