package war;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diegomachado
 */
public class Controller {

    private static Controller INSTANCE;

    private static void initializeInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
        }
    }
    private Board board;
    private String contFile = "data/continent.txt";
    private String terrFile = "data/territories.txt";
    private String neighFile = "data/neighbors.txt";
    private String objFile = "data/objectives.txt";
    private LinkedList<Player> players;
    private LinkedList<String> colors;
    private Match match;

    private Controller() {
        try {
            this.board = new Board(contFile, terrFile, neighFile);
            this.players = new LinkedList<>();
            this.colors = new LinkedList<>();
            addColors();
            this.match = new Match();
        } catch (FileNotFoundException e) {
        } catch (IOException io) {
        }
    }

    public static Controller getInstance() {
        if (INSTANCE == null) {
            initializeInstance();
        }
        return INSTANCE;
    }

    private void addColors() {
        this.colors.push("Amarelo");
        this.colors.push("Azul");
        this.colors.push("Roxo");
        this.colors.push("Preto");
        this.colors.push("Verde");
        this.colors.push("Vermelho");
    }

    private static class ControllerHolder {

        private static final Controller INSTANCE = new Controller();
    }

    public Map getTerritories() {
        return board.getTerritories();
    }

    public Map getContinents() {
        return board.getContinents();
    }

    public Map getNeighborhoods() {
        return board.getNeighborhoods();
    }

    public Territory getTerritory(Integer i) {
        return board.getTerritory(i);
    }

    public Continent getContinent(Integer i) {
        return board.getContinent(i);
    }

    public List<Territory> getNeighborhood(Integer i) {
        return board.getNeighborhood(i);
    }

    public void createHumanPlayer(String name, String color) {
        int i = this.players.indexOf(color);
        if (i >= 0){
            this.players.remove(i);
        }
        this.players.push(new Player(name, color, 0));
    }

    public void createAIPlayers(int i) {
        String name, color;
        for (int j = 0; j < i; j++) {
            name = "AI_" + String.valueOf(j+1);
            color = this.colors.pop();
            this.players.push(new Player(name, color, j+1));
        }
    }

    public void startMatch(){
        match.setPlayers(this.players);
        match.distributeObjectives(objFile);
        match.distributeTerritories();
        match.startMatch();

    }
}
