package com.effect;

public class ChangeAttackEffect extends SoldierEffect {
    public int changeAttack;
    public ChangeAttackEffect(int changeAttack) {
        super(true, 0);
        this.changeAttack = changeAttack;
    }
}
