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
public class BinaryTree {
    private Leaf root;
    private int leaves;
    
    BinaryTree(){
        root = null;
        leaves = 0;
    }
    
    BinaryTree(int d){
        root = new Leaf(d);
        leaves = 1;
    }
    
    void insert(int d, Leaf root){
        if(!isEmpty()){
            if(d < root.getData()){
                if(root.left != null){
                    root.left = new Leaf(d);
                    leaves++;
                } else {
                    insert(d , root.left);
                }
            } else {
                if(root.right != null){
                    root.right = new Leaf(d);
                    leaves++;
                } else{
                    insert(d , root.right);
                }
            }
        } else {
            root = new Leaf(d);
            leaves = 1;
        }
    }
    
    boolean isEmpty(){
        return leaves ==0;
    }
    
    void showLeaf(Leaf root){
        System.out.println(root);
    }
    
    int Heigth(Leaf root){
        if(isEmpty()){
            return 0;
        } else {
            int a , b;
            if(root.right!=null && root.left!=null){
                return 1;
            } else {
                a = Heigth(root.left);
                b = Heigth(root.right);
                if(a>b) return a+1;
                else return b+1;
            }
        }
    }
    
    Leaf getRoot(){
        return root;
    }
    
    
    int getLeaves(){
        return leaves;
    }
}
