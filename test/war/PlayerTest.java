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
           this. players[i] = new Player("P"+i.toString(), "A"+i.toString(), i);
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
            String expResult = "P"+i.toString();
            String result = instance.getName();
            assertEquals(expResult, result);
        }
        fail("Fail to get name player name");
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
     * Test of chooseObjective method, of class Player.
     */
    //@Test
    public void testChooseObjective() {
        System.out.println("chooseObjective");
        Player instance = null;
        instance.chooseObjective();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distributeTroops method, of class Player.
     */
    //@Test
    public void testDistributeTroops() {
        System.out.println("distributeTroops");
        Territory t = null;
        int n = 0;
        Player instance = null;
        instance.distributeTroops(t, n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }    
}
