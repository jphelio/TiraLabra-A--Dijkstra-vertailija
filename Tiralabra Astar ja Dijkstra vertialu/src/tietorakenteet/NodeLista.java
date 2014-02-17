/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tietorakenteet;

import java.util.Iterator;
import verkko.Node;

/**
 * Oma tehty suppea ArrayList ohjelman tarvitsemilla toiminnoilla, suoaan Node-tyyppiä, jne
 * 
 * @author Juhani Heliö
 */
public class NodeLista implements Iterable<Node>{
    private Node[] lista;
    private final int LISAYS=100;
    private final int DEFAULT_PITUUS=20;
    private int index;
    private int montakoArvoa; 

    public NodeLista() {
        lista=new Node[DEFAULT_PITUUS];
        index=0;
        montakoArvoa=0;
    }

    public void setMontakoArvoa(int montakoArvoa) {
        this.montakoArvoa = montakoArvoa;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setLista(Node[] lista) {
        this.lista = lista;
    }

    public int getLISAYS() {
        return LISAYS;
    }

    public int getDEFAULT_PITUUS() {
        return DEFAULT_PITUUS;
    }

    public int getIndex() {
        return index;
    }

    public int getMontakoArvoa() {
        return montakoArvoa;
    }
    
    public void add(Node n){
        montakoArvoa++;
        if(index<lista.length){
            lista[index]=n;
            index++;
        }
        else{
            listanPidennys(lista);
            add(n);
        }
    }
    
    public void listanPidennys(Node[] lista){
        Node[] apulista=new Node[lista.length+LISAYS];
            for(int i=0;i<this.lista.length;i++){
                apulista[i]=this.lista[i];
            }
            this.lista=apulista;
    }
    
    public boolean contains(Node n){
        if(montakoArvoa!=0){
            for(int i=(lista.length-1); i>=0 ;i--){
                if(n.equals(lista[i])){
                    return true;
                }
            }
        }
        return false;
    }
    
    public Node get(int i){
        return lista[i];
    }
    
    public void clear(){
        lista=new Node[DEFAULT_PITUUS];
    }
    
    public Node[] getLista(){
        return lista;
    }
    
    public int size(){
        return montakoArvoa;
    }
    
    public boolean isEmpty(){
        if(montakoArvoa==0){
            return true;
        }
        return false;
    }
    
    public boolean remove(Node n){
        int apu=0;
        boolean loytyi=false;
        if(montakoArvoa!=0){
            montakoArvoa--;
            for(int i=0;i<montakoArvoa;i++){
                if(lista[i].equals(n)){
                    lista[i]=null;
                    loytyi=true;
                }
                apu=i;
                i+=lista.length;
            }
            for(int i=apu;i<lista.length-1;i++){
                lista[i]=lista[i+1];
            }
        }
        return loytyi;
    }

    @Override
    public Iterator<Node> iterator() {
        Iterator<Node> apu=new Iterator<Node>() {
            
            Node[] apulista=lista;
            
            
            @Override
            public boolean hasNext() {
                if(next()!=null){
                    return true;
                }
                return false;
            }

            @Override
            public Node next() {
                Node n=lista[0];
                remove();
                return n;
            }

            @Override
            public void remove() {
                for(int i=0;i<lista.length-1;i++){
                    lista[i]=lista[i+1];
                }
                lista[lista.length-1]=null;
            }
        };
        return apu;
    }

}
