package com.cards.cardabilities;

import com.cards.SoldierCard;
import com.game.GameHandler;
import com.game.ScannerUtils;
import com.game.Utils;
import com.player.Player;

public abstract class CardAbility {
    public abstract void useAbility(GameHandler gm);
    public abstract String getDiscription();

    public static class PlayerAndIndex{
        public Player player;
        public int index;

        public PlayerAndIndex(Player player, int index) {
            this.player = player;
            this.index = index;
        }
    }

    public SoldierCard getCardFromTheField(GameHandler gm, String message) {
        PlayerAndIndex pi = getCardPlayerAndIndexFromTheField(gm, message);
        return pi.player.getCardsOnField().get(pi.index);
    }

    public PlayerAndIndex getCardPlayerAndIndexFromTheField(GameHandler gm, String message) {
        System.out.println(message + "Player");
        Player player = null;
        String answer;
        while(player == null){
            System.out.println("Which Player (playerName)?");
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
        return new PlayerAndIndex(player, Utils.getCardIndex(player.getCardsOnField().size()));
    }
}
