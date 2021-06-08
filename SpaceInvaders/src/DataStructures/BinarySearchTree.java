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
        System.out.println("Entro en inOrder");
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
        TreeNode First=root;
        if (index==0){
            System.out.println("Entro en getTree 1");
            System.out.println(root.getData());
            return root.getData();
        }
        if (index==1){
            System.out.println("Entro en getTree 2");
            System.out.println(root.getLeft().getData());
            return root.getLeft().getData();
        }
        if(index==2){
            System.out.println("Entro en getTree 3");
            System.out.println(root.getRigth().getData());
            return root.getRigth().getData();
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
    public void insert(Invader enemy,int key) {
        TreeNode n = new TreeNode(key);
        n.setData(enemy);
        System.out.println("entro en insert BST");
        if(root == null){
            root = n;
            size++;
            System.out.println(root);
            System.out.println("Fijado el root"+""+root+"  es    "+ root.getData());
            return;
        }
        TreeNode First =root;
        if(First.rigth == null){
            System.out.println("añadido root.right");
            System.out.println(n.getData());
            First.setRigth(n);
            size++;
        }
        if(First.left==null){
            System.out.println("añadido root.left");
            System.out.println(n.getData());
            First.setLeft(n);
            size++;
        }
        while(First.rigth != null || First.left!=null ){
            if (First.rigth !=null){
                First=First.getRigth();
            }
        }
        if(First.rigth == null){
            System.out.println("añadido"+First+"right");
            First.setRigth(n);
            size++;
            return;
        }
        if(First.left==null){
            System.out.println("añadido"+First+"Left");
            First.setLeft(n);
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
            //this.key = index;
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
