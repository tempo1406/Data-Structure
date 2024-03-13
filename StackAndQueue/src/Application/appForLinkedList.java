package Application;

import Module.QueueLinkedList;
import Module.StackLinkedList;

public class appForLinkedList {
	public static void main(String[] args) {
		StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.print("Stack: ");
		stack.output();
		System.out.println(stack.countSize());
		// Test method
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.search(0));
		System.out.print("Stack after test: ");
		stack.output();

		System.out.println();
		
		/// Queue
		QueueLinkedList<Integer> queue = new QueueLinkedList<Integer>();
		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.add(2);

		System.out.println(queue.element());
		System.out.print("Queue:");
		queue.output();
		// Test method
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.remove());

		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.offer(2);
		System.out.print("Queue after test: ");
		queue.output();
	}
}
