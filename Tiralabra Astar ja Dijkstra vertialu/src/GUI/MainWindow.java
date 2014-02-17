/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import algoritmit.Astar;
import algoritmit.Dijkstra;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import verkko.Verkko;

/**
 *
 * @author Juhani Heliö
 */
public class MainWindow extends JFrame{
    
    private JPanel mainPanel=new JPanel();
    private JPanel astarPanel=new JPanel();
    private JPanel dijkstraPanel=new JPanel();
    private JPanel[][] astarPanelGrid;
    private JPanel[][] dijkstraPanelGrid;
    private int[][] verkko=new int[10][10];
    private int[][] verkko2=new int[10][10];
    private Astar astar;
    private Dijkstra dijkstra;
    private int x;
    private int y;
    
    private final Color ALKU=Color.RED;
    private final Color MAALI=Color.GREEN;
    private final Color ESTE=Color.BLACK;
    private final Color CLOSED=Color.BLUE;
    private final Color OPEN=Color.CYAN;
    private final Color PATH=Color.ORANGE;
    private final Color TYHJA=Color.WHITE;
    
    
    
    public MainWindow(){
        astarPanelGrid=new JPanel[10][10];
        dijkstraPanelGrid=new JPanel[10][10];
        
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
        
        astar=new Astar(new Verkko(2,7,9,0,verkko,false));
        dijkstra=new Dijkstra(new Verkko(1,8,9,0,verkko2,true));
        
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
        astar.laskeReitti();
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
        dijkstra.laskeReitti();
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
        mainPanel.setLayout(new GridLayout(1, 2));
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
                astarPanelGrid[x][y].addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {}

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                });
                dijkstraPanelGrid[x][y].addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {}

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {}

                    @Override
                    public void mouseExited(MouseEvent e) {}
                });
            }
        }
        
        varitaRuudut();
        mainPanel.add(astarPanel);
        mainPanel.add(dijkstraPanel);
        
        this.add(mainPanel);
        
        this.pack();
        this.setSize(200, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    
    private void varitaRuudut(){
        astarVerkkoVarita();
        dijkstraVerkkoVarita();
    }
}
