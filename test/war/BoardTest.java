package war;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    public void testGenerateContinentsOneContinent() {
        try {
            Board board = new Board("territories_test.txt", "neighbors_test.txt");
            
            Territory t1 = new Territory("t1", null, 1);
            Territory t2 = new Territory("t2", null, 2);
            Territory t3 = new Territory("t3", null, 3);
            
            Territory n1 = new Territory("t2", null, 4);
            Territory n2 = new Territory("t3", null, 5);
            Territory n3 = new Territory("t1", null, 6);
            
            n1.addNeighbor(t1);
            n2.addNeighbor(t2);
            n3.addNeighbor(t3);
            
            t1.addNeighbor(n1);
            t2.addNeighbor(n2);
            t3.addNeighbor(n3);
            
            
            
            List<Territory> territoryList = new ArrayList<>();
            
            territoryList.add(t1);
            territoryList.add(t2);
            territoryList.add(t3);
            
            Continent c1 = new Continent("c1", territoryList);
            
            List<Continent> continentsList = new ArrayList<>();
            
            continentsList.add(c1);
            
            System.out.println("Board");
            for(Territory t : board.continents.get(0).getTerritories()){
                System.out.println(t.getName()+" "+t.getNeighbors().get(0).getName());
            }
            
            System.out.println("Aqui");
            for(Territory t : continentsList.get(0).getTerritories()){
                System.out.println(t.getName()+" "+t.getNeighbors().get(0).getName());
            }
            
            assertEquals(board.continents, continentsList);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }
}

