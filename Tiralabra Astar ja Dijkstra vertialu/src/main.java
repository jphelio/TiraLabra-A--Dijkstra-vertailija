
import GUI.MainWindow;
import algoritmit.Astar;
import algoritmit.Dijkstra;
import verkko.Verkko;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Pääsääntöisesti testejä ja kokeiluja
 * @author Juhani Heliö
 */
public class main {
    private static int[][] verkko=new int[9][9];
    private static int[][] verkko2=new int[9][9];
    
    public static void main(String[] args) {
        
        MainWindow m=new MainWindow();
        
        Verkko v1=new Verkko(7, 7, 2, 3, verkko, true);
        verkko2[2][1]=1;
        verkko2[2][2]=1;
        verkko2[1][2]=1;
        verkko2[2][0]=1;
        Verkko v2=new Verkko(7,7,0,0,verkko2, true);
        Verkko v3=new Verkko(7,7,0,0,verkko, true);
        Verkko v4=new Verkko(7, 7, 2, 3, verkko, false);
        verkko2[2][1]=1;
        verkko2[2][2]=1;
        verkko2[1][2]=1;
        verkko2[2][0]=1;
        Verkko v5=new Verkko(7,7,0,0,verkko2, false);
        Verkko v6=new Verkko(7,7,0,0,verkko, false);
        
        Astar a1=new Astar(v4);
        Astar a2=new Astar(v5);
        Astar a3=new Astar(v6);        

        a1.piirra();
        a2.piirra();
        a3.piirra();
        
        System.out.println("----------------------------");
        
        Dijkstra d1=new Dijkstra(v1);
        Dijkstra d2=new Dijkstra(v2);
        Dijkstra d3=new Dijkstra(v3);
        
        d1.piirra();
        d2.piirra();
        d3.piirra();
        
//        Erinäisiä kokeiluja, toiminto siirretty astar luokkaan, kts piirra()
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if(v.getNodeVerkko()[i][j].isMaali()){
//                    System.out.print("W ");
//                }
//                else if(v.getNodeVerkko()[i][j].isAlku()){
//                    System.out.print("S ");
//                }
//                else{
//                    System.out.print(v.getNodeVerkko()[i][j].getMatkaAlkuun()+" ");
//                }
////                System.out.print(v.getNodeVerkko()[i][j].getX()+","+v.getNodeVerkko()[i][j].getY()+" ");
//            }
//            System.out.println("");
//        }
//        System.out.println(a.laskeReitti());
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if(v2.getNodeVerkko()[i][j].isMaali()){
//                    System.out.print("W ");
//                }
//                else if(v2.getNodeVerkko()[i][j].isAlku()){
//                    System.out.print("S ");
//                }
//                else if(v2.getNodeVerkko()[i][j].isObstacle()){
//                    System.out.print("O ");
//                }
//                else{
//                    System.out.print(v2.getNodeVerkko()[i][j].getMatkaAlkuun()+" ");
//                }
////                System.out.print(v.getNodeVerkko()[i][j].getX()+","+v.getNodeVerkko()[i][j].getY()+" ");
//            }
//            System.out.println("");
//        }
//        System.out.println(a2.laskeReitti());
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if(v3.getNodeVerkko()[i][j].isMaali()){
//                    System.out.print("W ");
//                }
//                else if(v3.getNodeVerkko()[i][j].isAlku()){
//                    System.out.print("S ");
//                }
//                else{
//                    System.out.print(v3.getNodeVerkko()[i][j].getMatkaAlkuun()+" ");
//                }
////                System.out.print(v.getNodeVerkko()[i][j].getX()+","+v.getNodeVerkko()[i][j].getY()+" ");
//            }
//            System.out.println("");
//        }
//        System.out.println(a3.laskeReitti());
    }
}
