package com.cards.cardabilities;

import com.effect.ChangeAttackEffect;
import com.effect.ChangeHealthEffect;
import com.game.GameHandler;
import com.game.ScannerUtils;
import com.game.Utils;
import com.player.Player;

/**
 * Add a ChangeAttackEffect and a ChangeHealthEffect on a SoldierCard
 */
public class ChangeAttackAndHealthForAdjacentAbility extends CardAbility {
    private int attackValue;
    private int healthValue;

    public ChangeAttackAndHealthForAdjacentAbility(int attackValue, int healthValue) {
        this.attackValue = attackValue;
        this.healthValue = healthValue;
    }

    /**
     * Adds a change attack effect and a change health effect on a chosen card's neighbors
     * Handles the cases where one or both of the neighbors are missing
     * @param gm, GameHandler to call the getCardFromTheField with it
     */
    @Override
    public void useAbility(GameHandler gm) {
        System.out.println("Please choose player");
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
        int cardIndex = Utils.getCardIndex(player.getCardsOnField().size());
        if(cardIndex - 1 >= 0){
            player.getCardsOnField().get(cardIndex - 1).addEffect(new ChangeAttackEffect(attackValue));
            player.getCardsOnField().get(cardIndex - 1).addEffect(new ChangeHealthEffect(healthValue));
        }
        if(cardIndex + 1 < 5){
            player.getCardsOnField().get(cardIndex + 1).addEffect(new ChangeAttackEffect(attackValue));
            player.getCardsOnField().get(cardIndex + 1).addEffect(new ChangeHealthEffect(healthValue));
        }
    }

    @Override
    public String getDescription() {
        return "Changes a soldier's adjacent soldier's attack by " + (attackValue > 0 ? "+" : "") + attackValue + " and health by " + (healthValue > 0 ? "+": "") + healthValue;
    }
}
