package com.effect;

/**
 * If this effect is on a Soldier Card and active it will Change the attack value of a Soldier Card
 */
public class ChangeAttackEffect extends SoldierEffect {
    private final int changeAttack;
    public ChangeAttackEffect(int changeAttack) {
        super(true, 0, false, true);
        this.changeAttack = changeAttack;
    }

    public int getChangeAttack() {
        return changeAttack;
    }

    public String getDescription() {
        return "Attack value is changed by " + changeAttack;
    }
}
