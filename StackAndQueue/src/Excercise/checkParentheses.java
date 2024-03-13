package Excercise;

import java.util.Scanner;

import Module.StackLinkedList;

public class checkParentheses {

	public static boolean isParentheses(String str) {
		StackLinkedList<Character> stack = new StackLinkedList<Character>();
		int countO = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				countO++;
				stack.push(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (countO == 0)
					return false;
				char signC = stack.peek();
				if ((signC == '(') && (ch == ')') 
						|| (signC == '[') && (ch == ']') 
						|| (signC == '{') && (ch == '}')) {
					countO--;
					stack.pop();
				} else
					return false;
			}
		}
		return stack.empty();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number: ");
		String str = scanner.nextLine();
		System.out.println("The string is parentheses: " + isParentheses(str));
		scanner.close();
	}
}
//(con{lon[dit me may dung]})