/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class SplitTest {
    
    public SplitTest() {
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
     * Test of decoupe method, of class Split.
     */
    @Test
    public void testDecoupe() {
        System.out.println("decoupe");
        String ligneEntree = "";
        String separateur = "";
        Split instance = new Split();
        String[] expResult = null;
        String[] result = instance.decoupe(ligneEntree, separateur);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SplitDouble method, of class Split.
     */
    @Test
    public void testSplitDouble() {
        System.out.println("SplitDouble");
        String chaine = "";
        String sep1 = "";
        String sep2 = "";
        Split instance = new Split();
        String[][] expResult = null;
        String[][] result = instance.SplitDouble(chaine, sep1, sep2);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
