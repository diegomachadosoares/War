package war;

import java.util.List;
import java.util.Map;

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
    }

    public void distributeObjectives() {
        Objective obj = Objective.getInstance();
        for (int i = 0; i < players.size(); i++) {
            
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

    public void setPlayers(List<Player> players){
         this.players = players;
    }
}
