/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tietorakenteet;

import verkko.Node;

/**
 * Itse tehty priorityQueue, joka perustuu minimikekoon. Suoraan node tyyppiä.
 * @author Juhani Heliö
 */
public class OmaPriorityMinHeap {
    private NodeLista heap;
    
    
    /**
     * luo uuden priorityqueuen, jonka keko on tyhjä
     */
    public OmaPriorityMinHeap(){
        heap=new NodeLista();
    }
    
    /**
     * lisää noden
     * @param node 
     */
    public void add(Node node){       
        heap.add(node);
        int paikka=heap.size()-1;
        if(heap.isEmpty()){
            heap.add(node);
            return;
        }
        while(paikka>=0&&paikka<heap.size()&&node.compareTo(heap.get(parent(paikka)))<0){
            swap(paikka, parent(paikka));
            paikka=parent(paikka);
        }
    }
    
    
    /**
     * poistaa keon ensimmäisen noden
     * @return 
     */
    public Node remove(){
        if(heap.isEmpty()){
            return null;
        }
        else{
            Node n=heap.get(0);
            heap.set(0, heap.get(heap.size()-1));
            heap.remove(heap.size()-1);
            heapify(0);
            return n;
        }
    }
    /**
     * palauttaa keon koon
     * @return 
     */
    public int size(){
        return heap.size();
    }
    
    public boolean isEmpty(){
        return heap.isEmpty();
    }
    /**
     * palauttaa true jos keossa on node n
     * @param n
     * @return 
     */
    public boolean contains(Node n){
        for(int i=0;i<heap.size();i++){
            if(heap.get(i).equals(n)){
                return true;
            }
        }
        return false;
        
    }
    public void clear(){
        heap=new NodeLista();
    }
    
    private int vasenL(int i){
        return 2*i+1;
    }
    
    private int oikeaL(int i){
        return 2*i+2;
    }
    
    private int parent(int i) {
        return (i-1)/2;
    }
    
    private void heapify(int i){
        int vasenLapsi=vasenL(i);
        int oikeaLapsi=oikeaL(i);
        int pienin;
        
        if(vasenLapsi>=0&&vasenLapsi<heap.size()&&heap.get(vasenLapsi).compareTo(heap.get(i))<0){
            pienin=vasenLapsi;
        }
        else{
            pienin=i;
        }
        if(oikeaLapsi>=0&&oikeaLapsi<=heap.size()-1&&heap.get(oikeaLapsi).compareTo(heap.get(pienin))<0){
            pienin=oikeaLapsi;
        }
        if(pienin!=i){
            swap(i, pienin);
            heapify(pienin);
        }
    }
    
    private void swap(int i, int j){
        Node n=heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, n);
    }
}
