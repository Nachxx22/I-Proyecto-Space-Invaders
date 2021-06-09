package DataStructures;

import Objects.Invader;


public class BinarySearchTree implements ArbolBST {
    TreeNode root;
    int size;

    /**
     * Para crear el bst con el root/raiz en null
     **/
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Recorre el arbol y returna el nodo con el indice regresado
     * @param index el indice para buscar el nodo deseado
     * @param n El nodo inicial para empezar la busqueda
     **/
    public Invader inOrder(TreeNode n,int index){
        if(n != null){

            if(n.getRigth().getKey()==index){
                return n.getRigth().getData();}
            if(n.getLeft().getKey()==index) {
                return n.getLeft().getData();}
            if(n.getLeft().getKey() != index || n.getRigth().getKey() != index){
                 return inOrder(n.getRigth(),index);
            }
            else{
                System.out.println("error en los ifs");
            }
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
    /**
     * retorna el nodo con el indice ingresado
     * @param index I
     **/
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
    /**
     * Inserta el nodo
     * @param enemy Objecto Invader que se busca insertar
     * @param key Indice para buscar donde ingresar el objecto
     **/
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
            n.getData().setPosY(n.getData().getPosY()+90);
            n.getData().setPosX(420+100);
            First.setRigth(n);
            size++;
            return;
        }
        if(First.left==null){
            n.getData().setPosY(n.getData().getPosY()+90);
            n.getData().setPosX(420-200);
            First.setLeft(n);
            size++;
            return;
        }
        while(First.rigth != null && First.left != null ){
                First=First.getRigth();
                n.getData().setPosY(n.getData().getPosY()+110);
        }
        if(First.left == null && First.rigth != null){
            n.getData().setPosX(n.getData().getPosX()-100);
            First.setLeft(n);
            size++;
            return;
        }
        else if(First.rigth == null ){
            n.getData().setPosX(n.getData().getPosX()+100);
            First.setRigth(n);
            size++;
            return;
        }

    }

    public class TreeNode {
        public TreeNode dad;
        public TreeNode rigth;
        public TreeNode left;
        public int key;
        public Object contents;
        public Invader Data;

        /**
         * Para crear los nuevos nodos
         * @param key este es un int que es el indice del nodo para insertarlo e ubicarlo
         **/
        public TreeNode(int key){
            this.key = key;
            this.rigth = null;
            this.left = null;
            this.dad = null;
            this.Data=null;
        }

        /**
         * retorna el nodo izquierdo
         **/
        public TreeNode getLeft() {
            return left;
        }

        /**
         * Añade el nodo izquierdo
         **/
        public void setLeft(TreeNode left) {
            this.left = left;
        }

        /**
         * Añade el nodo derecho
         **/
        public void setRigth(TreeNode rigth) {
            this.rigth = rigth;
        }

        /**
         * retorna el nodo derecho
         **/
        public TreeNode getRigth() {
            return rigth;
        }

        /**
         * Fija o cambia la contraseña
         **/
        public void setKey(int key) {
            this.key = key;
        }

        /**
         * retorna el dato de key (se utiliza para los index)
         **/
        public int getKey(){return  key;}

        /**
         * retorna el nodo con el indice ingresado
         **/

        /**
         * añade o cambia la data(información) que tiene el nodo(objecto)
         **/
        public void setData(Invader Data){
            this.Data=Data;
        }

        /**
         * retorna la data(información) que tiene el nodo (Objecto)
         **/
        public Invader getData(){
            return Data;
        }
    }
}
