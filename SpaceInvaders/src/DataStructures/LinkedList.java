package DataStructures;

public class LinkedList<Class> implements List<Class> {
	private Node<Class> head;
	private int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	@Override
	public void add(Class value) {
		Node<Class> newNode = new Node<Class>();
		newNode.setValue(value);
		if(head == null) {
			head = newNode;
			size++;
		} else {
			Node<Class> current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
			size++;
		}
	}
	
	@Override
	public void remove(int index) {
		if(index == 0 && index < size) {
			head = head.getNext();
			size--;
			return;
		}
		Node<Class> current = head;
		int counter = 0;
		while(counter < index-1 && current.getNext() != null) {
			current = current.getNext();
			counter++;
		}
		if(counter == size-2) {
			current.setNext(null);
			size--;

		} else {
			current.setNext(current.getNext().getNext());
			size--;
			return;
		}
	}
	
	@Override
	public Class get(int index) {
		if(index > size-1)
			return null;
		Node<Class> current = head;
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getValue();
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}
	
	@Override
	public void swap(int index1, int index2) {

	}
}