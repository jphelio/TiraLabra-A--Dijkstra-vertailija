/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tietorakenteet;

import verkko.Node;

/**
 * Binäärihakua käyttävä itsestään järjestykseen menevä Priority lista.
 * Voi olla vain väliaikainen ratkaisu
 * @author Juhani Heliö
 */
public class PriorityNodeLista extends NodeLista{

    public PriorityNodeLista() {
        super();
    }
    
    @Override
    public void add(Node n){
        Node[] lista=getLista();
        
        if(getMontakoArvoa()==0){
            lista[0]=n;
        }
        else{
            int paikka=binaariHaku(n, lista);
            if( paikka!=-1 && getMontakoArvoa()+1<lista.length){
                for(int i=getMontakoArvoa()-1;i>=paikka;i--){
                    lista[i+1]=lista[i];
                }
                lista[paikka]=n;
            }
            else{
                listanPidennys(lista);
                this.add(n);
            }
        }
        setMontakoArvoa(getMontakoArvoa()+1);
    }
    
    public Node remove(){
        Node n=getLista()[0];
        Node[] apu=new Node[getLista().length];
        for(int i=0;i<getMontakoArvoa();i++){
            apu[i]=getLista()[i+1];
        }
        setLista(apu);
        setMontakoArvoa(getMontakoArvoa()-1);
        return n;
    }
    
    private int binaariHaku(Node n, Node[] lista){
        int lo=0;
        int hi=getMontakoArvoa()-1;
        while (lo<=hi) {
            int mid = lo + (hi - lo) / 2;
            if(n.compareTo(lista[mid])==-1){
                hi = mid - 1;
            }
            else if(n.compareTo(lista[mid])==1){
                lo = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
