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
		for (int i = 0; i < size; i++) {
			if (findNode.data.equals(element)) {
				return true;
			}
			findNode = findNode.nextNode;
		}
		return false;
	}

	@Override
	public MyStringIterator iterator() {
		//
		return new MyStringIterator();
	}

	@Override
	public void add(String element) {
		// element�� linkedList �� �ڿ� ����
		Node newNode = new Node(element);

		if (size == 0) {
			addFirst(newNode);
		} else {
			addLast(newNode);
		}
		size++;
	}

	@Override
	public void add(int index, String element) {
		// LinkedList �� index �� element�� ����
		Node newNode = new Node(element);

		if (index == 0) {
			addFirst(newNode);
		} else {
			Node findNode = nodeOfListIndex(index);

			pushOfLink(findNode.preNode, newNode, findNode);
		}
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
		if (findNode == head) {
			removeFirst(findNode);
			clearInNode(findNode);
		} else if (findNode == tail) {
			removeLast(findNode);
			clearInNode(findNode);
		} else {
			pullOfLink(findNode.preNode, findNode, findNode.nextNode);

			clearInNode(findNode); // help GC
		}
		size--;
	}

	@Override
	public void remove(int index) {
		// index��ġ�� �� ���� ���� list�� ��ܿ�
		Node findNode = nodeOfListIndex(index);
		if (findNode == head) {
			removeFirst(findNode);
			clearInNode(findNode);
		} else if (findNode == tail) {
			removeLast(findNode);
			clearInNode(findNode);
		} else {
			pullOfLink(findNode.preNode, findNode, findNode.nextNode);

			clearInNode(findNode); // help GC
		}
		size--;
	}

	@Override
	public void addAll(MyLinkedList sourceList) {
		// sourceList ���� LinkedList�� �ǵں��� ����
		String[] array = new String[sourceList.size()];
		array = sourceList.toArray();
		for (int i = 0; i < (sourceList.size()); i++) {
			this.add(array[i]);
		}
	}

	@Override
	public void clear() {
		// Ŭ.��.��
		for (int i = 0; i < size; i++) {
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
		for (int i = 0; i < size; i++) {
			//
			array[i] = findNode.data;
			findNode = findNode.nextNode;
		}
		return array;
	}

	public class MyStringIterator implements StringIterator {
		//
		private Node returnNode;
		private Node nextNode;
		private int index;

		public MyStringIterator() {
			//
			nextNode = head;
			index = 0;
		}

		@Override
		public String next() {
			//
			returnNode = nextNode;
			nextNode = nextNode.nextNode;
			index++;

			return returnNode.data;
		}

		@Override
		public boolean hasNext() {
			//
			return index < size;
		}

		@Override
		public void remove() {
			//
			MyLinkedListLogic.this.remove(index - 1);
			index--;
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
		if(index > size) {
			throw new IndexOutOfBoundsException("The index value of the corresponding LinkedList has been exceeded :" + index);
		}
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
		int index = 0;
		while (true) {
			//
			if (index == size) {
				throw new NullPointerException("No element in this LinkedList :" + element);
			}
			if (findNode.data == element) {
				break;
			}
			findNode = findNode.nextNode;
			index += 1;
		}
		return findNode;
	}

	private void clearInNode(Node node) {
		// ����� ������ null�� �ʱ�ȭ
		node.data = null;
		node.preNode = null;
		node.nextNode = null;
	}

	private void addFirst(Node newNode) {
		//
		newNode.nextNode = head;
		head = newNode;

		if (head.nextNode == null) {
			tail = head;
		}
	}

	private void addLast(Node newNode) {
		//
		tail.nextNode = newNode;
		newNode.preNode = tail;
		tail = newNode;
	}

	private void removeFirst(Node removeNode) {
		//
		head = removeNode.nextNode;

		if (head == tail) {
			head.preNode = null;
		}
	}

	private void removeLast(Node removeNode) {
		//
		tail = removeNode.preNode;
		tail.nextNode = null;
	}
}
