package linkedlist.structure;

public class LinkedListTest {
	// ��� �׽�Ʈ
	public static void main(String args[]) {

		MyLinkedList linkedList = new MyLinkedListLogic();

		linkedList.add("Test1");
		linkedList.add("Test2");
		linkedList.add("Test3");
		linkedList.add("Test4");
		linkedList.add("Test5");

		System.out.println("[�⺻�� add(String element) ��]");
		System.out.print("���� linkedList �� ����� ���� :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("�̰� size �� (" + linkedList.size() + ") �Դϴ�.");
		System.out.println("============================================================");
		
		System.out.println("linkedList.contain(Test3) ����� :" + linkedList.contains("Test3"));
		System.out.println("linkedList.contain(Test9) ����� :" + linkedList.contains("Test9"));
		System.out.println("============================================================");
		
		linkedList.add(4, "AddTest1");
		System.out.println("[add(2, AddTest1) �޼ҵ� ��]");
		System.out.print("���� linkedList �� ����� ���� :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("�̰� size �� (" + linkedList.size() + ") �Դϴ�.");
		System.out.println("============================================================");
		
		linkedList.remove(5);
		System.out.println("[remove(6) �޼ҵ� ��]");
		System.out.print("���� linkedList �� ����� ���� :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("�̰� size �� (" + linkedList.size() + ") �Դϴ�.");
		System.out.println("============================================================");
		
		linkedList.remove("AddTest1");
		System.out.println("[remove(AddTest1) �޼ҵ� ��]");
		System.out.print("���� linkedList �� ����� ���� :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("�̰� size �� (" + linkedList.size() + ") �Դϴ�.");
		System.out.println("============================================================");
		
		System.out.println("[toArray() �޼ҵ� �����]");
		for (int i = 0; i < linkedList.toArray().length; i++) {
			System.out.print("linkedList.toArray[" + i + "]:" + linkedList.toArray()[i] + "  ");
		}
		System.out.println("\n============================================================");
		
		// ���ο� linkedList �߰�
		MyLinkedList addLinkedList = new MyLinkedListLogic();

		addLinkedList.add("Add1");
		addLinkedList.add("Add2");
		addLinkedList.add("Add3");
		
		linkedList.addAll(addLinkedList);		
		System.out.println("[addAll(addLinkedList) �޼ҵ� �����]");	
		System.out.print("���� linkedList �� ����� ���� :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("�̰� size �� (" + linkedList.size() + ") �Դϴ�.");
		System.out.println("============================================================");
		
		linkedList.clear();
		System.out.println("[clear() �޼ҵ� �����]");
		System.out.print("���� linkedList �� ����� ���� :");
		for (int i = 0; i < linkedList.size(); i++) {
			System.out.print(linkedList.get(i) + ",");
		}
		System.out.println("�̰� size �� (" + linkedList.size() + ") �Դϴ�.");
		System.out.println("============================================================");

	}
}
