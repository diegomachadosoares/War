/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package war;

import java.util.List;
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
public class MatchTest {
    
    public MatchTest() {
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


    /**
     * Test of exchangeCards method, of class Match.
     */
    @Test
    public void testExchangeEqualCards() {
        //Test if all exchange when all cards are equal
        
        Card c1 = new Card(new Territory("Territory1", null, 0), "Square");
        Card c2 = new Card(new Territory("Territory2", null, 0), "Square");
        Card c3 = new Card(new Territory("Territory3", null, 0), "Square");
        
        Match m = new Match();
        
        int numberOfTroops = m.exchangeCards(c1, c2, c3);
        
        assertEquals(4, numberOfTroops);
        
    }
    
    @Test
    public void testExchangeDifferentCards() {
        Card c1 = new Card(new Territory("Territory1", null, 0), "Square");
        Card c2 = new Card(new Territory("Territory2", null, 0), "Triangle");
        Card c3 = new Card(new Territory("Territory3", null, 0), "Circle");
        
        Match m = new Match();
        
        int numberOfTroops = m.exchangeCards(c1, c2, c3);
        
        assertEquals(4, numberOfTroops);
    }
    
    @Test
    public void testExchangeIncompleteSetCards() {
        Card c1 = new Card(new Territory("Territory1", null, 0), "Square");
        Card c2 = new Card(new Territory("Territory2", null, 0), "Triangle");
        Card c3 = new Card(new Territory("Territory3", null, 0), "Square");
        
        Match m = new Match();
        
        int numberOfTroops = m.exchangeCards(c1, c2, c3);
        
        
        assertEquals(0, numberOfTroops);
    }
    
    @Test
    public void testSerieOfExchanges() {
        Card c1 = new Card(new Territory("Territory1", null, 0), "Square");
        Card c2 = new Card(new Territory("Territory2", null, 0), "Triangle");
        Card c3 = new Card(new Territory("Territory3", null, 0), "Circle");
        
        Match m = new Match();
        
        int[] expectedNumberOfTroops = {4,6,8};
        
        int[] numberOfTroops = new int[3];
        numberOfTroops[0] = m.exchangeCards(c1, c2, c3);
        numberOfTroops[1] = m.exchangeCards(c1, c2, c3);
        numberOfTroops[2] = m.exchangeCards(c1, c2, c3);
        
        assertArrayEquals(expectedNumberOfTroops, numberOfTroops);
    }
}

