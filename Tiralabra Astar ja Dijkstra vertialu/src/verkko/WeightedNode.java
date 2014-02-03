/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package verkko;

/**
 *
 * @author Juhani Heliö
 */
public class WeightedNode extends Node {

    public WeightedNode(int x, int y, int matkaMaaliin, int matkaAlkuun, boolean isObstacle, boolean alku, boolean maali) {
        super(x, y, matkaMaaliin, matkaAlkuun, isObstacle, alku, maali);
    }
    
    public WeightedNode(int x, int y) {
        super(x, y);
    }

    @Override
    public int compareTo(Node n) {
        if(this.getPaino()<n.getPaino()){
            return -1;
        }
        else if(this.getPaino()>n.getPaino()){
            return 1;
        }
        else{
            return 0;
        }
    }
    
}
