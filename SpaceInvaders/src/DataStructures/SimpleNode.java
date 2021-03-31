package DataStructures;

public class SimpleNode <Type> {
    private Type element;
    private SimpleNode <Type> next;

    public SimpleNode() {
        element = null;
        next = null;
    }

    public Type getElement() {
        return element;
    }

    public void setValue(Type element) {
        this.element = element;
    }

    public SimpleNode<Type> getNext() {
        return next;
    }

    public void setNext(SimpleNode<Type> next) {
        this.next = next;
    }
}
