/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmit;

import java.util.*;
import tietorakenteet.NodeLista;
import tietorakenteet.OmaPriorityLista;
import verkko.*;

/**
 * Dijkstran algoritmi
 * @author Juhani Heliö
 */
public class Dijkstra {
    
    private Verkko v;
    
    private OmaPriorityLista nodeList;
    private NodeLista closedList;
    private NodeLista path;
    
    private int lyhyinPolku;    
    
    public Dijkstra(Verkko v){
        this.v=v;
        this.lyhyinPolku=0;
        
        nodeList=new OmaPriorityLista();
        closedList=new NodeLista();
        path=new NodeLista();
    }
    
    /**
     * laskee reitin dijkstran algoritmilla
     */
    
    public void laskeReitti(){
        nodeList.clear();
        closedList.clear();
        nodeList.add(v.getAlkuNode());
        v.getAlkuNode().setPaino(0);
        
        while(!nodeList.isEmpty()){
            Node current=nodeList.remove();
            closedList.add(current);
            
            if(current.equals(v.getMaaliNode())){
                haeReitti();
                return;
            }
            
            for(int i=0;i<current.getNaapurit().size();i++){
                Node node=current.getNaapurit().get(i);
                if(!node.isObstacle()&&!closedList.contains(node)){
                    int matka=current.getMatkaAlkuun()+1;
                    if(matka<node.getPaino()){
                        node.setEdellinen(current);
                        node.setPaino(matka);
                        node.setMatkaAlkuun(matka);
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
            for(int i=0;i<node.getNaapurit().size();i++){
                Node n=node.getNaapurit().get(i);
                apulista.add(n);
            }
            node=apulista.remove();
            path.add(node);
        }
    }

    public Verkko getV() {
        return v;
    }

    public OmaPriorityLista getNodeList() {
        return nodeList;
    }

    public NodeLista getClosedList() {
        return closedList;
    }

    public NodeLista getPath() {
        return path;
    }

    public int getLyhyinPolku() {
        return lyhyinPolku;
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
                else if(closedList.contains(v.getNodeVerkko()[i][j])){
                    System.out.print("c");
                }
                else if(nodeList.contains(v.getNodeVerkko()[i][j])){
                    System.out.print("o");
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