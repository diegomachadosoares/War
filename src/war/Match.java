/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AleGomes
 */
public class Match {

    private int numberOfExchanges = 0;
    private int numberOfTroops = 2;
    List<Player> players;
    Board board;

    public Match() {

    }

    public Match(List<Player> players, Board board) {
        this.players = players;
        this.board = board;
    }

    public void distributeTerritories() {
        //Distribuir territorios
        int territoriesCount = 0;
        Map<Integer, Continent> continents = board.getContinents();
        for (int i = 0; i < continents.size(); i++) {
            for (int j = 0; j < continents.get(i).getTerritories().size(); j++) {
                if (territoriesCount == players.size()) {
                    territoriesCount = territoriesCount % players.size();
                }
                Territory t = continents.get(i).getTerritories().get(j);
                Player p = players.get(territoriesCount);

                t.setOwner(p);
                p.addTerritory(t);
                t.setOwner(p);

                players.set(territoriesCount, p);
                continents.get(i).getTerritories().set(j, t);

                territoriesCount++;
            }
        }
        
        List<Territory> listaTerritorios = new ArrayList<>();
       
        for (int i = 0; i < this.board.continents.size(); i++) {
            for (int j = 0; j < this.board.continents.get(i).getTerritories().size(); j++) {
                listaTerritorios.add(this.board.continents.get(i).getTerritories().get(j));
            }
        }
        
        this.board.territories = listaTerritorios;
        
    }

    public void distributeObjectives() {
        for (int i = 0; i < players.size(); i++) {
            players.get(i).chooseObjective();
        }
    }

    public void startMatch() {
        boolean acabou = true;

        //Inicializacao
        //Rodada de fortificação
        for (int i = 0; i < players.size(); i++) {
            
        }

        while (!acabou) {
            for (int i = 0; i < players.size(); i++) {
                //Distribui peças
                //Ataca / Combate
                //Movimenta tropas
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
