/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package war;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author AleGomes
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        Controller.clearStateForTesting();
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of getTerritories method, of class Controller.
     */
    //@Test
    public void testGetTerritories() {
        System.out.println("getTerritories");
        Controller instance = Controller.getInstance();
        Map expResult = null;
        Map result = instance.getTerritories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContinents method, of class Controller.
     */
    //@Test
    public void testGetContinents() {
        System.out.println("getContinents");
        Controller instance = null;
        Map expResult = null;
        Map result = instance.getContinents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNeighborhoods method, of class Controller.
     */
    //@Test
    public void testGetNeighborhoods() {
        System.out.println("getNeighborhoods");
        Controller instance = null;
        Map expResult = null;
        Map result = instance.getNeighborhoods();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerById method, of class Controller.
     */
    //@Test
    public void testGetPlayerById() {
        System.out.println("getPlayerById");
        Integer i = null;
        Controller instance = null;
        Player expResult = null;
        Player result = instance.getPlayerById(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlayerById method, of class Controller.
     */
    //@Test
    public void testSetPlayerById() {
        System.out.println("setPlayerById");
        Integer i = null;
        Player p = null;
        Controller instance = null;
        instance.setPlayerById(i, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTerritory method, of class Controller.
     */
//    @Test
    public void testGetTerritory() {
        System.out.println("getTerritory");
        Integer i = null;
        Controller instance = null;
        Territory expResult = null;
        Territory result = instance.getTerritory(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContinent method, of class Controller.
     */
//    @Test
    public void testGetContinent() {
        System.out.println("getContinent");
        Integer i = null;
        Controller instance = null;
        Continent expResult = null;
        Continent result = instance.getContinent(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNeighborhood method, of class Controller.
     */
    //@Test
    public void testGetNeighborhood() {
        System.out.println("getNeighborhood");
        Integer i = null;
        Controller instance = null;
        List<Territory> expResult = null;
        List<Territory> result = instance.getNeighborhood(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGameStarted method, of class Controller.
     */
    @Test
    public void testSetGameStarted() {
    
        System.out.println("setGameStarted");
        Controller instance = Controller.getInstance();
        instance.setGameStarted();
        boolean expected = true;
        
        assertEquals(expected, instance.getGameStarted());
    }

    /**
     * Test of getGameStarted method, of class Controller.
     */
    @Test
    public void testGetGameStarted() {
        System.out.println("getGameStarted");
        Controller instance = Controller.getInstance();
        boolean expResult = true;
        
        instance.setGameStarted();
        
        boolean result = instance.getGameStarted();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerTroops method, of class Controller.
     */
    //@Test
    public void testGetPlayerTroops() {
        
    }

    /**
     * Test of getState method, of class Controller.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Controller instance = Controller.getInstance();
        int expResult = 0;
        int result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of createHumanPlayer method, of class Controller.
     */
    @Test
    public void testCreateHumanPlayer() {
        System.out.println("createHumanPlayer");

        String name = "P1";
        String color = "Azul";
        Player p = new Player(name, color, 0);
        
        Controller instance = Controller.getInstance();
        instance.createHumanPlayer(name, color);

        Player otherPlayer = instance.getPlayerById(0);
        
        assertEquals(p, otherPlayer);
    }

    /**
     * Test of createAIPlayers method, of class Controller.
     */
    @Test
    public void testCreateAIPlayers() {
        Controller.clearStateForTesting();
        Controller controller  = Controller.getInstance();
        System.out.println("createAIPlayers");
        int i = 3;
        
        controller.createAIPlayers(i);
        assertEquals(3, controller.getPlayers().size());
    }

    /**
     * Test of startMatch method, of class Controller.
     */
    @Test
    public void testStartMatch() {
    /*        
    public void startMatch() {
        match.setPlayers(this.players);
        match.distributeObjectives(objFile);
        match.distributeTerritories();
        this.gainTroops();
        // First round - Fotification only
        for (int i = 1; i < players.size(); i++) {
            Player p = this.players.get(i);
            distributeIATroops(p);         }     }     */
        System.out.println("startMatch");
        Controller instance = Controller.getInstance();
        
        instance.createHumanPlayer("AAA", "Azul");
        instance.createAIPlayers(3);
        instance.startMatch();
        
        for (int i = 0; i < instance.getPlayers().size(); i++) {
            
        }
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeState method, of class Controller.
     */
    @Test
    public void testChangeStateWithStateZero() {
        System.out.println("testChangeStateWithStateZero");
        Controller instance = Controller.getInstance();
        int expResult = 1;
        int result = instance.changeState();
        assertEquals(expResult, result);
    }

    @Test
    public void testChangeStateWithStateOne() {
        
        System.out.println("testChangeStateWithStateOne");
        Controller instance = Controller.getInstance();
        int expResult = 2;
        instance.changeState();
        int result = instance.changeState();
        
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testChangeStateWithStateTwo() {
        
        /*
        if (this.state == 2) {
            this.state = 0;
        }
        this.state++;
        return this.state;
        */
        
        System.out.println("testChangeStateWithStateTwo");
        Controller instance = Controller.getInstance();
        int expResult = 0;
        int result;
        
        result = instance.changeState();
        result = instance.changeState();
        result = instance.changeState();
        
        assertEquals(expResult, result);
    }
    
    @Test
    
    public void testElegerAlvos(){
        Controller instance = Controller.getInstance();
        
        
        
        /*
        public List<Territory> elegerAlvos(int indice) {
        List<Territory> neighbors = getNeighborhood(indice);
        ArrayList<Territory> target = new ArrayList();
        for (int i = 0; i < neighbors.size(); i++) {
            if (neighbors.get(i).getOwner().getId() == getTerritory(indice).getID()) {
                target.add(getTerritory(indice));
            }
        }
        return target;
    }
                */
        
        
        
    }
}
