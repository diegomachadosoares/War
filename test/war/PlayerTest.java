package war;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diegomachado
 */
public class PlayerTest {

    private final int numPlayers;
    private final Player[] players;

    public PlayerTest() {
        this.numPlayers = 6;
        this.players = new Player[numPlayers];
        for (Integer i = 0; i < this.numPlayers; i++) {
            this.players[i] = new Player("P" + i, "A" + i, i);
        }
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        for (Integer i = 0; i < this.numPlayers; i++) {
            Player instance = players[i];
            String expResult = "P" + i;
            String result = instance.getName();
            assertEquals(expResult, result);
        }
        //fail("Fail to get name player name");
    }

    /**
     * Test of getColor method, of class Player.
     */
    //@Test
    public void testGetColor() {
        System.out.println("getColor");
        Player instance = null;
        String expResult = "";
        String result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distributeTroops method, of class Player.
     */
    @Test
    public void testDistributeTroops() {
        System.out.println("distributeTroops");
        Player owner = new Player("P1", "Azul", 1);
        Territory t1 = new Territory("Brazil", owner, 1);
        owner.addTerritory(t1);
        
        Player notOwner = new Player("P2", "Preto", 2);
        Territory t2 = new Territory("Alaska", notOwner, 2);
        notOwner.addTerritory(t2);
        
        //notOwner tentando distribuir tropas no territorio de owner vai dar false
        boolean result = notOwner.distributeTroops(t1, 5); 
        
        assertEquals(false, result);
    }

}
