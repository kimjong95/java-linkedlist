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
		// element가 포함되어있으면 true 그렇지 않으면 false 반환	
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
		// element를 linkedList 맨 뒤에 삽입
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
		// LinkedList 의 index 에 element값 삽입
		Node newNode = new Node(element);

		Node findNode = nodeOfListIndex(index);

		pushOfLink(findNode.preNode, newNode, findNode);

		size++;
	}

	@Override
	public String get(int index) {
		// index위치의 값 반환
		return nodeOfListIndex(index).data;
	}

	@Override
	public void remove(String element) {
		// LinkedList의 element 값 삭제 뒤의 list를 당겨옴
		Node findNode = findNodeToElement(element);

		pullOfLink(findNode.preNode, findNode, findNode.nextNode);

		clearInNode(findNode);
		
		size--;
	}

	@Override
	public void remove(int index) {
		// index위치의 값 삭제 뒤의 list를 당겨옴
		Node findNode = nodeOfListIndex(index);

		pullOfLink(findNode.preNode, findNode, findNode.nextNode);
		
		clearInNode(findNode);

		size--;
	}

	@Override
	public void addAll(MyLinkedList sourceList) {
		// sourceList 값을 LinkedList의 맨뒤부터 삽입
		String[] array = new String[sourceList.size()];
		array = sourceList.toArray();
		for(int i=0; i<(sourceList.size()); i++) {		
			this.add(array[i]);		
		}			
	}

	@Override
	public void clear() {
		// 클.리.어
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
		// 배열형태로 반환
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
		// LinkedList에서 사용할 노드
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
		// index위치의 데이터 반환 (linked List의 index가 없어서 index위치를 찾아서 데이터 반환하는 함수)
		Node findNode = head;

		for (int i = 0; i < index; i++) {
			findNode = findNode.nextNode;
		}
		return findNode;
	}

	private void pushOfLink(Node preNode, Node newNode, Node nextNode) {
		// 새로운 노드 (newNode) 를 지정된 위치의 노드(nextNode) 와 그 앞 노드(preNode) 사이에 넣고 연결하는 메소드
		newNode.preNode = preNode;
		newNode.nextNode = nextNode;
		preNode.nextNode = newNode;
		nextNode.preNode = newNode;
	}

	private void pullOfLink(Node preNode, Node findNode, Node nextNode) {
		// 지정된 위치의 노드(findNode) 의 앞 노드(preNode)와 뒤 노드(NextNode)를 연결하는 메소드
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
		// 노드의 내용을 null로 초기화
		node.data = null;
		node.preNode = null;
		node.nextNode = null;
	}
}
