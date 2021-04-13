package DataStructures;

public class DoubleLinkedList<Class> implements List<Class> {
	private DoubleNode<Class> head;
	private int size;
	
	public DoubleLinkedList() {
		head = null;
		size = 0;
	}
	
	@Override
	public void add(Class value) {
		DoubleNode<Class> newNode = new DoubleNode<Class>();
		newNode.setValue(value);
		if(head == null) {
			head = newNode;
			size++;
			return;
		}
		DoubleNode<Class> current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		newNode.setPrev(current);
		current.setNext(newNode);
		size++;
	}
	
	@Override
	public void remove(int index) {
		if(index == 0 && index < size) {
			head = head.getNext();
			size--;
			return;
		}
		DoubleNode<Class> current = head;
		int counter = 0;
		while(counter < index-1 && current.getNext() != null) {
			current = current.getNext();
			counter++;
		}
		if(counter == size-2) {
			current.setNext(null);
			size--;
			return;
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
		DoubleNode<Class> current = head;
		for(int c = 0; c < index; c++) {
			current = current.getNext();
		}
		return current.getValue();
	}
	
	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void swap(int index1, int index2) {
		Class d1 = this.get(index1);
		Class d2 = this.get(index2);
		DoubleNode<Class> current = head;
		for(int c = 0; c < size; c++) {
			if(this.get(c) == d1) {
				current.setValue(d2);
			} else if(this.get(c) == d2) {
				current.setValue(d1);
			}
			current = current.getNext();
		}
	}
}
