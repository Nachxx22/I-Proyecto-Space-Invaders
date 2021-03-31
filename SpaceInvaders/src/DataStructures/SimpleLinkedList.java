package DataStructures;

public class SimpleLinkedList <Type> implements List<Type> {
    private SimpleNode<Type> head;
    private int length;
    public SimpleLinkedList() {
        head = null;
        length = 0;
    }
    @Override
    public void add(Type element) {
        SimpleNode<Type> newNode = new SimpleNode<Type>();
        newNode.setValue(element);
        if(head == null) {
            head = newNode;
            length++;
        } else {
            SimpleNode<Type> current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
            length++;
        }
    }

    @Override
    public void remove(int index) {
        if(index == 0 && index < length) {
            head = head.getNext();
            length--;
            return;
        }
        SimpleNode<Type> current = head;
        int counter = 0;
        while(counter < index-1 && current.getNext() != null) {
            current = current.getNext();
            counter++;
        }
        if(counter == length-2) {
            current.setNext(null);
            length--;
            return;
        } else {
            current.setNext(current.getNext().getNext());
            length--;
            return;
        }
    }

    @Override
    public Type get(int index) {
        if(index > length-1)
            return null;
        SimpleNode<Type> current = head;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getElement();
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public void clear() {
        this.head = null;
        length = 0;

    }

    @Override
    public void swap(int index1, int index2) {
        Type d1 = this.get(index1);
        Type d2 = this.get(index2);
        SimpleNode<Type> current = head;
        for(int i = 0; i < this.length(); i++) {
            if(this.get(length) == d1) {
                current.setValue(d2);
            } else if(this.get(i) == d2) {
                current.setValue(d1);
            }
            current = current.getNext();
    }
}
}
