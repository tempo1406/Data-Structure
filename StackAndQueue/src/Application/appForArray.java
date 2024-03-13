package Application;

import Module.QueueArray;
import Module.StackArray;

public class appForArray {

	public static void main(String[] args) {

		/// Stack
		StackArray<Integer> stack = new StackArray<Integer>(10);
//		Stack<Integer> stack2 = new Stack<>();
//		stack2.push(0);
//		stack2.push(1);
//		stack2.push(2);
//		stack2.push(3);
//		stack2.push(4);
//		stack2.push(5);
//		System.out.println(stack2.search(0));
		stack.push(0);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.print("Stack: ");
		stack.output();
		// Test method
		System.out.println(stack.search(0));
		System.out.print("Stack after test: ");
		stack.output();

		System.out.println();

		/// Queue
//		Queue<Integer> queue2 = new LinkedList<>();
//		queue.add(2);
//		System.out.println(queue);
		QueueArray<Integer> queue = new QueueArray<Integer>(3);
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
		System.out.println(queue.poll());

		queue.add(0);
		queue.add(1);
		queue.add(2);
		queue.add(2);
		System.out.print("Queue after test: ");
		queue.output();
	}
}
