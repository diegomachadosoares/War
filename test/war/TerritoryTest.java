/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.util.ArrayList;
import java.util.Collections;
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
public class TerritoryTest {

    public TerritoryTest() {
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
     * Test of equals method, of class Territory.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Territory obj = new Territory("t1", new Player("Joao", "Blue", 1), 0);
        Territory instance = new Territory("t1", new Player("Joao", "Blue", 1), 0);

        assertEquals(obj, instance);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testEqualsToItself() {
        //Territory obj = new Territory("t1", new Player("Joao", "Blue",1), 0);
        Territory instance = new Territory("t1", new Player("Joao", "Blue", 1), 0);

        boolean expected = true;
        boolean res = instance.equals(instance);
        assertEquals(expected, res);
    }

    @Test
    public void testEqualsToNull() {
        //Territory obj = new Territory("t1", new Player("Joao", "Blue",1), 0);
        Territory instance = new Territory("t1", new Player("Joao", "Blue", 1), 0);

        boolean expected = false;
        boolean res = instance.equals(null);
        assertEquals(expected, res);
    }

    @Test
    public void testAddNeighbors() {
        Territory obj = new Territory("t1", new Player("Joao", "Azul", 1), 0);

        Territory n1 = new Territory("n1", new Player("AAA", "Preto", 1), 0);
        Territory n2 = new Territory("n2", new Player("BBB", "Roxo", 1), 0);
        Territory n3 = new Territory("n3", new Player("CCC", "Vermelho", 1), 0);

        obj.addNeighbor(n1);

        assertEquals(obj.getNeighbors().size(), 1);
    }
    
    @Test
    public void testSubTroopsWithOneTroop(){
        Territory obj = new Territory("t1", new Player("Joao", "Azul", 1), 0);
        
        int expected = 1;
        int res = obj.subTroop();
        
        assertEquals(expected, res);
    }
    
    @Test
    public void testSubTroopsWithMoreThanOneTroop(){
        Territory obj = new Territory("t1", new Player("Joao", "Azul", 1), 0);
        
        int expected = 1;
        obj.addTroops(1);
        int res = obj.subTroop();
        
        assertEquals(expected, res);
    }
}
