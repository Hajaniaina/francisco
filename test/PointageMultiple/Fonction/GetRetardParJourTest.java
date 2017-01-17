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
public class GetRetardParJourTest {
    
    public GetRetardParJourTest() {
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
     * Test of retardParJour method, of class GetRetardParJour.
     */
    @Test
    public void testRetardParJour() {
        System.out.println("retardParJour");
        int Matricule = 0;
        Date d = null;
        GetRetardParJour instance = new GetRetardParJour();
        Object[][] expResult = null;
        Object[][] result = instance.retardParJour(Matricule, d);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
