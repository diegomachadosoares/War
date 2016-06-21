/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AleGomes
 */
public class Match {

    private int numberOfExchanges = 0;
    private int numberOfTroops = 2;

    public void startMatch(List<Player> players) {
        boolean acabou = true;

        while (!acabou) {
            for (int i = 0; i < players.size(); i++) {

            }
        }
    }

    public int exchangeCards(Card card1, Card card2, Card card3) {
        if ((card1.getFigure().equalsIgnoreCase(card2.getFigure()) && card2.getFigure().equalsIgnoreCase(card3.getFigure()))
                || !card1.getFigure().equalsIgnoreCase(card2.getFigure()) && !card1.getFigure().equalsIgnoreCase(card3.getFigure()) && !card2.getFigure().equalsIgnoreCase(card3.getFigure())) {
                numberOfTroops += 2;
                numberOfExchanges++;
                return numberOfTroops;
        }
        return 0;
    }
}
