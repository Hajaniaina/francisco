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
public class ComparaisonEMpoyeTest {
    
    public ComparaisonEMpoyeTest() {
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
     * Test of getNomNouv method, of class ComparaisonEMpoye.
     */
    @Test
    public void testGetNomNouv() {
        System.out.println("getNomNouv");
        ComparaisonEMpoye instance = new ComparaisonEMpoye();
        String expResult = "";
        String result = instance.getNomNouv();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomNouv method, of class ComparaisonEMpoye.
     */
    @Test
    public void testSetNomNouv() {
        System.out.println("setNomNouv");
        String nomNouv = "";
        ComparaisonEMpoye instance = new ComparaisonEMpoye();
        instance.setNomNouv(nomNouv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareEmp method, of class ComparaisonEMpoye.
     */
    @Test
    public void testCompareEmp() throws Exception {
        System.out.println("compareEmp");
        String[] listeNom = null;
        ComparaisonEMpoye instance = new ComparaisonEMpoye();
        instance.compareEmp(listeNom);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
