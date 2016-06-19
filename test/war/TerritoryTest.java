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

        
        Territory obj = new Territory("t1", new Player("Joao", "Blue",1), 0);
        Territory instance = new Territory("t1", new Player("Joao", "Blue",1), 0);

        assertEquals(obj, instance);
        // TODO review the generated test code and remove the default call to fail.
    }
}

