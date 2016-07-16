package war;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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

    @Test
    public void testTerritoriesCreation() throws IOException {
        System.out.println("\n$--- Beginning Territory creation tests... ---$\n");
        Map territories = this.board.getTerritories();
        int i = 0;
        Territory t;
        while (!territories.isEmpty()) {
            t = (Territory) territories.get(i);
            System.out.println("\t" + t.getID() + " " + t.getName());
            territories.remove(i);
            i++;
        }
        System.out.println("\n$--- End of Territory creation tests... ---$\n");
    }

    @Test
    public void testContinentsCreation() throws IOException {
        System.out.println("\n$--- Beginning Continent creation tests... ---$\n");
        Map continentMap = this.board.getContinents();
        Continent cont;
        List<Territory> t;
        for (int j = 0; j < continentMap.size(); j++) {
            cont = (Continent) continentMap.get(j);
            System.out.println("\nCONTINENTE: " + cont.getName() + "\n");
            testContinentTerritoryCreation(cont);
        }
        System.out.println("\n$--- End of Continent creation tests... ---$\n");
    }

    public void testContinentTerritoryCreation(Continent c) {
        List<Territory> t;
        t = c.getTerritories();
        for (int j = 0; j < t.size(); j++) {
            System.out.println(t.get(j).getName());
        }
    }
    
    @Test
    public void testTerritoriesDistribution(){
        List<Player> players = new LinkedList<>();
        players.add(new Player("AAA","Azul",0));
        players.add(new Player("BBB","Preto",1));
        players.add(new Player("CCC","Vermelho",2));
        this.board.distributeTerritories(players);
        
        for(Object t : this.board.getTerritories().values()){
            Territory tt = (Territory) t;
            if (tt.getOwner() == null)
                fail("Territory without owner.");
        }
        assertEquals(true, true);
    }
}
