/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author franc
 */
public class Leaf {
     private int data;
    Leaf right;
    Leaf left;
    
    Leaf(){
        left = right = null;
        data = 0;
    }
    
    Leaf(int d){
        right = left = null;
        data = d;
    }
    
    void print(){
        System.out.println(" " +data +" ");
    }
    
    int getData(){
        return data;
    }
    
    void setData(int d){
        data = d;
    }
}
