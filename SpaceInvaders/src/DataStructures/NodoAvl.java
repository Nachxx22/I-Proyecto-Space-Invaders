package DataStructures;
import java.lang.Class;
/*public class NodoAVL {
    int dato, fe;
    NodoAVL Izquierdo;
    NodoAVL Derecho;
    public NodoAVL (int d){
        this.dato = d;
        this.fe = 0;
        this.Izquierdo = null;
        this.Derecho = null;

    }
}

 */
public class NodoAvl{
    //Valor que almacenado en el nodo
    public Object valor;
    public NodoAvl izquierda;      //Liga a la izquierda
    public NodoAvl derecha;        //Liga a la derecha
    public int altura;

    /**
     * Constructor a partir de un valor
     * @param valor -- valor que se almacena en el nodo
     */
    NodoAvl(Object valor) {this( valor, null, null );
    }

    /**
     * Constructor a partir de un valor y ligas al hijo izquierdo y al derecho
     * @param valor -- valor que se almacena en el nodo
     * @param izquierdo -- referencia al hijo izquiero
     * @param derecho -- referencia al hijo derecho
     */
    NodoAvl(Object valor, NodoAvl izquierdo, NodoAvl derecho) {
        this.valor = valor;
        this.izquierda = izquierdo;
        this.derecha = derecho;
        altura = 0;
    }
}
