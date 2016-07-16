package war;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author AleGomes
 */
public class Match {

    private int numberOfExchanges = 0;
    private int numberOfTroops = 2;
    List<Player> players;
    Board board;
    LinkedList<Objective> objectives;

    public Match() {

    }

    public Match(List<Player> players, Board board) {
        this.players = players;
        this.board = board;
        this.objectives = new LinkedList<>();
    }

    public void distributeTerritories() {
        
        board.distributeTerritories(players);
            
   }

    
    public void distributeObjectives(String objectiveFile) {
        initializeObjectives(objectiveFile);
        for (int i = 0; i < players.size(); i++) {
            //FIXME -> Make me random!
            this.players.get(i).setObjective(this.objectives.get(i));
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
    
    public void initializeObjectives(String objectiveFile){
        try {
            Scanner sc = new Scanner(new FileInputStream(new File(objectiveFile)));
            String currline;
            String[] split;
            while (sc.hasNextLine()) {
                currline = sc.nextLine();
                split = currline.split(":");
                switch (Integer.parseInt(split[0])) {
                    case 0:
                    case 1:
                        List<Integer> list = new ArrayList<>();
                        list.add(Integer.parseInt(split[1]));
                        list.add(Integer.parseInt(split[2]));
                        this.objectives.push(new Objective(Integer.parseInt(split[0]), split[3], list));
                        break;
                    case 2:
                        //FIXME -> Corrigir o caso do objetivo 18 territorios com 2 tropas cada
                        this.objectives.push(new Objective(Integer.parseInt(split[0]), split[2], Integer.parseInt(split[1])));
                        break;
                    case 3:
                        this.objectives.push(new Objective(Integer.parseInt(split[0]), split[2], split[1]));
                        break;
                    default:
                        break;
                }
            }
        } catch (FileNotFoundException e) {
        }
    }
}
