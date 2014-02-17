/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmit;

import verkko.Node;

/**
 * Heuristiikka
 * Tällä hetkellä laskee lyhimmän matkan tämän solmun ja maalisolmun välillä. 
 * Ei välitä esteistä
 * @author Juhani Heliö
 */
public class Heuristic {
    public static int matka(Node n, Node maali){
        
        int dumbHeurX=Math.abs(n.getX()-maali.getX());
        int dumbHeurY=Math.abs(n.getY()-maali.getY());
        
        return dumbHeurX+dumbHeurY+1;
    }
}
