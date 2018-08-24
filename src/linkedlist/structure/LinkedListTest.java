package linkedlist.structure;

public class LinkedListTest {
	// 기능 테스트
	public static void main(String args[]) {

		MyLinkedList linkedList = new MyLinkedListLogic();

		linkedList.add("Test1");
		linkedList.add("Test2");
		linkedList.add("Test3");
		linkedList.add("Test4");
		linkedList.add("Test5");

		System.out.println("[기본값 add(String element) 후]");
		System.out.print("현재 linkedList 에 저장된 값은 :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("이고 size 는 (" + linkedList.size() + ") 입니다.");
		System.out.println("============================================================");
		
		System.out.println("linkedList.contain(Test3) 결과값 :" + linkedList.contains("Test3"));
		System.out.println("linkedList.contain(Test9) 결과값 :" + linkedList.contains("Test9"));
		System.out.println("============================================================");
		
		linkedList.add(4, "AddTest1");
		System.out.println("[add(2, AddTest1) 메소드 후]");
		System.out.print("현재 linkedList 에 저장된 값은 :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("이고 size 는 (" + linkedList.size() + ") 입니다.");
		System.out.println("============================================================");
		
		linkedList.remove(5);
		System.out.println("[remove(6) 메소드 후]");
		System.out.print("현재 linkedList 에 저장된 값은 :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("이고 size 는 (" + linkedList.size() + ") 입니다.");
		System.out.println("============================================================");
		
		linkedList.remove("AddTest1");
		System.out.println("[remove(AddTest1) 메소드 후]");
		System.out.print("현재 linkedList 에 저장된 값은 :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("이고 size 는 (" + linkedList.size() + ") 입니다.");
		System.out.println("============================================================");
		
		System.out.println("[toArray() 메소드 결과값]");
		for (int i = 0; i < linkedList.toArray().length; i++) {
			System.out.print("linkedList.toArray[" + i + "]:" + linkedList.toArray()[i] + "  ");
		}
		System.out.println("\n============================================================");
		
		// 새로운 linkedList 추가
		MyLinkedList addLinkedList = new MyLinkedListLogic();

		addLinkedList.add("Add1");
		addLinkedList.add("Add2");
		addLinkedList.add("Add3");
		
		linkedList.addAll(addLinkedList);		
		System.out.println("[addAll(addLinkedList) 메소드 결과값]");	
		System.out.print("현재 linkedList 에 저장된 값은 :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("이고 size 는 (" + linkedList.size() + ") 입니다.");
		System.out.println("============================================================");
		
		linkedList.clear();
		System.out.println("[clear() 메소드 결과값]");
		System.out.print("현재 linkedList 에 저장된 값은 :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("이고 size 는 (" + linkedList.size() + ") 입니다.");
		System.out.println("============================================================");

	}
}
