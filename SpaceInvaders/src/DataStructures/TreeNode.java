package DataStructures;

public class TreeNode {
    // El nodo no tiene las funciones necesarias además de hacerse la clase en la misma clase del arbol binario lo cual puede causar error
    // El get value no tiene ningun sentido ya que siempre va a retornar un 0 por que nunca se hace un set de value para el nodo
    //el nodo simplemente recibe un index como key que no tiene ningún sentido ya que el nodo deberia contener el objecto del Invader
    public BinarySearchTree.TreeNode dad;
    public BinarySearchTree.TreeNode rigth;
    public BinarySearchTree.TreeNode left;
    public int key;
    public Object contents;

    public TreeNode(int index){
        this.key = index;
        this.rigth = null;
        this.left = null;
        this.dad = null;
    }

    public Object getValue(){
        return key;
    }
}

