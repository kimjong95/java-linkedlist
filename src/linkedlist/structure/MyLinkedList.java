package linkedlist.structure;

import linkedlist.structure.MyLinkedListLogic.MyStringIterator;

public interface MyLinkedList {
	//
	int size();
	boolean empty();
	boolean contains(String element);
	MyStringIterator iterator();
	void add(String element);
	void add(int index, String element);
	String get(int index);
	void remove(String element);
	void remove(int index);
	void addAll(MyLinkedList sourceList);
	void clear();
	String[] toArray();
}
