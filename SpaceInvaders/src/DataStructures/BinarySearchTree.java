package DataStructures;

import Objects.Invader;

public class BinarySearchTree implements Arbol{
    TreeNode root;
    int size;

    public BinarySearchTree(){
        root = null;
    }

    /*
    @Override
    public void insert(int index, Class value){
        TreeNode n = new TreeNode(index);
        n.setData(value);

        if(root == null){
            root = n;
        }else{
            TreeNode aux = root;
            while(aux != null){
                n.dad = aux;
                if(n.key >= aux.key){
                    aux = aux.rigth;
                }else{
                    aux = aux.left;
                }
            }
            if(n.key < n.dad.key){
                n.dad.left = n;
            }else{
                n.dad.rigth = n;
            }
        }
        size++;
    }

     */

    @Override
    public Object get(TreeNode treeNode) {
        return treeNode.getValue();
    }


    public Object inOrder(TreeNode n){
        if(n != null){
            if(root.left==n){
                return get(n.left);
            }
            if(root.rigth==n){
                return get(n.rigth);
            }
            else{
                System.out.println("error en los ifs");
            }
            /*
            inOrder(n.left);
            System.out.println("Indice: " + n.key + " Valor: " + n.contents);
            inOrder(n.rigth);

             */
        }
        return null;
    }

    @Override
    public boolean estaVacio() {
        return false;
    }

    @Override
    public void vaciar() {

    }

    @Override
    public int tamaño(){
        return size;
    }

    @Override
    public void agregar(Object elem) {

    }

    @Override
    public boolean contiene(Object elem) {
        return false;
    }

    @Override
    public Invader getTree(int index) {
        if (index==1){
            return root.getData();
        }
        if (index==2){
            return root.left.getData();
        }
        if(index==3){
            return root.rigth.getData();
        }
        else if(index%2==0){
            inOrder(root.left);
        }
        else if(index%3==0){
            inOrder(root.rigth);
        }
        else{
            System.out.println("error en los ifs de getTree");
        }
        return null;
    }

    @Override
    public void eliminar(Object elem) {

    }
    @Override
    public void insert(Invader enemy) {
        TreeNode n = new TreeNode();
        n.setData(enemy);

        if(root == null){
            root = n;
        }else{
            TreeNode aux = root;
            while(aux != null){
                n.dad = aux;
                if(n.key >= aux.key){
                    aux = aux.rigth;
                }else{
                    aux = aux.left;
                }
            }
            if(n.key < n.dad.key){
                n.dad.left = n;
            }else{
                n.dad.rigth = n;
            }
        }
        size++;

    }


    public class TreeNode {
        // El nodo no tiene las funciones necesarias además de hacerse la clase en la misma clase del arbol binario lo cual puede causar error
        // El get value no tiene ningun sentido ya que siempre va a retornar un 0 por que nunca se hace un set de value para el nodo
        //el nodo simplemente recibe un index como key que no tiene ningún sentido ya que el nodo deberia contener el objecto del Invader
        public TreeNode dad;
        public TreeNode rigth;
        public TreeNode left;
        public int key;
        public Object contents;
        public Invader Data;

        public TreeNode(){
            //this.key = index;
            this.rigth = null;
            this.left = null;
            this.dad = null;
            this.Data=null;
        }

        public int getValue(){
            return key;
        }
        public void setData(Invader Data){
            this.Data=Data;
        }
        public Invader getData(){
            return Data;
        }
    }
}
