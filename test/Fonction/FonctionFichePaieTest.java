/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonction;

import mapping.FichePaie;
import mapping.Personnel;
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
public class FonctionFichePaieTest {
    
    public FonctionFichePaieTest() {
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
     * Test of ficheDePaie method, of class FonctionFichePaie.
     */
    @Test
    public void testFicheDePaie() throws Exception {
        System.out.println("ficheDePaie");
        Personnel p = null;
        int moi = 0;
        int annee = 0;
        FonctionFichePaie instance = new FonctionFichePaie();
        FichePaie expResult = null;
        FichePaie result = instance.ficheDePaie(p, moi, annee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
