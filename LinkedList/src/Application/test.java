package Application;

import Module.TestMyLinkedList;

public class test {
	public static void main(String[] args) {
		TestMyLinkedList<Integer> list = new TestMyLinkedList<Integer>();
		list.addFirst(-11);
		list.addFirst(2);
		list.addFirst(-51);
		list.addFirst(-21);
		list.addFirst(2);
		list.addFirst(5);
		list.addLast(4);
		list.addLast(10);
		list.addLast(9);
		list.addIndex(3, 0);
		System.out.println("First singly linkedlist:\t" + list.toString());
		System.out.println("Sum list: " + list.sum());
		System.out.println("Diff between largest and smallest: " + list.diff());
		System.out.println("Largest sum of two consecutive elements: " + list.largetSumConsecutive());
		System.out.println("Reverse list:\t" + list.reverse().toString());
		list.removeNegative();
		System.out.println("Remove negative value in linkedlist:\t" + list.toString());
		list.removeSimilar();
		System.out.println("Remove simmilar value in linkedlist:\t" + list.toString());
		
		TestMyLinkedList<Integer> listIncreasing = new TestMyLinkedList<Integer>();
		listIncreasing.add(0);
		listIncreasing.add(1);
		listIncreasing.add(2);
		listIncreasing.add(3);
		listIncreasing.add(4);
		listIncreasing.add(5);
		System.out.println("Sorted singly linkedlist:\t" + listIncreasing.toString());
		System.out.println("List is sorted:"+listIncreasing.isSorted());
		listIncreasing.insertIncreasing(7);
		System.out.println("Sorted singly linkedlist after add:\t" + listIncreasing.toString());
		list.attach(listIncreasing);
		System.out.println("Attach two linked list:\t"+list.toString());

		TestMyLinkedList<Integer> listDecreasing = new TestMyLinkedList<Integer>();
		listDecreasing.add(5);
		listDecreasing.add(4);
		listDecreasing.add(3);
		listDecreasing.add(2);
		listDecreasing.add(1);
		listDecreasing.add(0);
		listIncreasing.removeLast();
		System.out.println("Sorted singly linkedlist:\t" + listDecreasing.toString());
		System.out.println("List is sorted:"+listDecreasing.isSorted());
		System.out.println("Check two list is same:\t"+listIncreasing.isSame(listDecreasing));
		
		TestMyLinkedList<Integer> listIncreasing2 = new TestMyLinkedList<Integer>();
		listIncreasing2.add(0);
		listIncreasing2.add(1);
		listIncreasing2.add(2);
		listIncreasing2.add(3);
		listIncreasing2.add(4);
		listIncreasing2.add(5);
		TestMyLinkedList<Integer> mergeList = new TestMyLinkedList<Integer>();
		
		System.out.println("Merge two increasing list:\t"+mergeList.mergeArray(listIncreasing, listIncreasing2));
	}
}
