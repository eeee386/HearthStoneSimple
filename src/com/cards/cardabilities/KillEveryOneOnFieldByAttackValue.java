package com.cards.cardabilities;

import com.cards.SoldierCard;

/**
 * Kill everyone on field which has more than the specified attack value
 */
public class KillEveryOneOnFieldByAttackValue extends KillEveryOneOnFieldAbility {
    private final int attackValue;

    public KillEveryOneOnFieldByAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    /**
     * Kill everyone who has more than the specified attack value
     * specified attack value is defined in this.attackValue
     * @param e, general argument for soldier card
     */
    @Override
    public void predicate(SoldierCard e) {
        if(e.getActualAttack() >= attackValue){
            super.predicate(e);
        }
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", which has " + attackValue + " or more attack";
    }
}
