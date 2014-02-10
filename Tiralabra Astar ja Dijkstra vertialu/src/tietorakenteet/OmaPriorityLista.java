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
public class OmaPriorityLista {
    private LinkedNode head;
    private LinkedNode last;
    private LinkedNode apuhead=null;
    private int size=0;

    public OmaPriorityLista(LinkedNode head) {
        this.head = head;
    }
    
    public Node remove(){
        if(size>0){
            size-=1;
        }
        Node apu=head.getData();
        head=apuhead;
        apuhead=apuhead.getNext();
        return apu;
    }
    
    public void add(){
        
    }
    
    public void clear(){
        head=null;
    }
}
