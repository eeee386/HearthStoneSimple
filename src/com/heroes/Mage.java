package com.heroes;

import com.game.GameHandler;
import com.game.ScannerUtils;
import com.game.Utils;
import com.player.Player;

public class Mage extends Hero {
    private final int hitDamage = 2;

    public void abilityHandler(GameHandler gm) {
        String answer = null;
        Player player = null;
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
        answer = null;
        while(answer == null){
            System.out.println("Please choose: hero or soldier");
            answer = ScannerUtils.readline();
            if("hero".equals(answer)){
                player.getHero().hit(hitDamage);
            } else if("soldier".equals(answer)) {
                int index = Utils.getCardIndex(player.getCardsOnField().size());
                player.getCardsOnField().get(index).hit(hitDamage);
            }
        }
    }
}
