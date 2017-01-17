/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonction;

import mapping.ListePaie;
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
public class FonctionListePaieTest {
    
    public FonctionListePaieTest() {
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
     * Test of getListePaieDesEmploye method, of class FonctionListePaie.
     */
    @Test
    public void testGetListePaieDesEmploye() throws Exception {
        System.out.println("getListePaieDesEmploye");
        int moi = 0;
        int annee = 0;
        FonctionListePaie instance = new FonctionListePaie();
        ListePaie[] expResult = null;
        ListePaie[] result = instance.getListePaieDesEmploye(moi, annee);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculResteApayer method, of class FonctionListePaie.
     */
    @Test
    public void testCalculResteApayer() {
        System.out.println("calculResteApayer");
        double sommeGain = 0.0;
        double sommeretenu = 0.0;
        FonctionListePaie instance = new FonctionListePaie();
        double expResult = 0.0;
        double result = instance.calculResteApayer(sommeGain, sommeretenu);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matricul method, of class FonctionListePaie.
     */
    @Test
    public void testMatricul() throws Exception {
        System.out.println("matricul");
        int matricul = 0;
        int moi = 0;
        int annee = 0;
        FonctionListePaie instance = new FonctionListePaie();
        int expResult = 0;
        int result = instance.matricul(matricul, moi, annee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
