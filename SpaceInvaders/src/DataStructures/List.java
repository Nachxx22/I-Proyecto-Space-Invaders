package DataStructures;

public interface List <Type> {
    public void add(Type element);
    public void remove(int index);
    public Type get(int index);
    public int length();
    public void clear();
    public void swap(int index1, int index2);
}
