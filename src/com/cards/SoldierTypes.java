package com.cards;

/**
 * Enum to categorize the soldier cards
 */
public enum SoldierTypes implements CardTypes {
    SIMPLE ("SIMPLE"),
    CHARGE ("CHARGE"),
    TAUNT ("TAUNT"),
    BATTLECRY ("BATTLECRY");

    private String type;

    SoldierTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
