/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

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
public class calculRetardAbsSupplTest {
    
    public calculRetardAbsSupplTest() {
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
     * Test of calculRetard method, of class calculRetardAbsSuppl.
     */
    @Test
    public void testCalculRetard() {
        System.out.println("calculRetard");
        double salair = 0.0;
        int retard = 0;
        calculRetardAbsSuppl instance = new calculRetardAbsSuppl();
        double expResult = 0.0;
        double result = instance.calculRetard(salair, retard);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculAbs method, of class calculRetardAbsSuppl.
     */
    @Test
    public void testCalculAbs() {
        System.out.println("calculAbs");
        double salair = 0.0;
        int abs = 0;
        calculRetardAbsSuppl instance = new calculRetardAbsSuppl();
        double expResult = 0.0;
        double result = instance.calculAbs(salair, abs);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of calculSupplementaire method, of class calculRetardAbsSuppl.
     */
    @Test
    public void testCalculSupplementaire() {
        System.out.println("calculSupplementaire");
        double salair = 0.0;
        int hsup = 0;
        calculRetardAbsSuppl instance = new calculRetardAbsSuppl();
        double expResult = 0.0;
        double result = instance.calculSupplementaire(salair, hsup);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of calculSalaireHorraireMoyer method, of class calculRetardAbsSuppl.
     */
    @Test
    public void testCalculSalaireHorraireMoyer() {
        System.out.println("calculSalaireHorraireMoyer");
        double salaire = 0.0;
        calculRetardAbsSuppl instance = new calculRetardAbsSuppl();
        double expResult = 0.0;
        double result = instance.calculSalaireHorraireMoyer(salaire);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
