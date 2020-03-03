package com.cards;

public enum SpellTypes implements CardTypes {
    ;

    private String type;
    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
