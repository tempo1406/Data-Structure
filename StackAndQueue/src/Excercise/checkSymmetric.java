package Excercise;

import java.util.Scanner;

import Module.QueueLinkedList;
import Module.StackLinkedList;

public class checkSymmetric {

	public static boolean isSymmetric(String str) {
		StackLinkedList<Character> stack = new StackLinkedList<Character>();
		QueueLinkedList<Character> queue = new QueueLinkedList<Character>();
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			queue.add(str.charAt(i));
		}
		int i = 0;
		while (i < stack.countSize() / 2) {
			if (stack.pop() != queue.poll())
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = scanner.nextLine().trim().toLowerCase();
		System.out.println("The string is symmetric: " + isSymmetric(str));
		scanner.close();
	}
}
