package com.cards.cardabilities;

import com.cards.SoldierCard;

public class KillEveryOneOnFieldByAttackValue extends KillEveryOneOnFieldAbility {
    private final int attackValue;

    public KillEveryOneOnFieldByAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    @Override
    public void predicate(SoldierCard e) {
        if(e.getActualAttack() >= attackValue){
            super.predicate(e);
        }
    }

    @Override
    public String getDiscription() {
        return super.getDiscription() + ", which has " + attackValue + " or more attack";
    }
}
