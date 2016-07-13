package war;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author AleGomes
 */
public class BoardTest {

    private Board board;

    public BoardTest() {
        try {
            this.board = new Board("./data/continents.txt", "./data/territories.txt", "./data/neighborhood.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }
//
//    @Test
//    public void testIfCreatedAllContinents(){
//        try {
//            Board board = new Board("territorios.txt", "vizinhos.txt");
//            
//            assertEquals(board.continents.size(), 6);
//        } catch (IOException ex) {
//            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    @Test
//    public void testIfCreatedAllTerritories() {
//        try {
//            Board board = new Board("territorios.txt", "vizinhos.txt");
//
//            int numberOfTerritories = 0;
//            
//            for(Continent c : board.continents){
//                numberOfTerritories += c.getTerritories().size();
//            }
//            assertEquals(numberOfTerritories, 42);
//        } catch (IOException ex) {
//            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Test
    public void testTerritoriesCreation() throws IOException {
        System.out.println("\n$--- Beginning Territory creation tests... ---$\n");
        Map territories = this.board.getTerritories();
        int i = 0;
        Territory t;
        while (!territories.isEmpty()) {
            t = (Territory) territories.get(i);
            System.out.println("\t" +t.getID() + " " + t.getName());
            territories.remove(i);
            i++;
        }
        System.out.println("\n$--- End of Territory creation tests... ---$\n");
    }

    @Test
    public void testContinentsCreation() throws IOException {
        System.out.println("\n$--- Beginning Continent creation tests... ---$\n");
        Map continentMap = this.board.getContinents();
        int i = 0;
        Continent cont;
        List<Territory> t;
        while (!continentMap.isEmpty()) {
            cont = (Continent) continentMap.get(i);
            System.out.println(cont.getName());
            t = cont.getTerritories();
            continentMap.remove(i);
            i++;
        }
        System.out.println("\n$--- End of Continent creation tests... ---$\n");
    }
    
//    @Test
//    public void testContinentTerritoryCreation(){
//        Map contMap = board.getContinents();
//        Continent c;
//        List<Territory> t;
//        int i = 0;
//        int j = 0;
//        while(!contMap.isEmpty()){
//            c = (Continent)contMap.get(i);
//            t = c.getTerritories();
//            while(!t.isEmpty()){
//                System.out.println(t.get(j));
//                t.remove(j);
//                j++;
//            }
//            System.out.println(c.getTerritories());
//            contMap.remove(i);
//            i++;
//        }
//    }
}
