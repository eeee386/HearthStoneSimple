package com.game;

import com.cards.SoldierCard;
import com.player.Player;

/**
 * Utility class mainly for handling card and character choosing
 */
public class Utils {
    /**
     * Inner static class for easier handling of getting characters on field
     */
    public static class PlayerAndIndexOrHero {
        private Player player;
        private int index;
        private boolean isHero;

        public PlayerAndIndexOrHero(Player player, int index, boolean isHero) {
            this.player = player;
            this.index = index;
            this.isHero = isHero;
        }

        public Player getPlayer() {
            return player;
        }

        public int getIndex() {
            return index;
        }

        public boolean isHero() {
            return isHero;
        }
    }


    /**
     * Handles choosing a valid card index
     * @param cardListSize the size of the card list (in hand, on field, or otherwise)
     * @return the card index of the chosen card
     */
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

    /**
     * Gets a player and its card index that can be chosen
     * @param gm Gameplayer, for getting the player and its cards
     * @param message The message to describe why we need this card
     * @return the PlayerAndIndexOrHero class instance, filled with the active player's choices
     * @see PlayerAndIndexOrHero
     */
    public static PlayerAndIndexOrHero getCardPlayerAndIndexFromTheField(GameHandler gm, String message) {
        System.out.println(message);
        Player player = null;
        String answer;
        while(player == null){
            System.out.println("Which Player (playerName (Player1 or Player2))?");
            answer = ScannerUtils.readline();
            if("Player1".equals(answer)){
                player = gm.getPlayerOne();
            } else if("Player2".equals(answer)) {
                player = gm.getPlayerTwo();
            } else {
                System.out.println("Please choose a player");
            }
        }
        System.out.println("Please add index: ");
        return new PlayerAndIndexOrHero(player, Utils.getCardIndex(player.getCardsOnField().size()), false);
    }

    /**
     * Gets a player and its hero
     * @param gm Gameplayer, for getting the player and its hero
     * @param message The message to describe why we need the player's hero
     * @return the PlayerAndIndexOrHero class instance, filled with the active player's choices
     * @see PlayerAndIndexOrHero
     */
    public static PlayerAndIndexOrHero getCardPlayerAndIndexOrHeroFromTheField(GameHandler gm, String message){
        String answer;
        Player player = null;
        while(player == null){
            System.out.println("Which Player (playerName (Player1 or Player2))?");
            answer = ScannerUtils.readline();
            if("Player1".equals(answer)){
                player = gm.getPlayerOne();
            } else if("Player2".equals(answer)) {
                player = gm.getPlayerTwo();
            } else {
                System.out.println("Please choose a player");
            }
        }
        answer = null;
        PlayerAndIndexOrHero pi = null;
        while(answer == null){
            System.out.println("Please choose: hero or soldier");
            answer = ScannerUtils.readline();
            if("hero".equals(answer)){
                pi = new PlayerAndIndexOrHero(player, -1, true);
            } else if("soldier".equals(answer)) {
                System.out.println("Please add index: ");
                int index = Utils.getCardIndex(player.getCardsOnField().size());
                pi = new PlayerAndIndexOrHero(player, index, false);
            }
        }
        return pi;
    }

    /**
     * Gets the chosen card
     * @param gm GameHandler to get the card
     * @param message to describe why we need this card
     * @return The soldier card chosen by the active player
     */
    public static SoldierCard getCardFromTheField(GameHandler gm, String message) {
        PlayerAndIndexOrHero pi = getCardPlayerAndIndexFromTheField(gm, message);
        return pi.player.getCardsOnField().get(pi.index);
    }
}
