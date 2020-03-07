package com.cards;

import com.cards.cardabilities.*;
import com.effect.AddPlusAttackForEveryTurnEffect;
import com.effect.AddPlusHealthForEveryTurnEffect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardFactory {
    public static ArrayList<Card> cards = new ArrayList<>();
    public static void createCards() {
        ArrayList<CardAbility> blessOfChampions = abilityListFactory(new ChangeHealthAndAttackAbility(3, 3));

        ArrayList<CardAbility> spellOfArgus = abilityListFactory(new ChangeAttackAndHealthForAdjacentAbility(1, 1));

        ArrayList<CardAbility> sap = abilityListFactory(new SendBackSoldierAbility());

        ArrayList<CardAbility> mindControl = abilityListFactory(new SeduceEnemyAbility());

        ArrayList<CardAbility> fireBall = abilityListFactory(new AttackAbility(4));

        ArrayList<CardAbility> heroCannotBeAttackedForOneTurn = abilityListFactory(new MakeHeroInvincibleForNextTurnAbility());

        ArrayList<CardAbility> freeze = abilityListFactory(new FreezeAbility(1));

        ArrayList<CardAbility> addPlus1Both = abilityListFactory(new ChangeHealthAndAttackAbility(1, 1));

        ArrayList<CardAbility> clearBonuses = abilityListFactory(new ClearBonusesAbility());

        ArrayList<CardAbility> addItselfplus1byNumberOfSoldiers = abilityListFactory(new IncreaseAttackAndHealthByNumberOfSoldiers());

        ArrayList<CardAbility> drawTwoCards = abilityListFactory(new DrawCardAbility(2));

        ArrayList<CardAbility> dealTwoDamageToAll = abilityListFactory(new DamageEveryoneAbility(2));

        ArrayList<CardAbility> killEveryOneAbove3Damage = abilityListFactory(new KillEveryOneOnFieldByAttackValue(3));

        cards.add(new SpellCard(3, "Blessing of Champions",blessOfChampions));
        cards.add(new SpellCard(3, "Spell of Argus", spellOfArgus));
        cards.add(new SpellCard(2, "Sap", sap));
        cards.add(new SpellCard(10, "Mind Control", mindControl));
        cards.add(new SpellCard(4, "Fireball", fireBall));
        cards.add(new SpellCard(3, "Freeze", freeze));
        cards.add(new SpellCard(3, "Timeout", heroCannotBeAttackedForOneTurn));

        cards.add(new TauntSoldierCard(2, "Grunt", 2, 2));
        cards.add(new TauntSoldierCard(4, "Shieldmaster", 3, 5));
        cards.add(new TauntSoldierCard(6, "Lord of the Arena", 6, 5));
        cards.add(new TauntSoldierCard(8, "Protector", 8, 8));
        cards.add(new TauntSoldierCard(1, "Footman", 1, 2));
        cards.add(new TauntSoldierCard(1, "Shieldbearer", 0, 4));

        cards.add(new ChargeSoldierCard(2, "Angry Warrior", 2, 1));
        cards.add(new ChargeSoldierCard(6, "Reckless Warrior", 5, 3));
        cards.add(new ChargeSoldierCard(1, "Boar", 1, 1));
        cards.add(new ChargeSoldierCard(3, "Rider", 3, 1));

        cards.add(new BattleCrySoldierCard(3, "Sun Priest", addPlus1Both, 3, 2));
        cards.add(new BattleCrySoldierCard(5, "Janitor", clearBonuses, 4, 5));
        cards.add(new BattleCrySoldierCard(5, "Warlord", addItselfplus1byNumberOfSoldiers, 4, 4));
        cards.add(new BattleCrySoldierCard(4, "Chest", drawTwoCards, 0, 4));
        cards.add(new BattleCrySoldierCard(7, "Lord Destroyer", dealTwoDamageToAll, 4, 4));
        cards.add(new BattleCrySoldierCard(6, "Horror", killEveryOneAbove3Damage, 3, 4));

        cards.add(new SimpleSoldierCard(8, "Ghoul",7, 7, new ArrayList<>(Arrays.asList(new AddPlusHealthForEveryTurnEffect(1), new AddPlusAttackForEveryTurnEffect(1)))));
        cards.add(new SimpleSoldierCard(2, "Swordsmith", 1, 3, new ArrayList<>(Collections.singletonList(new AddPlusHealthForEveryTurnEffect(1)))));

        cards.add(new SimpleSoldierCard(0, "Wisp", 1, 1));
        cards.add(new SimpleSoldierCard(1, "Raider", 2, 1));
        cards.add(new SimpleSoldierCard(1, "Battlemage", 2, 2));
        cards.add(new SimpleSoldierCard(3, "Rager", 5, 1));
    }

    public static ArrayList<Card> getFullDeck(){
        createCards();
        return cards;
    }

    private static ArrayList<CardAbility> abilityListFactory(CardAbility ...abilities){
        return new ArrayList<>(Arrays.asList(abilities));
    }
}
