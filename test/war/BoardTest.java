/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package war;

import java.io.IOException;
import java.lang.reflect.Array;
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
import war.Board;

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
            
            
            Territory t1 = new Territory("t1", null, 0);
            Territory t2 = new Territory("t2", null, 0);
            Territory t3 = new Territory("t3", null, 0);
            
            Territory n1 = new Territory("n1", null, 0);
            Territory n2 = new Territory("n2", null, 0);
            Territory n3 = new Territory("n3", null, 0);
            
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
           
            System.out.println("Do board");
            System.out.println(board.continents.get(0).name);
            for(Territory territory : board.continents.get(0).territories){
                System.out.println(territory.getName());
            }
            
            System.out.println("Daqui");
            System.out.println(continentsList.get(0).name);
            for(Territory territory : continentsList.get(0).territories){
                System.out.println(territory.getName());
            }
            
            assertEquals(board.continents, continentsList);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        
        
    }
}

