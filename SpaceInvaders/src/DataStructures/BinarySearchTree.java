package DataStructures;

public class BinarySearchTree implements Arbol{
    Node root;
    int size;

    public BinarySearchTree(){
        root = null;
    }

    @Override
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

    @Override
    public Object get(Node node) {
        return node.getValue();
    }


    public Object inOrder(Node n){
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
    public Object getTree(int index) {
        if (index==1){
            return get(root);
        }
        if (index==2){
            return get(root.left);
        }
        if(index==3){
            return get(root.rigth);
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

    public class Node{
        public Node dad;
        public Node rigth;
        public Node left;
        public int key;
        public Object contents;

        public Node(int index){
            this.key = index;
            this.rigth = null;
            this.left = null;
            this.dad = null;
        }

        public int getValue(){
            return key;
        }
    }
}
