package linkedlist.structure;


public class MyLinkedListLogic implements MyLinkedList{
	//
	private int size;
	private String[] array;
	private Node head;
	private Node tail;
	
	public MyLinkedListLogic() {
		//
		size = 0;
	}
	
	@Override
	public int size() {
		//
		return size;
	}

	@Override
	public boolean empty() {
		// ����ִ��� �˻�
		return false;
	}

	@Override
	public boolean contains(String element) {
		// element�� ���ԵǾ������� true �׷��� ������ false ��ȯ
		return false;
	}

	@Override
	public MyStringIterator iterator() {
		//
		return null;
	}
	
	@Override
	public void add(String element) {
		// element�� linkedList �� �ڿ� ����
		Node newNode = new Node(element);
		
		if(size == 0) {
			head = newNode;
			tail = head;
		} else {
			tail.nextNode = newNode;
			newNode.preNode = tail;
			tail = newNode;
		}
		
	}

	@Override
	public void add(int index, String element) {
		// LinkedList �� index �� element�� ����
		
	}

	@Override
	public String get(int index) {
		// index��ġ�� �� ��ȯ
		return null;
	}

	@Override
	public void remove(String element) {
		// LinkedList�� element �� ���� ���� list�� ��ܿ�
		
	}

	@Override
	public void remove(int index) {
		// index��ġ�� �� ���� ���� list�� ��ܿ�
		
	}

	@Override
	public void addAll(MyLinkedList sourceList) {
		// sourceList ���� LinkedList�� �ǵں��� ����
		
	}

	@Override
	public void clear() {
		// Ŭ.��.��
		
	}

	@Override
	public String[] toArray() {
		// �迭���·� ��ȯ
		return null;
	}
	
	public class MyStringIterator implements StringIterator {
		//
		
		@Override
		public String next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class Node{
		// LinkedList���� ����� ���
		
		private String data;
		private Node preNode;
		private Node nextNode;
		
		public Node(String value) {
			//
			this.data = value;
			this.preNode = null;
			this.nextNode = null;
		}
		
	}
	
	
	//private Method
	private String dataOfListIndex(int index) {
		// index��ġ�� ������ ��ȯ (linked List�� index�� ��� index��ġ�� ã�Ƽ� ������ ��ȯ�ϴ� �Լ�)
		//Node findNode = 
		return null;
	}
	
	private void pushLinkedList() {
		// ������ ��ġ�� ��带 �о� �� ���, preNode, nextNode �� �����ϴ� �Լ� -> �̴� �Լ��� ����
	}
	
	private void pullLinkedList() {
		// ������ ��ġ�� ����� nextNode�� preNode�� ��� �����ϴ� �Լ� -> ���� �Լ��� ����
	}
	// �����ϴ� �Լ� ��������
}
