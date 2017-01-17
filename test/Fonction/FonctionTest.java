/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fonction;

import java.sql.Date;
import java.util.List;
import mapping.Personnel;
import mapping.Pointage;
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
public class FonctionTest {
    
    public FonctionTest() {
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
     * Test of getAllEploye method, of class Fonction.
     */
    @Test
    public void testGetAllEploye() {
        System.out.println("getAllEploye");
        int moi = 0;
        int annee = 0;
        Fonction instance = new Fonction();
        Object[][] expResult = null;
        Object[][] result = instance.getAllEploye(moi, annee);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllJourFerier method, of class Fonction.
     */
    @Test
    public void testGetAllJourFerier() {
        System.out.println("getAllJourFerier");
        Date annee = null;
        Fonction instance = new Fonction();
        Object[][] expResult = null;
        Object[][] result = instance.getAllJourFerier(annee);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testeJourferier method, of class Fonction.
     */
    @Test
    public void testTesteJourferier() {
        System.out.println("testeJourferier");
        Date annee = null;
        Pointage p = null;
        Fonction instance = new Fonction();
        boolean expResult = false;
        boolean result = instance.testeJourferier(annee, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testeJourferier2 method, of class Fonction.
     */
    @Test
    public void testTesteJourferier2() {
        System.out.println("testeJourferier2");
        Date annee = null;
        Date d = null;
        Fonction instance = new Fonction();
        boolean expResult = false;
        boolean result = instance.testeJourferier2(annee, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testePointageRetourMemeJour method, of class Fonction.
     */
    @Test
    public void testTestePointageRetourMemeJour() {
        System.out.println("testePointageRetourMemeJour");
        Pointage p = null;
        Personnel per = null;
        Fonction instance = new Fonction();
        int expResult = 0;
        int result = instance.testePointageRetourMemeJour(p, per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus24Heure method, of class Fonction.
     */
    @Test
    public void testPlus24Heure() throws Exception {
        System.out.println("plus24Heure");
        Pointage p = null;
        Personnel per = null;
        Fonction instance = new Fonction();
        int expResult = 0;
        int result = instance.plus24Heure(p, per);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculTempsbs method, of class Fonction.
     */
    @Test
    public void testCalculTempsbs() {
        System.out.println("calculTempsbs");
        int tempPourCalculer = 0;
        Fonction instance = new Fonction();
        int expResult = 0;
        int result = instance.calculTempsbs(tempPourCalculer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of spliter method, of class Fonction.
     */
    @Test
    public void testSpliter() {
        System.out.println("spliter");
        String txt = "";
        String sep = "";
        Fonction instance = new Fonction();
        String[] expResult = null;
        String[] result = instance.spliter(txt, sep);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHEureSupJfetWeekEnd method, of class Fonction.
     */
    @Test
    public void testGetHEureSupJfetWeekEnd() throws Exception {
        System.out.println("getHEureSupJfetWeekEnd");
        Personnel perso = null;
        Pointage p = null;
        Fonction instance = new Fonction();
        int expResult = 0;
        int result = instance.getHEureSupJfetWeekEnd(perso, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insererGainRetenu method, of class Fonction.
     */
    @Test
    public void testInsererGainRetenu() throws Exception {
        System.out.println("insererGainRetenu");
        Pointage p = null;
        int CountnmbrePointagePresence = 0;
        String poste = "";
        int plus24 = 0;
        double temps = 0.0;
        Fonction instance = new Fonction();
        instance.insererGainRetenu(p, CountnmbrePointagePresence, poste, plus24, temps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertRetenuSiNonRetouravantRentreeNormal method, of class Fonction.
     */
    @Test
    public void testInsertRetenuSiNonRetouravantRentreeNormal() throws Exception {
        System.out.println("insertRetenuSiNonRetouravantRentreeNormal");
        Personnel p = null;
        Pointage point = null;
        Fonction instance = new Fonction();
        instance.insertRetenuSiNonRetouravantRentreeNormal(p, point);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listeDesDates method, of class Fonction.
     */
    @Test
    public void testListeDesDates() {
        System.out.println("listeDesDates");
        Date DateDebut = null;
        Date DateFin = null;
        List<Date> expResult = null;
        List<Date> result = Fonction.listeDesDates(DateDebut, DateFin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of permuter method, of class Fonction.
     */
    @Test
    public void testPermuter() {
        System.out.println("permuter");
        String[] chaine = null;
        Fonction instance = new Fonction();
        String expResult = "";
        String result = instance.permuter(chaine);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testeJourFerierOUWeekend method, of class Fonction.
     */
    @Test
    public void testTesteJourFerierOUWeekend() {
        System.out.println("testeJourFerierOUWeekend");
        Date d = null;
        Pointage p = null;
        Fonction instance = new Fonction();
        boolean expResult = false;
        boolean result = instance.testeJourFerierOUWeekend(d, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testeJourFerierOUWeekend2 method, of class Fonction.
     */
    @Test
    public void testTesteJourFerierOUWeekend2() {
        System.out.println("testeJourFerierOUWeekend2");
        Date d = null;
        Pointage p = null;
        Fonction instance = new Fonction();
        boolean expResult = false;
        boolean result = instance.testeJourFerierOUWeekend2(d, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
