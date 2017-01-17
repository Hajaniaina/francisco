/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonction;

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
public class DemandeAvanceTest {
    
    public DemandeAvanceTest() {
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
     * Test of concatenerDeuString method, of class DemandeAvance.
     */
    @Test
    public void testConcatenerDeuString() {
        System.out.println("concatenerDeuString");
        String[] liste = null;
        int[] nombr = null;
        DemandeAvance instance = new DemandeAvance();
        String expResult = "";
        String result = instance.concatenerDeuString(liste, nombr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decoupe method, of class DemandeAvance.
     */
    @Test
    public void testDecoupe() {
        System.out.println("decoupe");
        String ligneEntree = "";
        String separateur = "";
        DemandeAvance instance = new DemandeAvance();
        String[] expResult = null;
        String[] result = instance.decoupe(ligneEntree, separateur);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SplitDouble method, of class DemandeAvance.
     */
    @Test
    public void testSplitDouble() {
        System.out.println("SplitDouble");
        String chaine = "";
        String sep1 = "";
        String sep2 = "";
        DemandeAvance instance = new DemandeAvance();
        String[][] expResult = null;
        String[][] result = instance.SplitDouble(chaine, sep1, sep2);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculTierSalaire method, of class DemandeAvance.
     */
    @Test
    public void testCalculTierSalaire() {
        System.out.println("calculTierSalaire");
        double salaire = 0.0;
        DemandeAvance instance = new DemandeAvance();
        double expResult = 0.0;
        double result = instance.calculTierSalaire(salaire);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
