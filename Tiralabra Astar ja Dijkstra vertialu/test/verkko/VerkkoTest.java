/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verkko;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vesihiisi
 */
public class VerkkoTest {
    
    public VerkkoTest() {
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
     * Test of setMaaliNode method, of class Verkko.
     */
    @Test
    public void testSetMaaliNode() {
        System.out.println("setMaaliNode");
        int maaliNodeX = 0;
        int maaliNodeY = 0;
        Verkko instance = null;
        instance.setMaaliNode(maaliNodeX, maaliNodeY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTila method, of class Verkko.
     */
    @Test
    public void testSetTila() {
        System.out.println("setTila");
        int x = 0;
        int y = 0;
        int tila = 0;
        Verkko instance = null;
        instance.setTila(x, y, tila);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaaliNodeX method, of class Verkko.
     */
    @Test
    public void testGetMaaliNodeX() {
        System.out.println("getMaaliNodeX");
        Verkko instance = null;
        int expResult = 0;
        int result = instance.getMaaliNodeX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaaliNodeY method, of class Verkko.
     */
    @Test
    public void testGetMaaliNodeY() {
        System.out.println("getMaaliNodeY");
        Verkko instance = null;
        int expResult = 0;
        int result = instance.getMaaliNodeY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaaliNode method, of class Verkko.
     */
    @Test
    public void testGetMaaliNode() {
        System.out.println("getMaaliNode");
        Verkko instance = null;
        Node expResult = null;
        Node result = instance.getMaaliNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlkuNode method, of class Verkko.
     */
    @Test
    public void testSetAlkuNode() {
        System.out.println("setAlkuNode");
        int alkuNodeX = 0;
        int alkuNodeY = 0;
        Verkko instance = null;
        instance.setAlkuNode(alkuNodeX, alkuNodeY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlkuNodeX method, of class Verkko.
     */
    @Test
    public void testGetAlkuNodeX() {
        System.out.println("getAlkuNodeX");
        Verkko instance = null;
        int expResult = 0;
        int result = instance.getAlkuNodeX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlkuNodeY method, of class Verkko.
     */
    @Test
    public void testGetAlkuNodeY() {
        System.out.println("getAlkuNodeY");
        Verkko instance = null;
        int expResult = 0;
        int result = instance.getAlkuNodeY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlkuNode method, of class Verkko.
     */
    @Test
    public void testGetAlkuNode() {
        System.out.println("getAlkuNode");
        Verkko instance = null;
        Node expResult = null;
        Node result = instance.getAlkuNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVerkko method, of class Verkko.
     */
    @Test
    public void testGetVerkko() {
        System.out.println("getVerkko");
        Verkko instance = null;
        int[][] expResult = null;
        int[][] result = instance.getVerkko();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVerkko method, of class Verkko.
     */
    @Test
    public void testSetVerkko() {
        System.out.println("setVerkko");
        int[][] verkko = null;
        Verkko instance = null;
        instance.setVerkko(verkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNodeVerkko method, of class Verkko.
     */
    @Test
    public void testGetNodeVerkko() {
        System.out.println("getNodeVerkko");
        Verkko instance = null;
        Node[][] expResult = null;
        Node[][] result = instance.getNodeVerkko();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNodeVerkko method, of class Verkko.
     */
    @Test
    public void testSetNodeVerkko() {
        System.out.println("setNodeVerkko");
        Node[][] nodeVerkko = null;
        Verkko instance = null;
        instance.setNodeVerkko(nodeVerkko);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
