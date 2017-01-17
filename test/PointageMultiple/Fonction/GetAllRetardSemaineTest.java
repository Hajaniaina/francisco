/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PointageMultiple.Fonction;

import java.sql.Date;
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
public class GetAllRetardSemaineTest {
    
    public GetAllRetardSemaineTest() {
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
     * Test of listeRetard method, of class GetAllRetardSemaine.
     */
    @Test
    public void testListeRetard() {
        System.out.println("listeRetard");
        int[] listeMatricule = null;
        Date d = null;
        GetAllRetardSemaine instance = new GetAllRetardSemaine();
        Object[] expResult = null;
        Object[] result = instance.listeRetard(listeMatricule, d);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRetardUnEmpSemaine method, of class GetAllRetardSemaine.
     */
    @Test
    public void testGetRetardUnEmpSemaine() {
        System.out.println("getRetardUnEmpSemaine");
        Date d = null;
        int matricule = 0;
        GetAllRetardSemaine instance = new GetAllRetardSemaine();
        int expResult = 0;
        int result = instance.getRetardUnEmpSemaine(d, matricule);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
