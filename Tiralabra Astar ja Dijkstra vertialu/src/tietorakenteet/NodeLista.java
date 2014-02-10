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

    public NodeLista() {
        lista=new Node[DEFAULT_PITUUS];
        index=0;
    }
    
    public void add(Node n){
        if(index<lista.length){
            lista[index]=n;
            index++;
        }
        else{
            Node[] apulista=new Node[lista.length+LISAYS];
            for(int i=0;i<lista.length;i++){
                apulista[i]=lista[i];
            }
            lista=apulista;
        }
    }
    
    public boolean contains(Node n){
        for(int i=(lista.length-1); i>=0 ;i--){
            if(n.equals(lista[i])){
                return true;
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
    
    public boolean remove(Node n){
        int apu=0;
        boolean loytyi=false;
        for(int i=0;i<lista.length;i++){
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
