package com.effect;

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
