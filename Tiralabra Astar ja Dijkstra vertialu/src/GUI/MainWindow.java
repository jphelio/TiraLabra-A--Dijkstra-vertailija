/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import algoritmit.Astar;
import algoritmit.Dijkstra;
import algoritmit.Heuristic;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import verkko.Verkko;

/**
 * Luo näkymän jossa A* ja Dijkstra ratkaisevat verkon
 * @author Juhani Heliö
 */
public class MainWindow extends JFrame{
    
    private JPanel mainPanel=new JPanel();
    private JPanel astarPanel=new JPanel();
    private JPanel dijkstraPanel=new JPanel();
    private JPanel[][] astarPanelGrid;
    private JPanel[][] dijkstraPanelGrid;
    private JLabel astarAikalabel=new JLabel();
    private JLabel dijkstraAikalabel=new JLabel();
    private int[][] verkko=new int[50][50];
    private int[][] verkko2=new int[50][50];
    private Astar astar;
    private Dijkstra dijkstra;
    private int x;
    private int y;
    private long astarAika=0;
    private long dijkstraAika=0;
    
    private final Color ALKU=Color.RED;
    private final Color MAALI=Color.GREEN;
    private final Color ESTE=Color.BLACK;
    private final Color CLOSED=Color.BLUE;
    private final Color OPEN=Color.CYAN;
    private final Color PATH=Color.ORANGE;
    private final Color TYHJA=Color.WHITE;
    
    
    
    public MainWindow(){
        astarPanelGrid=new JPanel[50][50];
        dijkstraPanelGrid=new JPanel[50][50];
        
        verkko[6][4]=1;
        verkko[6][5]=1;
        verkko[6][6]=1;
        verkko[6][7]=1;
        verkko[6][8]=1;
        verkko[6][9]=1;
        verkko[8][0]=1;
        verkko[8][1]=1;
        verkko[8][2]=1;
        verkko[8][3]=1;
        verkko[5][5]=1;
        verkko[5][6]=1;
        verkko[4][3]=1;
        verkko[4][4]=1;
        verkko[2][1]=1;
        verkko[1][0]=1;
        verkko[3][8]=1;
        
        verkko2[6][4]=1;
        verkko2[6][5]=1;
        verkko2[6][6]=1;
        verkko2[6][7]=1;
        verkko2[6][8]=1;
        verkko2[6][9]=1;
        verkko2[8][0]=1;
        verkko2[8][1]=1;
        verkko2[8][2]=1;
        verkko2[8][3]=1;
        verkko2[5][5]=1;
        verkko2[5][6]=1;
        verkko2[4][3]=1;
        verkko2[4][4]=1;
        verkko2[2][1]=1;
        verkko2[1][0]=1;
        verkko2[3][8]=1;
        
        astar=new Astar(new Verkko(0,49,49,49,verkko,false));
        dijkstra=new Dijkstra(new Verkko(0,49,49,49,verkko2,true));
        
        teeGUI();
    }
    
    public MainWindow(int rows, int cols){
        astarPanelGrid=new JPanel[rows][cols];
        dijkstraPanelGrid=new JPanel[rows][cols];
        
        verkko=new int[rows][cols];
        verkko2=new int[rows][cols];
        
        astar=new Astar(new Verkko(0,cols,rows,0,verkko,false));
        dijkstra=new Dijkstra(new Verkko(0,cols,rows,0,verkko2,true));
        
        teeGUI();
    }
    
    public void astarVerkkoVarita(){
        astarAika=System.nanoTime();
        astar.laskeReitti();
        astarAika=System.nanoTime()-astarAika;
        astarAika=astarAika/1000000;
        astarAikalabel.setText("A*-algoritmi: "+astarAika+" ms, matka: "+astar.getLyhinPolku()+" heuristic: "+Heuristic.matka(astar.getV().getAlkuNode(), astar.getV().getMaaliNode()));
        for (int i = 0; i < astarPanelGrid.length; i++) {
            for (int j = 0; j < astarPanelGrid[0].length; j++) {
                if(astar.getV().getNodeVerkko()[i][j].isObstacle()){
                    astarPanelGrid[i][j].setBackground(ESTE);
                }
                else if(astar.getPath().contains(astar.getV().getNodeVerkko()[i][j])){
                    astarPanelGrid[i][j].setBackground(PATH);
                }
                else if(astar.getClosedList().contains(astar.getV().getNodeVerkko()[i][j])){
                    astarPanelGrid[i][j].setBackground(CLOSED);
                }
                else if(astar.getOpenList().contains(astar.getV().getNodeVerkko()[i][j])){
                    astarPanelGrid[i][j].setBackground(OPEN);
                }
                else{
                    astarPanelGrid[i][j].setBackground(TYHJA);
                }
            }
        }
        astarPanelGrid[astar.getV().getAlkuNodeX()][astar.getV().getAlkuNodeY()].setBackground(ALKU);
        astarPanelGrid[astar.getV().getMaaliNodeX()][astar.getV().getMaaliNodeY()].setBackground(MAALI);
    }
    
    public void dijkstraVerkkoVarita(){
        dijkstraAika=System.nanoTime();
        dijkstra.laskeReitti();
        dijkstraAika=System.nanoTime()-dijkstraAika;
        dijkstraAika=dijkstraAika/1000000;
        dijkstraAikalabel.setText("Dijkstran algoritmi: "+dijkstraAika+" ms, matka: "+dijkstra.getLyhyinPolku()+" heuristic: "+Heuristic.matka(astar.getV().getAlkuNode(), astar.getV().getMaaliNode()));
        for (int i = 0; i < dijkstraPanelGrid.length; i++) {
            for (int j = 0; j < dijkstraPanelGrid[0].length; j++) {
                if(dijkstra.getV().getNodeVerkko()[i][j].isObstacle()){
                    dijkstraPanelGrid[i][j].setBackground(ESTE);
                }
                else if(dijkstra.getPath().contains(dijkstra.getV().getNodeVerkko()[i][j])){
                    dijkstraPanelGrid[i][j].setBackground(PATH);
                }
                else if(dijkstra.getClosedList().contains(dijkstra.getV().getNodeVerkko()[i][j])){
                    dijkstraPanelGrid[i][j].setBackground(CLOSED);
                }
                else if(dijkstra.getNodeList().contains(dijkstra.getV().getNodeVerkko()[i][j])){
                    dijkstraPanelGrid[i][j].setBackground(OPEN);
                }
                else{
                    dijkstraPanelGrid[i][j].setBackground(TYHJA);
                }
            }
        }
        dijkstraPanelGrid[dijkstra.getV().getAlkuNodeX()][dijkstra.getV().getAlkuNodeY()].setBackground(ALKU);
        dijkstraPanelGrid[dijkstra.getV().getMaaliNodeX()][dijkstra.getV().getMaaliNodeY()].setBackground(MAALI);
    }
    
    private void teeGUI(){
        GroupLayout l=new GroupLayout(mainPanel);
        mainPanel.setLayout(l);
        
        astarPanel.setLayout(new GridLayout(astarPanelGrid.length, astarPanelGrid[0].length));
        dijkstraPanel.setLayout(new GridLayout(dijkstraPanelGrid.length, dijkstraPanelGrid[0].length));
        
        for(int i=0;i<astarPanelGrid.length;i++){
            for(int j=0;j<astarPanelGrid[0].length;j++){
                astarPanelGrid[i][j]=new JPanel();
                astarPanel.add(astarPanelGrid[i][j]);
            }
        }
        
        for(int i=0;i<dijkstraPanelGrid.length;i++){
            for(int j=0;j<dijkstraPanelGrid[0].length;j++){
                dijkstraPanelGrid[i][j]=new JPanel();
                dijkstraPanel.add(dijkstraPanelGrid[i][j]);
            }
        }
        
        for(x=0; x<dijkstraPanelGrid.length; x++){
            for(y=0; y<dijkstraPanelGrid[0].length; y++){
                astarPanelGrid[x][y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if(!e.getComponent().getBackground().equals(ALKU)&&!e.getComponent().getBackground().equals(MAALI)){
                            if(!e.getComponent().getBackground().equals(ESTE)){
                                e.getComponent().setBackground(ESTE);
                            }
                            else if(e.getComponent().getBackground().equals(ESTE)){
                                e.getComponent().setBackground(TYHJA);
                            }
                        }
                        luoVerkkoAstar();
                    }
                });
                
                dijkstraPanelGrid[x][y].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if(!e.getComponent().getBackground().equals(ALKU)&&!e.getComponent().getBackground().equals(MAALI)){
                            if(!e.getComponent().getBackground().equals(ESTE)){
                                e.getComponent().setBackground(ESTE);
                            }
                            else if(e.getComponent().getBackground().equals(ESTE)){
                                e.getComponent().setBackground(TYHJA);
                            }
                        }
                        luoVerkkoDijkstra();
                    }
                });
            }
        }
        
        varitaRuudut();
        
        GroupLayout.ParallelGroup astarX=l.createParallelGroup();
        astarX.addComponent(astarPanel);
        astarX.addComponent(astarAikalabel);
        
        GroupLayout.ParallelGroup dijkstraX=l.createParallelGroup();
        dijkstraX.addComponent(dijkstraPanel);
        dijkstraX.addComponent(dijkstraAikalabel);
        
        GroupLayout.SequentialGroup rootX=l.createSequentialGroup();
        rootX.addGroup(astarX);
        rootX.addGroup(dijkstraX);
        
        l.setHorizontalGroup(rootX);
        
        GroupLayout.SequentialGroup astarY=l.createSequentialGroup();
        astarY.addComponent(astarPanel);
        astarY.addComponent(astarAikalabel);
        
        GroupLayout.SequentialGroup dijkstraY=l.createSequentialGroup();
        dijkstraY.addComponent(dijkstraPanel);
        dijkstraY.addComponent(dijkstraAikalabel);
        
        GroupLayout.ParallelGroup rootY=l.createParallelGroup();
        rootY.addGroup(astarY);
        rootY.addGroup(dijkstraY);
        
        l.setVerticalGroup(rootY);
        
        this.add(mainPanel);
        
        this.pack();
        this.setLocation(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    
    private void luoVerkkoAstar(){
        verkko=new int[verkko.length][verkko[0].length];
        for(int i=0;i<verkko.length;i++){
            for(int j=0;j<verkko[0].length;j++){
                if(astarPanelGrid[i][j].getBackground().equals(ESTE)){
                    verkko[i][j]=1;
                }
            }
        }
        astar=new Astar(new Verkko(astar.getV().getMaaliNodeX(),astar.getV().getMaaliNodeY(),astar.getV().getAlkuNodeX(),astar.getV().getAlkuNodeY(),verkko,false));
        astarVerkkoVarita();
    }
    
    private void luoVerkkoDijkstra(){
        verkko2=new int[verkko2.length][verkko2[0].length];
        for(int i=0;i<verkko2.length;i++){
            for(int j=0;j<verkko2[0].length;j++){
                if(dijkstraPanelGrid[i][j].getBackground().equals(ESTE)){
                    verkko2[i][j]=1;
                }
            }
        }
        dijkstra=new Dijkstra(new Verkko(dijkstra.getV().getMaaliNodeX(),dijkstra.getV().getMaaliNodeY(),dijkstra.getV().getAlkuNodeX(),dijkstra.getV().getAlkuNodeY(),verkko2,true));
        dijkstraVerkkoVarita();
    }
    
    private void varitaRuudut(){
        astarVerkkoVarita();
        dijkstraVerkkoVarita();
    }
}
