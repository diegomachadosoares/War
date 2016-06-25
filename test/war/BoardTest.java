package war;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public BoardTest() {
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

    @Test
    public void testIfCreatedAllContinents(){
        try {
            Board board = new Board("territorios.txt", "vizinhos.txt");
            
            assertEquals(board.continents.size(), 6);
        } catch (IOException ex) {
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testIfCreatedAllTerritories() {
        try {
            Board board = new Board("territorios.txt", "vizinhos.txt");

            int numberOfTerritories = 0;
            
            for(Continent c : board.continents){
                numberOfTerritories += c.getTerritories().size();
            }
            assertEquals(numberOfTerritories, 42);
        } catch (IOException ex) {
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
