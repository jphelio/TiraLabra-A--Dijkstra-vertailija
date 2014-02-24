/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tietorakenteet;

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
public class OmaPriorityMinHeapTest {
    
    private Node node;
    private OmaPriorityMinHeap instance;
    
    public OmaPriorityMinHeapTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        node = new Node(0, 0);
        instance = new OmaPriorityMinHeap();
        instance.add(node);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class OmaPriorityMinHeap.
     */
    @Test
    public void testAdd() {
        assertTrue(instance.contains(node));
        
    }

    /**
     * Test of remove method, of class OmaPriorityMinHeap.
     */
    @Test
    public void testRemove() {
        assertTrue(node.equals(instance.remove()));
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of size method, of class OmaPriorityMinHeap.
     */
    @Test
    public void testSize() {
        assertTrue(instance.size()==1);
    }

    /**
     * Test of isEmpty method, of class OmaPriorityMinHeap.
     */
    @Test
    public void testIsEmpty() {
        instance.remove();
        assertTrue(instance.isEmpty());
    }

    /**
     * Test of contains method, of class OmaPriorityMinHeap.
     */
    @Test
    public void testContains() {
        assertTrue(instance.contains(node));
    }

    /**
     * Test of clear method, of class OmaPriorityMinHeap.
     */
    @Test
    public void testClear() {
        instance.clear();
        assertTrue(instance.isEmpty());
    }
    
}
