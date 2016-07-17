package war;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diegomachado
 */
public class Controller {

    private static Controller INSTANCE;
    private Board board;
    private String contFile = "data/continent.txt";
    private String terrFile = "data/territories.txt";
    private String neighFile = "data/neighbors.txt";
    private String objFile = "data/objectives.txt";
    private LinkedList<Player> players;
    private LinkedList<String> colors;
    private Match match;
    private boolean gameStarted;
    private int state;  // state = 0 => Fortify territories
    // state - 1 => Battle
    // state = 2 => moving troops

    private Controller() {
        try {
            this.board = new Board(contFile, terrFile, neighFile);
            this.players = new LinkedList<>();
            this.colors = new LinkedList<>();
            this.addColors();
            this.match = new Match(this.players, this.board);
            this.state = 0;
            this.gameStarted = false;
        } catch (FileNotFoundException e) {
        } catch (IOException io) {
        }
    }

    private static class ControllerHolder {

        private static final Controller INSTANCE = new Controller();
    }

    private static void initializeInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Controller();
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

    public Map getTerritories() {
        return board.getTerritories();
    }

    public Map getContinents() {
        return board.getContinents();
    }
    
    public List<Territory> elegerAlvos( int indice ) {
    List<Territory> alvos = getNeighborhood(indice);
    ArrayList<Integer> positions = new ArrayList();
    
        for (int i = 0; i < alvos.size(); i++) {
            if(alvos.get(i).getOwner().getId()==0){
            positions.add(i);
            }
            
        }
    
        for (int i = 0; i < positions.size(); i++) {
            Territory t = alvos.get(positions.get(i));
            alvos.remove(t);                        
        }
        
    return alvos;
    }
    
    public Map getNeighborhoods() {
        return board.getNeighborhoods();
    }

    public Player getPlayerById(Integer i) {
        return players.get(i);
    }

    public void setPlayerById(Integer i, Player p) {
        players.set(i, p);
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

    public void setGameStarted() {
        this.gameStarted = true;
    }

    public boolean getGameStarted() {
        return this.gameStarted;
    }

    public int getPlayerTroops(Player p) {
        return this.players.get(p.getId()).getNTroops();
    }

    public int getState() {
        return this.state;
    }

    public void createHumanPlayer(String name, String color) {
        int i = this.colors.indexOf(color);
        if (i >= 0) {
            this.colors.remove(i);
        }
        this.players.push(new Player(name, color, 0));
    }

    public void createAIPlayers(int i) {
        String name, color;
        for (int j = 0; j < i; j++) {
            color = this.colors.pop();
            name = color;
            this.players.push(new Player(name, color, j + 1));
        }
    }

    public void startMatch() {
        match.setPlayers(this.players);
        match.distributeObjectives(objFile);
        match.distributeTerritories();
        this.gainTroops();
        // First round - Fotification only
        for (int i = 1; i < players.size(); i++) {
            Player p = this.players.get(i);
            distributeIATroops(p);
        }
    }

    public void startIARound() {
        for (int i = 1; i < players.size(); i++) {
            Player p = this.players.get(i);
            distributeIATroops(p);
            attackIA(p);
            moveIATroops(p);
        }
    }

    public int changeState() {
        if (this.state == 2) {
            this.state = 0;
            return this.state;
        }
        this.state++;
        return this.state;
    }

    public void distributeIATroops(Player p) {
        int ntroops = p.getNTroops();
        LinkedList<Territory> t = p.getTerritories();
        for (int i = 0; i < ntroops; i++) {
            t.get((int) (1 + Math.random() * (t.size() - 1))).addTroops(1);
        }
    }

    public void attackIA(Player p) {

    }

    public void moveIATroops(Player p) {
    }

    public void gainTroops() {
        for (int i = 0; i < this.players.size(); i++) {
            int nterr = this.players.get(i).getTerritories().size();
            this.players.get(i).setNTroops(nterr / 2);
        }
    }
    
    public void setNTroops(int i , int j){
    this.players.get(i).setNTroops(j);
    }

    public List getPlayers() {
        return this.players;
    }

    //Esse metodo foi criada apenas para testes 
    //porque o singleton está causando conflitos entre os testes.
    public static void clearStateForTesting() {
        INSTANCE = null;
    }
    
    public void addTroops(int id, int nTroops){
        board.getTerritory(id).addTroops(nTroops);
    }
    
    public Territory[] battle(Territory att, int nTroops,  Territory def){
        Battle b = new Battle(att, def);
        Territory[] winners = b.attack(nTroops);
        return winners;
    }
}
