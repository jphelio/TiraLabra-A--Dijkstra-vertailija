/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tietorakenteet;

import verkko.Node;

/**
 * Oma PriorityQueuen tapainen jono
 * @author Juhani Heliö
 */
public class OmaPriorityLista {
    private LinkedNode head;
    private LinkedNode apuhead=null;
    private LinkedNode pointer;
    private int size=0;

    public OmaPriorityLista(LinkedNode head) {
        this.head = head;
        pointer=head;
    }
    public OmaPriorityLista(){
        head=null;
        pointer=head;
    }
    
    public Node remove(){
        if(size>0){
            size--;
        }
        Node apu=head.getData();
        apuhead=head;
        apuhead=apuhead.getNext();
        head.setNext(null);
        head=apuhead;
        apuhead=null;
        return apu;
    }
    
    public void add(Node n){
        pointer=head;
        if(head==null){
            head=new LinkedNode(null, n);
            size++;
            return;
        }
        if(size==1){
            LinkedNode apu=new LinkedNode(null, n);
            if(n.compareTo(head.getData())>=0){
                head.setNext(apu);
            }
            else{
                apu.setNext(head);
            }
            size++;
            return;
        }
        while(pointer!=null){
            if(pointer.getNext()==null){
                pointer.setNext(new LinkedNode(null, n));
                size++;
                return;
            }
            else if(n.compareTo(pointer.getData())<0){
                head=new LinkedNode(pointer, n);
                size++;
                return;
            }
            else if(n.compareTo(pointer.getNext().getData())<=0){
                LinkedNode apu=new LinkedNode(pointer.getNext(), n);
                pointer.setNext(apu);
                size++;
                return;
            }
            
            else{
                pointer=pointer.getNext();
            }
        }
    }
    
    public boolean contains(Node n){
        while(pointer!=null){
            if(n.equals(pointer.getData())){
                pointer=head;
                return true;
            }
            else{
                pointer=pointer.getNext();
            }
        }
        pointer=head;
        return false;
    }
    
    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }
    
    public void clear(){
        head=null;
    }
}
