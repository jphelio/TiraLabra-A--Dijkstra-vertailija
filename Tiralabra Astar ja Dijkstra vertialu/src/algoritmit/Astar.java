/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmit;

import verkko.Node;
import verkko.Verkko;
import java.util.*;
import tietorakenteet.NodeLista;

/**
 * A* algoritmi ja sen apumetodit
 * @author Juhani Heliö
 */
public class Astar {
    private Verkko v;
    
    private NodeLista closedList;
    private PriorityQueue<Node> openList;
    
    private NodeLista path;
    
    private int lyhinPolku=0;

    public Astar(Verkko v) {
        this.v = v;
        
        closedList=new NodeLista();
        openList=new PriorityQueue<>();
        path=new NodeLista();
    }
    
    /**
     * hakee lyhimmän reitin alkusolmun ja maalisolmun välillä
     */
    
    public int laskeReitti(){
        openList.clear();
        closedList.clear();
        openList.add(v.getAlkuNode());
        
        while(!openList.isEmpty()){
            Node current=openList.remove();
            closedList.add(current);
            
            for(Node node : current.getNaapurit()){
                if(!closedList.contains(node)&&!node.isObstacle()){
                    if(!openList.contains(node) || node.getMatkaAlkuun()<current.getMatkaAlkuun()){
                        node.setEdellinen(current);
                        if(!openList.contains(node)){
                            openList.add(node);
                        }
                    }
                }
            }
        }
        return lyhinReitti(v.getMaaliNode());
    }
    
    /**
     * Ottaa lyhyimmän reitin talteen path muuttujaan
     * @param n 
     * @return lyhyimmän reitin pituus
     */
    
    private int lyhinReitti(Node n){
        if(n.getEdellinen()!=null){
            path.add(n);
            lyhinReitti(n.getEdellinen());
        }
        return lyhinPolku+=n.getMatkaMaaliin();
    }
    
    
    /**
     * Piirtää kauniin ascii havainnollistuksen reitistä
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
