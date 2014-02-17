/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verkko;

import java.util.Objects;
import tietorakenteet.NodeLista;

/**
 * Verkon yksi solmu. 
 * Tuntee naapurinsa, jotka ovat pääilmansuuntien mukaisilla paikoilla. 
 * Node tietää myös matkan maaliin.
 * @author Juhani Heliö
 */
public class Node implements Comparable<Node>{
    private Node north;
    private Node east;
    private Node south;
    private Node west;
    private int x;
    private int y;
    private int matkaMaaliin;
    private int matkaAlkuun;
    private boolean Obstacle;
    private boolean alku;
    private boolean maali;
    private NodeLista naapurit;
    private Node edellinen;
    private int paino=Integer.MAX_VALUE;

    public Node(int x, int y, int matkaMaaliin, int matkaAlkuun, boolean isObstacle, boolean alku, boolean maali) {
        this.x = x;
        this.y = y;
        this.matkaMaaliin = matkaMaaliin;
        this.matkaAlkuun = matkaAlkuun;
        this.Obstacle = isObstacle;
        this.alku = alku;
        this.maali = maali;
        naapurit=new NodeLista();
    }
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        naapurit=new NodeLista();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if (!Objects.equals(this.north, other.north)) {
            return false;
        }
        if (!Objects.equals(this.east, other.east)) {
            return false;
        }
        if (!Objects.equals(this.south, other.south)) {
            return false;
        }
        if (!Objects.equals(this.west, other.west)) {
            return false;
        }
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        if (this.matkaMaaliin != other.matkaMaaliin) {
            return false;
        }
        if (this.matkaAlkuun != other.matkaAlkuun) {
            return false;
        }
        if (this.Obstacle != other.Obstacle) {
            return false;
        }
        if (this.alku != other.alku) {
            return false;
        }
        if (this.maali != other.maali) {
            return false;
        }
        if (!Objects.equals(this.naapurit, other.naapurit)) {
            return false;
        }
        if (!Objects.equals(this.edellinen, other.edellinen)) {
            return false;
        }
        if (this.paino != other.paino) {
            return false;
        }
        return true;
    }
    
    
    
    public Node getEdellinen() {
        return edellinen;
    }
    
    public void setEdellinen(Node edellinen) {
        this.edellinen = edellinen;
    }

    public int getPaino() {
        return paino;
    }

    public void setPaino(int paino) {
        this.paino = paino;
    }
    
    @Override
    public int compareTo(Node n){
        if(this.matkaMaaliin<n.getMatkaMaaliin()){
            return -1;
        }
        else if(this.matkaMaaliin>n.getMatkaMaaliin()){
            return 1;
        }
        else{
            return 0;
        }
    }

    public NodeLista getNaapurit() {
        return naapurit;
    }

    public void setNaapurit(NodeLista naapurit) {
        this.naapurit = naapurit;
    }

    public int getMatkaMaaliin() {
        return matkaMaaliin;
    }

    public void setMatkaMaaliin(int matkaMaaliin) {
        this.matkaMaaliin = matkaMaaliin;
    }

    public int getMatkaAlkuun() {
        return matkaAlkuun;
    }

    public void setMatkaAlkuun(int matkaAlkuun) {
        this.matkaAlkuun = matkaAlkuun;
    }

    public Node getNorth() {
        return north;
    }

    
    public Node getEast() {
        return east;
    }
    
    public Node getSouth() {
        return south;
    }
    
    public Node getWest() {
        return west;
    }
    
    public void setNorth(Node north) {
        if(this.north!=null&&naapurit.contains(this.north)){
            naapurit.remove(this.north);
        }
        naapurit.add(north);
        this.north = north;
    }
    
    public void setEast(Node east) {
        if(this.east!=null&&naapurit.contains(this.east)){
            naapurit.remove(this.east);
        }
        naapurit.add(east);
        this.east = east;
    }

    public void setSouth(Node south) {
        if(this.south!=null&&naapurit.contains(this.south)){
            naapurit.remove(this.south);
        }
        naapurit.add(south);
        this.south = south;
    }

    public void setWest(Node west) {
        if(this.west!=null&&naapurit.contains(this.west)){
            naapurit.remove(this.west);
        }
        naapurit.add(west);
        this.west = west;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isObstacle() {
        return Obstacle;
    }

    public void setObstacle(boolean isObstacle) {
        this.Obstacle = isObstacle;
    }

    public boolean isAlku() {
        return alku;
    }

    public void setAlku(boolean alku) {
        this.alku = alku;
    }

    public boolean isMaali() {
        return maali;
    }

    public void setMaali(boolean maali) {
        this.maali = maali;
    }    
}
