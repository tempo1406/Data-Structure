package Excercise;

import java.util.Scanner;

import Module.StackLinkedList;

public class convertToPostfix {

	public static int precedence(char ope) {
		switch (ope) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return 0;
	}

	public static String toPostfix(String exp) {
		StackLinkedList<Character> stack = new StackLinkedList<Character>();
		StringBuilder postFix = new StringBuilder();
		for (char ch : exp.toCharArray()) {
			if (Character.isLetterOrDigit(ch))
				postFix.append(ch);
			else if (ch == '(')
				stack.push(ch);
			else if (ch == ')') {
				while (!stack.empty() && stack.peek() != '(')
					postFix.append(stack.pop());
				if (!stack.empty() && stack.peek() != '(')
					return "Incorrect expression";
				else
					stack.pop();
			} else {
				while (!stack.empty() && precedence(ch) <= precedence(stack.peek()) && stack.peek()!='(')
					postFix.append(stack.pop());
				stack.push(ch);
			}
		}

		while (!stack.empty()) {
			if (stack.peek() != '(')
				postFix.append(stack.pop());
			else
				return "Incorrect expression";
		}
		return postFix.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Expression: ");
		String exp = scanner.nextLine().trim();
		System.out.println("Convert to postfix expression: " + toPostfix(exp));
		scanner.close();
	}
}
