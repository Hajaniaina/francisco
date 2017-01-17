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
public class VerificationSidembaucheTest {
    
    public VerificationSidembaucheTest() {
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
     * Test of listMatInDeb method, of class VerificationSidembauche.
     */
    @Test
    public void testListMatInDeb() throws Exception {
        System.out.println("listMatInDeb");
        int id = 0;
        VerificationSidembauche instance = new VerificationSidembauche();
        int expResult = 0;
        int result = instance.listMatInDeb(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
