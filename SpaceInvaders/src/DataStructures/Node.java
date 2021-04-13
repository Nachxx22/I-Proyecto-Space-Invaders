package DataStructures;

public class Node <Class> {
	private Class value;
	private Node<Class> next;
	
	public Node() {
		value = null;
		next = null;
	}

	public Class getValue() {
		return value;
	}

	public void setValue(Class value) {
		this.value = value;
	}

	public Node<Class> getNext() {
		return next;
	}

	public void setNext(Node<Class> next) {
		this.next = next;
	}
}