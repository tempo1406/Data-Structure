package Excercise;

import java.util.Scanner;

import Module.StackLinkedList;

public class palindromeString {

	public static boolean isPalindrome(String str) {
		StackLinkedList<Character> stack = new StackLinkedList<Character>();
		for (int i = 0; i < str.length(); i++)
			stack.push(str.charAt(i));
		int i = 0;
		while (i <= str.length() / 2) {
			if (!(str.charAt(i) == (stack.pop())))
				return false;
			i++;
		}
		return true;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = scanner.nextLine().toLowerCase();
		System.out.println("String is palindrome: " + isPalindrome(str));
		scanner.close();
	}
}
