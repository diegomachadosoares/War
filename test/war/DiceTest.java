/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

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
public class DiceTest {

    public DiceTest() {
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
    public void testDiceRange(){
        System.out.println("playDice");

        int[] results = new int[8];
        int result;
        for (int i = 0; i < 10000000; i++) {
            result = Dice.playDice();
            switch (result) {
                case 1:
                    results[1]++;
                    break;
                case 2:
                    results[2]++;
                    break;
                case 3:
                    results[3]++;
                    break;
                case 4:
                    results[4]++;
                    break;
                case 5:
                    results[5]++;
                    break;
                case 6:
                    results[6]++;
                    break;
                default:
                    if (result < 1) {
                        results[0]++;
                    }
                    if (result > 6) {
                        results[7]++;
                    }
            }
        }
        for (int i = 0; i< results.length; i++) {
            System.out.println(i+" "+results[i]);
        }
        System.out.println("End play dice");
        
        if(results[0] > 0 || results[7] > 0)
            fail("Number out of range.");
    }
}
