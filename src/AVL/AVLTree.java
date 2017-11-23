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
public class AVLTree {
    //Atributos
    //Raíz
    private AVLNode root;
    
    //Constructor
    public AVLTree (){
        this.root=null;
    }
    
    //Devuelve raiz
    public AVLNode getRoot(){
        return this.root;
    }
    
    //Buscar un nodo
    public AVLNode fetch (int d, AVLNode r){
        if (root == null){ //No hay nodos
            return null;
        }else if(root.data == d){//Si el dato está en raíz
            return root;
        }else if (root.data<d){ //Si el dato es mayor a raíz
            return fetch (d,r.right); //Lo buscamos por la derecha
        }else{
            return fetch (d,r.left); //Lo buscamos por la izquierda
        }
    }
    
    //Obtener factor de balance
    public int getBF(AVLNode node){
        if(node == null){
            return -1;
        }else{
            return node.bf;
        }
    }
    
    //Recalcular factor de balance
    public int calcBF(AVLNode node){
        return Math.max(getBF(node.left), getBF(node.right))+1;
    }
    
    //Rotación simple a la izquierda.
    public AVLNode rightRotation (AVLNode r){
        //Declaramos un auxiliar
        AVLNode aux = r.left;
        r.left=aux.right;
        aux.right=r;
        r.bf=calcBF(r);
        aux.bf=calcBF(aux);
        return aux;
    }
    
    //Rotación simple a la derecha.
    public AVLNode leftRotation (AVLNode r){
        //Declaramos un auxiliar
        AVLNode aux = r.right;
        r.right=aux.left;
        aux.left=r;
        r.bf=calcBF(r);
        aux.bf=calcBF(aux);
        return aux;
    }
    
    //Rotación doble a la izquierda.
    public AVLNode dRightRotation (AVLNode r){
        r.left=rightRotation(r.left);
        return leftRotation(r);
    }
    
    //Rotación doble a la derecha.
    public AVLNode dLeftRotation (AVLNode r){
        r.right=leftRotation(r.right);
        return rightRotation(r);
    }
        
    //Insertar nodo AVL
    private AVLNode insertAVL(AVLNode n, AVLNode sr){
        AVLNode newDAD = sr;
        if(n.data<sr.data){
            if (sr.left==null){
                sr.left = n;
            }else{
                sr.left=insertAVL(n,sr.left);
                if((getBF(sr.left)-getBF(sr.right))==2){
                    if(n.data<sr.left.data){
                        newDAD=leftRotation(sr);
                    }else{
                        newDAD=dLeftRotation(sr);
                    }
                }
            }
        }else if(n.data>sr.data){
            if(sr.right==null){
                sr.right=n;
            }else{
                sr.right=insertAVL(n,sr.right);
                if((getBF(sr.right)-getBF(sr.left))==2){
                    if(n.data>sr.right.data){
                        newDAD=rightRotation(sr);
                    }else{
                        newDAD=dRightRotation(sr);
                    }
                }
            }
        }else{
            System.out.println("El nodo está duplicado");
        }
        //Actualizar BF
        if(sr.left==null && sr.right!=null){
            sr.bf=sr.right.bf+1;
        }else if(sr.right==null && sr.left!=null){
            sr.bf=sr.left.bf+1;
        }else{
            sr.bf=calcBF(sr);
        }
        return newDAD;
    }

    //Insertar
    public void insert (int d){
        AVLNode node = new AVLNode(d);
        if (root==null){
            root = node;
        }else{
            root=insertAVL(node, root);
        }
    }

    //Recorridos
    public void inOrden(AVLNode r){
        if (r !=null){
            inOrden(r.left);
            System.out.print(Integer.toString(r.data));
            inOrden(r.right);
        }
    }
    
    public void preOrden(AVLNode r){
        if (r != null){
            System.out.print(Integer.toString(r.data));
            preOrden(r.left);
            preOrden(r.right);
        }
    }
    
    public void postOrden (AVLNode r){
        if (r != null){
            postOrden(r.left);
            postOrden(r.right);
            System.out.print(Integer.toString(r.data));
        }
    }
}
