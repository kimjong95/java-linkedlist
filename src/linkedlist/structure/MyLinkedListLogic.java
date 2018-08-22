package linkedlist.structure;

public class MyLinkedListLogic implements MyLinkedList {
	//
	private int size;
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
		//
		return size == 0;
	}

	@Override
	public boolean contains(String element) {
		// element�� ���ԵǾ������� true �׷��� ������ false ��ȯ	
		Node findNode = head;
		for(int i = 0; i<size ; i++) {
			if(findNode.data.equals(element)) {
				return true;
			}
			findNode = findNode.nextNode;
		}		
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

		if (size == 0) {
			head = newNode;
			tail = head;
		} else {
			tail.nextNode = newNode;
			newNode.preNode = tail;
			tail = newNode;
		}
		size++;
	}

	@Override
	public void add(int index, String element) {
		// LinkedList �� index �� element�� ����
		Node newNode = new Node(element);

		Node findNode = nodeOfListIndex(index);

		pushOfLink(findNode.preNode, newNode, findNode);

		size++;
	}

	@Override
	public String get(int index) {
		// index��ġ�� �� ��ȯ
		return nodeOfListIndex(index).data;
	}

	@Override
	public void remove(String element) {
		// LinkedList�� element �� ���� ���� list�� ��ܿ�
		Node findNode = findNodeToElement(element);

		pullOfLink(findNode.preNode, findNode, findNode.nextNode);

		clearInNode(findNode);
		
		size--;
	}

	@Override
	public void remove(int index) {
		// index��ġ�� �� ���� ���� list�� ��ܿ�
		Node findNode = nodeOfListIndex(index);

		pullOfLink(findNode.preNode, findNode, findNode.nextNode);
		
		clearInNode(findNode);

		size--;
	}

	@Override
	public void addAll(MyLinkedList sourceList) {
		// sourceList ���� LinkedList�� �ǵں��� ����
		String[] array = new String[sourceList.size()];
		array = sourceList.toArray();
		for(int i=0; i<(sourceList.size()); i++) {		
			this.add(array[i]);		
		}			
	}

	@Override
	public void clear() {
		// Ŭ.��.��
		for(int i = 0; i<size; i++) {
			head.data = null;
			head.preNode = null;
			
			head = head.nextNode;			
		}
		
		head = tail;
		
		size = 0;
		
	}

	@Override
	public String[] toArray() {
		// �迭���·� ��ȯ
		String[] array = new String[size];
		
		Node findNode = head;
		for(int i = 0; i<size ; i++) {
			
			array[i] = findNode.data;
			
			findNode = findNode.nextNode;
		}		
		return array;
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

	private class Node {
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

	// private Method
	private Node nodeOfListIndex(int index) {
		// index��ġ�� ������ ��ȯ (linked List�� index�� ��� index��ġ�� ã�Ƽ� ������ ��ȯ�ϴ� �Լ�)
		Node findNode = head;

		for (int i = 0; i < index; i++) {
			findNode = findNode.nextNode;
		}
		return findNode;
	}

	private void pushOfLink(Node preNode, Node newNode, Node nextNode) {
		// ���ο� ��� (newNode) �� ������ ��ġ�� ���(nextNode) �� �� �� ���(preNode) ���̿� �ְ� �����ϴ� �޼ҵ�
		newNode.preNode = preNode;
		newNode.nextNode = nextNode;
		preNode.nextNode = newNode;
		nextNode.preNode = newNode;
	}

	private void pullOfLink(Node preNode, Node findNode, Node nextNode) {
		// ������ ��ġ�� ���(findNode) �� �� ���(preNode)�� �� ���(NextNode)�� �����ϴ� �޼ҵ�
		preNode.nextNode = nextNode;
		nextNode.preNode = preNode;
	}

	private Node findNodeToElement(String element) {
		//
		Node findNode = head;

		while (true) {
			if (findNode.data == element) {
				break;
			}
			
			findNode = findNode.nextNode;
		}
		return findNode;
	}
	
	private void clearInNode(Node node) {
		// ����� ������ null�� �ʱ�ȭ
		node.data = null;
		node.preNode = null;
		node.nextNode = null;
	}
}
