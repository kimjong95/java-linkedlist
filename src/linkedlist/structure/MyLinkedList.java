package linkedlist.structure;

public interface MyLinkedList {
	//
	int size();
	boolean empty();
	boolean contains(String element);
	StringIterator iterator();
	void add(String element);
	void add(int index, String element);
	String get(int index);
	void remove(String element);
	void remove(int index);
	void addAll(MyLinkedList sourceList);
	void clear();
	String[] toArray();
}
