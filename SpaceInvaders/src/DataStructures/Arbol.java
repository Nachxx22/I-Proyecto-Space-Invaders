package DataStructures;

public interface Arbol<Class> {

    /**
     * Metodo para determinar si un arbol esta o no vacio.
     * @return boolean -- true si el arbol esta vacio y false en otro caso.
     */
    public boolean estaVacio();

    /**
     * Metodo para eliminar todos los elementos de un arbol
     */
    public void vaciar();

    /**
     * Metodo para conocer el tamano de un arbol
     * @return int -- cantidad de elementos en el arbol
     */
    public int tamaño();

    /**
     * Metodo para introducir un elemento en el arbol
     * @param dato -- elemento a introducir en el arbol
     */
    public void agregar( Object dato);

    /**
     * Metodo para determinar si un elemento esta en el arbol
     * @param elem -- elemento a buscar en el arbol
     * @return boolean -- true si el arbol contiene el elemento y false en otro caso
     */
    public boolean contiene( Object elem);

    public Class getTree(int index);


    /**
     * Metodo para eliminar el elemento del arbol
     */
    public void eliminar(Object elem);

    public void insert(int index, Object value);

    Object get(BinarySearchTree.Node node);
}
