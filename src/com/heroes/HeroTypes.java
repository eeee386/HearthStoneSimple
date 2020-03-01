package com.heroes;

public enum HeroTypes {
    CLERIC ("Cleric"),
    MAGE("Mage"),
    PALADIN("Paladin"),
    HUNTER("Hunter"),
    WARLOCK("Warlock");

    private final String value;

    HeroTypes(String str) {
        this.value = str;
    }

    public boolean equalValue(String passedValue){
        return this.value.equals(passedValue);
    }

    public String getValue() {
        return this.value;
    }
}
