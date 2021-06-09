package DataStructures;

import Objects.Invader;


public class BinarySearchTree implements Arbol {
    TreeNode root;
    int size;

    public BinarySearchTree() {
        root = null;
    }



    @Override
    public Object get(TreeNode treeNode) {
        return treeNode.getValue();
    }


    public Invader inOrder(TreeNode n,int index){
        System.out.println("Entro en inOrder");
        System.out.println(n+"    "+index);
        if(n != null){

            if(n.getRigth().getKey()==index){
                System.out.println(n.getRigth().getKey());;
                System.out.println("retornando datos del nodo derecho");
                return n.getRigth().getData();}
            if(n.getLeft().getKey()==index) {
                System.out.println(n.getLeft().getKey());;
                System.out.println("retornando datos del nodo izquierdo");
                return n.getLeft().getData();}
            if(n.getLeft().getKey() != index || n.getRigth().getKey() != index){
                System.out.println("Siguente inOrder para seguir buscando");
                 return inOrder(n.getRigth(),index);
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
        TreeNode First=root;
        if (index==0){
            return root.getData();
        }
        else if(index%2==0){
            return inOrder(root,index);
        }
        else{
            return inOrder(root,index);
        }
    }

    @Override
    public void eliminar(Object elem) {

    }
    @Override
    public void insert(Invader enemy,int key) {
        TreeNode n = new TreeNode(key);
        n.setData(enemy);
        if(root == null){
            root = n;
            size++;
            return;
        }
        TreeNode First =root;
        if(First.rigth == null){
            System.out.println("añadido root.right");
            System.out.println(n.getData());
            First.setRigth(n);
            size++;
            return;
        }
        if(First.left==null){
            System.out.println("añadido root.left");
            System.out.println(n.getData());
            First.setLeft(n);
            size++;
            return;
        }
        while(First.rigth != null && First.left != null ){
                First=First.getRigth();
        }
        if(First.left == null && First.rigth != null){
            First.setLeft(n);
            size++;
            return;
        }
        else if(First.rigth == null ){
            First.setRigth(n);
            size++;
            return;
        }

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

        public TreeNode(int key){
            this.key = key;
            this.rigth = null;
            this.left = null;
            this.dad = null;
            this.Data=null;
        }


        public TreeNode getLeft() {
            return left;
        }
        public void setLeft(TreeNode left) {
            this.left = left;
        }
        public void setRigth(TreeNode rigth) {
            this.rigth = rigth;
        }
        public TreeNode getRigth() {
            return rigth;
        }

        public void setKey(int key) {
            this.key = key;
        }
        public int getKey(){return  key;}

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
