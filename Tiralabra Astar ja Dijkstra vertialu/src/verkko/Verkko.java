package verkko;

import Algorithms.Heuristic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Verkko luo uuden verkon valmiin int -taulukon pohjalta käyttäen nodeja solmuina. 
 * @author Juhani Heliö
 */

public class Verkko {
    private int maaliNodeX;
    private int maaliNodeY;
    private int alkuNodeX;
    private int alkuNodeY;
    private int[][] verkko;
    private Node[][] nodeVerkko;

    public Verkko(int maaliNodeX, int maaliNodeY, int alkuNodeX, int alkuNodeY, int[][] verkko) {
        this.maaliNodeX = maaliNodeX;
        this.maaliNodeY = maaliNodeY;
        this.alkuNodeX = alkuNodeX;
        this.alkuNodeY = alkuNodeY;
        this.verkko = verkko;
        luoVerkko();
    }

    /**
     * Luo verkon ja asettaa nodeille oikeat ominaisuudet annetun taulukon pohjalta
     */
    private void luoVerkko(){
        nodeVerkko=new Node[verkko.length][verkko[0].length];
        for(int i=0;i<verkko.length;i++){
            for(int j=0;j<verkko[i].length;j++){
                nodeVerkko[i][j]=new Node(i, j);
            }
        }
        for(int i=0;i<verkko.length;i++){
            for(int j=0;j<verkko[i].length;j++){
                paivitaNode(i, j);
                naapuroi(nodeVerkko[i][j]);
            }
        }
    }
    
    /**
     * Asettaa nodelle n sen naapurit
     * @param n 
     */
    private void naapuroi(Node n){
        if(n.getX()!=0){
            n.setWest(nodeVerkko[n.getX()-1][n.getY()]);
        }
        if(n.getX()<nodeVerkko.length-1){
            n.setEast(nodeVerkko[n.getX()+1][n.getY()]);
        }
        if(n.getY()!=0){
            n.setNorth(nodeVerkko[n.getX()][n.getY()-1]);
        }
        if(n.getY()<nodeVerkko[n.getX()].length-1){
            n.setSouth(nodeVerkko[n.getX()][n.getY()+1]);
        }
    }
    
    /**
     * Päivittää noden tilan.
     * Tila voi olla joko este, maali tai alku
     * @param i
     * @param j 
     */
    
    private void paivitaNode(int i, int j){
        if(verkko[i][j]==1){
            nodeVerkko[i][j].setObstacle(true);
        }
        else if(i==maaliNodeX && j==maaliNodeY){
            nodeVerkko[i][j].setMaali(true);
        }
        else if(i==alkuNodeX && j==alkuNodeY){
            nodeVerkko[i][j].setAlku(true);
        }
        nodeVerkko[i][j].setMatkaMaaliin(Heuristic.matka(nodeVerkko[i][j], nodeVerkko[maaliNodeX][maaliNodeY]));
        nodeVerkko[i][j].setMatkaAlkuun(Heuristic.matka(nodeVerkko[i][j], nodeVerkko[alkuNodeX][alkuNodeY]));
    }

    public void setMaaliNode(int maaliNodeX, int maaliNodeY) {
        this.maaliNodeX = maaliNodeX;
        this.maaliNodeY = maaliNodeY;
        paivitaNode(this.maaliNodeX, this.maaliNodeY);
    }

    public int getMaaliNodeX() {
        return maaliNodeX;
    }
    
    public int getMaaliNodeY() {
        return maaliNodeY;
    }

    public Node getMaaliNode() {
        return nodeVerkko[maaliNodeX][maaliNodeY];
    }
    
    public void setAlkuNode(int alkuNodeX, int alkuNodeY) {
        this.alkuNodeX = alkuNodeX;
        this.alkuNodeY = alkuNodeY;
        paivitaNode(this.alkuNodeX, this.alkuNodeY);
    }

    public int getAlkuNodeX() {
        return alkuNodeX;
    }
    
    public int getAlkuNodeY() {
        return alkuNodeY;
    }

    public Node getAlkuNode() {
        return nodeVerkko[alkuNodeX][alkuNodeY];
    }
    
    public int[][] getVerkko() {
        return verkko;
    }

    public void setVerkko(int[][] verkko) {
        this.verkko = verkko;
    }

    public Node[][] getNodeVerkko() {
        return nodeVerkko;
    }

    public void setNodeVerkko(Node[][] nodeVerkko) {
        this.nodeVerkko = nodeVerkko;
    }
}