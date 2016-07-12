package war;

import java.io.FileNotFoundException;
import java.io.IOException;

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
    
    public Territory getTerritory(int id){
        return board.getTerritory(id);
    }
}
