/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmit;

import java.util.*;
import tietorakenteet.NodeLista;
import verkko.*;

/**
 *
 * @author Juhani Heliö
 */
public class Dijkstra {
    
    private Verkko v;
    
    private PriorityQueue<Node> nodeList;
    private NodeLista closedList;
    private NodeLista path;
    
    private int lyhyinPolku;    
    
    public Dijkstra(Verkko v){
        this.v=v;
        this.lyhyinPolku=0;
        
        nodeList=new PriorityQueue<>();
        closedList=new NodeLista();
        path=new NodeLista();
    }
    
    /**
     * laskee reitin dijkstran algoritmilla
     */
    
    private void laskeReitti(){
        nodeList.clear();
        nodeList.add(v.getAlkuNode());
        
        while(!nodeList.isEmpty()){
            Node current=nodeList.remove();
            closedList.add(current);
            
            if(current.equals(v.getMaaliNode())){
                haeReitti();
                return;
            }
            
            for(Node node : current.getNaapurit()){
                if(!node.isObstacle()){
                    int matka=current.getMatkaAlkuun()+(node.getMatkaAlkuun()-current.getMatkaAlkuun());
                    if(matka<node.getPaino()){
                        node.setPaino(matka);
                        nodeList.add(node);
                    }
                }
            }
        }
    }
    
    /**
     * Hakee reitin nodejen painon perusteella. Backtrackää maalista alkuun pienintä painoa käyttäen
     */
    
    private void haeReitti(){
        Node node=v.getMaaliNode();
        while(!node.equals(v.getAlkuNode())){
            PriorityQueue<Node> apulista=new PriorityQueue<>();
            for(Node n : node.getNaapurit()){
                apulista.add(n);
            }
            node=apulista.remove();
            path.add(node);
        }
    }
    
    /**
     * piirtää kauniin ascii-art-taulukon, jossa on löydetty reitti
     */
    
    public void piirra(){
        laskeReitti();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(v.getNodeVerkko()[i][j].isMaali()){
                    System.out.print("W");
                }
                else if(v.getNodeVerkko()[i][j].isAlku()){
                    System.out.print("S");
                }
                else if(v.getNodeVerkko()[i][j].isObstacle()){
                    System.out.print("0");
                }
                else if(path.contains(v.getNodeVerkko()[i][j])){
                    System.out.print("X");
                }
                else{
                    System.out.print("=");
                }
            }
            System.out.println("");
        }
        System.out.println("");
    }
}