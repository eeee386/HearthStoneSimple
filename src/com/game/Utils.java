package com.game;

public class Utils {
    public static int getCardIndex(int cardListSize) {
        int cardIndex = -1;
        while (cardIndex == -1) {
            cardIndex = ScannerUtils.readInt();
            if(cardIndex < 0 || cardIndex > cardListSize - 1){
                System.out.println("Please choose a number between 0 and " + (cardListSize -1));
            }
        }
        return cardIndex;
    }
}
