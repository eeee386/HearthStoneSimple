package com.effect;

public class ChangeAttackEffect extends SoldierEffect {
    public int changeAttack;
    public ChangeAttackEffect(int changeAttack) {
        super(true, 0);
        this.changeAttack = changeAttack;
    }

    @Override
    public String toString() {
        return "Attack value is changed by " + changeAttack;
    }
}
