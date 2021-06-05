package DataStructures;

import java.util.Comparator;



/**
 * Clase para trabajar con  binarios de busqueda balanceados, llamados AVL
 * @author Amparo Lopez Gaona
 * @version 1a. ed.
 */

public class ArbolAvl implements Arbol {
    private NodoAvl  raiz;            // Nodo raiz del arbol
    private Comparator cmp;          // Comparador
    private int nNodos;



    /**
     * Constructor a partir de un comparador
     //* @param c para establecer relacion de orden entre nodos
     */
    public void Avl(Comparator c) {
        cmp = c;
    }

    public ArbolAvl() {
        raiz=null;
        nNodos = 0;
    }

    /*
     * Metodo interno, auxiliar, para agregar en un arbol.
     * @param dato -- elemento a agregar.
     * @param n -- nodo raiz del arbol.
     * @return NodoAvl -- la nueva raiz.
     */
    private NodoAvl agregar(Object dato, NodoAvl n) {
        if(n == null) {
            n = new NodoAvl(dato);
            nNodos ++;
        }
        else if(cmp.compare(dato, n.valor) < 0) {
            n.izquierda = agregar(dato, n.izquierda);
            if(altura(n.izquierda) - altura(n.derecha) == 2)
                if(cmp.compare(dato, n.izquierda.valor) < 0)
                    n = rotarIzq(n);
                else {
                    n.izquierda = rotarDer(n.izquierda);
                    n = rotarIzq(n);
                }
        } else if(cmp.compare(dato, n.valor) > 0) {
            n.derecha = agregar(dato, n.derecha);
            if(altura(n.derecha) - altura(n.izquierda) == 2)
                if(cmp.compare(dato, n.derecha.valor) > 0)
                    n = rotarDer(n);
                else {
                    n.derecha = rotarIzq(n.derecha);
                    n = rotarDer(n);
                }
        }  else ;  // Encontro un duplicado y no hace nada.

        n.altura = Math.max(altura(n.izquierda), altura(n.derecha)) + 1;
        return n;
    }


    /*
     * Metodo privado para conocer la altura de un nodo
     * @param n -- Nodo del que se desea conocer la altura
     * @return int -- altura del nodo
     */
    private int altura (NodoAvl n) {
        return (n == null) ? -1 : n.altura;
    }

    /**
     * Metodo para rotar a la izquierda
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    private NodoAvl rotarIzq(NodoAvl n) {
        NodoAvl nraiz = n.izquierda;
        n.izquierda = nraiz.derecha;
        nraiz.derecha = n;
        n.altura = Math.max(altura(n.izquierda), altura(n.derecha)) + 1;
        nraiz.altura = Math.max(altura(nraiz.izquierda), n.altura) + 1;
        return nraiz;
    }

    /**
     * Metodo para rotar a la izquierda
     * @param n -- nodo raiz del subarbol que se va a rotar
     * @return NodoAvl -- Nodo raiz del subarbol despues de la rotacion
     */
    private NodoAvl rotarDer(NodoAvl n) {
        NodoAvl nraiz = n.derecha;
        n.derecha = nraiz.izquierda;
        nraiz.izquierda = n;
        n.altura = Math.max(altura(n.izquierda), altura(n.derecha)) + 1;
        nraiz.altura = Math.max(altura(nraiz.derecha), n.altura) + 1;
        return nraiz;
    }

    /*
     * Metodo interno para encontrar el menor elemento en un subarbol.
     * @param n -- nodo raiz del arbol.
     * @return NodoAVl - el nodo que contiene el elemento menor.
     */
    public NodoAvl encuentraMin(NodoAvl n) {
        if(n == null)
            return null;
        else if(n.izquierda == null)
            return n;
        return encuentraMin(n.izquierda);
    }

    /**
     * Metodo para determinar si un arbol esta vacio.
     * @return true -- si el arbol esta vacio y false en otro caso.
     */
    @Override
    public boolean estaVacio() {
        return raiz == null;
    }
    /**
     * Metodo para dejar vacio un arbol
     */
    @Override
    public void vaciar() {
        raiz = null;
    }

    @Override
    public int tamaño() {
        return nNodos;
    }



    /**
     * Metodo para insertar un nodo en el arbol, ignorando los duplicados y
     * balanceando  si es necesario.
     * @param dato -- el elemento a insertar.
     */
    // cambiar el Comparable por Object para que funcione con el error anterior
    @Override
    public void agregar(Object dato) {
        raiz = agregar(dato, raiz);

    }
    /**
     * Metodo para encontrar un elemento en el arbol.
     * @param dato -- el dato a buscar.
     * @return boolean -- true si el elemento se encontro o false si no esta.
     */
    @Override
    public boolean contiene(Object dato) {
        return encontrar( dato, raiz) != null;
    }

    @Override
    public Object getTree(int index) {
        return null;
    }

    @Override
    public void eliminar(Object elem) {

    }

    @Override
    public void insert(int index, Object value) {

    }

    @Override
    public Object get(BinarySearchTree.Node node) {
        return null;
    }

    /*
     * Metodo interno para encontrar un elemento en un subarbol
     * @param dato -- elemento buscado.
     * @param n -- raiz del arbol.
     * @return NodoAVL que contiene el elemento encontrado o null si no lo encontro.
     */
    private NodoAvl encontrar(Object dato, NodoAvl n) {
        while(n != null)
            if(cmp.compare(dato, n.valor) < 0)
                n = n.izquierda;
            else if(cmp.compare(dato, n.valor) > 0)
                n = n.derecha;
            else
                return n;    // Lo encontro

        return null;   // No lo encontro.
    }
}


