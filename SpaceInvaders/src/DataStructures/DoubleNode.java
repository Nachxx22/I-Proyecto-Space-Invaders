package DataStructures;

/**
 *Clase DoubleNode: Esta clase define el doble nodo que se va implemenar para
 * la lista Doblemente Enlazada.
 */

public class DoubleNode<Class> {
	private DoubleNode<Class> next;
	private DoubleNode<Class> prev;
	private Class value;
	
	public DoubleNode() {
		this.next = null;
		this.prev = null;
		this.value = null;
	}

	public DoubleNode<Class> getNext() {
		return next;
	}

	public void setNext(DoubleNode<Class> next) {
		this.next = next;
	}

	public DoubleNode<Class> getPrev() {
		return prev;
	}

	public void setPrev(DoubleNode<Class> prev) {
		this.prev = prev;
	}

	public Class getValue() {
		return value;
	}

	public void setValue(Class value) {
		this.value = value;
	}
}
