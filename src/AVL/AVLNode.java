/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVL;

/**
 *
 * @author franc
 */
public class AVLNode {
    int data, bf; //dato y factor de equilibrio
    AVLNode left, right;
   
    public AVLNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
    
}
