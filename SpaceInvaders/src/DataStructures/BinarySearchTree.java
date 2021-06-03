package DataStructures;

public class BinarySearchTree implements Arbol{
    Node root;
    int size;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int index, Object value){
        Node n = new Node(index);
        n.contents = value;

        if(root == null){
            root = n;
        }else{
            Node aux = root;
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

    public void inOrder(Node n){
        if(n != null){
            inOrder(n.left);
            System.out.println("Indice: " + n.key + " Valor: " + n.contents);
            inOrder(n.rigth);
        }
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
    public Object contiene(Object elem) {
        return elem;
    }

    @Override
    public void eliminar(Object elem) {

    }

    public class Node{
        public Node dad;
        public Node rigth;
        public Node left;
        public int key;
        public Object contents;

        public Node(int index){
            key = index;
            rigth = null;
            left = null;
            dad = null;
        }
    }
}
