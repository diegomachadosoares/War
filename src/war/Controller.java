package war;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author diegomachado
 */
public class Controller {
    
    private static Controller INSTANCE;

    private static void initializeInstance() {
        if(INSTANCE == null){
            INSTANCE = new Controller();
        }
    }
    private Board board;
    private String contFile = "data/continent.txt";
    private String terrFile = "data/territories.txt";
    private String neighFile = "data/neighbors.txt";
    
    private Controller() {
        try{
            this.board = new Board(contFile, terrFile, neighFile);
        } catch (FileNotFoundException e){
        } catch (IOException io){
        }
    }
    
    public static Controller getInstance() {
        if(INSTANCE == null){
            initializeInstance();
        }
        return INSTANCE;
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
}
