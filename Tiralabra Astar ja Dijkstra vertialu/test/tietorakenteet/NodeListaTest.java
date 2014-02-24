/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tietorakenteet;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import verkko.Node;

/**
 *
 * @author Vesihiisi
 */
public class NodeListaTest {
    
    private NodeLista l;
    private Node n;
    
    public NodeListaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        l=new NodeLista();
        n=new Node(0,0);
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of add method, of class NodeLista.
     */
    @Test
    public void testAdd() {
        l.add(n);
        assertTrue(l.contains(n));
        assertTrue(l.get(0).equals(n));
        assertTrue(l.size()==1);
    }

    /**
     * Test of listanPidennys method, of class NodeLista.
     */
    @Test
    public void testListanPidennys() {
        for(int i=0;i<21;i++){
            l.add(new Node(i,i));
        }
        assertTrue(l.size()==21);
    }

    /**
     * Test of contains method, of class NodeLista.
     */
    @Test
    public void testContains() {
        l.add(n);
        assertTrue(l.contains(n));
    }

    /**
     * Test of get method, of class NodeLista.
     */
    @Test
    public void testGet() {
        l.add(n);
        assertTrue(l.get(0).equals(n));
    }

    /**
     * Test of clear method, of class NodeLista.
     */
    @Test
    public void testClear() {
        for(int i=0;i<21;i++){
            l.add(new Node(i,i));
        }
        l=new NodeLista();
        assertTrue(l.size()==0);
    }

    /**
     * Test of size method, of class NodeLista.
     */
    @Test
    public void testSize() {
        for(int i=0;i<21;i++){
            l.add(new Node(i,i));
        }
        assertTrue(l.size()==21);
    }

    /**
     * Test of isEmpty method, of class NodeLista.
     */
    @Test
    public void testIsEmpty() {
        NodeLista instance = new NodeLista();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of remove method, of class NodeLista.
     */
    @Test
    public void testRemove_int() {
        l.add(n);
        l.remove(n);
        assertTrue(l.isEmpty());
    }

    /**
     * Test of remove method, of class NodeLista.
     */
    @Test
    public void testRemove_Node() {
        l.add(n);
        l.remove(0);
        assertTrue(l.isEmpty());
    }    
}
