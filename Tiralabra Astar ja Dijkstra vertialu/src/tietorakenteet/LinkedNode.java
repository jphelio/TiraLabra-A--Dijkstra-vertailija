/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tietorakenteet;

import verkko.Node;

/**
 *
 * @author Juhani Heliö
 */
public class LinkedNode {
    private LinkedNode next;
    private Node data;

    public LinkedNode(LinkedNode next, Node data) {
        this.next = next;
        this.data = data;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    public Node getData() {
        return data;
    }

    public void setData(Node data) {
        this.data = data;
    }
    
    
}
