/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmit;

import verkko.Node;
import verkko.Verkko;
import tietorakenteet.NodeLista;
import tietorakenteet.OmaPriorityMinHeap;

/**
 * A* algoritmi ja sen apumetodit
 * @author Juhani Heliö
 */
public class Astar {
    private Verkko v;
    
    private NodeLista closedList;
    private OmaPriorityMinHeap openList;
    
    private NodeLista path;
    
    private int lyhinPolku=0;

    public Astar(Verkko v) {
        this.v = v;
        
        closedList=new NodeLista();
        openList=new OmaPriorityMinHeap();
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
            if(current.equals(v.getMaaliNode())){
                return lyhinReitti(v.getMaaliNode());
            }
            
            closedList.add(current);
            for(int i=0;i<current.getNaapurit().size();i++){
                Node node=current.getNaapurit().get(i);
                if(!closedList.contains(node)&&!node.isObstacle()){
                    int matkaAlkuun=current.getMatkaAlkuun()+1;
                    if(!openList.contains(node) || matkaAlkuun<current.getMatkaAlkuun()){
                        node.setEdellinen(current);
                        node.setMatkaAlkuun(matkaAlkuun);
                        node.setMatkaMaaliin(node.getMatkaAlkuun()+Heuristic.matka(node, v.getMaaliNode()));
                        if(!openList.contains(node)){
                            openList.add(node);
                        }
                    }
                }
            }
        }
        return -1;
        
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
        return lyhinPolku++;
    }

    public void setV(Verkko v) {
        this.v = v;
    }

    public Verkko getV() {
        return v;
    }

    public NodeLista getClosedList() {
        return closedList;
    }

    public OmaPriorityMinHeap getOpenList() {
        return openList;
    }

    public NodeLista getPath() {
        return path;
    }

    public int getLyhinPolku() {
        return lyhinPolku;
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
                else if(closedList.contains(v.getNodeVerkko()[i][j])){
                    System.out.print("c");
                }
                else if(openList.contains(v.getNodeVerkko()[i][j])){
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
