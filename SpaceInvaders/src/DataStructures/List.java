package DataStructures;

public interface List<Class> {
	public void add(Class value);
	public void remove(int index);
	public Class get(int index);
	public int size();
	public void clear();
	public void swap(int index1, int index2);
}
