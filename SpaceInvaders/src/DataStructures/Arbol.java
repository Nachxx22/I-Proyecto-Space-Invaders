package DataStructures;

public interface Arbol {

    public boolean estaVcio();

    public void vaciar();

    public int tamaño();

    public void agregar(Object elem);

    public boolean contiene(Object elem);

    public void eliminar(Object elem);

    public void insert(int index, Object value);

    Object get(BinarySearchTree.Node node);
}
