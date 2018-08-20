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
		// 비어있는지 검사
		return false;
	}

	@Override
	public boolean contains(String element) {
		// element가 포함되어있으면 true 그렇지 않으면 false 반환
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
		// LinkedList 의 index 에 element값 삽입
		
	}

	@Override
	public String get(int index) {
		// index위치의 값 반환
		return null;
	}

	@Override
	public void remove(String element) {
		// LinkedList의 element 값 삭제 뒤의 list를 당겨옴
		
	}

	@Override
	public void remove(int index) {
		// index위치의 값 삭제 뒤의 list를 당겨옴
		
	}

	@Override
	public void addAll(MyLinkedList sourceList) {
		// sourceList 값을 LinkedList의 맨뒤부터 삽입
		
	}

	@Override
	public void clear() {
		// 클.리.어
		
	}

	@Override
	public String[] toArray() {
		// 배열형태로 반환
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
	
	
	//private Method
	private String dataOfListIndex(int index) {
		// index위치의 데이터 반환 (linked List의 index가 없어서 index위치를 찾아서 데이터 반환하는 함수)
		//Node findNode = 
		return null;
	}
	
	private void pushLinkedList() {
		// 삽입할 위치의 노드를 밀어 새 노드, preNode, nextNode 와 연결하는 함수 -> 미는 함수로 독립
	}
	
	private void pullLinkedList() {
		// 삭제한 위치의 노드의 nextNode와 preNode를 당겨 연결하는 함수 -> 당기는 함수로 독립
	}
	// 연결하는 함수 만들어야함
}
