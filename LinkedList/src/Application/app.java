package Application;

import Module.DoublyLinkedList;
import Module.SinglyLinkedList;

public class app {

	public static void main(String[] args) {

		/// Singly Linked List
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(5);
		list.addLast(4);
		list.addLast(10);
		list.addLast(9);
		list.addIndex(3, 0);
		System.out.println("First singly linkedlist:\t" + list.toString());
		list.removeFirst();
		list.removeLast();
		list.removeIndex(4);
		list.removeValue(0);
		list.set(3, 8);
		System.out.println(list.contain(3));
		System.out.println("Listkedlist after test:\t" + list.toString());
		System.out.println("Get first:\t" + list.getFirst());
		System.out.println("Get last:\t" + list.getLast());
		System.out.println("Get index:\t" + list.getIndex(2));
		System.out.print("To array: ");
		Object[] objects = list.toArray();
		for (Object object : objects) {
			System.out.print(object+"  ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();

		/// Doubly Linked List
		DoublyLinkedList<Integer> list2 = new DoublyLinkedList<Integer>();
		list2.addFirst(5);
		list2.addFirst(4);
		list2.addFirst(3);
		list2.addFirst(2);
		list2.addFirst(1);
		list2.addLast(6);
		list2.addLast(7);
		list2.addLast(8);
		list2.addIndex(6, 10);
		System.out.println("First doubly linkedlist:\t" + list2.toString());
		list2.removeFirst();
		list2.removeLast();		
		list2.removeIndex(6);
		list2.set(5, 0);
		System.out.println(list2.contain(3));
		System.out.println("First doubly linkedlist:\t" + list2.toString());
		System.out.println("Get first:\t" + list2.getFirst());
		System.out.println("Get last:\t" + list2.getLast());
		System.out.println("Get index:\t" + list2.getIndex(3));
		System.out.print("To array: ");
		Object[] objects2 = list2.toArray();
		for (Object object : objects2) {
			System.out.print(object+"  ");
		}
	}
}
